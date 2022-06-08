package com.edu.EmployeeApplication.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="departmentTbl")
public class Department {
	
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)

	private long dptid;
	@Column (nullable=false, unique=true)
    private String departmentId;
	@Column(nullable=false)
    private String departmentName;
    private String location;
    private String hodId;
    
    @OneToMany(mappedBy="department")
    private List<Employee> employees;
	public long getId() {
		return dptid;
	}
	public void setId(long id) {
		this.dptid = dptid;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getHodId() {
		return hodId;
	}
	public void setHodId(String hodId) {
		this.hodId = hodId;
	}
	public Department(long id, String departmentId, String departmentName, String location, String hodId) {
		super();
		this.dptid = dptid;
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.location = location;
		this.hodId = hodId;
	}
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Department [dptid=" + dptid + ", departmentId=" + departmentId + ", departmentName=" + departmentName
				+ ", location=" + location + ", hodId=" + hodId + "]";
	}

    



}
