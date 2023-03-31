package com.bean;

public class Class {
	
	private int id;
	private String classSection;
	private int subjectId;
	
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClassSection() {
		return classSection;
	}
	public void setClassSection(String classSection) {
		this.classSection = classSection;
	}
	
	public Class(int id, String classSection) {
		
		super();
		this.setId(id);
		this.setClassSection(classSection);
	}
	
	public Class(int id, String classSection, int subjectId) {
		
		this(id, classSection);
		this.setSubjectId(subjectId);
	}
}
