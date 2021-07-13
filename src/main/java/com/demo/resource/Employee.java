package com.demo.resource;

public class Employee {

	private String name;
	private int eno;

	public int getEno() {
		return eno;
	}

	public void setEno(int eno) {
		this.eno = eno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee() {

		super();
	}

	public Employee(String name, int eno) {
		this.name = name;
		this.eno = eno;
	}

	public String toString() {

		return "Employee [id=" + eno + ", Name=" + name + "]";
	}
}
