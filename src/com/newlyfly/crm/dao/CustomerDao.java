package com.newlyfly.crm.dao;

import com.newlyfly.crm.domain.Customer;

import java.util.List;

/**
 * Created by llf in 11:53 2017/9/28
 */
public interface CustomerDao{

    Customer get(Long id);

    List<Customer> queryAll(String hql);

    //增
    void save(Customer customer);

    //删
    void delete(Customer customer);

    //改
    void update(Customer customer);

    //根据id查询单条对象
    Customer queryCustomerById(Long id);

    //使用query分页查询
    List<Customer> queryPage(Integer start, Integer end);

    List<Customer> criteriaAll();

}
