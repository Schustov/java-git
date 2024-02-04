package javabase;

import java.util.Random;

public class Spending {
    public static void main(String[] args) {
        int[] spending = new int[7];
        int total = 0;
        Random r = new Random();

        for (int i = 0; i < spending.length; i++) {
            spending[i] = r.nextInt(1000) + 1;
            total += spending[i];
            System.out.printf("%s: %s$\n", i + 1, spending[i]);
        }
        System.out.printf("A total of %s$ was spent", total);
    }
}
