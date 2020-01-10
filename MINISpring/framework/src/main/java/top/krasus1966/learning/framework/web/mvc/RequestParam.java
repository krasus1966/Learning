package top.krasus1966.learning.framework.web.mvc;

import java.lang.annotation.*;

/**
 * @author Krasus1966
 * @date 2019/12/30 21:02
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface RequestParam {
    String value();
}
