package com.pet.domain;

import java.util.List;

public class Dept {
	private int deptno;
	private String dname;
	private String loc;
	//부서에는 0명이상의 사원이 근무한다 1:多 관계 collection
	private List<Emp> empList; 

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public List<Emp> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Emp> empList) {
		this.empList = empList;
	}
	
	
	
	
	
}
