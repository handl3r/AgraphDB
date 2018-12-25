package main.simulator;

import main.database.Database;
import main.database.Triple;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Simulator {
    public static void start() {
        Paper paper = null;
        ArrayList triples = null;
        Iterator<Triple> iterator ;
        Database database = new Database();
        Scanner scanner = new Scanner(System.in);
        int N =0;
        int M = 0;
        float ratio;
        do{
            System.out.println("M : ");
            M = scanner.nextInt();
            System.out.println("N : ");
            N = scanner.nextInt();

            ratio = (float) M/(float) N;
            System.out.println(ratio);
        }while (ratio < 1.4 || ratio > 1.5);

        int typeA = (3*M - 4*N)/2;
        int typeB = 3*M - 4*N - typeA;
        int typeC = 3*N - 2*M;

        for (int i =0 ;i < typeA; i++){
            paper = GenPaper.genTypeA();
            triples = paper.toTriple();
            iterator = triples.iterator();
            while (iterator.hasNext()) {
            database.saveTripleToDB(iterator.next());

          }
            database.storageModel();

        }
        for (int i =0 ;i < typeB; i++){
            paper = GenPaper.genTypeB();
            triples = paper.toTriple();
            iterator = triples.iterator();
            while (iterator.hasNext()) {
                database.saveTripleToDB(iterator.next());

            }
            database.storageModel();

        }
        for (int i =0 ;i < typeC; i++){
            paper = GenPaper.genTypeC();
            triples = paper.toTriple();
            iterator = triples.iterator();
            while (iterator.hasNext()) {
                database.saveTripleToDB(iterator.next());

            }
            database.storageModel();
        }


        System.out.println("main.simulator.Simulator call done");
    }

}
