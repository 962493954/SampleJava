package com.alibaba.idao;

import java.sql.Date;
import java.util.List;
import com.alibaba.entity.Jobs;

public interface IDAOJobs {

    public  List<Jobs> GetAllData();
	public  boolean  AddNameData(String title,String content,Date createDate) ;
	public  boolean  update(int id,String title) ;
	public  boolean delete(int id) ;
}
