import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** Marks a class to be created and managed by the Container. */
@Target(ElementType.TYPE)             // can only be placed on classes
@Retention(RetentionPolicy.RUNTIME)   // must survive until runtime so reflection can see it
public @interface Component {
    String value() default "";
}
