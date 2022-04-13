package com.example.crud_vue.service;

import com.example.crud_vue.mapper.UserMapper;
import com.example.crud_vue.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service    //定义业务逻辑层
public class UserService {

    @Resource  //自动装配DAO（这里用的是mapper）
    private UserMapper userMapper;

    //新增和修改
    public void save(User user){
        String now = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        user.setCreateTime(now);
        userMapper.save(user);
    }

    //删除
    public void delete(Long id){
        userMapper.deleteById(id);
    }

    //根据id查询用户
    public User findById(Long id){

        return userMapper.findById(id).orElse(null);
    }

    //查询所有用户
    public List<User> findAll() {
        return userMapper.findAll();
    }

    //分页查询用户
    public Page<User> findPage(Integer pageNum,Integer pageSize,String name){
        // 构建分页查询条件
        Sort sort = Sort.by(Sort.Direction.DESC, "create_time");
        Pageable pageRequest = PageRequest.of(pageNum - 1, pageSize, sort);
        return userMapper.findByNameLike(name,pageRequest);
    }
}
