package com.tianxing.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.tianxing.springboot.pojo.TRecord;

/**
 * TRecordDAO继承基类
 */
@Repository
public interface TRecordDAO extends MyBatisBaseDao<TRecord, Integer> {
	/**
	 * 查询奖惩
	 * */
	public List<TRecord> getTRecord(@Param("stucode")String stucode,@Param("stuname")String stuname,@Param("name")String name,@Param("id")Integer id);
	/**
	 * 修改奖惩
	 * */
	public Integer modifyTRecord(@Param("trecord")TRecord trecord); 
	
	/**
	 * 删除奖惩
	 * */
	public Integer deleteTRecord(@Param("id")Integer id);
	
	/**
	 * 添加奖惩
	 * */
	public Integer addTRecord(@Param("trecord")TRecord trecord); 
}