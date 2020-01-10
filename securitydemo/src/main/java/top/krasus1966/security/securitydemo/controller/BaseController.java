package top.krasus1966.security.securitydemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.krasus1966.security.securitydemo.dao.UsersMapper;

@Controller
public class BaseController {

    @Autowired
    public UsersMapper usersMapper;

    @GetMapping("/")
    @ResponseBody
    public String wel(){
        return "hello111";
    }
}
