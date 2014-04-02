package at.grueneis.spengergasse.idGeneration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import at.grueneis.spengergasse.lesson_plan.persistence.jdbc.*; 
import at.grueneis.spengergasse.lesson_plan.domain.Teacher;
import at.grueneis.spengergasse.lesson_plan.persistence.jdbc.AbstractDatabaseDao;

public class IdGeneration{
	
	private  AtomicInteger uniqueId=new AtomicInteger();
    private static  int id;

	public static int getid(){
    	
    	return  id;
    }
    
	public int generateUniqueId(int x) {      
		
		return id = 1+uniqueId.getAndIncrement();
	       
	}
	
	 private PreparedStatement findLastIdStatement() {
	        try {
	            if (findLastIdStatement == null) {
	                StringBuffer statementText = new StringBuffer();
	                statementText.append("SELECT MAX(");
	                statementText.append(columnList());
	                statementText.append(") ");
	                statementText.append("AS LastID");
	                statementText.append(" FROM ");
	                statementText.append(tableName());
	                
	                
	                System.out.println("Creating SQL statement: " + statementText);
	                findByIdStatement = connection().prepareStatement(statementText.toString());
	            }
	            return findLastIdStatement;
	        } catch (SQLException e) {
	            throw new LessonPlanDataAccessException("Failed to create find by id statement", e);
	        }
	 }
	
}


