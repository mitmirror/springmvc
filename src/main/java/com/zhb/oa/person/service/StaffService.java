package com.zhb.oa.person.service;

import java.util.List;

import org.apache.xmlbeans.impl.jam.internal.elements.VoidClassImpl;

import com.zhb.oa.person.dao.StaffDao;
import com.zhb.oa.person.entity.StaffEntity;

public interface StaffService {
	/*
	 * 增加员工
	 */
	public void addStaff(StaffEntity staffEntity);
	
	public void deleteStaffById(Integer id);
	
	public void updateStaffById(StaffEntity staffEntity);
	
	public List<StaffEntity> getStaff();
	
	

}
