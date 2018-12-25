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

            switch (number){
                case 0:{
                    System.exit(0);
                }
                case 1:{
                    Simulator.start();
                    break;
                }
                case 2:{
                    do {
                        System.out.println("0.back");
                        System.out.println("1.query1");
                        System.out.println("2.query2");
                        System.out.println("3.query3");
                        System.out.println("4.query4");
                        number = input.nextInt();
                        if (number == 1) Query.query1();
                        if (number == 2) Query.query2();
                        if (number == 3) Query.query3();
                        if (number == 4) Query.query4();
                    }while(number != 0);
                    break;
                }
                default:
                    break;
            }

        }while (true);
    }


}

