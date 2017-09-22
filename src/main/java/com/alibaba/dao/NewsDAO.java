package com.alibaba.dao;
import java.sql.CallableStatement;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.entity.News;
import com.alibaba.idao.IDAONews;
  //���ݷ��ʲ�
public class NewsDAO extends DAOBase implements IDAONews
{
	
	//���캯��
	public  NewsDAO() 
	{
	
	}
	/** 
	* @Title: GetAlldata 
	* @Description: TODO(��ѯ������Ϣ) 
	* @param @return    ���
	* @return List<News> ��������
	* @author ��DR�� 
	* @throws
	* @date 2017��8��28�� ����4:14:41 
	* @version V1.0   
	*/
	public  List<News> GetAllData() {	
		List<News> list=new  ArrayList<News>();
		try {		 							 
		//3��SQL��� 
		 sql="call GetAllNews();";
		//Ԥ���� 
		CallableStatement statement= connection.prepareCall(sql);
		//4.ִ��
		ResultSet resultSet=statement.executeQuery();
		//5�����������
		while (resultSet.next()) {
			//��ȡ����
			int id=resultSet.getInt("Id");			
			String  title=resultSet.getString("title");
			String  content=resultSet.getString("content");
			int  viewTimes=resultSet.getInt("viewTimes");
			Date createDate=resultSet.getDate("createDate");
			//ʵ����ת��
			News news=new News();
			news.setId(id);
			news.setTitle(title);
			news.setContent(content);
			news.setViewTimes(viewTimes);
			news.setCreateDate(createDate);
			//�洢����
			list.add(news);
			
		}
		/*//�ر�����
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
		//��������
		try {									 
		//3��SQL���   ����ʹ��enter��ֱ�ӻ���Ҳ�ǿ��Ե�  ���Բ���ƴ���ַ���
			
	    sql = "INSERT INTO `alibaba`.`news`"; 
		sql = sql+	" (`Title`,`CoverImage`,`Images`,`Content`,`CreateDate`,`UserId`,`Tags`,`ViewTimes`,`Up`,`Down`,`State`)";
		sql = sql+	" VALUES(?,'����','1',?,now(),8,?,1,1,3,1);";
			//4.Ԥ���� 
		    statement=connection.prepareStatement(sql);			
			//5.���ò���
			statement.setString(1,title);
			statement.setString(2,content);
			statement.setString(3, tags);
			//6��ִ��
		    boolean result=statement.execute();			
		    //7.�ر�
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
		 //1����������				
		//3��SQL��� 		
	   sql="update news set title=? where Id=?";
		//4.Ԥ���� 
	   statement=connection.prepareStatement(sql);		
		//5.���ò���
		statement.setString(1,title);
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
	}finally{
		Close();
	}
	return false;
	}
	public  boolean delete(int id) {
		try {
			//1����������					
			//3��SQL��� 			
		//3��SQL���   ���ô洢����
		 sql="call DeleteNews(?);";
		//Ԥ���� 
		CallableStatement statement= connection.prepareCall(sql);
			
			//5.���ò���
			statement.setInt(1,id);
			 boolean result= statement.execute();
			//6�����������
		    //�ر�����
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