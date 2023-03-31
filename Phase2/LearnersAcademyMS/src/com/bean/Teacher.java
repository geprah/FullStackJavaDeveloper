package com.bean;

public class Teacher {

	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Teacher(int id, String name) {
		
		super();
		this.setId(id);
		this.setName(name);
	}
}
