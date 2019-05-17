package chap11_proxy.gumball;

import java.util.Scanner;

public class GumballMachineTestDrive {
    public static void main(String[] args) {
        int count;
        if (args.length < 2) {
            System.out.println("GumballMachineTestDrive <name> <inventory>");
            System.exit(1);
        }
        count = Integer.parseInt(args[1]);
        GumballMachine gumballMachine = new GumballMachine(args[0], count);
        GumballMonitor monitor = new GumballMonitor(gumballMachine);
        boolean switchON = true;
        int choice = 0;
        Scanner scanner;
        while (switchON) {
            System.out.println("0 - Help");
            scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) choice = scanner.nextInt();
            else continue;

            switch (choice) {
                case (1):gumballMachine.insertQuarter();break;
                case (2):gumballMachine.turnCrank();break;
                case (3):gumballMachine.ejectQuarter();break;
                case (4):gumballMachine.refill(2);break;
                case (5):System.out.println(gumballMachine);break;
                case (6):monitor.report();break;
                case (9):switchON = false;break;
                case (0):
                    System.out.println("1 - insertQuarter");
                    System.out.println("2 - turnCrank     3 - ejectQuarter");
                    System.out.println("4 - refill");
                    System.out.println("5 - print         6 - monitor.report");
                    System.out.println("9 - Exit");
                    break;
            }
            scanner.close();
        }
    }
}