package com.alibaba.entity;
import java.util.Date;



// 实体类  声明  与C#中的区别
public class News {
	//实体类和数据库的表进行对接的，  entity  字段跟数据库一一对应
	private int id;	
	private String title;
	private String content;
	private String tags;
	private int viewTimes;
	private Date createDate;
	
	//无参构造函数
		public News() {}
		//有参构造函数
		public News(int  id, String title,String content,String tags,int viewsTimes,Date createDate) 
		{this.id=id;
		 this.title=title;
		 this.content=content;
		 this.tags=tags;
	     this.viewTimes=viewsTimes;
	     this.createDate=createDate;
		}	  	
	
	//属性
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public int getViewTimes() {
		return viewTimes;
	}
	public void setViewTimes(int viewTimes) {
		this.viewTimes = viewTimes;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
