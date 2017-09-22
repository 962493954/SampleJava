package com.alibaba.services;
import java.util.List;

import com.alibaba.dao.NewsDAO;
import com.alibaba.entity.News;
import com.alibaba.idao.IDAONews;
  //业务逻辑层    
public class NewsServices {
	//全局变量
	private  IDAONews dao;
	
	public  NewsServices(){
		dao=new NewsDAO();
	}
	
	//构造函数
	public  NewsServices(IDAONews daonews) {
		dao=daonews;
	}
	public  List<News> GetAllData(){
		
		return dao.GetAllData();
	}
	public  boolean  AddNameData(String title,String content,String tags) {
		
		return dao.AddNameData(title, content,tags);
	}
	public  boolean  update(int id,String title) {
		
		 return dao.update(id, title);
	}
	public  boolean delete(int id) {
		
	  return dao.delete(id);
	}

}
