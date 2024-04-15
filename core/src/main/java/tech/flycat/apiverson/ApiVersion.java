package tech.flycat.apiverson;

import java.lang.annotation.*;

/**
 * @author <a href="mailto:zengbin@hltn.com">zengbin</a>
 * @since 2024/3/8
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ApiVersion {
    /**
     * 版本号
     * @return
     */
    String version();
}
