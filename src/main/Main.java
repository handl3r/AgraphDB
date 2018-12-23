package main;

import main.query.Query;
import main.simulator.Simulator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("1.main.simulator.Simulator");
        System.out.println("2.main.query.Query");
        System.out.println("0.Exit");
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        switch (number) {
            case 1: {
                Simulator.start();
            }
            case 2: {
                Query.start();
            }
            default:
                break;

        }
    }


}

