package com.alibaba.services;

import java.util.List;

import com.alibaba.dao.AlibabaDAO;
import com.alibaba.entity.Employee;
  //ҵ���߼���    
public class AlibabaServices {
	//ȫ�ֱ���
	private  AlibabaDAO dao;
	//���캯��
	public  AlibabaServices() {
		dao=new AlibabaDAO();
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