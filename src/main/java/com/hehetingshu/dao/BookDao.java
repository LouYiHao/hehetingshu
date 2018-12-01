package com.hehetingshu.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.hehetingshu.entity.Book;

@Mapper
public interface BookDao {
    int deleteByPrimaryKey(Integer bookid);

    int insert(Book record);
    
    Book selectByPrimaryKey(Integer bookid);
    @Select("select * from Book")
    List<Book> selectAll();
    
    @Select("select * from Book where cfid=#{param1}")
    List<Book> selectAllBycfid(String cfid);

    int updateByPrimaryKey(Book record);
}