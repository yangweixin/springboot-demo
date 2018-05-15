package top.oyoung.springbootdemo.entity;

import org.apache.ibatis.type.Alias;
<<<<<<< Updated upstream
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
=======
import org.springframework.core.annotation.AliasFor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
>>>>>>> Stashed changes

/**
 * @Method: top.oyoung.springmvc.entity
 * @Desc:
 * @Author: Yang Weixin
 * @Date: 2018/3/26 10:11
 */
@Alias("User")
<<<<<<< Updated upstream
public class User implements Serializable,UserDetails {

    private int id ;
    private String account;
    private String username;
    private String password;
    private String address;
    private List<GrantedAuthority> authorities = new ArrayList<>();


=======
public class User implements UserDetails,Serializable{

    private int id ;
    private String account;

    private String username;
    private String address;
    private String password;
>>>>>>> Stashed changes

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account='" + account + '\'' +
<<<<<<< Updated upstream
                ", name='" + username + '\'' +
=======
                ", username='" + username + '\'' +
>>>>>>> Stashed changes
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

<<<<<<< Updated upstream

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void addAuthorities(GrantedAuthority authoritie) {
        this.authorities.add(authoritie);
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
=======
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_READER"));
>>>>>>> Stashed changes
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
