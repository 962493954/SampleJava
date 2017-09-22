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
  //数据访问层
public class AlibabaDAO {
	public  List<Employee> GetAllData() {	
		List<Employee> list=new  ArrayList<Employee>();
		try {
		 //1、加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2、链接
		String url="jdbc:mysql://localhost:3306/alibaba?useUnicode=true& characterEncoding=UTF-8&useSSL=false";
		String user="root";
		String password="1995";
		
		
	Connection  connection=DriverManager.getConnection(url, user, password);
		 
		//3、SQL语句 
		String sql="call GetAllEmployee();";
		//预编译 
		CallableStatement statement= connection.prepareCall(sql);
		//4.执行
		ResultSet resultSet=statement.executeQuery();
		//5、处理结果集
		while (resultSet.next()) {
			//抽取数据
			int id=resultSet.getInt("Id");
			String  name=resultSet.getString("name");
			String  title=resultSet.getString("title");
			String  address=resultSet.getString("address");
			int  age=resultSet.getInt("age");
			
			//实体类转换
			Employee employee=new Employee();
			employee.setId(id);
			employee.setName(name);
			employee.settitle(title);
			employee.setAddress(address);
			employee.setAge(age);
			//存储到表
			list.add(employee);
			
		}
		//关闭链接
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
		//新增员工
		try {
			 //1、加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2、链接
			String url="jdbc:mysql://localhost:3306/alibaba?useUnicode=true& characterEncoding=UTF-8&useSSL=false";
			String user="root";
			String password="1995";
			
			
		Connection  connection=DriverManager.getConnection(url, user, password);
			 
			//3、SQL语句   这里使用enter键直接换行也是可以的  可以不用拼接字符串
			
		String sql = "INSERT INTO `alibaba`.`employee`"; 
		sql = sql+	" (`Name`,`Age`,`Title`,`Level`,`Address`,`Mobile`,`QQ`,`Email`,`Salary`,`Gender`,`JoinDate`)";
		sql = sql+	" VALUES(?,18,?,8,'中国杭州','12213','127319281','12731@qq.com',88888,2,now());";


			//4.预编译 
			PreparedStatement  statement=connection.prepareStatement(sql);
			
			//5.设置参数
			statement.setString(1,name);
			statement.setString(2,title);
			//6、执行
		    boolean result=statement.execute();
			
		    //7.关闭
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
		 //1、加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2、链接
		String url="jdbc:mysql://localhost:3306/alibaba?useUnicode=true& characterEncoding=UTF-8&useSSL=false";
		String user="root";
		String password="1995";
		
		
	Connection  connection=DriverManager.getConnection(url, user, password);
		 
		//3、SQL语句 
		//String sql="delete form employee where Id="+id;
		String sql="update employee set name=? where Id=?";
		//4.预编译 
		PreparedStatement  statement=connection.prepareStatement(sql);
		
		//5.设置参数
		statement.setString(1,name);
		statement.setInt(2,id);
	   boolean result= statement.execute();
		//6、处理结果集
	    //7.关闭
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
			 //1、加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2、链接
			String url="jdbc:mysql://localhost:3306/alibaba?useUnicode=true& characterEncoding=UTF-8&useSSL=false";
			String user="root";
			String password="1995";
			
			
		Connection  connection=DriverManager.getConnection(url, user, password);
			 
			//3、SQL语句 
			//String sql="delete form employee where Id="+id;
		//3、SQL语句   调用存储过程
		String sql="call DeleteEmployee(?);";
		//预编译 
		CallableStatement statement= connection.prepareCall(sql);
			
			//5.设置参数
			statement.setInt(1,id);
			 boolean result= statement.execute();
			//6、处理结果集
		    //关闭链接
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
