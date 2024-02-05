package exam1;
import java.util.Objects;
import java.util.Scanner;

public class FinancialCalculator {
    public static void main(String[] args) {
        double[] spending = new double[30];
        boolean session = true;
        Scanner console = new Scanner(System.in);

        while (session) {
            System.out.print("""                    
                      1. Ввести расходы за определенный день
                      2. Вывести траты за месяц
                      3. Самая большая сумма расхода за месяц
                      4. Конвертировать в другую валюту
                      0. Выход
                    Выберите пункт из меню:\s""");
            String choice = console.next();

            switch (choice) {
                case "0":
                    System.out.println("До свидания!");
                    System.exit(0);

                case "1":
                    boolean session_1 = true;
                    while (session_1) {
                        System.out.print("Введите день: ");
                        choice = console.next();
                        try {
                            if (Integer.parseInt(choice) < 1 || Integer.parseInt(choice) > 30) {
                                System.out.println("День не входит в диапазон, попробуйте еще раз.");
                                continue;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("День не входит в диапазон, попробуйте еще раз.");
                            continue;
                        }

                        if (spending[Integer.parseInt(choice) - 1] != 0) {
                            System.out.print("Сумма уже указана, перезаписать?(да/нет): ");
                            String choice_1 = console.next().trim().toLowerCase();
                            if (!Objects.equals(choice_1, "да")) break;
                        }
                        System.out.printf("%s день: ", choice);
                        double amount = console.nextDouble();
                        spending[Integer.parseInt(choice) - 1] = amount;

                        System.out.print("Ввести траты за другой день?(да/нет): ");
                        choice = console.next().trim().toLowerCase();
                        if (!Objects.equals(choice, "да")) session_1 = false;
                    }
                    break;

                case "2":
                    for (int i = 0; i < spending.length; i++) {
                        System.out.printf("%s день - %s руб\n", i + 1, spending[i]);
                    }
                    break;

                case "3":
                    double max = spending[0];
                    int index = 0;
                    for (int i = 1; i < spending.length; i++) {
                        if (spending[i] > max) {
                            max = spending[i];
                            index = i;
                        }
                    }
                    System.out.printf("%s день - %s руб\n", index + 1, max);
                    break;

                case "4":
                    System.out.print("""                    
                        1. Евро
                        2. Доллары
                        3. Юани
                      Выберите пункт из меню:\s""");
                    choice = console.next().trim();

                    switch (choice) {
                        case "1":
                            for (int i = 0; i < spending.length; i++) {
                                System.out.printf("%s день - %.2f €\n", i + 1, spending[i] * 0.010138);
                            }
                            break;
                        case "2":
                            for (int i = 0; i < spending.length; i++) {
                                System.out.printf("%s день - %.2f $\n", i + 1, spending[i] * 0.01103);
                            }
                            break;
                        case "3":
                            for (int i = 0; i < spending.length; i++) {
                                System.out.printf("%s день - %.2f ¥\n", i + 1, spending[i] * 0.079364);
                            }
                            break;
                        default:
                            System.out.println("Такого пункта нет в меню.");
                            break;
                    }
                    break;

                default:
                    System.out.println("Такого пункта нет в меню.");
                    break;
            }
        }
    }
}
