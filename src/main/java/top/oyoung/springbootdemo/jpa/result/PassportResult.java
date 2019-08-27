package top.oyoung.springbootdemo.jpa.result;

/**
 * @Author: Yang Weixin
 * @Description:
 * @DateTime: 2018/8/7 下午2:48
 */
public class PassportResult {

    private long id;
    private double money;
    private String username;

    protected PassportResult() {}

    public PassportResult(long id, double money, String username) {
        this.id = id;
        this.money = money;
        this.username = username;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "PassportResult{" +
            "id='" + id + '\'' +
            ", money='" + money + '\'' +
            ", username='" + username + '\'' +
            '}';
    }
}
