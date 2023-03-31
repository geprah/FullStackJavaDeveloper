package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.resource.LaDbConnection;

/**
 * Servlet implementation class LaAdminPortalController
 */
//@WebServlet("/LaAdminPortalController") 
public class LaAdminPortalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LaAdminPortalController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher rd;
		PrintWriter pw = response.getWriter();
		String submitButton = "";
		PreparedStatement pstmt;
		ResultSet rs;
		submitButton = request.getParameter("addOperation");
		try {
		switch (submitButton) {
		
			case "Login":
				
				pstmt = LaDbConnection.getLaDbConn().prepareStatement(
						"select * from Login where userName=? and passWord=?");
				pstmt.setString(1, request.getParameter("userName"));
				pstmt.setString(2, request.getParameter("passWord"));
				response.setContentType("text/html");
				
				pstmt.execute();
				rs = pstmt.getResultSet();
				
				if (rs.next()) {
					
					rd = request.getRequestDispatcher("home.jsp");
					rd.forward(request, response);
				}else {
					
					rd = request.getRequestDispatcher("index.jsp");
					rd.include(request, response);
					pw.println("<br/>Login failed!. <br/>Please retry with correct credentials");
				}
				break;
		
			case "Add Teacher":
				//pw.println("Adding Teacher");
				pstmt = LaDbConnection.getLaDbConn().prepareStatement(
						"insert into Teacher(teacherName) values(?)");
				pstmt.setString(1, request.getParameter("teacherName"));
				
				response.setContentType("text/html");
				rd = request.getRequestDispatcher("addTeacher.jsp");
				rd.include(request, response);
				pw.println("Added "+pstmt.executeUpdate()+" teacher");
				break;
				
			case "Add Subject":
				pw.println("Adding Subject");
				pstmt = LaDbConnection.getLaDbConn().prepareStatement(
						"insert into Subject(subjectName,teacherId) values(?,?)");
				pstmt.setString(1, request.getParameter("subjectName"));
				pstmt.setString(2, request.getParameter("teacherId"));
				
				response.setContentType("text/html");
				rd = request.getRequestDispatcher("addSubject.jsp");
				rd.include(request, response);
				pw.println("Added "+pstmt.executeUpdate()+" subject");
				break;
				
			case "Add Class":
				pw.println("Adding Class");
				pstmt = LaDbConnection.getLaDbConn().prepareStatement(
						"insert into Class(classSection,subjectId) values(?,?)");
				pstmt.setString(1, request.getParameter("classSection"));
				pstmt.setString(2, request.getParameter("subjectId"));
				
				response.setContentType("text/html");
				rd = request.getRequestDispatcher("addClass.jsp");
				rd.include(request, response);
				pw.println("Added "+pstmt.executeUpdate()+" class");
				break;
				
			case "Add Student":
				pw.println("Adding Student");
				pstmt = LaDbConnection.getLaDbConn().prepareStatement(
						"insert into Student(studenttName,classId) values(?,?)");
				pstmt.setString(1, request.getParameter("studentName"));
				pstmt.setString(2, request.getParameter("classId"));
				
				response.setContentType("text/html");
				rd = request.getRequestDispatcher("addStudent.jsp");
				rd.include(request, response);
				pw.println("Added "+pstmt.executeUpdate()+" student");
				break;
				
			default:
				
		}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		//doGet(request, response);
	}

}
