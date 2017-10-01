package com.newlyfly.crm.action;

import com.newlyfly.crm.domain.Customer;
import com.newlyfly.crm.service.CustomerService;
import com.newlyfly.crm.service.impl.CustomerServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import java.util.List;
import java.util.Set;

/**
 * Created by llf in 11:55 2017/9/28
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
    private Customer model = new Customer();
    @Override
    public Customer getModel() {
        return model;
    }

    CustomerService customerService = new CustomerServiceImpl();
    //去客户列表页面

    public String list() throws Exception {
        List<Customer> list = customerService.queryAll();
//        for (Customer customer : list) {
//            customer.getCustLinkman();
//        }
//
//        Customer customer = list.get(0);
//
//        Set<LinkMan> custLinkman = customer.getCustLinkman();
//
//        for (LinkMan linkMan : custLinkman) {
//
//        }
//        LinkMan[] objects = (LinkMan[]) custLinkman.toArray();
//        String lkmName = objects[0].getLkmName();
        ServletActionContext.getRequest().setAttribute("list",list);
        return SUCCESS;
    }

    //去新增客户页面
    public String toAdd() throws Exception {
        return "toAdd";
    }

    //添加客户
    public String add() throws Exception {
        customerService.save(model);
        return "add";
    }

    //删除客户
    public String delete() throws Exception {
        customerService.delete(model);
        return "delete";
    }

    //去修改客户信息页面
    public String toUpdate() throws Exception {
        //根据传过来的id先查询出当前对象
        Customer customer = customerService.get(model.getCustId());
        //将对象放入request域
        ServletActionContext.getRequest().setAttribute("customer",customer);
        return "toUpdate";
    }

    //编辑客户
    public String update() throws Exception {
        return "update";
    }
}
