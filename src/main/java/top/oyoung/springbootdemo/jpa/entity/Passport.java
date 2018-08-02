package top.oyoung.springbootdemo.jpa.entity;

import javax.persistence.*;

/**
 * @Author: Yang Weixin
 * @Description:
 * @DateTime: 2018/8/2 下午3:55
 */
@Entity
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double money = 0.0;

    protected Passport(){

    }

    public Passport(double money) {
        this.money = money;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }


    @Override
    public String toString() {
        return "Passport{" +
            "id=" + id +
            ", money=" + money +
            '}';
    }
}
