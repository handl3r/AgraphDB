package main.entity;

import main.database.Triple;

import java.util.ArrayList;

public class Country extends ParentObject {
    private int population = -1; // if population = -1 , it's nothing

    public Country(String id, String label, String description, Source source, String type) {
        super(id, label, description, source, type);
    }

    public Country(String id, String label, String description, Source source, String type, int population) {
        super(id, label, description, source, type);
        this.population = population;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public void displayInfor() {
        super.displayInfor();
        if (population != -1)
            System.out.println("population : " + population);
        System.out.println("----");
    }

    @Override
    public ArrayList toTriple() {
        ArrayList triples = super.toTriple();

        String IDString = getIDString();
        if (population != -1){
            Triple triple1 = new Triple(IDString, "population", String.valueOf(population));
            triples.add(triple1);
        }
        return triples;
    }
}
