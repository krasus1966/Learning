package top.krasus1966.security.securitydemo.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.krasus1966.security.securitydemo.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/users")
public class UsersController extends BaseController {

    @ResponseBody
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/")
    public String hello(){
        return "hello";
    }

    @ResponseBody
    @PostMapping("/toRegister")
    public String toRegister(User users, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String msg;
        users.setPwd(new BCryptPasswordEncoder().encode(users.getPwd()));
        if(usersMapper.insert(users)==1){
            System.out.println("注册成功");
            msg="注册成功";
            response.sendRedirect(request.getContextPath()+ "/login");
        }else{
            System.out.println("注册失败");
            msg="注册失败";
            response.sendRedirect(request.getContextPath()+ "/users/register");
        }
        request.setAttribute("msg",msg);
        return null;
    }

    @GetMapping("/index/{userId}")
    public String userHome(@PathVariable("userId") String userId, HttpServletRequest request, HttpServletResponse response){
        System.out.println(userId);
        return "userhome";
    }
}
