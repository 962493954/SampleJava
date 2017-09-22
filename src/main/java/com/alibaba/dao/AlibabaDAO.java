package com.alibaba.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.entity.Employee;
  //���ݷ��ʲ�
public class AlibabaDAO {
	public  List<Employee> GetAllData() {	
		List<Employee> list=new  ArrayList<Employee>();
		try {
		 //1����������
		Class.forName("com.mysql.jdbc.Driver");
		//2������
		String url="jdbc:mysql://localhost:3306/alibaba?useUnicode=true& characterEncoding=UTF-8&useSSL=false";
		String user="root";
		String password="1995";
		
		
	Connection  connection=DriverManager.getConnection(url, user, password);
		 
		//3��SQL��� 
		String sql="call GetAllEmployee();";
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
			String  address=resultSet.getString("address");
			int  age=resultSet.getInt("age");
			
			//ʵ����ת��
			Employee employee=new Employee();
			employee.setId(id);
			employee.setName(name);
			employee.settitle(title);
			employee.setAddress(address);
			employee.setAge(age);
			//�洢����
			list.add(employee);
			
		}
		//�ر�����
		connection.close();
		statement.close();
		
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return list;
	
	
	}
	public  boolean  AddNameData(String name,String title) {
		//����Ա��
		try {
			 //1����������
			Class.forName("com.mysql.jdbc.Driver");
			//2������
			String url="jdbc:mysql://localhost:3306/alibaba?useUnicode=true& characterEncoding=UTF-8&useSSL=false";
			String user="root";
			String password="1995";
			
			
		Connection  connection=DriverManager.getConnection(url, user, password);
			 
			//3��SQL���   ����ʹ��enter��ֱ�ӻ���Ҳ�ǿ��Ե�  ���Բ���ƴ���ַ���
			
		String sql = "INSERT INTO `alibaba`.`employee`"; 
		sql = sql+	" (`Name`,`Age`,`Title`,`Level`,`Address`,`Mobile`,`QQ`,`Email`,`Salary`,`Gender`,`JoinDate`)";
		sql = sql+	" VALUES(?,18,?,8,'�й�����','12213','127319281','12731@qq.com',88888,2,now());";


			//4.Ԥ���� 
			PreparedStatement  statement=connection.prepareStatement(sql);
			
			//5.���ò���
			statement.setString(1,name);
			statement.setString(2,title);
			//6��ִ��
		    boolean result=statement.execute();
			
		    //7.�ر�
		    connection.close();
			statement.close();
			return result;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
		
		
	}

	public  boolean  update(int id,String  name) {try {
		 //1����������
		Class.forName("com.mysql.jdbc.Driver");
		//2������
		String url="jdbc:mysql://localhost:3306/alibaba?useUnicode=true& characterEncoding=UTF-8&useSSL=false";
		String user="root";
		String password="1995";
		
		
	Connection  connection=DriverManager.getConnection(url, user, password);
		 
		//3��SQL��� 
		//String sql="delete form employee where Id="+id;
		String sql="update employee set name=? where Id=?";
		//4.Ԥ���� 
		PreparedStatement  statement=connection.prepareStatement(sql);
		
		//5.���ò���
		statement.setString(1,name);
		statement.setInt(2,id);
	   boolean result= statement.execute();
		//6�����������
	    //7.�ر�
	    connection.close();
		statement.close();
		return  result;
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;}
	public  boolean delete(int id) {
		try {
			 //1����������
			Class.forName("com.mysql.jdbc.Driver");
			//2������
			String url="jdbc:mysql://localhost:3306/alibaba?useUnicode=true& characterEncoding=UTF-8&useSSL=false";
			String user="root";
			String password="1995";
			
			
		Connection  connection=DriverManager.getConnection(url, user, password);
			 
			//3��SQL��� 
			//String sql="delete form employee where Id="+id;
		//3��SQL���   ���ô洢����
		String sql="call DeleteEmployee(?);";
		//Ԥ���� 
		CallableStatement statement= connection.prepareCall(sql);
			
			//5.���ò���
			statement.setInt(1,id);
			 boolean result= statement.execute();
			//6�����������
		    //�ر�����
		    connection.close();
			statement.close();
			return result;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
		
		
	}
	

}