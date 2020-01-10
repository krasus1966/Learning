package top.krasus1966.security.securitydemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import top.krasus1966.security.securitydemo.service.impl.UserServiceImpl;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserServiceImpl userServiceImpl;

    /**
     * 登录验证，访问数据库
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userServiceImpl).passwordEncoder(new BCryptPasswordEncoder());
    }

    /**
     * http请求过滤
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .antMatchers("/") .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .logout().permitAll()
                .and()
                .formLogin()


        //自定义登录页面
//                .loginPage("/users/login")
//                .loginProcessingUrl("/users/toLogin")
//                .defaultSuccessUrl("/")
//                .permitAll()
//                .usernameParameter("userName")
//                .passwordParameter("pwd")
        ;
        http.csrf().disable();
    }

    /**
     * 不过滤静态资源
     *
     * @param web
     */
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/js/**", "/css/**", "/img/**", "https://cdn.90so.net/jquery/3.4.1/jquery.min.js");
    }
}
