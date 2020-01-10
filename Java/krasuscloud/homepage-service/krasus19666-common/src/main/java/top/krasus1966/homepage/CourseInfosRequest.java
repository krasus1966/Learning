package top.krasus1966.homepage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Krasus1966
 * @date 2019/12/19 11:36
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseInfosRequest {
    private List<Long> ids;
}
