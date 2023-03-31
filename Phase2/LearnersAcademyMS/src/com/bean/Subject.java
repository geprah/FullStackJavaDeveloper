package com.bean;

public class Subject {
	
	private int id;
	private String name;
	private int teacherId;
	
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
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
	
	public Subject(int id, String name) {
		
		super();
		this.setId(id);
		this.setName(name);
	}
	
	public Subject(int id, String name, int teacherId) {
		
		this(id, name);
		this.setTeacherId(teacherId);
	}

}
