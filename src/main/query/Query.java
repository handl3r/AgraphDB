package main.query;


import com.franz.agraph.repository.AGRepositoryConnection;
import com.franz.agraph.repository.AGTupleQuery;
import main.database.Configue;
import main.database.Connector;
import org.apache.jena.base.Sys;
import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.eclipse.rdf4j.model.vocabulary.XMLSchema;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.QueryLanguage;
import org.eclipse.rdf4j.query.TupleQueryResult;

import java.io.IOException;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        do {
            System.out.println("============= 10 Basic Query =============");
            System.out.println("1.Query1");
            System.out.println("2.Query2");
            System.out.println("3.Query3");
            System.out.println("4.Query4");
            System.out.println("5.Query5");
            System.out.println("6.Query6");
            System.out.println("7.Query7");
            System.out.println("8.Query8");
            System.out.println("9.Query9");
            System.out.println("10.Query10");
            System.out.println("0.back");
            number = scanner.nextInt();
            long start = System.nanoTime();
            switch (number){
                case 1: {
                    query1();
                    break;
                }
                case 2:{
                    query2();
                    break;
                }
                case 3: {
                    query3();
                    break;
                }
                case 4:{
                    query4();
                    break;
                }
                case 5: {
                    query5();
                    break;
                }
                case 6:{
                    query6();
                    break;
                }
                case 7: {
                    query7();
                    break;
                }
                case 8:{
                    query8();
                    break;
                }
                case 9: {
                    query9();
                    break;
                }
                case 10:{
                    query10();
                    break;
                }
                default: break;
            }
            long elapsedTime = System.nanoTime() - start;
            System.out.println("\nTime: " + elapsedTime / 1000000 + " ms");
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }while(number != 0);

    }
    public void complexQuery(){
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        do {
            System.out.println("============= 10 Complex Query =============");
            System.out.println("1.Query1");
            System.out.println("2.Query2");
            System.out.println("3.Query3");
            System.out.println("4.Query4");
            System.out.println("5.Query5");
            System.out.println("6.Query6");
            System.out.println("7.Query7");
            System.out.println("8.Query8");
            System.out.println("9.Query9");
            System.out.println("10.Query10");
            System.out.println("0.back");
            number = scanner.nextInt();
            long start = System.nanoTime();
            switch (number){
                case 1: {
                    query11();
                    break;
                }
                case 2:{
                    query12();
                    break;
                }
                case 3: {
                    query13();
                    break;
                }
                case 4:{
                    query14();
                    break;
                }
                case 5: {
                    query15();
                    break;
                }
                case 6:{
                    query16();
                    break;
                }
                case 7: {
                    query17();
                    break;
                }
                case 8:{
                    query18();
                    break;
                }
                case 9: {
                    query19();
                    break;
                }
                case 10:{
                    query20();
                    break;
                }
                default: break;
            }
            long elapsedTime = System.nanoTime() - start;
            System.out.println("\nTime: " + elapsedTime / 1000000 + " ms");
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }while(number != 0);
    }

    public static void printResult(TupleQueryResult result){
        while (result.hasNext()) {
            BindingSet bindingSet = result.next();
            Value s = bindingSet.getValue("r1");
            Value p = bindingSet.getValue("r2");
            Value o = bindingSet.getValue("r3");
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

    //10 Complex Query
    public void query11(){
//        System.out.println("Ten Truy Van");
//        String str1 = new String("select ?s ?p ?o {?s ?p ?o} limit 100");
//        printResult(this.getResult(str1));
    }
    public void query12(){
//        System.out.println("Ten Truy Van");
//        String str1 = new String("select ?s ?p ?o {?s ?p ?o} limit 100");
//        printResult(this.getResult(str1));
    }
    public void query13(){
//        System.out.println("Ten Truy Van");
//        String str1 = new String("select ?s ?p ?o {?s ?p ?o} limit 100");
//        printResult(this.getResult(str1));
    }
    public void query14(){
//        System.out.println("Ten Truy Van");
//        String str1 = new String("select ?s ?p ?o {?s ?p ?o} limit 100");
//        printResult(this.getResult(str1));
    }
    public void query15(){
//        System.out.println("Ten Truy Van");
//        String str1 = new String("select ?s ?p ?o {?s ?p ?o} limit 100");
//        printResult(this.getResult(str1));
    }
    public void query16(){
//        System.out.println("Ten Truy Van");
//        String str1 = new String("select ?s ?p ?o {?s ?p ?o} limit 100");
//        printResult(this.getResult(str1));
    }
    public void query17(){
//        System.out.println("Ten Truy Van");
//        String str1 = new String("select ?s ?p ?o {?s ?p ?o} limit 100");
//        printResult(this.getResult(str1));
    }
    public void query18(){
//        System.out.println("Ten Truy Van");
//        String str1 = new String("select ?s ?p ?o {?s ?p ?o} limit 100");
//        printResult(this.getResult(str1));
    }
    public void query19(){
//        System.out.println("Ten Truy Van");
//        String str1 = new String("select ?s ?p ?o {?s ?p ?o} limit 100");
//        printResult(this.getResult(str1));
    }
    public void query20(){
//        System.out.println("Ten Truy Van");
//        String str1 = new String("select ?s ?p ?o {?s ?p ?o} limit 100");
//        printResult(this.getResult(str1));
    }
    /// end Complex Query

    // 10 Basic Query
    public void query1(){
        System.out.println("Fill name person :");
        Scanner scanner = new Scanner(System.in);
        String input =scanner.nextLine();
        String str1 = new String("select ?r1 { ?person ?rel ?r1 { ?person a class:person . ?r1 a class:event . { ?person prop:label ?name FILTER (CONTAINS(?name, '"+input+"')) } } } limit 100");
        printResult(this.getResult(str1));
    }
    public void query2(){
        System.out.println("Fill location :");
        Scanner scanner = new Scanner(System.in);
        String input =scanner.nextLine();
        String str1 = new String("\n" +
                "select ?r1 { ?r1 ?rel ?location { ?location a class:location . ?r1 a class:event . { ?location prop:label ?name FILTER (CONTAINS(?name, '"+input+"')) } } } limit 100");
        printResult(this.getResult(str1));
    }
    public void query3(){
        System.out.println("Fill Age :");
        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt();
        String str1 = new String("select ?r1 ?r2 { ?r1 prop:age ?r2 . FILTER (xsd:integer(?r2) < "+age+") } limit 100");
        printResult(this.getResult(str1));
    }
    public void query4(){
        System.out.println("Fill name :");
        Scanner scanner = new Scanner(System.in);
        String input =scanner.nextLine();
        String str1 = new String("\n" +
                "select ?r1 ?r2 { ?r1 rela:visit ?r2 . { ?r1 prop:label ?name FILTER (CONTAINS(?name, '"+input+"')) } } limit 100");
        printResult(this.getResult(str1));
    }
    public void query5(){
        System.out.println("Fill name person :");
        Scanner scanner = new Scanner(System.in);
        String input =scanner.nextLine();
        String str1 = new String("select ?r1 ?r2 ?r3 { ?r1 a class:person . ?r1 ?r2 ?r3 . { ?r1 prop:label ?name FILTER (CONTAINS(?name, '"+input+"')) } FILTER(STRSTARTS(str(?r2), str(\"http://oop2018/properties/\"))) } ORDER BY ?r1 limit 100");
        printResult(this.getResult(str1));

    }
    public void query6(){
        System.out.println("Fill name country :");
        Scanner scanner = new Scanner(System.in);
        String input =scanner.nextLine();
        String str1 = new String("select ?r1 ?r2 { ?r1 prop:population ?r2 . { ?r1 prop:label ?name FILTER (CONTAINS(?name, '"+input+"')) } } limit 100");
        printResult(this.getResult(str1));

    }
    public void query7(){
        System.out.println("Fill name person :");
        Scanner scanner = new Scanner(System.in);
        String input =scanner.nextLine();
        String str1 = new String("select ?r1 ?r2 { ?r1 prop:nationality ?r2 . { ?r1 prop:label ?name FILTER (CONTAINS(?name, '"+input+"')) } } limit 100");
        printResult(this.getResult(str1));

    }
    public void query8(){
        System.out.println("Fill population : ");
        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt();
        String str1 = new String("select ?r1 ?r2 { ?r1 prop:population ?r2 . FILTER (xsd:integer(?r2) < "+age+") } limit 100");
        printResult(this.getResult(str1));

    }
    public void query9(){
        System.out.println("Fill year : ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        String str1 = new String("select ?r1 ?r2 { ?orga prop:label ?r1 . ?orga prop:since ?r2 . FILTER (xsd:integer(?r2) > "+input+") } order by ?r1 limit 100");
        printResult(this.getResult(str1));
    }
    public void query10(){
        System.out.println("Fill country :");
        Scanner scanner = new Scanner(System.in);
        String input =scanner.nextLine();
        String str1 = new String("select ?r1 ?r2 { ?r1 prop:country ?r2 FILTER (CONTAINS(?r2, '"+input+"')) } limit 100");
        printResult(this.getResult(str1));
    }
    /// end 10 Basic Query

    public static void start() {
        System.out.println("0.back");
        System.out.println("1.basicQuery");
        System.out.println("2.query2");
        System.out.println("3.query3");
        System.out.println("4.query4");
        Query query = new Query();
        query.basicQuery();

        System.out.println("query call done!!");
    }

}
