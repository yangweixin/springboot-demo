package top.oyoung.springbootdemo.dao;

import org.springframework.data.repository.CrudRepository;
import top.oyoung.springbootdemo.jpa.entity.Passport;

/**
 * @Author: Yang Weixin
 * @Description:
 * @DateTime: 2018/8/2 下午4:32
 */
public interface PassportRepository extends CrudRepository<Passport, Long> {
}
