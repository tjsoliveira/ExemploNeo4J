package Persistence;

import java.util.ArrayList;
import model.User;

public class RepositoryFake implements RepositoryIF{

	public ArrayList<User> users;
	
	public RepositoryFake(){
		this.users = new ArrayList<User>();
	}
	
	public void createUser(User user){
		this.users.add(user);
	}
	
	public User getUser(long id) throws Exception{
		
		for (User user: users){
			if(user.getId() == id){
				return user;
			}
		}
		
		throw new Exception("Not exists Student with this id!");
	}
}
