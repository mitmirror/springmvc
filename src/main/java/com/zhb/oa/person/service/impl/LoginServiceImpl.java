package com.zhb.oa.person.service.impl;

import com.zhb.oa.person.dao.StaffDao;
import com.zhb.oa.person.dao.impl.StaffDaoImpl;
import com.zhb.oa.person.entity.StaffEntity;
import com.zhb.oa.person.service.LoginService;

public class LoginServiceImpl implements LoginService {

	@Override
	public boolean isLogin(int id, String password) {
		// TODO Auto-generated method stub
		StaffDao impl=new StaffDaoImpl();
		StaffEntity staffEntity =impl.findStaffById(id);
		if(staffEntity.getPassword().equals(password)){
			return true;
		}
		return false;
	}

}
