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
        return triples;

    }

    public void showInfor() {
        for (int i = 0; i < parentObjects.length; i++) {
            parentObjects[i].displayInfor();
        }
        for (int i = 0; i < relationships.length; i++) {
            System.out.println(relationships[i].getType());
        }
    }
}
