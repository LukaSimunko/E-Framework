package at.grueneis.spengergasse.idGeneration;

import java.util.concurrent.atomic.AtomicInteger;

import at.grueneis.spengergasse.lesson_plan.domain.Teacher;

public class IdGeneration {
	
	private  AtomicInteger uniqueId=new AtomicInteger();
    private  int id;
	
    
    public int getid(int id){
    	
    	return  id;
    }
    
	public int generateUniqueId() {      
		
		return id = 1+uniqueId.getAndIncrement();
	       
	   }
	
	public static void main(String[] args){
		
		IdGeneration idg = new IdGeneration();
		for(int i=0; i<=10;i++){
	    	   System.out.println(idg.generateUniqueId()+" Hello Worldddddddddd");
	       }
	}

}