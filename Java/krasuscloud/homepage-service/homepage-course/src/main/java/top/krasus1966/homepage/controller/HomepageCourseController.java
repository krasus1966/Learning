package top.krasus1966.homepage.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import top.krasus1966.homepage.CourseInfo;
import top.krasus1966.homepage.CourseInfosRequest;
import top.krasus1966.homepage.service.ICourseService;

import java.util.List;

/**
 * @author Krasus1966
 * @date 2019/12/23 11:06
 **/
@Slf4j
@Controller
public class HomepageCourseController {

    private final ICourseService iCourseServicel;

    @Autowired
    public HomepageCourseController(ICourseService iCourseServicel) {
        this.iCourseServicel = iCourseServicel;
    }

    @GetMapping("/get/course")
    public CourseInfo getCourseInfo(Long id) {
        log.info("<homepage-course>: get course ->{}", id);
        return iCourseServicel.getCourseInfo(id);
    }
    @GetMapping("/get/courses")
    public List<CourseInfo> getCourseInfos(@RequestBody CourseInfosRequest request){
        log.info("<homepage-course>: get courses ->{}", JSON.toJSONString(request));
        return iCourseServicel.getCourseInfos(request);
    }
}
