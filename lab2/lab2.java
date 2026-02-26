public class Main {

    public static void main(String[] args) {

        // ===== Задача 1 =====
        System.out.println("=== Задача 1. Переменные и константы ===");
        int count = 10;
        double price = 99.99;
        boolean isAvailable = true;
        final double PI = 3.14159;

        System.out.println("Количество: " + count);
        System.out.println("Цена: " + price);
        System.out.println("Доступно: " + isAvailable);
        System.out.println("Константа PI: " + PI);


        // ===== Задача 2 =====
        System.out.println("\n=== Задача 2. Примитивные и ссылочные типы ===");
        int number = 25;
        String text = "Привет";

        System.out.println("Значение int: " + number);
        System.out.println("Значение String: " + text);


        // ===== Задача 3 =====
        System.out.println("\n=== Задача 3. Область видимости переменных ===");
        ScopeExample scopeExample = new ScopeExample();
        scopeExample.showValues();


        // ===== Задача 4 =====
        System.out.println("\n=== Задача 4. Наследование ===");
        Student student = new Student();
        student.name = "Иван";
        student.age = 20;
        student.group = "ИС-2204";

        student.displayInfo();


        // ===== Задача 5 =====
        System.out.println("\n=== Задача 5. Полиморфизм ===");

        Person person = new Student();
        person.name = "Алексей";
        person.age = 22;

        // Нужно приведение типа, чтобы задать group
        if (person instanceof Student) {
            ((Student) person).group = "ИС-2205";
        }

        person.displayInfo();
    }
}


// ===== Родительский класс =====
class Person {

    String name;
    int age;

    void displayInfo() {
        System.out.println("Имя: " + name);
        System.out.println("Возраст: " + age);
    }
}


// ===== Класс для области видимости =====
class ScopeExample {

    int classField = 100; // поле класса

    void showValues() {
        int localVariable = 50; // локальная переменная

        System.out.println("Поле класса: " + classField);
        System.out.println("Локальная переменная: " + localVariable);
    }
}


// ===== Дочерний класс =====
class Student extends Person {

    String group;

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Группа: " + group);
    }
}
