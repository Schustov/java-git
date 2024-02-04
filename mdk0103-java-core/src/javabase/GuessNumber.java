package javabase;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Random r = new Random();
        int randomNumber = r.nextInt(9) + 1;
        int guess;
        int attempts = 0;

        do {
            attempts++;
            System.out.print("Enter the number: ");
            guess = console.nextInt();

            if (guess == randomNumber) {
                System.out.println("Congratulations! You guessed right.");
                return;
            } else if (guess > randomNumber) {
                System.out.printf("The hidden number is less. %s attempts left\n", 3 - attempts);
            } else {
                System.out.printf("The hidden number is greater. %s attempts left\n", 3 - attempts);
            }
            if (attempts == 3) {
                System.out.println("You lose!");
                return;
            }

        } while (guess != randomNumber);
    }
}
