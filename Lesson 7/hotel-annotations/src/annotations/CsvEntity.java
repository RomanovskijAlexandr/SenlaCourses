package annotations;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface CsvEntity {
    String filename();
    String valuesSeparator() default ",";
    String entityId() default "id";
}
