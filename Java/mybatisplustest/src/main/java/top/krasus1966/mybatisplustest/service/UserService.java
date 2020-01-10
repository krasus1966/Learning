package top.krasus1966.mybatisplustest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.krasus1966.mybatisplustest.pojo.User;

public interface UserService extends IService<User> {
    String saves();
}
