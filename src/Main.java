import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // ===== Задание 1. Последовательность выполнения команд =====
        int x = 5;
        int y = 10;
        int z = 15;
        int sumXYZ = x + y + z;

        System.out.println("Задание 1:");
        System.out.println("x = " + x + ", y = " + y + ", z = " + z);
        System.out.println("Сумма = " + sumXYZ);
        System.out.println();

        // ===== Задание 2. Арифметические операции =====
        System.out.println("Задание 2:");
        System.out.print("Введите первое число: ");
        double a = scanner.nextDouble();

        System.out.print("Введите второе число: ");
        double b = scanner.nextDouble();

        double sum = a + b;
        double product = a * b;
        double division = a / b;

        System.out.println("Сложение: " + sum);
        System.out.println("Умножение: " + product);
        System.out.println("Деление: " + division);
        System.out.println();

        // ===== Задание 3. Оператор присваивания =====
        System.out.println("Задание 3:");
        int number = 10;
        System.out.println("Начальное значение: " + number);

        number = number + 5;
        System.out.println("После присваивания: " + number);
        System.out.println();

        // ===== Задание 4. Ввод и вывод данных =====
        System.out.println("Задание 4:");
        System.out.print("Введите целое число: ");
        int n = scanner.nextInt();

        int square = n * n;
        System.out.println("Квадрат числа: " + square);
        System.out.println();

        // ===== Задание 5. Линейный алгоритм (площадь прямоугольника) =====
        System.out.println("Задание 5:");
        System.out.print("Введите длину прямоугольника: ");
        double length = scanner.nextDouble();

        System.out.print("Введите ширину прямоугольника: ");
        double width = scanner.nextDouble();

        double area = length * width;
        System.out.println("Площадь прямоугольника: " + area);
        System.out.println();

        // ===== Дополнительные задания =====

        // 1. Сумма и среднее арифметическое
        System.out.println("Доп. задание 1:");
        double avg = (a + b) / 2;
        System.out.println("Сумма: " + (a + b));
        System.out.println("Среднее арифметическое: " + avg);
        System.out.println();

        // 2. Площадь и периметр прямоугольника
        System.out.println("Доп. задание 2:");
        double perimeter = 2 * (length + width);
        System.out.println("Площадь: " + area);
        System.out.println("Периметр: " + perimeter);
        System.out.println();

        // 3. Площадь круга
        System.out.println("Доп. задание 3:");
        final double PI = 3.14;
        System.out.print("Введите радиус круга: ");
        double r = scanner.nextDouble();

        double circleArea = PI * r * r;
        System.out.println("Площадь круга: " + circleArea);
        System.out.println();

        // 4. Перевод температуры
        System.out.println("Доп. задание 4:");
        System.out.print("Введите температуру в Цельсиях: ");
        double celsius = scanner.nextDouble();

        double fahrenheit = celsius * 9 / 5 + 32;
        System.out.println("Температура в Фаренгейтах: " + fahrenheit);
        System.out.println();

        // 5. Расстояние при равномерном движении
        System.out.println("Доп. задание 5:");
        System.out.print("Введите скорость (v): ");
        double v = scanner.nextDouble();

        System.out.print("Введите время (t): ");
        double t = scanner.nextDouble();

        double distance = v * t;
        System.out.println("Расстояние: " + distance);
        System.out.println();

        // 6. Квадрат и куб числа
        System.out.println("Доп. задание 6:");
        System.out.print("Введите число: ");
        int k = scanner.nextInt();

        int squareK = k * k;
        int cubeK = k * k * k;

        System.out.println("Квадрат: " + squareK);
        System.out.println("Куб: " + cubeK);

        scanner.close();
    }
}
