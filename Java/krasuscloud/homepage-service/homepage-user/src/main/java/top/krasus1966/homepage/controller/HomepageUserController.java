package top.krasus1966.homepage.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import top.krasus1966.homepage.UserInfo;
import top.krasus1966.homepage.service.IUserService;
import top.krasus1966.homepage.vo.CreateUserRequest;
import top.krasus1966.homepage.vo.UserCourseInfo;

/**
 * @author Krasus1966
 * @date 2019/12/23 17:14
 **/
@Slf4j
@Controller
public class HomepageUserController {
    private final IUserService iUserService;

    public HomepageUserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @PostMapping("/create/user")
    public UserInfo createUser(@RequestBody CreateUserRequest request){
        log.info("<homepage-user>:create user ->{}", JSON.toJSONString(request));
        return iUserService.createUser(request);
    }

    @GetMapping("/get/user")
    public UserInfo getUserInfo(Long id){
        log.info("<homepage-user>:get user ->{}", id);
        return iUserService.getUserInfo(id);
    }
    @GetMapping("/get/user/course")
    public UserCourseInfo getUserCourseInfo(Long id){
        log.info("<homepage-user>:get user course info ->{}", id);
        return iUserService.getUserCourseInfo(id);
    }
}
