package Persistence;

import model.User;

public interface RepositoryIF {
	
	public void createUser(User user) throws Exception;
	
}
