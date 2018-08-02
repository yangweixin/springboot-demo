package top.oyoung.springbootdemo.jpa.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Yang Weixin
 * @Description:
 * @DateTime: 2018/8/2 下午2:24
 */
@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @ElementCollection
    private Map<Long, Contact> contact = new HashMap<>();

    @OneToMany( targetEntity = Passport.class, cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<Passport> passport = new ArrayList<>();

    protected Teacher(){}

    public Teacher(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Map<Long, Contact> getContact() {
        return contact;
    }

    public void setContact(Map<Long, Contact> contact) {
        this.contact = contact;
    }

    public List<Passport> getPassports() {
        return passport;
    }

    public void setPassports(List<Passport> passport) {
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "Teacher{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", contact=" + contact +
            ", passports=" + passport +
            '}';
    }
}
