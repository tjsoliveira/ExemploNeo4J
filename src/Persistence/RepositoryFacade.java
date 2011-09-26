package Persistence;

import model.User;

public class RepositoryFacade {

	private NodeRepository graphBd;
	private RepositoryFake relationalBd;

	public RepositoryFacade() {

		graphBd = new NodeRepository();
		relationalBd = new RepositoryFake();

	}
	
	public void addUser(User user) throws Exception{
		
		try {
			graphBd.createUser(user);
			relationalBd.createUser(user);
			
		} catch (Exception e) {
			
			throw e;
		}
	}

	public User getUser(long id) throws Exception{
	
		if (!graphBd.existsUser(id))
			throw new Exception("User don't exists!");
		else{
			return relationalBd.getUser(id);
		}
	}
	
}
