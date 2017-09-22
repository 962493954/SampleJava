package com.alibaba.dao;
import java.sql.CallableStatement;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.entity.News;
import com.alibaba.idao.IDAONews;
  //数据访问层
public class NewsDAO extends DAOBase implements IDAONews
{
	
	//构造函数
	public  NewsDAO() 
	{
	
	}
	/** 
	* @Title: GetAlldata 
	* @Description: TODO(查询所有信息) 
	* @param @return    入参
	* @return List<News> 返回类型
	* @author （DR） 
	* @throws
	* @date 2017年8月28日 下午4:14:41 
	* @version V1.0   
	*/
	public  List<News> GetAllData() {	
		List<News> list=new  ArrayList<News>();
		try {		 							 
		//3、SQL语句 
		 sql="call GetAllNews();";
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
			Date createDate=resultSet.getDate("createDate");
			//实体类转换
			News news=new News();
			news.setId(id);
			news.setTitle(title);
			news.setContent(content);
			news.setViewTimes(viewTimes);
			news.setCreateDate(createDate);
			//存储到表
			list.add(news);
			
		}
		/*//关闭链接
		connection.close();
		statement.close();*/				
	} 	
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		finally{
		Close();
	}
		return list;		
	}
	public  boolean  AddNameData(String title,String content,String tags) {
		//新增新闻
		try {									 
		//3、SQL语句   这里使用enter键直接换行也是可以的  可以不用拼接字符串
			
	    sql = "INSERT INTO `alibaba`.`news`"; 
		sql = sql+	" (`Title`,`CoverImage`,`Images`,`Content`,`CreateDate`,`UserId`,`Tags`,`ViewTimes`,`Up`,`Down`,`State`)";
		sql = sql+	" VALUES(?,'封面','1',?,now(),8,?,1,1,3,1);";
			//4.预编译 
		    statement=connection.prepareStatement(sql);			
			//5.设置参数
			statement.setString(1,title);
			statement.setString(2,content);
			statement.setString(3, tags);
			//6、执行
		    boolean result=statement.execute();			
		    //7.关闭
		   /* connection.close();
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
		 //1、加载驱动				
		//3、SQL语句 		
	   sql="update news set title=? where Id=?";
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
	return false;
	}
	public  boolean delete(int id) {
		try {
			//1、加载驱动					
			//3、SQL语句 			
		//3、SQL语句   调用存储过程
		 sql="call DeleteNews(?);";
		//预编译 
		CallableStatement statement= connection.prepareCall(sql);
			
			//5.设置参数
			statement.setInt(1,id);
			 boolean result= statement.execute();
			//6、处理结果集
		    //关闭链接
		   /* connection.close();
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
