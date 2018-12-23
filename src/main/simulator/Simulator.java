package main.simulator;

import main.database.Database;
import main.database.Triple;

import java.util.ArrayList;
import java.util.Iterator;

public class Simulator {
    public static void start() {
        Paper paper = GenPaper.genTypeA();
        ArrayList triples = paper.toTriple();
        Iterator<Triple> iterator = triples.iterator();
        Database database = new Database();
        while (iterator.hasNext()) {
            database.saveTripleToDB(iterator.next());
        }
        database.storageModel();

        System.out.println("main.simulator.Simulator call done");
    }

    public static void main(String[] args) {
        Simulator.start();
    }
}
