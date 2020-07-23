package com.govind.jackson.json.model;

public class Employee {
	
	public String name;
	public String email;
	
	
	public Employee() {
		super();
	}


	public Employee(String name, String email) {
		this.name=name;
		this.email=email;
	}


	@Override
	public String toString() {
		return "Employee [name=" + name + ", email=" + email + "]";
	}
	
	
}
