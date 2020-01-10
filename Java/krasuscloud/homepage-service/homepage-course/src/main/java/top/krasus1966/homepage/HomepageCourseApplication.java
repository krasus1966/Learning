package top.krasus1966.homepage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Springboot启动入口
 * @author Krasus1966
 * @date 2019/12/20 15:57
 **/
@EnableJpaAuditing
@EnableEurekaClient
@SpringBootApplication
public class HomepageCourseApplication {
    public static void main(String[] args) {
        SpringApplication.run(HomepageCourseApplication.class,args);
    }
}
