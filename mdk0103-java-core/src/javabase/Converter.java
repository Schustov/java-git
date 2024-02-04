package javabase;

import java.util.Scanner;

public class Converter {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Which country do you want to visit?");
        System.out.print("Enter 1 if Sweden, 2 if China: ");
        String country = console.next();

        switch (country) {
            case ("1"):
                System.out.print("Enter the amount of euros: ");
                double eurosCount = console.nextDouble();
                double eurosPerKrona = eurosCount * 11.4;
                System.out.printf("%s euros in Swedish krona is %s", eurosCount, eurosPerKrona);
                break;
            case ("2"):
                System.out.print("Enter the amount of yen: ");
                double yenCount = console.nextDouble();
                double yenPerYuan = yenCount * 0.05;
                System.out.printf("%s yen in yuan is %s", yenCount, yenPerYuan);
                break;
        }
    }
}
