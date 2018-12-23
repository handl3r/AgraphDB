package main.entity;

import main.database.Triple;

import java.util.ArrayList;

public class Location extends ParentObject {
    private String country;

    public Location(String id, String label, String description, Source source, String type) {
        super(id, label, description, source, type);
    }

    public Location(String id, String label, String description, Source source, String type, String country) {
        super(id, label, description, source, type);
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public void displayInfor() {
        super.displayInfor();
        if (country != null)
            System.out.println("country : " + country);
        System.out.println("----");
    }
    @Override
    public ArrayList toTriple(){
        ArrayList triples = super.toTriple();
        String IDString = getIDString();
        if (country != null){
            Triple triple1 = new Triple(IDString,"hasProperty",country);
            triples.add(triple1);
        }
        return  triples;
    }
}
