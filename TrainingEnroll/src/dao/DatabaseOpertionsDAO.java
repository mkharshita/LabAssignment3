package dao;

import java.util.List;

import model.Training;

public interface DatabaseOpertionsDAO 
{
	public boolean enrolledStatement(int d,int seat) throws Exception;
	public List<Training> getInstructors()throws Exception;
}
