import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class StreamLabApp {

    // Модель данных для работы с объектами
    static class Student {
        String name;
        int age;
        double grade;

        Student(String name, int age, double grade) {
            this.name = name;
            this.age = age;
            this.grade = grade;
        }

        @Override
        public String toString() {
            return String.format("║ %-10s | Возраст: %-2d | Балл: %-5.1f ║", name, age, grade);
        }
    }

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMainMenu();
            String choice = sc.nextLine();
            if (choice.equals("0")) break;

            processTask(choice);

            System.out.println("\n[Нажмите Enter, чтобы вернуться в меню]");
            sc.nextLine();
        }
        System.out.println("Программа завершена. Хорошего дня!");
    }

    private static void showMainMenu() {
        System.out.println("\n╔══════════════════════════════════════════════════════╗");
        System.out.println("║       LAB #13: LAMBDA & STREAM API TERMINAL          ║");
        System.out.println("╠══════════════════════════════════════════════════════╣");
        System.out.println("║ 1. Сложение (Lambda)     11. Consumer (Печать)       ║");
        System.out.println("║ 2. UpperCase (Function)  12. Supplier (Random)       ║");
        System.out.println("║ 3. Filter (Нечетные)     13. Сортировка (Age)        ║");
        System.out.println("║ 4. Map (Квадраты)        14. Фильтр (Grade > 80)     ║");
        System.out.println("║ 5. Max (Comparator)      15. Цепочка методов         ║");
        System.out.println("║ 6. Сортировка (Length)   16. Группировка (Age)       ║");
        System.out.println("║ 7. Capitalize            17. Агрегация (Reduce)      ║");
        System.out.println("║ 8. Filter (> 5 chars)    18. Distinct & Limit        ║");
        System.out.println("║ 9. Method Reference      19. FlatMap (Lists)         ║");
        System.out.println("║ 10. Optional (Min)       20. Real Case (Orders)      ║");
        System.out.println("╠══════════════════════════════════════════════════════╣");
        System.out.println("║ 0. ВЫХОД                                             ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");
        System.out.print("Введите номер задания: ");
    }

    private static void processTask(String task) {
        System.out.println("--- Результат задания №" + task + " ---");
        try {
            switch (task) {
                case "1" -> {
                    BinaryOperator<Integer> sum = (a, b) -> a + b;
                    System.out.println("10 + 25 = " + sum.apply(10, 25));
                }
                case "2" -> {
                    Function<String, String> up = String::toUpperCase;
                    System.out.println("'java' -> " + up.apply("java"));
                }
                case "3" -> {
                    List<Integer> n = Arrays.asList(1, 2, 3, 4, 5);
                    System.out.println("Нечетные: " + n.stream().filter(x -> x % 2 != 0).collect(Collectors.toList()));
                }
                case "4" -> {
                    Arrays.asList(1, 2, 3).stream().map(x -> x * x).forEach(res -> System.out.print(res + " "));
                    System.out.println();
                }
                case "5" -> {
                    int max = Arrays.asList(10, 50, 20).stream().max(Integer::compare).get();
                    System.out.println("Max из (10, 50, 20): " + max);
                }
                case "6" -> {
                    List<String> list = Arrays.asList("Java", "PHP", "Python");
                    list.sort(Comparator.comparingInt(String::length));
                    System.out.println("Отсортировано: " + list);
                }
                case "7" -> {
                    UnaryOperator<String> cap = s -> s.substring(0, 1).toUpperCase() + s.substring(1);
                    System.out.println("'apple' -> " + cap.apply("apple"));
                }
                case "8" -> {
                    List<String> s = Arrays.asList("Stream", "API", "Developer");
                    s.stream().filter(x -> x.length() > 5).forEach(System.out::println);
                }
                case "9" -> {
                    Arrays.asList("Method", "Reference").forEach(System.out::println);
                }
                case "10" -> {
                    Optional<Integer> empty = Optional.empty();
                    System.out.println("Значение: " + empty.orElse(0));
                }
                case "11" -> {
                    Consumer<String> cons = val -> System.out.println("Получено: " + val);
                    cons.accept("Работает");
                }
                case "12" -> {
                    Supplier<Double> rand = Math::random;
                    System.out.println("Random: " + rand.get());
                }
                case "13" -> {
                    List<Student> st = getStudents();
                    st.sort(Comparator.comparingInt(s -> s.age));
                    st.forEach(System.out::println);
                }
                case "14" -> {
                    getStudents().stream().filter(s -> s.grade > 80).forEach(System.out::println);
                }
                case "15" -> {
                    getStudents().stream()
                            .filter(s -> s.age > 19)
                            .map(s -> s.name.toUpperCase())
                            .sorted()
                            .forEach(System.out::println);
                }
                case "16" -> {
                    Map<Integer, List<Student>> map = getStudents().stream().collect(Collectors.groupingBy(s -> s.age));
                    map.forEach((age, list) -> System.out.println(age + " лет: " + list.size() + " чел."));
                }
                case "17" -> {
                    int sum = Arrays.asList(1, 2, 3).stream().reduce(0, Integer::sum);
                    System.out.println("Сумма 1+2+3 = " + sum);
                }
                case "18" -> {
                    Arrays.asList(1, 1, 2, 2, 3, 3).stream().distinct().limit(2).forEach(System.out::println);
                }
                case "19" -> {
                    List<List<Integer>> nested = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4));
                    System.out.println("Flat: " + nested.stream().flatMap(Collection::stream).collect(Collectors.toList()));
                }
                case "20" -> {
                    List<Double> orders = Arrays.asList(1500.0, 500.0, 2500.0);
                    orders.stream().filter(p -> p > 1000).sorted().forEach(p -> System.out.println("Заказ: " + p));
                }
                default -> System.out.println("Ошибка: Задание не найдено.");
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка при выполнении задания.");
        }
    }

    private static List<Student> getStudents() {
        return Arrays.asList(
                new Student("Алиса", 20, 95.0),
                new Student("Борис", 19, 75.0),
                new Student("Вера", 20, 88.0),
                new Student("Глеб", 21, 91.0)
        );
    }
}
