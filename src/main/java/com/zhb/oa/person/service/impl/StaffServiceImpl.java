package com.zhb.oa.person.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhb.oa.person.dao.StaffDao;
import com.zhb.oa.person.dao.impl.StaffDaoImpl;
import com.zhb.oa.person.entity.StaffEntity;
import com.zhb.oa.person.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService {
	@Autowired
	private StaffDao staffDao;

	@Override
	public void addStaff(StaffEntity staffEntity) {
		// TODO Auto-generated method stub
		staffDao.addStaff(staffEntity);
		
	}

	@Override
	public void deleteStaffById(Integer id) {
		// TODO Auto-generated method stub
		
		staffDao.deleteStaffById(id);
	}

	@Override
	public void updateStaffById(StaffEntity staffEntity) {
		// TODO Auto-generated method stub
		
		staffDao.updateStaffById(staffEntity);
		
	}

	@Override
	public List<StaffEntity> getStaff() {
		// TODO Auto-generated method stub
		List<StaffEntity> list=staffDao.findAll();
		return list;
	}

}
