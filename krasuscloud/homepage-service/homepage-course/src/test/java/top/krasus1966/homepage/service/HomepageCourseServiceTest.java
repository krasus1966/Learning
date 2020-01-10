package top.krasus1966.homepage.service;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.krasus1966.homepage.Application;
import top.krasus1966.homepage.CourseInfosRequest;
import top.krasus1966.homepage.dao.HomepageCourseDao;
import top.krasus1966.homepage.entity.HomepageCourse;

import java.util.Arrays;

/**
 * @author Krasus1966
 * @date 2019/12/23 11:19
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class HomepageCourseServiceTest {

    @Autowired
    private HomepageCourseDao homepageCourseDao;
    @Autowired
    private ICourseService iCourseService;

//    @Test
    public void testCreateCourseInfo() {
        HomepageCourse course1 = new HomepageCourse(
                "JDK11&12 新特性解读",
                0,
                "http://www.imooc.com",
                "解读JDK11和12的新版本特性"
        );
        HomepageCourse course2 = new HomepageCourse(
                "SpringCloud微服务架构 广告系统设计与实现",
                1,
                "http://www.imooc.com",
                "广告系统的设计与实现"
        );
        System.out.println(homepageCourseDao.saveAll(
                Arrays.asList(course1, course2)
        ).size());
    }

    @Test
    public void testGetCourseInfo(){
        System.out.println(JSON.toJSONString(
                iCourseService.getCourseInfo(1L)
        ));
        System.out.println(JSON.toJSONString(
                iCourseService.getCourseInfo(8L)
        ));
    }

    @Test
    public void testGetCourseInfos(){
        System.out.println(JSON.toJSONString(
                iCourseService.getCourseInfos(new CourseInfosRequest(Arrays.asList(1L,2L)))
        ));
    }
}
