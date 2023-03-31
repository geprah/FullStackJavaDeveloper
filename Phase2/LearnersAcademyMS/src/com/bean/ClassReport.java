package com.bean;

public class ClassReport {

	private int id;
	private String classSection;
	private String teacherName;
	private String subjectName;
	private String studentName;
	
	
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

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public ClassReport(int id, String classSection) {
		
		super();
		this.setId(id);
		this.setClassSection(classSection);
	}
	
	public ClassReport(int id, String classSection, String teacherName) {
		
		this(id, classSection);
		this.setTeacherName(teacherName);
	}
	
	public ClassReport(int id, String classSection, String teacherName, String subjectName) {
		
		this(id, classSection, teacherName);
		this.setSubjectName(subjectName);
	}
	
	public ClassReport(int id, String classSection, String teacherName, 
			String subjectName, String studentName) {
		
		this(id, classSection, teacherName, subjectName);
		this.setStudentName(studentName);
	}	
}
