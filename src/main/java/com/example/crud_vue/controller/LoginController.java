package com.example.crud_vue.controller;

import com.example.crud_vue.common.Result;
import com.example.crud_vue.mapper.LoginMapper;
import com.example.crud_vue.entity.Login;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
//登录控制器
@RestController
@RequestMapping("/user")
public class LoginController {

    @Resource
    private LoginMapper loginMapper;

    @PostMapping("/login")
    public Result<Login> login(@RequestBody Login login){
        if (!checkParam(login)){
            return Result.error("-1","缺少必要参数");
        }
        Login login1 = loginMapper.selectByUsernameAndPassword(login);
        if (login1 == null){
            Result.error("-1","账户或密码错误");
        }
        return Result.success(login1);
    }

    private boolean checkParam(Login login){
        return login.getUsername() != null && login.getPassword() != null;
    }
}
