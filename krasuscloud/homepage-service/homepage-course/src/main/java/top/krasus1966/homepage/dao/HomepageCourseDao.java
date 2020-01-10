package top.krasus1966.homepage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.krasus1966.homepage.entity.HomepageCourse;

/**
 * @author Krasus1966
 * @date 2019/12/20 16:34
 **/
public interface HomepageCourseDao extends JpaRepository<HomepageCourse,Long> {
}
