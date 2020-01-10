package top.krasus1966.security.securitydemo.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collections;


/**
 * 替换security的User实体
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserDetail extends org.springframework.security.core.userdetails.User {
    private User user;
    public UserDetail(User user1) {
        super(user1.getUserName(), user1.getPwd(), true, true, true, true, Collections.EMPTY_SET);
        this.user= user1;
    }
}
