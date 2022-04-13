package com.example.crud_vue.mapper;

import com.example.crud_vue.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
// User表的DAO层接口，并没有具体的实现，继承基础CRUD实现
// 泛型1：实体类 泛型2：主键映射类型

/**
 * @Repository(value="userDao")注解是告诉Spring，让Spring创建一个名字叫“userDao”的UserDaoImpl实例。
 */
@Repository
public interface UserMapper extends JpaRepository<User,Long> {

    @Query(value = "select * from test_demo where name like %?1%",nativeQuery = true)
    Page<User> findByNameLike(String name, Pageable pageRequest);

}
