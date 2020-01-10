package top.krasus1966.security.securitydemo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class User  {

    @TableId(type = IdType.UUID)
    //用户唯一标识
    private String uuid;
    //用户名
    private String userName;
    //密码
    private String pwd;
    //昵称
    private String userId;
    //电话号
    private String tel;
    //邮箱
    private String email;

}
