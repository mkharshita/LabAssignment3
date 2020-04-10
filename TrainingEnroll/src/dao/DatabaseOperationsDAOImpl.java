package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Training;

public class DatabaseOperationsDAOImpl implements DatabaseOpertionsDAO {
	
	Connection con;
	PreparedStatement ps;
	
	

	public DatabaseOperationsDAOImpl() throws ClassNotFoundException, SQLException {
		
		con = DatabaseConnectionFactory.getConnection();
	}



	@Override
	public List<Training> getInstructors() throws Exception {
		
		List<Training> list = new ArrayList<Training>();
		String q = "select * from Training";
		ps = con.prepareStatement(q);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			int id = rs.getInt(1);
			String name = rs.getString(2);
			int seats = rs.getInt(3);
			Training t=new Training();
			t.setId(id);
			t.setName(name);
			t.setSeat(seats);
			
			
			
			list.add(t);
		}
		con.close();
		return list;
	}



	@Override
	public boolean enrolledStatement(int id,int seat) throws Exception {
		System.out.println("HIII");
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("update Training set Availableseats=AvailableSeats-1 where trainingId="+id);
		con.close();
		return true;
	}
	
	

}
