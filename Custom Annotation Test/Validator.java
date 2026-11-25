import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/** Checks @Range constraints on int fields using reflection. */
public class Validator {

    public static List<String> validate(Object obj) {
        List<String> violations = new ArrayList<>();

        for (Field field : obj.getClass().getDeclaredFields()) {
            Range range = field.getAnnotation(Range.class);
            if (range == null) continue;
            if (field.getType() != int.class && field.getType() != Integer.class) continue;

            try {
                field.setAccessible(true);
                int actual = field.getInt(obj);
                if (actual < range.min() || actual > range.max()) {
                    violations.add(field.getName() + " - " + range.message() + " (actual: " + actual + ")");
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Could not read field " + field.getName(), e);
            }
        }
        return violations;   // empty list = everything valid
    }
}
