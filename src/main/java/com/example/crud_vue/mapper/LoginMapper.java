package com.example.crud_vue.mapper;

import com.example.crud_vue.entity.Login;

//登录接口
public interface LoginMapper {

    //通过id来查询登录用户信息
    Login selectByPrimaryKey(Integer id);

    Login selectByUsernameAndPassword(Login login);

}
