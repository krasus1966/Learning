package top.krasus1966.security.securitydemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebAdapter implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/users/register").setViewName("register.html");
        registry.addViewController("/users/login").setViewName("login.html");
        registry.addViewController("/error").setViewName("error.html");
    }
}
