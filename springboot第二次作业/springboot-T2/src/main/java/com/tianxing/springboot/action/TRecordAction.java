package com.tianxing.springboot.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.tianxing.springboot.biz.TRecordBiz;
import com.tianxing.springboot.biz.TStudentBiz;
import com.tianxing.springboot.pojo.TRecord;
import com.tianxing.springboot.pojo.TStudent;

@Controller
@RequestMapping("/c")
public class TRecordAction {
	@Resource
	private TRecordBiz biz;
	@Resource
	private TStudentBiz biz2;
	@RequestMapping("showDetails")
	public String showDetails(String code,Model model){
		model.addAttribute("details", biz.getTRecord(code, null, null, null));
		return "showDetails";
	}
	@RequestMapping("details")
	public String details(String name,String stuname,Model model){
		if(name==null&&stuname==null) {
			return "details";
		}
		model.addAttribute("details2", biz.getTRecord(null, stuname, name, null));
		return "details";
	}
	@RequestMapping("toModify")
	public String toModify(Integer id,Model model){
		model.addAttribute("stulist",biz2.getTStudent(null, null));
		model.addAttribute("modifyR", biz.getTRecord(null, null, null, id).get(0));
		return "modify";
	}
	@RequestMapping("delete")
	public String delete(Integer id){
		biz.deleteTRecord(id);
		return "details";
	}
	@RequestMapping("toAdd")
	public String toAdd(Model model){
		model.addAttribute("stulist",biz2.getTStudent(null, null));
		return "add";
	}
	@RequestMapping("add")
	public String add(TRecord trecord,HttpSession session){
		trecord.setCreateby(((TStudent)session.getAttribute("emp")).getCode());
		biz.addTRecord(trecord);
		return "details";
	}
	@RequestMapping("modify")
	public String modify(TRecord trecord,HttpSession session){
		trecord.setCreateby(((TStudent)session.getAttribute("emp")).getCode());
		biz.modifyTRecord(trecord);
		return "details";
	}
}
