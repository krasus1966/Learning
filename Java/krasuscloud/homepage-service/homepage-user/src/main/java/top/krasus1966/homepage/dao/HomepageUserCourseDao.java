package top.krasus1966.homepage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.krasus1966.homepage.entity.HomepageUserCourse;

import java.util.List;

/**
 * @author Krasus1966
 * @date 2019/12/23 16:24
 **/
public interface HomepageUserCourseDao extends JpaRepository<HomepageUserCourse,Long> {

    List<HomepageUserCourse> findAllByUserId(Long userId);
}
