package top.krasus1966.homepage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.krasus1966.homepage.entity.HomepageUser;

/**
 * @author Krasus1966
 * @date 2019/12/23 16:24
 **/
public interface HomepageUserDao extends JpaRepository<HomepageUser,Long> {

    HomepageUser findByUsername(String username);
}
