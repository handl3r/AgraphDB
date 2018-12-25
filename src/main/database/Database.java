package main.database;

import com.franz.agraph.repository.AGRepositoryConnection;
import com.franz.agraph.repository.AGValueFactory;
import main.entity.Relationship;
import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.impl.TreeModel;
import org.eclipse.rdf4j.model.vocabulary.RDF;

import java.util.ArrayList;
import java.util.Collections;

public class Database {
    private AGRepositoryConnection connection;
    private TreeModel treeModel = new TreeModel();
    private AGValueFactory valueFactory;
    private ArrayList<String> listProps = new ArrayList<String>();

    public Database(){
        this.listProps.add("source");
        this.listProps.add("description");
        this.listProps.add("label");
        this.listProps.add("population");
        this.listProps.add("country");
        this.listProps.add("since");
        this.listProps.add("headquater");
        this.listProps.add("age");
        this.listProps.add("nationality");
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
        else if (listProps.contains(triple.getPredicate())) {
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
        connection.add(treeModel);
        treeModel.clear();
        System.out.println("Size: " + connection.size());
    }
}
