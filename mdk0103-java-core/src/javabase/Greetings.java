package javabase;

import java.util.Date;
import java.util.Scanner;

public class Greetings {
    public static void main(String[] args) {
        Date date = new Date();
        int currentTime = date.getHours();
        String greeting;

        if (currentTime < 4) greeting = "night";
        else if (currentTime < 12) greeting = "morning";
        else if (currentTime < 18) greeting = "afternoon";
        else greeting = "evening";

        Scanner console = new Scanner(System.in);
        System.out.print("What is your name?: ");
        String name = console.nextLine();
        System.out.printf("Good %s, %s", greeting, name);
    }
}
