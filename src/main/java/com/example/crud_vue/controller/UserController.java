package com.example.crud_vue.controller;

import com.example.crud_vue.common.Result;
import com.example.crud_vue.entity.User;
import com.example.crud_vue.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
//用户控制器
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    //新增用户
    @PostMapping
    public Result add(@RequestBody User user){
        userService.save(user);
        return Result.success();
    }

    //修改用户
    @PutMapping
    public Result update(@RequestBody User user){
        userService.save(user);
        return Result.success();
    }

    //删除用户
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Long id){
        userService.delete(id);
        return Result.success();
    }

    //根据id查询用户信息
    @GetMapping("/{id}")
    public Result<User> findById(@PathVariable("id") Long id){

        return Result.success(userService.findById(id));
    }

    //查询所有用户
    public Result<List<User>> findAll(){
        return Result.success(userService.findAll());
    }

    //分页模糊查询
    @GetMapping("/page")
    public Result<Page<User>> findPage(@RequestParam(defaultValue = "1")Integer pageNum,
                                       @RequestParam(defaultValue = "10")Integer pageSize,
                                       @RequestParam(required = false)String name){
        return Result.success(userService.findPage(pageNum,pageSize,name));
    }
}
