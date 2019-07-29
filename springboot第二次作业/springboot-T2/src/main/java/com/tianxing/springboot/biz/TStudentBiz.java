package com.tianxing.springboot.biz;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.tianxing.springboot.dao.TStudentDAO;
import com.tianxing.springboot.pojo.TStudent;
@Service
public class TStudentBiz {
	@Resource
	private TStudentDAO dao;
	/**
	 * 查询学生 
	 * */
	public List<TStudent> getTStudent(@Param("code")String code,@Param("pwd")String pwd){
		return dao.getTStudent(code, pwd);
	}
}
