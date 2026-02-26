import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // ===== Задание 1 =====
        System.out.println("Задание 1. Последовательность выполнения команд");
        int x = 5;
        int y = 10;
        int z = 15;

        int sumXYZ = x + y + z;

        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("z = " + z);
        System.out.println("Сумма = " + sumXYZ);
        System.out.println();

        // ===== Задание 2 =====
        System.out.println("Задание 2. Арифметические операции");
        System.out.print("Введите первое число: ");
        double num1 = scanner.nextDouble();

        System.out.print("Введите второе число: ");
        double num2 = scanner.nextDouble();

        System.out.println("Сложение: " + (num1 + num2));
        System.out.println("Умножение: " + (num1 * num2));

        if (num2 != 0) {
            System.out.println("Деление: " + (num1 / num2));
        } else {
            System.out.println("Ошибка: деление на ноль невозможно.");
        }
        System.out.println();

        // ===== Задание 3 =====
        System.out.println("Задание 3. Оператор присваивания");
        int number = 10;
        System.out.println("Начальное значение: " + number);

        number += 5;
        System.out.println("После увеличения на 5: " + number);
        System.out.println();

        // ===== Задание 4 =====
        System.out.println("Задание 4. Ввод и вывод данных");
        System.out.print("Введите целое число: ");
        int n = scanner.nextInt();

        int square = n * n;
        System.out.println("Квадрат числа: " + square);
        System.out.println();

        // ===== Задание 5 =====
        System.out.println("Задание 5. Линейный алгоритм (площадь прямоугольника)");
        System.out.print("Введите длину: ");
        double length = scanner.nextDouble();

        System.out.print("Введите ширину: ");
        double width = scanner.nextDouble();

        double rectangleArea = length * width;
        System.out.println("Площадь прямоугольника: " + rectangleArea);
        System.out.println();

        // ===== Дополнительное 1 =====
        System.out.println("Доп. задание 1. Сумма и среднее");
        double sum = num1 + num2;
        double average = sum / 2;
        System.out.println("Сумма: " + sum);
        System.out.println("Среднее арифметическое: " + average);
        System.out.println();

        // ===== Дополнительное 2 =====
        System.out.println("Доп. задание 2. Площадь и периметр прямоугольника");
        double perimeter = 2 * (length + width);
        System.out.println("Площадь: " + rectangleArea);
        System.out.println("Периметр: " + perimeter);
        System.out.println();

        // ===== Дополнительное 3 =====
        System.out.println("Доп. задание 3. Площадь круга");
        System.out.print("Введите радиус: ");
        double radius = scanner.nextDouble();

        double circleArea = Math.PI * radius * radius;
        System.out.println("Площадь круга: " + circleArea);
        System.out.println();

        // ===== Дополнительное 4 =====
        System.out.println("Доп. задание 4. Перевод температуры");
        System.out.print("Введите температуру в Цельсиях: ");
        double celsius = scanner.nextDouble();

        double fahrenheit = celsius * 9 / 5 + 32;
        System.out.println("Температура в Фаренгейтах: " + fahrenheit);
        System.out.println();

        // ===== Дополнительное 5 =====
        System.out.println("Доп. задание 5. Расстояние");
        System.out.print("Введите скорость: ");
        double speed = scanner.nextDouble();

        System.out.print("Введите время: ");
        double time = scanner.nextDouble();

        double distance = speed * time;
        System.out.println("Расстояние: " + distance);
        System.out.println();

        // ===== Дополнительное 6 =====
        System.out.println("Доп. задание 6. Квадрат и куб числа");
        System.out.print("Введите число: ");
        int k = scanner.nextInt();

        int squareK = k * k;
        int cubeK = k * k * k;

        System.out.println("Квадрат: " + squareK);
        System.out.println("Куб: " + cubeK);

        scanner.close();
    }
}
