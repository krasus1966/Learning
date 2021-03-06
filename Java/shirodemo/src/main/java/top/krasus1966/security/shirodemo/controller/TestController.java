package top.krasus1966.security.shirodemo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.krasus1966.security.shirodemo.model.User;

import javax.servlet.http.HttpServletRequest;


@Controller
public class TestController {

    @RequestMapping("/login")
    public String login() {

        return "login";
    }

//    @RequestMapping("/index")
//    public String index() {
//        return "index";
//    }

    @RequestMapping("/loginUser")
    public String loginUser(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            HttpServletRequest request) {
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(token);
            User user = (User) subject.getPrincipal();
            request.setAttribute("user",user);
            return "index";
        }catch (Exception e){
            return "login";
        }
    }
}
