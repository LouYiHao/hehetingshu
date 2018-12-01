package com.hehetingshu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hehetingshu.dao.ClassificationDao;
import com.hehetingshu.entity.Classification;

@Service
@Transactional
public class ClassificationService {
	@Resource
	ClassificationDao c;
	public List<Classification> selectAll(){
		return c.selectAll();
	}
}
