package com.zhb.oa.person.dao;

import java.util.List;

import com.zhb.oa.person.entity.StaffEntity;

public interface StaffDao {
	/*
	 * 增加员工
	 */
	public void addStaff(StaffEntity staffEntity);
	
	/*
	 * 删除员工
	 */
	public void deleteStaffById(Integer id);
	
	/*
	 * 修改员工
	 */
	public void updateStaffById(StaffEntity staffEntity);
	
	/*
	 * 按照ID找员工
	 */
	public StaffEntity findStaffById(Integer id);
	
	/*
	 * 查找所有员工
	 */
	public List<StaffEntity> findAll();

}
