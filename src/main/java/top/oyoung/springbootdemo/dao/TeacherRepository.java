package top.oyoung.springbootdemo.dao;

import org.springframework.data.repository.CrudRepository;
import top.oyoung.springbootdemo.jpa.entity.Teacher;

/**
 * @Author: Yang Weixin
 * @Description:
 * @DateTime: 2018/8/2 下午2:50
 */
public interface TeacherRepository extends CrudRepository<Teacher, Long> {
}
