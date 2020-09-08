package configuration.annotation;

import java.lang.annotation.*;

/**
 * 自定义权限注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface Permission {

    PermissionEnum value();
}
