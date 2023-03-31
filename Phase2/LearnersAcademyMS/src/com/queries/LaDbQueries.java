package com.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.resource.LaDbConnection;

public class LaDbQueries {

	
	public static List<String> getAllTeachers(){
		
		Connection con = LaDbConnection.getLaDbConn();
		//PreparedStatement getAllTeachers = 
		
		return new ArrayList<String>();
	}
	
	public static List<String> getAllSubjects(){
		return new ArrayList<String>();
	}
	
	public static List<String> getAllClasses(){
		return new ArrayList<String>();
	}
	
	public static List<String> getAllStudents(){
		return new ArrayList<String>();
	}
}
