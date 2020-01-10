package top.krasus1966.security.securitydemo.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.krasus1966.security.securitydemo.dao.UsersMapper;
import top.krasus1966.security.securitydemo.pojo.User;
import top.krasus1966.security.securitydemo.pojo.UserDetail;
import top.krasus1966.security.securitydemo.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UsersMapper, User> implements UserService{

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = new User();
        user.setUserName(username);
        User user1 = usersMapper.selectOne(new QueryWrapper<>(user));
        if(user1==null){
            System.out.println("用户不存在");
            throw new UsernameNotFoundException("用户不存在");
        }else{
            System.out.println("登录成功");

            return new UserDetail(user1);
        }
    }


}
