import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("1.Simulator");
        System.out.println("2.Query");
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

