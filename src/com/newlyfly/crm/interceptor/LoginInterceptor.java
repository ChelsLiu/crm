package com.newlyfly.crm.interceptor;

import com.newlyfly.crm.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * Created by llf in 14:44 2017/10/1
 * 登录拦截器
 * 根据session域中是否存在登录信息
 */
public class LoginInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        //获得session域中的User对象
        User user = (User) ActionContext.getContext().getSession().get("user");
        //判断user是否存在
        if (null == user || "".equals(user)){
//            不存在跳转到登录页面
            return "toLogin";
        }else {
//            存在user，放行
            return actionInvocation.invoke();
        }
    }
}
