package javabase;

import java.util.Scanner;

public class Money {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter the amount of money: ");
        double moneyCount = console.nextInt();
        double moneyInterest = 0.1;
        int moneyGoal = 1000000;
        int years = 0;

        while (moneyCount < moneyGoal) {
            moneyCount += moneyCount * moneyInterest;
            years++;
        }
        System.out.printf("In %s years you will have accumulated 1 million rubles", years);
    }
}
