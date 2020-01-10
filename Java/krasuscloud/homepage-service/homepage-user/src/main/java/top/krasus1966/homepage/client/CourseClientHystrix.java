package top.krasus1966.homepage.client;

import org.springframework.stereotype.Component;
import top.krasus1966.homepage.CourseInfo;
import top.krasus1966.homepage.CourseInfosRequest;

import java.util.Collections;
import java.util.List;

/**
 * 熔断降级策略
 * @author Krasus1966
 * @date 2019/12/23 16:39
 **/
@Component
public class CourseClientHystrix implements CourseClient{

    @Override
    public CourseInfo getCourseInfo(Long id) {
        return CourseInfo.invalid();
    }

    @Override
    public List<CourseInfo> getCourseInfos(CourseInfosRequest request) {
        return Collections.emptyList();
    }
}
