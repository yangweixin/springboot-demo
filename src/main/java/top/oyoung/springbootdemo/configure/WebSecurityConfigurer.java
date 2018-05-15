package top.oyoung.springbootdemo.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import top.oyoung.springbootdemo.filter.AntiXXSFilter;
import top.oyoung.springbootdemo.filter.LoginAuthenticationProvider;

/**
 * @Author: Yang Weixin
 * @Description:
 * @DateTime: 2018/5/15 下午3:57
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginAuthenticationProvider authenticationProvider;
    @Autowired
    private AntiXXSFilter antiXXSFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.addFilterBefore(antiXXSFilter, FilterSecurityInterceptor.class);

        http
            .formLogin()
                .and()
            .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/test/4/**").permitAll()
                .anyRequest()
                .authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }
}
