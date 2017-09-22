package com.alibaba.dao;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.alibaba.entity.Jobs;
import com.alibaba.idao.IDAOJobs;
  //���ݷ��ʲ�
public class JobsDAO extends DAOBase implements IDAOJobs
{
	public  List<Jobs> GetAllData() 
	{	
		List<Jobs> list=new  ArrayList<Jobs>();
		try {				 
		//3��SQL��� 
		 sql="call GetAllJobs();";
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
			String tags=resultSet.getString("tags");
			Date createDate=null;//����if������ж�ʱ�䲻Ϊ�յ�
			if (resultSet.getDate("createDate")!=null) {
				createDate=resultSet.getDate("createDate");
			}
			//ʵ����ת��
			Jobs jobs=new Jobs();
			jobs.setId(id);
			jobs.setTitle(title);
			jobs.setContent(content);
			jobs.setTags(tags);
			jobs.setViewTimes(viewTimes);
			jobs.setCreateDate(createDate);
			
			//�洢����
			list.add(jobs);
			
		}
		//�ر�����
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
		//����Ա��
		try {
			
			 
			//3��SQL���   ����ʹ��enter��ֱ�ӻ���Ҳ�ǿ��Ե�  ���Բ���ƴ���ַ���
			
		 sql = "INSERT INTO `alibaba`.`jobs`"; 
		sql = sql+	" (`Title`,`Content`,`CreateDate`)";
		sql = sql+	" VALUES(?,?,now());";


			//4.Ԥ���� 
		   statement=connection.prepareStatement(sql);
			
			//5.���ò���
			statement.setString(1,title);
			statement.setString(2,content);
			statement.setDate(3, createDate);
			//6��ִ��
		    boolean result=statement.execute();
			
		    //7.�ر�
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
	
		 
		//3��SQL��� 
		
		 sql="update jobs set title=? where Id=?";
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
	return false;}
	public  boolean delete(int id) {
		try {
			
		//SQL��� 			
		//3��SQL���   ���ô洢����
		 sql="delete from jobs where Id=?;";
		//Ԥ���� 
		CallableStatement statement= connection.prepareCall(sql);
			
			//5.���ò���
			statement.setInt(1,id);
			 boolean result= statement.execute();
			//6�����������
		  /*  //�ر�����
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