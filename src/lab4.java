package PACKAGE_NAME;

public class lab4 {
}
import java.util.Scanner;

public class lab4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Лабораторная работа №4 =====");
            System.out.println("----- Работа с циклами -----");
            System.out.println("1. Сумма чисел от 1 до N (for)");
            System.out.println("2. Чётные числа от 1 до 20 (for)");
            System.out.println("3. Факториал числа (for)");
            System.out.println("4. Повторение символа (while)");
            System.out.println("5. Нечётные числа от 1 до 100 (do-while)");
            System.out.println("6. Сумма чисел до ввода 0 (do-while)");

            System.out.println("----- Самостоятельная работа -----");
            System.out.println("7. Определить знак числа");
            System.out.println("8. Оценка по баллам");
            System.out.println("9. Сравнить два числа");
            System.out.println("10. День недели");
            System.out.println("11. Чётное или нечётное");
            System.out.println("12. Доступ по возрасту");
            System.out.println("13. Дни в месяце");
            System.out.println("14. Температура");
            System.out.println("15. Проверка диапазона");
            System.out.println("16. Калькулятор");

            System.out.println("0. Выход");
            System.out.print("Выберите задание: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: sumToN(scanner); break;
                case 2: evenNumbers(); break;
                case 3: factorial(scanner); break;
                case 4: repeatSymbol(scanner); break;
                case 5: oddNumbers(); break;
                case 6: sumUntilZero(scanner); break;
                case 7: signNumber(scanner); break;
                case 8: grade(scanner); break;
                case 9: compare(scanner); break;
                case 10: dayOfWeek(scanner); break;
                case 11: evenOdd(scanner); break;
                case 12: access(scanner); break;
                case 13: daysInMonth(scanner); break;
                case 14: temperature(scanner); break;
                case 15: rangeCheck(scanner); break;
                case 16: calculator(scanner); break;
                case 0:
                    System.out.println("Выход...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный ввод!");
            }
        }
    }

    // ===== ЦИКЛЫ =====

    static void sumToN(Scanner sc) {
        System.out.print("Введите N: ");
        int n = sc.nextInt();
        int sum = 0;
        for (int i = 1; i <= n; i++) sum += i;
        System.out.println("Сумма = " + sum);
    }

    static void evenNumbers() {
        System.out.println("Чётные числа от 1 до 20:");
        for (int i = 1; i <= 20; i++) {
            if (i % 2 == 0) System.out.print(i + " ");
        }
        System.out.println();
    }

    static void factorial(Scanner sc) {
        System.out.print("Введите N: ");
        int n = sc.nextInt();
        long fact = 1;
        for (int i = 1; i <= n; i++) fact *= i;
        System.out.println("Факториал = " + fact);
    }

    static void repeatSymbol(Scanner sc) {
        System.out.print("Введите символ: ");
        char ch = sc.next().charAt(0);
        System.out.print("Сколько раз повторить: ");
        int count = sc.nextInt();
        int i = 0;
        while (i < count) {
            System.out.print(ch);
            i++;
        }
        System.out.println();
    }

    static void oddNumbers() {
        int i = 1;
        System.out.println("Нечётные числа от 1 до 100:");
        do {
            if (i % 2 != 0) System.out.print(i + " ");
            i++;
        } while (i <= 100);
        System.out.println();
    }

    static void sumUntilZero(Scanner sc) {
        int sum = 0;
        int number;
        System.out.println("Введите числа (0 для завершения):");
        do {
            number = sc.nextInt();
            sum += number;
        } while (number != 0);
        System.out.println("Сумма = " + sum);
    }

    // ===== САМОСТОЯТЕЛЬНАЯ РАБОТА =====

    static void signNumber(Scanner sc) {
        System.out.print("Введите число: ");
        int n = sc.nextInt();
        if (n > 0) System.out.println("Положительное");
        else if (n < 0) System.out.println("Отрицательное");
        else System.out.println("Ноль");
    }

    static void grade(Scanner sc) {
        System.out.print("Введите балл: ");
        int score = sc.nextInt();
        if (score >= 90) System.out.println("Оценка: 5");
        else if (score >= 75) System.out.println("Оценка: 4");
        else if (score >= 60) System.out.println("Оценка: 3");
        else System.out.println("Оценка: 2");
    }

    static void compare(Scanner sc) {
        System.out.print("Первое число: ");
        int a = sc.nextInt();
        System.out.print("Второе число: ");
        int b = sc.nextInt();
        if (a > b) System.out.println("Первое больше");
        else if (b > a) System.out.println("Второе больше");
        else System.out.println("Числа равны");
    }

    static void dayOfWeek(Scanner sc) {
        System.out.print("Введите номер дня (1-7): ");
        int day = sc.nextInt();
        switch (day) {
            case 1: System.out.println("Понедельник"); break;
            case 2: System.out.println("Вторник"); break;
            case 3: System.out.println("Среда"); break;
            case 4: System.out.println("Четверг"); break;
            case 5: System.out.println("Пятница"); break;
            case 6: System.out.println("Суббота"); break;
            case 7: System.out.println("Воскресенье"); break;
            default: System.out.println("Неверный номер дня");
        }
    }

    static void evenOdd(Scanner sc) {
        System.out.print("Введите число: ");
        int n = sc.nextInt();
        System.out.println((n % 2 == 0) ? "Чётное" : "Нечётное");
    }

    static void access(Scanner sc) {
        System.out.print("Введите возраст: ");
        int age = sc.nextInt();
        System.out.println((age >= 18) ? "Доступ разрешён" : "Доступ запрещён");
    }

    static void daysInMonth(Scanner sc) {
        System.out.print("Введите месяц (1-12): ");
        int m = sc.nextInt();
        switch (m) {
            case 1, 3, 5, 7, 8, 10, 12 -> System.out.println("31 день");
            case 4, 6, 9, 11 -> System.out.println("30 дней");
            case 2 -> System.out.println("28 или 29 дней");
            default -> System.out.println("Неверный месяц");
        }
    }

    static void temperature(Scanner sc) {
        System.out.print("Введите температуру: ");
        int t = sc.nextInt();
        if (t < 0) System.out.println("Холодно");
        else if (t <= 25) System.out.println("Тепло");
        else System.out.println("Жарко");
    }

    static void rangeCheck(Scanner sc) {
        System.out.print("Введите число: ");
        int n = sc.nextInt();
        if (n >= 10 && n <= 50)
            System.out.println("В диапазоне 10-50");
        else
            System.out.println("Вне диапазона");
    }

    static void calculator(Scanner sc) {
        System.out.print("Введите первое число: ");
        double a = sc.nextDouble();
        System.out.print("Введите второе число: ");
        double b = sc.nextDouble();
        System.out.print("Операция (+ - * /): ");
        char op = sc.next().charAt(0);

        switch (op) {
            case '+': System.out.println("Результат = " + (a + b)); break;
            case '-': System.out.println("Результат = " + (a - b)); break;
            case '*': System.out.println("Результат = " + (a * b)); break;
            case '/':
                if (b != 0) System.out.println("Результат = " + (a / b));
                else System.out.println("Деление на 0 невозможно");
                break;
            default: System.out.println("Неверная операция");
        }
    }
}
