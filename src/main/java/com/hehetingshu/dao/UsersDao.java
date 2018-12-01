package com.hehetingshu.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hehetingshu.entity.Users;
@Mapper
public interface UsersDao {
    int insert(Users record);

    List<Users> selectAll();
}