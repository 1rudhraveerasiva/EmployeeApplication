package com.edu.EmployeeApplication.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {

	@Id
	private long id;
	private String projectId;
	private String title;
	private Date startDate;
	private Date endDate;
	
	@ManyToMany(mappedBy="project")
	private List<Employee>employees;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Project(long id, String projectId, String title, Date startDate, Date endDate) {
		super();
		this.id = id;
		this.projectId = projectId;
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Project [id=" + id + ", projectId=" + projectId + ", title=" + title + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
	
	
	
}
