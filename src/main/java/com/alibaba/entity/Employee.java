package com.alibaba.entity;
// ʵ����  ����  ��C#�е�����
public class Employee {
	//ʵ��������ݿ�ı����жԽӵģ�  entity  �ֶθ����ݿ�һһ��Ӧ
	private int id;
	private String name;
	private String title;
	private int age;
	private String address;
	//�޲ι��캯��
	public Employee() {}
	//�вι��캯��
	public Employee(int  id, String name,String title,String address) 
	{this.id=id;
	 this.name=name;
	 this.title=title;
	 this.address=address;
	
	}
   //����
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