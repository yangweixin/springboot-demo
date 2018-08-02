package top.oyoung.springbootdemo.dao;

import org.springframework.data.repository.CrudRepository;
import top.oyoung.springbootdemo.jpa.entity.Role;

/**
 * @Author: Yang Weixin
 * @Description:
 * @DateTime: 2018/8/2 上午11:14
 */
public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByName(String name);
}
