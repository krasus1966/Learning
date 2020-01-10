package top.krasus1966.security.securitydemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.krasus1966.security.securitydemo.pojo.User;

@Mapper
public interface UsersMapper extends BaseMapper<User> {

}
