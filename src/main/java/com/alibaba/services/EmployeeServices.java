package com.alibaba.services;

import java.util.List;

import com.alibaba.dao.AlibabaDAO;
import com.alibaba.dao.EmployeeDAO;
import com.alibaba.entity.Employee;
import com.alibaba.idao.IDAOEmployee;
import com.alibaba.idao.IDAOJobs;
  //ҵ���߼���    
public class EmployeeServices {
	//ȫ�ֱ���
	private  IDAOEmployee dao;
	//���캯��
	public  EmployeeServices() {
		dao=new EmployeeDAO();
	}
	//���캯�� �ӿ�
	public  EmployeeServices(IDAOEmployee daoemployee)
	{
		dao=daoemployee;
	}
	
	public  List<Employee> GetAllData(){
		
		return dao.GetAllData();
	}
	public  boolean  AddNameData(String name,String title) {
		
		return dao.AddNameData(name, title);
	}
	public  boolean  update(int id,String name) {
		
		 return dao.update(id, name);
	}
	public  boolean delete(int id) {
		
	  return dao.delete(id);
	}

}