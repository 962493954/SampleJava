package com.alibaba.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOBase {
	
	public  Connection connection=null;
	public  PreparedStatement statement;
	//2、链接
	public	String url="jdbc:mysql://localhost:3306/alibaba?useUnicode=true& characterEncoding=UTF-8&useSSL=false";
	public	String user="root";
	public	String password="1995";
	public String sql=null;
	
	public  DAOBase(){
		 try {
			//1、加载驱动
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			connection=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//关闭起来
	protected void Close(){
	
		if(connection!=null){
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(statement!=null){
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	
}
