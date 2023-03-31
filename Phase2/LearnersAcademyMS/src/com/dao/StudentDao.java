package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Student;
import com.resource.LaDbConnection;

public class StudentDao {

	public static List<Student> list() throws SQLException {
        List<Student> listStudent = new ArrayList<>();
         
        try (Connection conn = LaDbConnection.getLaDbConn()) {
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Student ORDER BY studentName");
            ResultSet resultSet = pstmt.executeQuery();
             
            while (resultSet.next()) {
                int id = resultSet.getInt("studentId");
                String name = resultSet.getString("studentName");
                int classId = resultSet.getInt("classId");
                Student student = new Student(id, name, classId);
                     
                listStudent.add(student);
            }          
             
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }      
         
        return listStudent;
    }
}
