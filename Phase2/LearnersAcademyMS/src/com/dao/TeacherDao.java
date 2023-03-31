package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Teacher;
import com.resource.LaDbConnection;

public class TeacherDao {

	public static List<Teacher> list() throws SQLException {
        List<Teacher> listTeacher = new ArrayList<>();
         
        try (Connection conn = LaDbConnection.getLaDbConn()) {
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Teacher ORDER BY teacherName");
            ResultSet resultSet = pstmt.executeQuery();
             
            while (resultSet.next()) {
                int id = resultSet.getInt("teacherId");
                String name = resultSet.getString("teacherName");
                Teacher teacher = new Teacher(id, name);
                     
                listTeacher.add(teacher);
            }          
             
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }      
         
        return listTeacher;
    }
}
