package main.query;

import com.franz.agraph.repository.AGRepositoryConnection;
import com.franz.agraph.repository.AGTupleQuery;
import main.database.Configue;
import main.database.Connector;
import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.eclipse.rdf4j.model.vocabulary.XMLSchema;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.QueryLanguage;
import org.eclipse.rdf4j.query.TupleQueryResult;

public class Query {
    private AGRepositoryConnection connect;

    public Query(){
        Connector connector = new Connector();
        this.connect = connector.getConnection(Configue.REPOSITORY_ID);
    }

    public TupleQueryResult getResult(String tupleString){
        AGTupleQuery tupleQuery = connect.prepareTupleQuery(QueryLanguage.SPARQL,tupleString);
        TupleQueryResult result = tupleQuery.evaluate();
        return result;
    }

    public void basicQuery(){
        System.out.println("============= 10 Basic Query =============");

        System.out.println("Ten Truy Van");
        String str1 = new String("select ?s ?p ?o {?s ?p ?o} limit 100");
        printResult(this.getResult(str1));

//        System.out.println("Ten Truy Van");
//        String str2 = null;
//        printResult(this.getResult(str2));
//
//        System.out.println("Ten Truy Van");
//        String str3 = null;
//        printResult(this.getResult(str3));
//
//        System.out.println("Ten Truy Van");
//        String str4 = null;
//        printResult(this.getResult(str4));
//
//        System.out.println("Ten Truy Van");
//        String str5 = null;
//        printResult(this.getResult(str5));
    }

    public static void printResult(TupleQueryResult result){
        while (result.hasNext()) {
            BindingSet bindingSet = result.next();
            Value s = bindingSet.getValue("s");
            Value p = bindingSet.getValue("p");
            Value o = bindingSet.getValue("o");
            String s1 = new String();
            s1 = s1 + removePrefix(s) + " " + removePrefix(p) + " " + removePrefix(o);
            System.out.println(s1);
        }
    }

    public static String removePrefix(Value uri){
        if(uri == null) return "";

        String str = uri.toString();
        str = str.replace(Configue.ENTITY_LINK,"");
        str = str.replace(Configue.CLASS_LINK,"");
        str = str.replace(Configue.PROPERTIES_LINK,"");
        str = str.replace(Configue.RELATIONSHIP_LINK, "");
        str = str.replace(RDF.TYPE.toString()," is ");
        str = str.replace(XMLSchema.NAMESPACE.toString(),"");

        if (str.charAt(0) == '"') {
            int pos = str.indexOf('^');
            str = str.substring(1, pos - 1);
        }

        return str;
    }
    public static void start() {
        Query query = new Query();
        query.basicQuery();

        System.out.println("query call done!!");
    }

    public static void main(String[] args) {
        start();
    }
}
