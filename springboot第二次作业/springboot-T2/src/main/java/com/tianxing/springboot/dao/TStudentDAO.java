package com.tianxing.springboot.dao;

import com.tianxing.springboot.pojo.TStudent;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * TStudentDAO继承基类
 */
@Repository
public interface TStudentDAO extends MyBatisBaseDao<TStudent, Integer> {
	/**
	 * 查询学生 
	 * */
	public List<TStudent> getTStudent(@Param("code")String code,@Param("pwd")String pwd);
}