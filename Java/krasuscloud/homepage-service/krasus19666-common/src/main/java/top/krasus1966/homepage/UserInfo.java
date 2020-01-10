package top.krasus1966.homepage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 基本用户信息
 * @author Krasus1966
 * @date 2019/12/19 11:20
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    private Long id;
    private String username;
    private String email;

    public static UserInfo invalid(){
        return new UserInfo(-1L,"","");
    }
}
