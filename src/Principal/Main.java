package Principal;

import model.Student;
import Persistence.RepositoryFacade;

public class Main
{

    public static void main( final String[] args ){
    	
    	RepositoryFacade db = new RepositoryFacade();
    	
    	try {
    		
    		db.addUser(new Student(1, "Thiago", "80811110", "email"));
    		System.out.println(db.getUser(1).toString());
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
    	
    }
}
