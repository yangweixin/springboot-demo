package top.oyoung.springbootdemo.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.PathVariable;
import top.oyoung.springbootdemo.entity.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    public User getUser();

    @Select("select * from user where id=#{id}")
    public User getUserById(int id);

    @Insert({"insert user (account,name,address) value(#{name}, #{name}, #{name})}"})
    public int insertUser(String name);

    @Insert("insert into user (account,name,address) value('sun','孙秘书','西安')")
    public void insert();

    @Update("update user set account='zhen' where id=2")
    public void update();

    @Update("update user set account=#{account} where id=#{id}")
    public void updateUserById(@Param("account") String account, @Param("id")int id);

    @Delete("delete from user where id=1")
    public void delete();

    @Select("select * from user")
    public List<Map<String, Object>> query();
}
