package com.newlyfly.crm.service;

import com.newlyfly.crm.domain.User;
import com.newlyfly.crm.domain.User;

import java.util.List;

/**
 * Created by llf in 11:55 2017/9/28
 */
public interface UserService {

    User get(Long id);

    List<User> queryAll();

    void save(User user);

    void delete(User user);

    void update(User user);

    User queryUserById(Long id);

    // 根据用户名和密码查询用户
    User queryUserByUserNameAndPassword(String userName, String password);

    // 根据用户名查询单条用户
    User queryUserByUserName(String userName);

    List<User> queryPage(Integer start, Integer end);
}
