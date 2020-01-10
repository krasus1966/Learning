package top.krasus1966.homepage.service;

import top.krasus1966.homepage.UserInfo;
import top.krasus1966.homepage.vo.CreateUserRequest;
import top.krasus1966.homepage.vo.UserCourseInfo;

/**
 * 用户相关服务接口定义
 * @author Krasus1966
 * @date 2019/12/23 17:00
 **/
public interface IUserService {
    /**
     * 创建用户
     * @param request
     * @return
     */
    UserInfo createUser(CreateUserRequest request);

    /**
     * 根据ID获取用户信息
     * @param id
     * @return
     */
    UserInfo getUserInfo(Long id);

    /**
     * 获取用户和课程信息
     * @param id
     * @return
     */
    UserCourseInfo getUserCourseInfo(Long id );
}
