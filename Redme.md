# JAvavavavava
<img width="1393" height="991" alt="Screenshot 2026-01-22 143530" src="https://github.com/user-attachments/assets/b49d8eac-c4d4-4cfe-90df-cafac163856d" />


Краткий отчёт по программе «Студенты»

Цель работы:
Изучить основы объектно-ориентированного программирования на языке Java, научиться создавать классы, объекты и работать с ними в среде IntelliJ IDEA.

Описание программы:
В ходе работы была разработана программа на языке Java, состоящая из двух классов: Main и Student.
Класс Student предназначен для хранения информации о студенте (имя, возраст, направление обучения, курс).
Класс Main содержит метод main, в котором создаются объекты класса Student и выводится информация о них на экран.

Используемые технологии:

Язык программирования: Java

Среда разработки: IntelliJ IDEA

Основные концепции: классы, объекты, конструкторы, методы, инкапсуляция

Результат работы:
Программа корректно компилируется и запускается, выводя информацию о студентах в консоль. Были устранены ошибки, связанные с именами файлов и настройкой JDK.

Вывод:
В результате выполнения работы были освоены базовые принципы объектно-ориентированного программирования на языке Java и получены практические навыки работы в среде IntelliJ IDEA.


Main java
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Сколько студентов ввести? ");
        int count = scanner.nextInt();
        scanner.nextLine(); // очистка буфера

        for (int i = 0; i < count; i++) {
            System.out.println("\nСтудент " + (i + 1));

            System.out.print("Имя: ");
            String name = scanner.nextLine();

            System.out.print("Возраст: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Направление: ");
            String direction = scanner.nextLine();

            System.out.print("Курс: ");
            int course = scanner.nextInt();
            scanner.nextLine();

            students.add(new Student(name, age, direction, course));
        }

        System.out.println("\n=== Список студентов ===");
        for (Student s : students) {
            s.showInfo();
        }
    }
}

student
public class Student {

    private String name;
    private int age;
    private String direction;
    private int course;

    public Student(String name, int age, String direction, int course) {
        this.name = name;
        this.age = age;
        this.direction = direction;
        this.course = course;
    }

    public void showInfo() {
        System.out.println("Имя: " + name);
        System.out.println("Возраст: " + age);
        System.out.println("Направление: " + direction);
        System.out.println("Курс: " + course);
        System.out.println("------------------------");
    }
}
