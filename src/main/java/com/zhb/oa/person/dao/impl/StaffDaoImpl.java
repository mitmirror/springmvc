package com.zhb.oa.person.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sun.star.sdbc.SQLException;
import com.zhb.oa.person.dao.StaffDao;
import com.zhb.oa.person.entity.StaffEntity;

@Repository
public class StaffDaoImpl implements StaffDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return this.sessionFactory.openSession();
	}

	@Override
	public void addStaff(StaffEntity staffEntity) {
		// TODO Auto-generated method stub
		System.out.println("开始保存数据");
		System.out.println(staffEntity.toString());
		getCurrentSession().save(staffEntity);
	}

	@Override
	public void deleteStaffById(Integer id) {
		// TODO Auto-generated method stub
		getCurrentSession().createQuery("delete StaffEntity t where t.staffId="+id).executeUpdate();
		System.out.print("delete staff sucess!");
	}

	@Override
	public void updateStaffById(StaffEntity staffEntity) {
		// TODO Auto-generated method stub
		String hql="update StaffEntity t set t.password=?,t.staffName=?,t.staffSex=?,t.staffAge=?,t.position=?,t.staffAddress=?,t.staffPhone=? where id=?";
		Query query=getCurrentSession().createQuery(hql);
		
		query.setParameter(0, staffEntity.getPassword());
		query.setParameter(1, staffEntity.getStaffName());
		query.setParameter(2, staffEntity.getStaffSex());
		query.setParameter(3, staffEntity.getStaffAge());
		query.setParameter(4, staffEntity.getPosition());
		query.setParameter(5, staffEntity.getStaffAddress());
		query.setParameter(6, staffEntity.getStaffPhone());
		query.setParameter(7, staffEntity.getStaffId());
		query.executeUpdate();
		System.out.println("update staff sucessful!");
	}

	@Override
	public StaffEntity findStaffById(Integer id) {
		// TODO Auto-generated method stub
		String hql="form StaffEntity t where t.staffId=?";
		Query query=getCurrentSession().createQuery(hql);
		query.setParameter(0, id);
		return (StaffEntity)query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StaffEntity> findAll() {
		System.out.println("连接数据库查询所有员工信息");
		List<StaffEntity> list=getCurrentSession().createQuery("select t from StaffEntity t").list();
		for(int i=0;i<list.size();i++){
			System.out.println("姓名："+list.get(i).getStaffName());
		}
		return list;
	}

}
