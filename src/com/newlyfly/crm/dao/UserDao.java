package com.newlyfly.crm.dao;

import com.newlyfly.crm.domain.User;

import java.util.List;

/**
 * Created by llf in 11:53 2017/9/28
 */
public interface UserDao {

    User get(Long id);

    List<User> queryAll(String hql);

    // 增
    void save(User user);

    // 删
    void delete(User user);

    // 改
    void update(User user);

    // 根据id查询单条对象customercustomer
    User queryUserById(Long id);

    // 根据用户名和密码查询单条用户
    User queryUserByUserNameAndPassword(String userName, String password);

    // 使用query分页查询
    List<User> queryPage(Integer start, Integer end);

    List<User> criteriaAll();

}
