package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.ClassReport;
import com.resource.LaDbConnection;

public class ClassReportDao {

	public static List<ClassReport> list() throws SQLException {
        List<ClassReport> listClassReport = new ArrayList<>();
         
        try (Connection conn = LaDbConnection.getLaDbConn()) {
            
            PreparedStatement pstmt = conn.prepareStatement(
            		  "SELECT Class.classId , Class.classSection , "
            		+ "Teacher.teacherName , Subject.subjectName , Student.studentName "
            		+ "FROM Class , Subject , Teacher , Student "
            		+ "WHERE Class.subjectId = Subject.subjectId "
            		+ "AND Subject.teacherId = Teacher.teacherId "
            		+ "AND Student.classId = Class.classId "
            		+ "ORDER BY classId,classSection");
            pstmt.execute();
            ResultSet resultSet = pstmt.getResultSet();
            ClassReport classReport;
            
            while (resultSet.next()) {
                int id = resultSet.getInt("classId");
                String classSection = resultSet.getString("classSection");
                System.out.println("here");
                String teacherName = resultSet.getString("teacherName");
                String subjectName = resultSet.getString("subjectName");
                String studentName = resultSet.getString("studentName");
                
//                ClassReport classReport = new ClassReport(id, classSection, teacherName,
//                		subjectName, studentName);
                classReport = new ClassReport(id, classSection, teacherName,
                		subjectName, studentName);
                     
                listClassReport.add(classReport);
            }          
             
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }      
         
        return listClassReport;
    }
}
