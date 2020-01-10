package top.krasus1966.mybatisplustest.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.krasus1966.mybatisplustest.dao.UserMapper;
import top.krasus1966.mybatisplustest.pojo.User;
import top.krasus1966.mybatisplustest.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>  implements UserService {
    @Override
    public String saves() {
        return null;
    }
}
