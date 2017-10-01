package com.newlyfly.crm.service;

import com.newlyfly.crm.domain.LinkMan;

import java.util.List;

/**
 * Created by llf in 11:55 2017/9/28
 */
public interface LinkManService {

    LinkMan get(Long id);

    List<LinkMan> queryAll();

    void save(LinkMan linkMan);

    void delete(LinkMan linkMan);

    void update(LinkMan linkMan);

    LinkMan queryLinkManById(Long id);

    List<LinkMan> queryPage(Integer start, Integer end);
}
