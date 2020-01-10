package top.krasus1966.homepage.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import top.krasus1966.homepage.CourseInfo;
import top.krasus1966.homepage.CourseInfosRequest;
import top.krasus1966.homepage.UserInfo;
import top.krasus1966.homepage.client.CourseClient;
import top.krasus1966.homepage.dao.HomepageUserCourseDao;
import top.krasus1966.homepage.dao.HomepageUserDao;
import top.krasus1966.homepage.entity.HomepageUser;
import top.krasus1966.homepage.entity.HomepageUserCourse;
import top.krasus1966.homepage.service.IUserService;
import top.krasus1966.homepage.vo.CreateUserRequest;
import top.krasus1966.homepage.vo.UserCourseInfo;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 用户相关服务实现
 *
 * @author Krasus1966
 * @date 2019/12/23 17:03
 **/
@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    private final HomepageUserDao homepageUserDao;

    private final HomepageUserCourseDao homepageUserCourseDao;

    private final CourseClient courseClient;

    @Autowired
    public UserServiceImpl(HomepageUserDao homepageUserDao, HomepageUserCourseDao homepageUserCourseDao, CourseClient courseClient) {
        this.homepageUserDao = homepageUserDao;
        this.homepageUserCourseDao = homepageUserCourseDao;
        this.courseClient = courseClient;
    }

    @Override
    public UserInfo createUser(CreateUserRequest request) {
        if (!request.validate()) {
            return UserInfo.invalid();
        }
        HomepageUser oldUser = homepageUserDao.findByUsername(request.getUsername());
        if (null != oldUser) {
            return UserInfo.invalid();
        }
        HomepageUser newUser = homepageUserDao.save(new HomepageUser(request.getUsername(), request.getEmail()));

        return new UserInfo(newUser.getId(), newUser.getUsername(), newUser.getEmail());
    }

    @Override
    public UserInfo getUserInfo(Long id) {
        Optional<HomepageUser> user = homepageUserDao.findById(id);
        if (!user.isPresent()) {
            return UserInfo.invalid();
        }
        HomepageUser curUser = user.get();
        return new UserInfo(curUser.getId(), curUser.getUsername(), curUser.getEmail());
    }

    @Override
    public UserCourseInfo getUserCourseInfo(Long id) {
        Optional<HomepageUser> user = homepageUserDao.findById(id);
        if (!user.isPresent()) {
            return UserCourseInfo.invalid();
        }
        HomepageUser homepageUser = user.get();
        UserInfo userInfo = new UserInfo(homepageUser.getId(), homepageUser.getUsername(), homepageUser.getEmail());

        List<HomepageUserCourse> userCourses = homepageUserCourseDao.findAllByUserId(id);
        if (CollectionUtils.isEmpty(userCourses)) {
            return new UserCourseInfo(userInfo, Collections.emptyList());
        }

        List<CourseInfo> courseInfos = courseClient.getCourseInfos(
                new CourseInfosRequest(userCourses.stream()
                        .map(HomepageUserCourse::getCourseId)
                        .collect(Collectors.toList()))
        );
        return new UserCourseInfo(userInfo,courseInfos);
    }
}
