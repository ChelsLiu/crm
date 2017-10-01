package com.newlyfly.crm.action;

import com.newlyfly.crm.domain.Customer;
import com.newlyfly.crm.domain.LinkMan;
import com.newlyfly.crm.service.CustomerService;
import com.newlyfly.crm.service.LinkManService;
import com.newlyfly.crm.service.impl.CustomerServiceImpl;
import com.newlyfly.crm.service.impl.LinkManServiceImpl;
import com.newlyfly.crm.util.PageBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by llf in 13:34 2017/9/28
 */
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        CustomerService customerService = new CustomerServiceImpl();
        LinkManService linkManService = new LinkManServiceImpl();

        String method = request.getParameter("method");
        if ("add".equals(method)){
            response.sendRedirect("/jsp/customer/add.jsp");
        }else if ("list".equals(method)){
            List<Customer> total = customerService.queryAll();
            String currentPage1 = request.getParameter("currentPage");
            String pageSize1 = request.getParameter("pageSize");
            if (currentPage1 == null || "".equals(currentPage1)){
                currentPage1 = "1";
            }
            if (pageSize1 == null || "".equals(pageSize1)){
                pageSize1 = "5";
            }
            Integer currentPage = Integer.valueOf(currentPage1);
            Integer pageSize = Integer.valueOf(pageSize1);
            PageBean pageBean = new PageBean(currentPage, pageSize, total.size());
            request.setAttribute("pageBean",pageBean);
            Integer start = (currentPage - 1) * pageSize;
            List<Customer> list = customerService.queryPage(start, start + pageSize);
            request.setAttribute("list",list);
            request.getRequestDispatcher("/jsp/customer/list.jsp").forward(request,response);
        }else if ("edit".equals(method)){
            response.sendRedirect("/jsp/customer/edit.jsp");
        }else if ("delete".equals(method)){
            String custId = request.getParameter("custId");
            Long id = Long.valueOf(custId);
//            long id = Long.parseLong(custId);
            Customer customer = customerService.get(id);
            customerService.delete(customer);
            request.getRequestDispatcher("/customerServlet?method=list").forward(request,response);
        }else if ("addsubmit".equals(method)){
            Customer customer = new Customer();
            customer.setCustName(request.getParameter("custName"));
            customer.setCustLevel(request.getParameter("custLevel"));
            customer.setCustSource(request.getParameter("custSource"));
            LinkMan linkMan = new LinkMan();
            linkMan.setLkmName(request.getParameter("custLinkman"));
            customer.getCustLinkman().add(linkMan);
            customer.setCustPhone(request.getParameter("custPhone"));
            customer.setCustMobile(request.getParameter("custMobile"));
            customer.setCustAddress(request.getParameter("custAddress"));
            customer.setCustZipcode(request.getParameter("custZip"));
            customer.setCustFax(request.getParameter("custFax"));
            customer.setCustWebsite(request.getParameter("custWebsite"));
            linkMan.setCustId(customer);
            customerService.save(customer);
            linkManService.save(linkMan);
//            response.sendRedirect("/jsp/customer/list.jsp");
            //点击保存后跳转到首页，同时查询所有数据
            request.getRequestDispatcher("/customerServlet?method=list").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
