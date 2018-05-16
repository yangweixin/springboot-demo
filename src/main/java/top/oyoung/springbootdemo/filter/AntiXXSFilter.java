package top.oyoung.springbootdemo.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Filter;

/**
 * @Author: Yang Weixin
 * @Description:
 * @DateTime: 2018/5/15 下午6:52
 */
@Component
public class AntiXXSFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        System.out.printf("hello ~~ i am filter");
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
