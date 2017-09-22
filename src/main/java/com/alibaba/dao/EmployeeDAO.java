package com.alibaba.dao;

import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.entity.Employee;
import com.alibaba.idao.IDAOEmployee;
  //���ݷ��ʲ�
public class EmployeeDAO extends DAOBase implements IDAOEmployee
{
	

//�޲ι��캯��
	public EmployeeDAO(){			 
	         }
	
	
	public  List<Employee> GetAllData() {	
		List<Employee> list=new  ArrayList<Employee>();
		try {
		 //1����������
		
		//3��SQL��� 
		 sql="call GetAllEmployee();";
		//Ԥ���� 
		CallableStatement statement= connection.prepareCall(sql);
		//4.ִ��
		ResultSet resultSet=statement.executeQuery();
		//5�����������
		while (resultSet.next()) {
			//��ȡ����
			int id=resultSet.getInt("Id");
			String  name=resultSet.getString("name");
			String  title=resultSet.getString("title");
			int  age=resultSet.getInt("age");
			
			//ʵ����ת��
			Employee employee=new Employee();
			employee.setId(id);
			employee.setName(name);
			employee.settitle(title);
			employee.setAge(age);
			//�洢����
			list.add(employee);
			
		}
		/*//�ر�����
		connection.close();
		statement.close();*/
		
		
	} 
	
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		
		Close();
	}
		return list;
	
	
	}
	public  boolean  AddNameData(String name,String title) {
		//����Ա��
		try {
			
			//3��SQL���   ����ʹ��enter��ֱ�ӻ���Ҳ�ǿ��Ե�  ���Բ���ƴ���ַ���
			
		sql = "INSERT INTO `alibaba`.`employee`"; 
		sql = sql+	" (`Name`,`Age`,`Title`,`Level`,`Address`,`Mobile`,`QQ`,`Email`,`Salary`,`Gender`,`JoinDate`)";
		sql = sql+	" VALUES(?,18,?,8,'�й�����','12213','127319281','12731@qq.com',88888,2,now());";


			//4.Ԥ���� 
		  statement=connection.prepareStatement(sql);
			
			//5.���ò���
			statement.setString(1,name);
			statement.setString(2,title);
			//6��ִ��
		    boolean result=statement.execute();
			
		   /* //7.�ر�
		    connection.close();
			statement.close();*/
			return result;
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			Close();
		}
		return false;
		
		
		
	}

	public  boolean  update(int id,String  name) {try {
		
		
		
	  connection=DriverManager.getConnection(url, user, password);
		 
		//3��SQL��� 
		//String sql="delete form employee where Id="+id;
		sql="update employee set name=? where Id=?";
		//4.Ԥ���� 
	  statement=connection.prepareStatement(sql);
		
		//5.���ò���
		statement.setString(1,name);
		statement.setInt(2,id);
	   boolean result= statement.execute();
		//6�����������
	    //7.�ر�
	   /* connection.close();
		statement.close();*/
		return  result;
	} 
	
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		
		Close();
	}
	return false;}
	public  boolean delete(int id) {
		try {
			
			//3��SQL��� 
			//String sql="delete form employee where Id="+id;
		//3��SQL���   ���ô洢����
		 sql="call DeleteEmployee(?);";
		//Ԥ���� 
		CallableStatement statement= connection.prepareCall(sql);
			
			//5.���ò���
			statement.setInt(1,id);
			 boolean result= statement.execute();
			//6�����������
		    //�ر�����
		    /*connection.close();
			statement.close();*/
			return result;
		}
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			Close();
		}
		return false;
		
		
		
	}
	
		
	

}