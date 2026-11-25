import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/** Dispatches a URL path to the bean method annotated with a matching @Route. */
public class Router {

    public static String dispatch(Container c, String path) {
        for (Object bean : c.getBeans()) {
            for (Method method : bean.getClass().getDeclaredMethods()) {
                Route route = method.getAnnotation(Route.class);
                if (route != null && pathOf(route).equals(path)) {
                    try {
                        method.setAccessible(true);
                        return (String) method.invoke(bean);   // no parameters, returns String
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException("Failed to invoke " + method.getName(), e);
                    }
                }
            }
        }
        return "404 Not Found: " + path;
    }

    /** Supports both @Route(path = "/x") and the shorthand @Route("/x"). */
    private static String pathOf(Route route) {
        return route.path().isEmpty() ? route.value() : route.path();
    }
}
