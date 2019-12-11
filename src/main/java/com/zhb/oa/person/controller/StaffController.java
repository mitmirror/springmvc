package com.zhb.oa.person.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.xmlbeans.impl.xb.xsdschema.impl.PublicImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zhb.oa.person.entity.StaffEntity;
import com.zhb.oa.person.service.LoginService;
import com.zhb.oa.person.service.StaffService;
import com.zhb.oa.person.service.impl.LoginServiceImpl;
import com.zhb.oa.person.service.impl.StaffServiceImpl;

import ResponseUtil.ResponseUtil;
import net.sf.json.JSONObject;


@Controller
@RequestMapping("/staffController")
public class StaffController {
	@Autowired
	private StaffService staffService;
	
	@RequestMapping(params="index")
	public String login(HttpServletRequest request,HttpServletResponse response){
		return "index";
		
	}
	
	@RequestMapping(params="staffList")
	@ResponseBody
	public String getStaffAll(HttpServletRequest request){
		List<StaffEntity> list=staffService.getStaff();
		StringBuffer buffer=new StringBuffer();
		buffer.append("{\"total\":"+list.size()+",\"rows\":");
	    buffer.append("[");
	    for(int i=0;i<list.size();i++){
	    	StaffEntity staffEntity=list.get(i);

	    	/*buffer.append("{\"staffId\":"+staffEntity.getStaffId()+",\"staffName\":\""+staffEntity.getStaffName()+",\"staffSex\":\""+staffEntity.getStaffSex()
	    			+",\"staffAddress\":\""+staffEntity.getStaffAddress()+",\"staffPhone\":\""+staffEntity.getStaffPhone()+"\",\"position\":"+
	    			staffEntity.getPosition()+"}");//将java对象转换为json对象*/
	    	//buffer.append("{\"staffId\":"+staffEntity.getStaffId()+",\"staffName\":\""+staffEntity.getStaffName()+"\",\"staffAge\":"+staffEntity.getStaffAge()+"}");
	    	buffer.append(JSON.toJSONString(staffEntity));
	    	
	    	
	    	if (i<list.size()-1) {
	    		
				buffer.append(",");
			
			}
	    	
	    }
	    buffer.append("]"+"}");
		return buffer.toString();
	}
	
	@RequestMapping(params="saveStaff")
	public String saveStaff(StaffEntity staffEntity, HttpServletRequest request,HttpServletResponse response){
		staffService.addStaff(staffEntity);
		
		List<StaffEntity> list=staffService.getStaff();
		request.setAttribute("index", list);
		JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", true);
        try {
			ResponseUtil.write(response, jsonObject);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        return null;
	}
	
	@RequestMapping(params="updateStaff")
	public String updateStaff(StaffEntity staffEntity,HttpServletRequest request,HttpServletResponse response){
		System.out.println("start to update:"+staffEntity.toString());
		staffService.updateStaffById(staffEntity);
		List<StaffEntity> list=staffService.getStaff();
		request.setAttribute("index", list);
		JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", true);
        try {
			ResponseUtil.write(response, jsonObject);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	@RequestMapping(params="deleteStaff")
	public String deleteStaff(Integer id,HttpServletRequest request,HttpServletResponse response){
		System.out.println("start to delete:"+id);
		staffService.deleteStaffById(id);
		JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", true);
        try {
			ResponseUtil.write(response, jsonObject);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}