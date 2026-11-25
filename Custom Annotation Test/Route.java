import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Maps a URL path to a method.
 *
 * The spec asks for an element called path(), but the starter code uses the shorthand
 * @Route("/hello"). Java only allows that shorthand when the element is named value().
 * So both are declared: @Route("/x") and @Route(path = "/x") are both valid.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Route {
    String path() default "";
    String value() default "";
}
