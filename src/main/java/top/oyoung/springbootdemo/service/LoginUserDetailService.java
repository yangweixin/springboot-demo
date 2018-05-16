package top.oyoung.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.oyoung.springbootdemo.Constants.Constants;
import top.oyoung.springbootdemo.dao.UserDao;
import top.oyoung.springbootdemo.entity.User;

import javax.annotation.Resource;

/**
 * @Author: Yang Weixin
 * @Description:
 * @DateTime: 2018/5/15 下午4:51
 */
@Service
public class LoginUserDetailService implements UserDetailsService {

    @Resource
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.getUserByAccount(username);
        if(user != null) {
            user.addAuthorities(new SimpleGrantedAuthority(Constants.SECURITY_ROLE_PREFIX + "NOMAL"));
        }
        return user;
    }
}
