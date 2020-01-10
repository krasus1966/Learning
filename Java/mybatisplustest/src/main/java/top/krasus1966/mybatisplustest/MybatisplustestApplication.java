package top.krasus1966.mybatisplustest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.krasus1966.mybatisplustest.dao")
public class MybatisplustestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisplustestApplication.class, args);
    }

}
