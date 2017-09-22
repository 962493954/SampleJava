package com.alibaba.dao;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.alibaba.entity.Jobs;
import com.alibaba.idao.IDAOJobs;
  //数据访问层
public class JobsDAO extends DAOBase implements IDAOJobs
{
	public  List<Jobs> GetAllData() 
	{	
		List<Jobs> list=new  ArrayList<Jobs>();
		try {				 
		//3、SQL语句 
		 sql="call GetAllJobs();";
		//预编译 
		CallableStatement statement= connection.prepareCall(sql);
		//4.执行
		ResultSet resultSet=statement.executeQuery();
		//5、处理结果集
		while (resultSet.next()) {
			//抽取数据
			int id=resultSet.getInt("Id");			
			String  title=resultSet.getString("title");
			String  content=resultSet.getString("content");
			int  viewTimes=resultSet.getInt("viewTimes");
			String tags=resultSet.getString("tags");
			Date createDate=null;//这里if语句是判断时间不为空的
			if (resultSet.getDate("createDate")!=null) {
				createDate=resultSet.getDate("createDate");
			}
			//实体类转换
			Jobs jobs=new Jobs();
			jobs.setId(id);
			jobs.setTitle(title);
			jobs.setContent(content);
			jobs.setTags(tags);
			jobs.setViewTimes(viewTimes);
			jobs.setCreateDate(createDate);
			
			//存储到表
			list.add(jobs);
			
		}
		//关闭链接
		/*connection.close();
		statement.close();
		*/
		
	} 
	
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		Close();
	}
		return list;		
	}
	public  boolean  AddNameData(String title,String content,Date createDate) {
		//新增员工
		try {
			
			 
			//3、SQL语句   这里使用enter键直接换行也是可以的  可以不用拼接字符串
			
		 sql = "INSERT INTO `alibaba`.`jobs`"; 
		sql = sql+	" (`Title`,`Content`,`CreateDate`)";
		sql = sql+	" VALUES(?,?,now());";


			//4.预编译 
		   statement=connection.prepareStatement(sql);
			
			//5.设置参数
			statement.setString(1,title);
			statement.setString(2,content);
			statement.setDate(3, createDate);
			//6、执行
		    boolean result=statement.execute();
			
		    //7.关闭
		  /*  connection.close();
			statement.close();*/
			return result;
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Close();
		}
		return false;
		
		
		
	}

	public  boolean  update(int id,String  title) {try {
	
		 
		//3、SQL语句 
		
		 sql="update jobs set title=? where Id=?";
		//4.预编译 
		statement=connection.prepareStatement(sql);
		
		//5.设置参数
		statement.setString(1,title);
		statement.setInt(2,id);
	   boolean result= statement.execute();
		//6、处理结果集
	    //7.关闭
	   /* connection.close();
		statement.close();*/
		return  result;
	} 
	
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		Close();
	}
	return false;}
	public  boolean delete(int id) {
		try {
			
		//SQL语句 			
		//3、SQL语句   调用存储过程
		 sql="delete from jobs where Id=?;";
		//预编译 
		CallableStatement statement= connection.prepareCall(sql);
			
			//5.设置参数
			statement.setInt(1,id);
			 boolean result= statement.execute();
			//6、处理结果集
		  /*  //关闭链接
		    connection.close();
			statement.close();*/
			return result;
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Close();
		}
		return false;
		
		
		
	}
	

}
