package main.test;

import java.io.File;

import com.franz.agraph.repository.AGCatalog;
import com.franz.agraph.repository.AGRepository;
import com.franz.agraph.repository.AGRepositoryConnection;
import com.franz.agraph.repository.AGServer;


public class TestConnect {
    private static final String SERVER_URL = "http://localhost:10035";
    private static final String CATALOG_ID = "scratch";
    private static final String REPOSITORY_ID = "TestJavaAPI";
    private static final String USERNAME = "test";
    private static final String PASSWORD = "buixuanthai";
    private static final File DATA_DIR = new File(".");

    private static final String FOAF_NS = "http://xmlns.com/foaf/0.1/";

    public void example1() {
        System.out.println("xx");
        AGServer server = new AGServer(SERVER_URL, USERNAME, PASSWORD);
        System.out.println("Available catalogs: " + server.listCatalogs());
        AGCatalog catalog = server.getRootCatalog();
        AGRepository repository = new AGRepository(catalog, REPOSITORY_ID);
        System.out.println("oke1");
        AGRepositoryConnection connection = repository.getConnection();
        System.out.println("oke2");
        connection.close();
        System.out.println("Got a connection.");
        System.out.println("Repository " + (repository.getRepositoryID()) +
                " is up! It contains " + (connection.size()) +
                " statements."
        );

    }

}

