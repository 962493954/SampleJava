package com.alibaba.idao;

import java.util.List;
import com.alibaba.entity.News;
//²¿·ÖÔ¼Êø
public interface IDAONews {
	
    public  List<News> GetAllData();	
	public  boolean  AddNameData(String title,String content,String tags) ;
	public  boolean  update(int id,String title) ;
	public  boolean delete(int id) ;

}
