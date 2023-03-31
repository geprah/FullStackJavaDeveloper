package com.bean;

public class Student {

	private int id;
	private String name;
	private int classId;
	
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
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
	
	public Student(int id, String name) {
		
		super();
		this.setId(id);
		this.setName(name);
	}
	
	public Student(int id, String name, int classId) {
		
		this(id, name);
		this.setClassId(classId);
	}
}
