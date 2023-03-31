package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Class;
import com.resource.LaDbConnection;

public class ClassDao {

	public static List<Class> list() throws SQLException {
        List<Class> listClass = new ArrayList<>();
         
        try (Connection conn = LaDbConnection.getLaDbConn()) {
            
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Class ORDER BY classId,classSection");
            ResultSet resultSet = pstmt.executeQuery();
             
            while (resultSet.next()) {
                int id = resultSet.getInt("classId");
                String classSection = resultSet.getString("classSection");
                int subjectId = resultSet.getInt("subjectId");
                com.bean.Class cclass = new com.bean.Class(id, classSection, subjectId);
                     
                listClass.add(cclass);
            }          
             
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }      
         
        return listClass;
    }
}
