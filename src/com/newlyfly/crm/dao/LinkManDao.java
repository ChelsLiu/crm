package com.newlyfly.crm.dao;

import com.newlyfly.crm.domain.LinkMan;

import java.util.List;

/**
 * Created by llf in 11:53 2017/9/28
 */
public interface LinkManDao {

    LinkMan get(Long id);

    List<LinkMan> queryAll(String hql);

    //增
    void save(LinkMan linkMan);

    //删
    void delete(LinkMan linkMan);

    //改
    void update(LinkMan linkMan);

    //根据id查询单条对象
    LinkMan queryLinkManById(Long id);

    //使用query分页查询
    List<LinkMan> queryPage(Integer start, Integer end);

    List<LinkMan> criteriaAll();

}
