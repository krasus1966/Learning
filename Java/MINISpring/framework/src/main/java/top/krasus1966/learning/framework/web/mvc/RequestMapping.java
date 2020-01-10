package top.krasus1966.learning.framework.web.mvc;

import java.lang.annotation.*;

/**
 * @author Krasus1966
 * @date 2019/12/30 21:01
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

public @interface RequestMapping {
    String value();
}
