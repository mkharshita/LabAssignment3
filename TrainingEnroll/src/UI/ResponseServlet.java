package UI;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DatabaseOperationsDAOImpl;


public class ResponseServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id =Integer.parseInt(request.getParameter("id"));
		int seat=Integer.parseInt(request.getParameter("seats"));
		PrintWriter out = response.getWriter();
		if(seat==0) {
			out.print("<b>No Seats Are Available.</b>");
			out.print("</br></br><a href='index.html'>Enroll Again</a>");
		}
		else
		{
			try {
				DatabaseOperationsDAOImpl operation = new DatabaseOperationsDAOImpl();
				System.out.println("responseservlet");
				if(operation.enrolledStatement(id, seat)) {
					out.print("<b>Hi you have successfully enrolled for Spring Training.</b>");
					out.print("</br></br><a href='Index.html'>Enroll Again</a>");
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
