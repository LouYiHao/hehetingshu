package com.hehetingshu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hehetingshu.entity.Book;
import com.hehetingshu.entity.Classification;
import com.hehetingshu.service.BookService;
import com.hehetingshu.service.ClassificationService;
	
@Controller
@RequestMapping("book")
public class BookController {
	
	@Resource
	BookService b;
	@RequestMapping("selectAllBycfid")
	@ResponseBody
	public List<Book> findAll(String cfid){
		System.out.println(cfid);
		List<Book> selectAll = b.selectAllBycfid(cfid);
		System.out.println(selectAll);
		return selectAll;
	}
		@Resource
		ClassificationService c;
		@RequestMapping("selectAllBycfids")
		public String findAll(HttpSession session){
			/*前台分类信息显示*/
			List<Classification> cAll = c.selectAll();
			for(int i=0;i<cAll.size();i++){
				List<Book> blist = b.selectAllBycfid(cAll.get(i).getCfid());
				cAll.get(i).setListbook(blist);	
			}	
			session.setAttribute("clist", cAll);
			/*前台推荐显示*/
			List<Book> bookAll = b.selectAll();
			session.setAttribute("bookAll", bookAll);
			/*前台图片轮播显示*/
			session.setAttribute("bookimgs", bookAll);
			return "home";
		}

}
