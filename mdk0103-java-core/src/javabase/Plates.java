package javabase;

import java.util.Scanner;

public class Plates {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter the number of plates: ");
        int plates_count = console.nextInt();
        System.out.print("Enter the amount of cleanser: ");
        double cleanser_count = console.nextDouble();

        while (plates_count >= 1 && cleanser_count >= 0.5) {
            plates_count--;
            cleanser_count -= 0.5;
            System.out.printf("%s plates left to wash. The amount of cleanser is %s\n", plates_count, cleanser_count);
        }
    }
}
