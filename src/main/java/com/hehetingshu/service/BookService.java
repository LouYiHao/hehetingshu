package com.hehetingshu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hehetingshu.dao.BookDao;
import com.hehetingshu.entity.Book;

@Service
@Transactional
public class BookService {
	@Resource
	BookDao b;
	public int deleteByPrimaryKey(Integer bookid){
		 return b.deleteByPrimaryKey(bookid);
	 }

	public  int insert(Book record){
	  	return b.insert(record);
	 }
	public Book selectByPrimaryKey(Integer bookid){
		 return b.selectByPrimaryKey(bookid);
	 }

	public  List<Book> selectAll(){
	    	return b.selectAll();
	    }

	public  int updateByPrimaryKey(Book record){
	    	return b.updateByPrimaryKey(record);
	    }
	public  List<Book> selectAllBycfid(String cfid){
		return b.selectAllBycfid(cfid);
	}
 
}
