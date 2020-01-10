package top.krasus1966.homepage.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

/**
 * 创建用户请求对象定义
 * @author Krasus1966
 * @date 2019/12/23 16:52
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

    private String username;
    private String email;

    /**
     * 请求有效性验证
     * @return
     */
    public boolean validate(){

        return StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(email);
    }
}
