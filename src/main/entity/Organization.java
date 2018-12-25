package main.entity;

import main.database.Triple;

import java.util.ArrayList;

public class Organization extends ParentObject {
    private String headquater;
    private int since = -1; // if since = -1 , it's nothing

    public Organization(String id, String label, String description, Source source, String type) {
        super(id, label, description, source, type);
    }

    public Organization(String id, String label, String description, Source source, String type, String headquater, int since) {
        super(id, label, description, source, type);
        this.headquater = headquater;
        this.since = since;
    }

    public Organization(String id, String label, String description, Source source, String type, String headquater) {
        super(id, label, description, source, type);
        this.headquater = headquater;
    }

    public Organization(String id, String label, String description, Source source, String type, int since) {
        super(id, label, description, source, type);
        this.since = since;
    }

    public String getHeadquater() {
        return headquater;
    }

    public void setHeadquater(String headquater) {
        this.headquater = headquater;
    }

    public int getSince() {
        return since;
    }

    public void setSince(int since) {
        this.since = since;
    }

    @Override
    public void displayInfor() {
        super.displayInfor();

        if (headquater != null)
            System.out.println("headquater : " + headquater);
        if (since != -1)
            System.out.println("since : " + since);
        System.out.println("----");

    }

    @Override
    public ArrayList toTriple() {
        ArrayList triples = super.toTriple();
        String IDString = getIDString();
        if (since != -1) {
            Triple triple1 = new Triple(IDString, "since", String.valueOf(since));
            triples.add(triple1);
        }
        Triple triple2 = new Triple(IDString, "headquater", headquater);
        triples.add(triple2);


        return triples;
    }
}
