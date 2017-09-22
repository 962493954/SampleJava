package com.alibaba.idao;

import java.util.List;
import com.alibaba.entity.Employee;

public interface IDAOEmployee {

    public  List<Employee> GetAllData();
	public  boolean  AddNameData(String name,String title) ;
	public  boolean  update(int id,String name) ;
	public  boolean delete(int id) ;
}
