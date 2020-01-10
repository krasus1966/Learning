package top.krasus1966.homepage.service;

import top.krasus1966.homepage.CourseInfo;
import top.krasus1966.homepage.CourseInfosRequest;

import java.util.List;

/**
 * @author Krasus1966
 * @date 2019/12/20 16:37
 **/
public interface ICourseService {

    /**
     * 通过ID获取课程信息
     * @param id
     * @return
     */
    CourseInfo getCourseInfo(Long id);

    /***
     * 通过ids获取课程信息
     * @param request
     * @return
     */
    List<CourseInfo> getCourseInfos(CourseInfosRequest request);

}
