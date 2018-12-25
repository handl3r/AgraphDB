package main.simulator;

import main.database.Triple;
import main.entity.ParentObject;
import main.entity.Relationship;

import java.util.ArrayList;

public class Paper {
    private ParentObject[] parentObjects;
    private Relationship[] relationships;

    public Paper(ParentObject[] parentObjects, Relationship[] relationships) {
        this.parentObjects = parentObjects;
        this.relationships = relationships;
    }

    public ArrayList toTriple() {
        int lengthObject = parentObjects.length;
        int lengRela = relationships.length;
        ArrayList triples = new ArrayList();
        for (int i = 0; i < lengthObject; i++) {
            triples.addAll(parentObjects[i].toTriple());
        }
        for (int i = 0; i < lengRela; i++) {
            triples.add(relationships[i].toTriple());
        }
//        ArrayList triples = parentObjects[0].toTriple();
//        triples.addAll(parentObjects[1].toTriple());
//        triples.addAll(parentObjects[2].toTriple());
//        Triple triple1 = relationships[0].toTriple();
//        Triple triple2 = relationships[1].toTriple();
//        triples.add(triple1);
//        triples.add(triple2);
//        System.out.println("Number of triples: " + triples.size());
        return triples;

    }

    public void showInfor() {
        for (int i = 0; i < parentObjects.length; i++) {
            parentObjects[i].displayInfor();
        }
        for (int i = 0; i < relationships.length; i++) {
            System.out.println(relationships[i].getType());
        }
//        System.out.println("OBJECT");
//        parentObjects[0].displayInfor();
//        System.out.println("HAVE RELATIONSHIP :");
//        System.out.println(relationships[0].getType());
//        System.out.println("WITH :");
//        parentObjects[1].displayInfor();
//        System.out.println("HAVE RELATIONSHIP :");
//        System.out.println(relationships[1].getType());
//        System.out.println("WITH :");
//        parentObjects[2].displayInfor();


    }
}
