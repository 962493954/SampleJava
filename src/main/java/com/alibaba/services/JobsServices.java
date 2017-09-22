package com.alibaba.services;
import java.sql.Date;
import java.util.List;
import com.alibaba.dao.JobsDAO;
import com.alibaba.entity.Jobs;
import com.alibaba.idao.IDAOJobs;

  //ҵ���߼���    
public class JobsServices {
	//ȫ�ֱ���
	private  IDAOJobs dao;
	
	public  JobsServices(){
		dao=new JobsDAO();
	}
	//���캯��
	public  JobsServices(IDAOJobs daojob) {
		dao=daojob;
	}
	public  List<Jobs> GetAllData(){
		
		return dao.GetAllData();
	}
	public  boolean  AddNameData(String title,String content,Date createDate) {
		
		return dao.AddNameData(title, content,createDate);
	}
	public  boolean  update(int id,String title) {
		
		 return dao.update(id, title);
	}
	public  boolean delete(int id) {
		
	  return dao.delete(id);
	}

}