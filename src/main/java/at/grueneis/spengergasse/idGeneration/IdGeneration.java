package at.grueneis.spengergasse.idGeneration;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGeneration {
	
	private static  AtomicInteger uniqueId=new AtomicInteger();
    private static  int id;
	
    
    public int getid(int id){
    	
    	return  id;
    }
    
	public static int generateUniqueId() {      
		
		return id = 1+uniqueId.getAndIncrement();
	       
	   }
	
	public static void main(String[] args){
		
		for(int i=0; i<=10;i++){
	    	   System.out.println(generateUniqueId());
	       }
	}

}