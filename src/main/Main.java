package main;

import main.query.Query;
import main.simulator.Simulator;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        int number = 0;
        do {
            System.out.println("1.main.simulator.Simulator");
            System.out.println("2.main.query.Query");
            System.out.println("0.Exit");
            Scanner input = new Scanner(System.in);
            number = input.nextInt();

            switch (number) {
                case 0: {
                    System.exit(0);
                }
                case 1: {
                    Simulator.start();
                    break;
                }
                case 2: {
                    do {
                        System.out.println("0.back");
                        System.out.println("1.Basic Query");
                        System.out.println("2.Complex Query");
                        number = input.nextInt();
                        Query query = new Query();
                        if (number == 1) query.basicQuery();
                        if (number == 2) query.complexQuery();
                    } while (number != 0);
                    break;
                }
                default:
                    break;
            }

        } while (true);
    }


}

