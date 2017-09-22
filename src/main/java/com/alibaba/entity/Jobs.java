package com.alibaba.entity;
import java.util.Date;



// ʵ����  ����  ��C#�е�����
public class Jobs {
	//ʵ��������ݿ�ı����жԽӵģ�  entity  �ֶθ����ݿ�һһ��Ӧ
	private int id;	
	private String title;
	private String content;
	private String tags;
	private int viewTimes;
	private Date createDate;
	private Date endDate;
	private int userId;
	//�޲ι��캯��
	public Jobs() {}
	//�вι��캯��
	public Jobs(int id, String title, String content, String tags, int viewTimes, Date createDate, Date endDate,
			int userId) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.tags = tags;
		this.viewTimes = viewTimes;
		this.createDate = createDate;
		this.endDate = endDate;
		this.userId = userId;
	}

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

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

		
		
	
	
	
	
}