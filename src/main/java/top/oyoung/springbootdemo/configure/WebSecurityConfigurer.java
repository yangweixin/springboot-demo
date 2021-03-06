package top.oyoung.springbootdemo.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import top.oyoung.springbootdemo.filter.AntiXXSFilter;
import top.oyoung.springbootdemo.filter.LoginAuthenticationEntryPoint;
import top.oyoung.springbootdemo.filter.LoginAuthenticationProvider;
import top.oyoung.springbootdemo.filter.RestAccessDeniedHandler;

import javax.annotation.Resource;

/**
 * @Author: Yang Weixin
 * @Description:
 * @DateTime: 2018/5/15 下午3:57
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginAuthenticationProvider authenticationProvider;
    @Autowired
    private AntiXXSFilter antiXXSFilter;
    @Resource
    private LoginAuthenticationEntryPoint authenticationEntryPoint;
    @Resource
    private RestAccessDeniedHandler accessDeniedHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.addFilterBefore(antiXXSFilter, FilterSecurityInterceptor.class);

        http
            .csrf()
                .disable()
            .exceptionHandling()
//                .authenticationEntryPoint(authenticationEntryPoint)
                .accessDeniedHandler(accessDeniedHandler)

                .and()
            .formLogin()
                .and()
            .authorizeRequests()
                .antMatchers("/css/**", "/js/**","/images/**", "/webjars/**", "**/favicon.ico", "/index").permitAll()
//                .antMatchers(HttpMethod.GET,"/test/3/**").hasRole("NOMAL")
//                .antMatchers(HttpMethod.POST, "/test/4/**").hasRole("ADMIN")
                .antMatchers("/test/**").permitAll()
                .anyRequest().authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
            .antMatchers(
                "/swagger-ui.html",
                "/v2/api-docs",
                "/swagger-resources",
                "/swagger-resources/configuration/ui",
                "/swagger-resources/configuration/security"
                );
    }
}
