package Persistence;

import java.io.File;

import model.User;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.index.Index;
import org.neo4j.kernel.EmbeddedGraphDatabase;

public class NodeRepository implements RepositoryIF{

	public static final String STOREDIR = "database";
	private final static String USER_KEY = "userID";
	private GraphDatabaseService graphDb;
	private Index<Node> index;

	public NodeRepository() {
		
		this.graphDb = new EmbeddedGraphDatabase(STOREDIR);
		index = graphDb.index().forNodes( "nodes" );
		deleteFileOrDirectory( new File( STOREDIR ) );
	}

	public void createUser(User user) throws Exception {

		Transaction tx = graphDb.beginTx();

		try {

			if (index.get(USER_KEY, user.getId()).getSingle() != null) {

				throw new Exception("Already exists a node with this id");

			} else {

				Node node = graphDb.createNode();
				node.setProperty(USER_KEY, user.getId());
				index.add(node, USER_KEY, user.getId());
				
				
				tx.success();
				
			}

		} finally {

			tx.finish();

		}

	}

	public Node getUser(long id) throws Exception {

		Transaction tx = graphDb.beginTx();
		try {

			Node res = index.get(USER_KEY, id).getSingle();

			if (res.equals(null))
				throw new Exception("Not exists node with this id!");
			else{
				tx.success();
				return res;
			}

		} finally {
			tx.finish();
		}

	}

	public void shutdown() {
		this.graphDb.shutdown();
	}

	public void registerShutdownHook() {
		// Registers a shutdown hook for the Neo4j and index service instances
		// so that it shuts down nicely when the VM exits (even if you
		// "Ctrl-C" the running example before it's completed)
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				shutdown();
			}
		});
	}
	
	private static void deleteFileOrDirectory( File file )
    {
        if ( file.exists() )
        {
            if ( file.isDirectory() )
            {
                for ( File child : file.listFiles() )
                {
                    deleteFileOrDirectory( child );
                }
            }
            file.delete();
        }
    }
	
	public boolean existsUser(long id){
		
		if (index.get(USER_KEY, id).getSingle() != null)
			return true;
		
		return false;
			
	}
		
}
