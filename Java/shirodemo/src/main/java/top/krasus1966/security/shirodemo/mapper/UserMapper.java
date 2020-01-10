package top.krasus1966.security.shirodemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.krasus1966.security.shirodemo.model.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
