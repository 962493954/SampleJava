package com.alibaba.entity;
// 实体类  声明  与C#中的区别
public class Employee {
	//实体类和数据库的表进行对接的，  entity  字段跟数据库一一对应
	private int id;
	private String name;
	private String title;
	private int age;
	private String address;
	//无参构造函数
	public Employee() {}
	//有参构造函数
	public Employee(int  id, String name,String title,String address) 
	{this.id=id;
	 this.name=name;
	 this.title=title;
	 this.address=address;
	
	}
   //属性
	public  int  getId() {
		return id;
	}
	public void setId(int id) {
		
		this.id=id;
	}
	public  String  getName() {
		return this.name;
	}
	public void setName(String  name) {
		
		this.name=name;
	}
	public  String  gettitle() {
		return this.title;
	}
	public void settitle(String title) {
		
		this.title=title;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
