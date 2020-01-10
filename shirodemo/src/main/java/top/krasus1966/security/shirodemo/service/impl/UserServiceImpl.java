package top.krasus1966.security.shirodemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.krasus1966.security.shirodemo.mapper.UserMapper;
import top.krasus1966.security.shirodemo.model.User;
import top.krasus1966.security.shirodemo.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
