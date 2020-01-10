package top.krasus1966.security.securitydemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetailsService;
import top.krasus1966.security.securitydemo.pojo.User;

public interface UserService extends IService<User>, UserDetailsService {
}
