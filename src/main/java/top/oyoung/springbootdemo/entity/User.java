package top.oyoung.springbootdemo.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @Method: top.oyoung.springmvc.entity
 * @Desc:
 * @Author: Yang Weixin
 * @Date: 2018/3/26 10:11
 */
@Alias("User")
public class User implements Serializable{

    private int id ;
    private String account;
    private String name;
    private String address;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
