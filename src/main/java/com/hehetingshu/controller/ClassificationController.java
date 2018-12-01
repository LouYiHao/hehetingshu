package com.hehetingshu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hehetingshu.entity.Book;
import com.hehetingshu.entity.Classification;
import com.hehetingshu.service.ClassificationService;

@Controller
@RequestMapping("classification")
public class ClassificationController {
	@Resource
	ClassificationService c;
	@RequestMapping("findAll")
	@ResponseBody
	public List<Classification> findAll(){
		List<Classification> selectAll = c.selectAll();
		System.out.println(selectAll);
		return selectAll;
	}
	
	
}
