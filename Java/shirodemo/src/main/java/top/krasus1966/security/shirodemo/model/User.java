package top.krasus1966.security.shirodemo.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class User {
    @TableId
    private Integer uid;
    private String username;
    private String password;
    @TableField(exist = false)
    private Set<Role> roles = new HashSet<>();
}
