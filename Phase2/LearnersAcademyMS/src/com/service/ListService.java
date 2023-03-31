package com.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Teacher;
import com.dao.TeacherDao;
import com.bean.Subject;
import com.dao.SubjectDao;
import com.bean.Class;
import com.bean.ClassReport;
import com.dao.ClassDao;
import com.dao.ClassReportDao;
import com.bean.Student;
import com.dao.StudentDao;
import com.resource.LaDbConnection;

/**
 * Servlet implementation class ListService
 */
public class ListService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		RequestDispatcher rd;
//		PrintWriter pw = response.getWriter();
//		PreparedStatement pstmt;

		String listOperation = "";
		listOperation = request.getParameter("listOperation");
		try {
		switch (listOperation) {
		
			case "View Teacher":
				
				List<Teacher> listTeacher = TeacherDao.list();
				request.setAttribute("listTeacher", listTeacher);		
				break;
				
			case "View Subject":
				
				List<Subject> listSubject = SubjectDao.list();
				request.setAttribute("listSubject", listSubject);
				break;
				
			case "View Class":
				
				List<Class> listClass = ClassDao.list();
				request.setAttribute("listClass", listClass);
				break;
				
			case "View Student":
				
				List<Student> listStudent = StudentDao.list();
				request.setAttribute("listStudent", listStudent);
				break;
			
			case "View Class Report":
				List<ClassReport> listClassReport = ClassReportDao.list();
				request.setAttribute("listClassReport", listClassReport);
				break;
				
			default:
				
		}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher rd;
		PrintWriter pw = response.getWriter();
		String listOperation = "";
		PreparedStatement pstmt;
		listOperation = request.getParameter("listOperation");
		try {
		switch (listOperation) {
		
			case "View Teachers":
				//response.setContentType("text/html");
				//pw.println("Viewing Teachers");
				//pstmt = LaDbConnection.getLaDbConn().prepareStatement("SELECT * from Teacher");
				//pstmt.setString(1, request.getParameter("teacherName"));
				
				List<Teacher> listTeacher = TeacherDao.list();
				request.setAttribute("listTeacher", listTeacher);
				//rd = request.getRequestDispatcher("addTeacher.jsp");
				//rd.include(request, response);
				//pw.println("Added "+pstmt.executeUpdate()+" teacher");
				
				break;
			case "Add Subject":
				pw.println("Adding Subject");
				pstmt = LaDbConnection.getLaDbConn().prepareStatement("insert into Subject(subjectName,teacherId) values(?,?)");
				pstmt.setString(1, request.getParameter("subjectName"));
				pstmt.setString(2, request.getParameter("teacherId"));
				
				response.setContentType("text/html");
				rd = request.getRequestDispatcher("addSubject.jsp");
				rd.include(request, response);
				pw.println("Added "+pstmt.executeUpdate()+" subject");
				
				break;
			case "Add Class":
				pw.println("Adding Class");
				break;
			case "Add Student":
				pw.println("Adding Student");
				break;
			default:
				
		}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		//doGet(request, response);
	}

}
