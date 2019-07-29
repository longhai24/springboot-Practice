package com.tianxing.springboot.biz;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tianxing.springboot.dao.TRecordDAO;
import com.tianxing.springboot.pojo.TRecord;
@Service
public class TRecordBiz {
	@Resource
	private TRecordDAO dao;
	/**
	 * 查询奖惩
	 * */
	public List<TRecord> getTRecord(@Param("stucode")String stucode,@Param("stuname")String stuname,@Param("name")String name,@Param("id")Integer id){
		return dao.getTRecord(stucode, stuname, name, id);
	}
	/**
	 * 修改奖惩
	 * */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public Integer modifyTRecord(@Param("trecord")TRecord trecord) {
		return dao.modifyTRecord(trecord);
	} 
	
	/**
	 * 删除奖惩
	 * */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public Integer deleteTRecord(@Param("id")Integer id) {
		return dao.deleteTRecord(id);
	}
	
	/**
	 * 添加奖惩
	 * */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public Integer addTRecord(@Param("trecord")TRecord trecord) {
		return dao.addTRecord(trecord);
	}
}
