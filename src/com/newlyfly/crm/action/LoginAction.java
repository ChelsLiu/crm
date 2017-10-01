package com.newlyfly.crm.action;

import com.newlyfly.crm.domain.User;
import com.newlyfly.crm.service.UserService;
import com.newlyfly.crm.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by llf in 15:04 2017/10/1
 */
public class LoginAction extends ActionSupport implements ModelDriven<User>{
    private User model = new User();
    @Override
    public User getModel() {
        return model;
    }

    UserService userService = new UserServiceImpl();

    private String msg;

    public String login() throws Exception {
        //根据登录信息
        User user = userService.queryUserByUserNameAndPassword(model.getUserName(), model.getPassword());

        if (!StringUtils.isNotBlank(model.getUserName())){
            msg = "用户名不能为空！";
        }else if (null == user){
            msg = "用户不存在！";
        }else if (!StringUtils.isNotBlank(model.getPassword())){
            msg = "密码不能为空！";
        }else if (!model.getPassword().equals(user.getPassword())){
            msg = "密码错误！";
        }else {
            ActionContext.getContext().getSession().put("user",user);
            return SUCCESS;
        }
        return ERROR;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
