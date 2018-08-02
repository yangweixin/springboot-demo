package top.oyoung.springbootdemo.jpa.entity;

import javax.persistence.Embeddable;

/**
 * @Author: Yang Weixin
 * @Description:
 * @DateTime: 2018/8/2 下午2:38
 */
@Embeddable
public class Contact {

    private int type;
    private String value;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Contact{" +
            "type=" + type +
            ", value='" + value + '\'' +
            '}';
    }
}
