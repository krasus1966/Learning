package top.krasus1966.homepage.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.krasus1966.homepage.CourseInfo;
import top.krasus1966.homepage.UserInfo;

import java.util.Collections;
import java.util.List;

/**
 * 用户课程信息对象定义
 * @author Krasus1966
 * @date 2019/12/23 16:54
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCourseInfo {
    private UserInfo userInfo;
    private List<CourseInfo> courseInfos;

    public static UserCourseInfo invalid(){
        return new UserCourseInfo(UserInfo.invalid(), Collections.emptyList());
    }
}
