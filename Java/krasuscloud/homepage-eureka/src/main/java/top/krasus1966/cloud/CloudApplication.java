package top.krasus1966.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 1. 只需要使用 @EnableEurekaServer 注解就可以让应用变为 Eureka Server
 * 2. pom 文件中对应到 spring-cloud-starter-netflix-eureka-server
 * @author Krasus1966
 * @date 2019/12/18 9:32
 **/
@EnableEurekaServer
@SpringBootApplication
public class CloudApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudApplication.class,args);
    }
}
