import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/** A tiny IoC container: creates beans from @Component classes and injects @Value fields. */
public class Container {

    // LinkedHashMap keeps registration order, so output is predictable
    private final Map<String, Object> beans = new LinkedHashMap<>();

    /** Creates and stores an instance of every class annotated with @Component. */
    public void scan(Class<?>... classes) {
        for (Class<?> clazz : classes) {
            Component component = clazz.getAnnotation(Component.class);

            if (component == null) {
                System.out.println("[Container] Skipped: " + clazz.getSimpleName() + " (no @Component)");
                continue;
            }

            // Bean name: value() if given, otherwise simple class name with lowercase first letter
            String name = component.value();
            if (name.isEmpty()) {
                String simple = clazz.getSimpleName();
                name = Character.toLowerCase(simple.charAt(0)) + simple.substring(1);
            }

            try {
                Object instance = clazz.getDeclaredConstructor().newInstance();
                beans.put(name, instance);
                System.out.println("[Container] Registered: " + name + " (" + clazz.getSimpleName() + ")");
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException("Could not create bean for " + clazz.getName(), e);
            }
        }
    }

    /** Sets every @Value field of every bean from the config map. */
    public void injectValues(Map<String, String> config) {
        for (Object bean : beans.values()) {
            Class<?> clazz = bean.getClass();

            for (Field field : clazz.getDeclaredFields()) {
                Value value = field.getAnnotation(Value.class);
                if (value == null) continue;               // field has no @Value -> skip

                String key = value.value();
                if (!config.containsKey(key)) {
                    System.out.println("[Container] Skipped: no config for key " + key);
                    continue;
                }
                String raw = config.get(key);

                try {
                    field.setAccessible(true);             // needed because fields are private
                    Class<?> type = field.getType();

                    if (type == int.class || type == Integer.class) {
                        field.set(bean, Integer.parseInt(raw.trim()));
                    } else if (type == String.class) {
                        field.set(bean, raw);
                    } else {
                        System.out.println("[Container] Skipped: unsupported type "
                                + type.getSimpleName() + " for " + field.getName());
                        continue;
                    }
                    System.out.println("[Container] Injected: " + key + " -> "
                            + clazz.getSimpleName() + "." + field.getName());
                } catch (NumberFormatException e) {
                    System.out.println("[Container] Skipped: '" + raw + "' is not a valid int for " + key);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Could not inject " + field.getName(), e);
                }
            }
        }
    }

    public Object getBean(String name) {
        return beans.get(name);
    }

    /** Read-only view of all beans (used by the Router). */
    public Collection<Object> getBeans() {
        return Collections.unmodifiableCollection(beans.values());
    }
}
