package javabase;

import java.util.Scanner;

public class FinancialMethod {
    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean status = true;

        while (status) {
            System.out.print("Enter your salary: ");
            double salary = scanner.nextDouble();
            if (!checkValues(salary)) continue;
            System.out.print("Enter your transportation expenses: ");
            double transportExpenses = scanner.nextDouble();
            if (!checkValues(salary, transportExpenses)) continue;
            System.out.print("Enter your food expenses: ");
            double foodExpenses = scanner.nextDouble();
            if (!checkValues(salary, transportExpenses, foodExpenses)) continue;
            System.out.print("Enter your savings: ");
            double savings = scanner.nextDouble();
            if (!checkValues(salary, transportExpenses, foodExpenses, savings)) continue;

            System.out.printf("You have enough salary for transport, food and savings, surplus funds are %s",
                    salary - transportExpenses - foodExpenses - savings);
            status = false;
        }
    }
    private static boolean checkValues(double salary) {
        if (salary <= 0) {
            System.out.println("Incorrect salary value. Try again");
            return false;
        }
        return true;
    }
    private static boolean checkValues(double salary, double transportExpenses) {
        if (transportExpenses > salary) {
            System.out.println("The cost of transportation is more than the salary. Try again");
            return false;
        }
        return true;
    }

    private static boolean checkValues(double salary, double transportExpenses, double foodExpenses) {
        double totalExpenses = transportExpenses + foodExpenses;
        if (totalExpenses > salary) {
            System.out.println("The cost of transportation and food is more than the salary. Try again");
            return false;
        }
        return true;
    }

    private static boolean checkValues(double salary, double transportExpenses, double foodExpenses, double savings) {
        double totalExpenses = transportExpenses + foodExpenses;
        double difference = salary - totalExpenses;
        if (savings > difference) {
            System.out.println("The salary is not enough for savings");
            return false;
        }
        return true;
    }
}
