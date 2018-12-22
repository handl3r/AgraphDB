import org.apache.jena.base.Sys;

import java.util.ArrayList;

public class Paper {
    private ParentObject[] parentObjects;
    private Relationship[] relationships;

    public Paper(ParentObject[] parentObjects, Relationship[] relationships) {
        this.parentObjects = parentObjects;
        this.relationships = relationships;
    }
    public ArrayList toTriple(){
        ArrayList triples = parentObjects[0].toTriple();
        triples.addAll(parentObjects[1].toTriple());
        triples.addAll(parentObjects[2].toTriple());
        Triple triple1 = relationships[0].toTriple();
        Triple triple2 = relationships[1].toTriple();
        triples.add(triple1);
        triples.add(triple2);
        return triples;

    }

    public void showInfor() {
        System.out.println("OBJECT0 :");
        parentObjects[0].displayInfor();
        System.out.println("HAVE RELATIONSHIP :");
        System.out.println(relationships[0].getType());
        System.out.println("WITH :");
        parentObjects[1].displayInfor();
        System.out.println("HAVE RELATIONSHIP :");
        System.out.println(relationships[1].getType());
        System.out.println("WITH :");
        parentObjects[2].displayInfor();


    }
}
