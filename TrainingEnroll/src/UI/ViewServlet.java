package UI;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DatabaseOperationsDAOImpl;
import model.Training;


public class ViewServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		List<Training> list;
		DatabaseOperationsDAOImpl operation;
		try {
			operation = new DatabaseOperationsDAOImpl();
			list=operation.getInstructors();
			out.print("<table>");
			out.print("<tr>");
			out.print("<th> Training Id </th>"); 
			out.print("<th> Training Name </th>"); 
			out.print("<th> Avalaible Seats </th>"); 
			out.print("</tr>");
			for (Training t : list) {
				out.print("<tr>");
				out.print("<td>"+t.getId()+"</td>");
				out.print("<td>"+t.getName()+"</td>");
				out.print("<td>"+t.getSeat()+"</td>");
				System.out.println("view");
				out.print("<td><a href='ResponseServlet?id="+t.getId()+"&seats="+t.getSeat()+"'>Enroll</a></td>");
				out.print("</tr>");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		
	}

}
