package at.grueneis.spengergasse.idGeneration;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import at.grueneis.spengergasse.lesson_plan.persistence.jdbc.*; 

import at.grueneis.spengergasse.lesson_plan.domain.Teacher;

public class IdGeneration{
	
	private  AtomicInteger uniqueId=new AtomicInteger();
    private static  int id;
    


	public static int getid(){
    	
    	return  id;
    }
    
	public int generateUniqueId() {      
		
		return id = 1+uniqueId.getAndIncrement();
	       
	}
	
	
	
	
}


