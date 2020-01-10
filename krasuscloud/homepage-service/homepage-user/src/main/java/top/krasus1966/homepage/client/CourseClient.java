package top.krasus1966.homepage.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.krasus1966.homepage.CourseInfo;
import top.krasus1966.homepage.CourseInfosRequest;

import java.util.List;

/**
 * 通过Feign访问课程微服务
 * @author Krasus1966
 * @date 2019/12/23 16:36
 **/
@FeignClient(value = "eureka-client-homepage-course",fallback = CourseClientHystrix.class)
public interface CourseClient {

    @RequestMapping(value = "/homepage-course/get/course",method = RequestMethod.GET)
    CourseInfo getCourseInfo(Long id);

    @RequestMapping(value = "/homepage-course/get/courses",method = RequestMethod.POST)
    List<CourseInfo> getCourseInfos(@RequestBody CourseInfosRequest request);
}
