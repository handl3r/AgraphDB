package main.database;

import com.franz.agraph.repository.AGRepositoryConnection;
import com.franz.agraph.repository.AGValueFactory;
import main.entity.Relationship;
import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.impl.TreeModel;
import org.eclipse.rdf4j.model.vocabulary.RDF;

public class Database {
    private AGRepositoryConnection connection;
    private TreeModel treeModel = new TreeModel();
    private AGValueFactory valueFactory;

    public Database(){
        Connector connector = new Connector();
        this.connection = connector.createConnect();
        this.valueFactory = connection.getValueFactory();
    }

//    public void setAttributeEntity() {
//        IRI label = valueFactory.createIRI(Configue.ENTITY_LINK,object);
//        IRI type = valueFactory.createIRI(Configue.CLASS_LINK,object.getType());
//        treeModel.add(label, RDF.TYPE,type);
//        //chua hoan thien
//        if(treeModel.size() > 200000) storageModel();
//    }

    public void saveTripleToDB(Triple triple) {
        if (triple.getPredicate().equals("typeOf")) {
            IRI s = valueFactory.createIRI(Configue.ENTITY_LINK,triple.getSubject());
            IRI o = valueFactory.createIRI(Configue.CLASS_LINK,triple.getObject());
            treeModel.add(s,RDF.TYPE,o);
        }
        else if (triple.getPredicate().equals("hasProperty")) {
            IRI s = valueFactory.createIRI(Configue.ENTITY_LINK,triple.getSubject());
            IRI p = valueFactory.createIRI(Configue.PROPERTIES_LINK,triple.getPredicate());
            Literal o = valueFactory.createLiteral(triple.getObject());
            treeModel.add(s,p,o);
        }
        else {
            IRI s = valueFactory.createIRI(Configue.ENTITY_LINK,triple.getSubject());
            IRI p = valueFactory.createIRI(Configue.RELATIONSHIP_LINK,triple.getPredicate());
            IRI o = valueFactory.createIRI(Configue.ENTITY_LINK,triple.getObject());
            treeModel.add(s,p,o);
        }
        if(treeModel.size() > 100) storageModel();
    }

    public void storageModel() {
        System.out.println(treeModel.size());
        connection.add(treeModel);
        treeModel.clear();
        System.out.println(connection.size());
        System.out.println("================================================================");
    }
}
