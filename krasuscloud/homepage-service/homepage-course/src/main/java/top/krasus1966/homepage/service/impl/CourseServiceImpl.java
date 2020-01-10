package top.krasus1966.homepage.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import top.krasus1966.homepage.CourseInfo;
import top.krasus1966.homepage.CourseInfosRequest;
import top.krasus1966.homepage.dao.HomepageCourseDao;
import top.krasus1966.homepage.entity.HomepageCourse;
import top.krasus1966.homepage.service.ICourseService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Krasus1966
 * @date 2019/12/20 16:39
 **/
@Slf4j
@Service
public class CourseServiceImpl implements ICourseService {

    private final HomepageCourseDao homepageCourseDao;

    @Autowired
    public CourseServiceImpl(HomepageCourseDao homepageCourseDao) {
        this.homepageCourseDao = homepageCourseDao;
    }

    @Override
    public CourseInfo getCourseInfo(Long id) {
        Optional<HomepageCourse> course = homepageCourseDao.findById(id);
        return buildCourseInfo(course.orElse(HomepageCourse.invalid()));
    }

    @Override
    public List<CourseInfo> getCourseInfos(CourseInfosRequest request) {
        if(CollectionUtils.isEmpty(request.getIds())){
            return Collections.emptyList();
        }
        List<HomepageCourse> courses = homepageCourseDao.findAllById(request.getIds());

        return courses.stream().map(this::buildCourseInfo).collect(Collectors.toList());
    }

    private CourseInfo buildCourseInfo(HomepageCourse course){
        return CourseInfo.builder()
                .id(course.getId())
                .courseName(course.getCourseName())
                .courseIcon(course.getCourseIcon())
                .courseType(course.getCourseType() ==0
                        ? "免费课程":"实战课程")
                .courseIntro(course.getCourseIntro())
                .build();
    }
}
