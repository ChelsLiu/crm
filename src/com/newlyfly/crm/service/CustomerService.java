package com.newlyfly.crm.service;

import com.newlyfly.crm.domain.Customer;

import java.util.List;

/**
 * Created by llf in 11:55 2017/9/28
 */
public interface CustomerService {

    Customer get(Long id);

    List<Customer> queryAll();

    void save(Customer customer);

    void delete(Customer customer);

    void update(Customer customer);

    Customer queryCustomerById(Long id);

    List<Customer> queryPage(Integer start, Integer end);
}
