package com.tianxing.springboot.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianxing.springboot.biz.TStudentBiz;
import com.tianxing.springboot.pojo.TStudent;

@Controller
@RequestMapping("/c")
public class TStudentAction {
	@Resource
	private TStudentBiz biz;
	/**
	 * 去登录页面
	 * */
	@RequestMapping("toLogin")
	public String toLogin(){
		return "login";
	}
	/**
	 * 登录
	 * */
	@RequestMapping("login")
	@ResponseBody
	public Map<String, String> getUser(String code,String pwd,HttpSession session){
		Map<String, String> map=new HashMap<>();
		List<TStudent> list=biz.getTStudent(code, pwd);
		if(list!=null&&list.size()>0) {
		   session.setAttribute("emp", list.get(0));
		   map.put("code", "200");
		   map.put("msg", JSON.toJSONString(list.get(0)));
		}else {
			map.put("code", "101");
		    map.put("msg", "登录失败");
		}
		return map;
	}
	/**
	 * 验证存在
	 * */
	@PostMapping("loginCheck/{code}")
	@ResponseBody
	public Integer loginCheck(@PathVariable("code")String code){
		return biz.getTStudent(code, null)==null||biz.getTStudent(code, null).size()<1?0:1;
	}
	/**
	 * 去首页
	 * */
	@RequestMapping("toIndex")
	public String toIndex(){
		return "index";
	}
	/**
	 * 学生集合
	 * */
	@RequestMapping("list")
	public String list(Integer currentPage, Model model){
		currentPage=currentPage==null?1:currentPage;
		PageHelper.startPage(currentPage, 2);
		model.addAttribute("pageInfo",new PageInfo<TStudent>(biz.getTStudent(null, null)));
		return "list";
	}
}
