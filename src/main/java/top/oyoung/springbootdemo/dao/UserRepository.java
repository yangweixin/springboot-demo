package top.oyoung.springbootdemo.dao;

import org.springframework.data.repository.CrudRepository;
import top.oyoung.springbootdemo.jpa.entity.Teacher;

/**
 * @Author: Yang Weixin
 * @Description:
 * @DateTime: 2018/8/2 下午2:29
 */
public interface UserRepository extends CrudRepository<Teacher, Long> {

}
