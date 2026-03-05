import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n================ МЕНЮ ЗАДАНИЙ ================");
            System.out.println("1.  Сумма отрицательных элементов A[20]");
            System.out.println("2.  Сумма положительных элементов B[15]");
            System.out.println("3.  Произведение отрицательных A[12] (дробные)");
            System.out.println("4.  Произведение положительных C[25]");
            System.out.println("5.  Среднее арифметическое D[17]");
            System.out.println("6.  Матрица A[10x10]: Суммы отр. по строкам -> B[10]");
            System.out.println("7.  Матрица B[5x5]: Суммы полож. по строкам -> A[5]");
            System.out.println("8.  Матрица A[12x6]: Произведение отр. по столбцам");
            System.out.println("9.  Матрица C[5x5]: Произведение полож. на диагонали");
            System.out.println("10. Матрица D[7x7]: Среднее на главной диагонали");
            System.out.println("11. Массив A[25]: Поменять местами Max и Min");
            System.out.println("12. Массив B[25]: Сортировка по возрастанию");
            System.out.println("13. Массив C[20]: Найти среднее значение");
            System.out.println("14. Массив D[30]: Сумма чётных и нечётных");
            System.out.println("15. Вывод таблицы 3x5 (числа < 10)");
            System.out.println("16. Поиск максимального элемента (метод maxX)");
            System.out.println("17. Сравнение строк (s4 == s5)");
            System.out.println("0.  ВЫХОД");
            System.out.println("==============================================");
            System.out.print("Выберите номер задания: ");

            int choice = in.nextInt();

            switch (choice) {
                case 0: exit = true; break;
                case 1: task1(in); break;
                case 2: task2(in); break;
                case 3: task3(in); break;
                case 4: task4(in); break;
                case 5: task5(in); break;
                case 6: task6(in); break;
                case 7: task7(in); break;
                case 8: task8(in); break;
                case 9: task9(in); break;
                case 10: task10(in); break;
                case 11: task11(in); break;
                case 12: task12(in); break;
                case 13: task13(in); break;
                case 14: task14(in); break;
                case 15: task15(in); break;
                case 16: task16(in); break;
                case 17: task17(in); break;
                default: System.out.println("Ошибка: задания с таким номером нет.");
            }
        }
        System.out.println("Программа завершена.");
        in.close();
    }

    // --- РЕАЛИЗАЦИЯ ВСЕХ ЗАДАНИЙ ---

    public static void task1(Scanner in) {
        System.out.print("Введите размер (n=20 по заданию): ");
        int n = in.nextInt();
        int[] a = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("A[" + i + "]: ");
            a[i] = in.nextInt();
            if (a[i] < 0) sum += a[i];
        }
        System.out.println("Результат: Сумма отрицательных = " + sum);
    }

    public static void task2(Scanner in) {
        System.out.print("Введите размер (n=15): ");
        int n = in.nextInt();
        int[] b = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("B[" + i + "]: ");
            b[i] = in.nextInt();
            if (b[i] > 0) sum += b[i];
        }
        System.out.println("Результат: Сумма положительных = " + sum);
    }

    public static void task3(Scanner in) {
        System.out.print("Введите размер (n=12): ");
        int n = in.nextInt();
        double[] a = new double[n];
        double prod = 1.0;
        boolean found = false;
        for (int i = 0; i < n; i++) {
            System.out.print("A[" + i + "] (double): ");
            a[i] = in.nextDouble();
            if (a[i] < 0) {
                prod *= a[i];
                found = true;
            }
        }
        System.out.println("Результат: Произведение отрицательных = " + (found ? prod : 0));
    }

    public static void task4(Scanner in) {
        System.out.print("Введите размер (n=25): ");
        int n = in.nextInt();
        int[] c = new int[n];
        long prod = 1;
        for (int i = 0; i < n; i++) {
            System.out.print("C[" + i + "]: ");
            c[i] = in.nextInt();
            if (c[i] > 0) prod *= c[i];
        }
        System.out.println("Результат: Произведение положительных = " + prod);
    }

    public static void task5(Scanner in) {
        System.out.print("Введите размер (n=17): ");
        int n = in.nextInt();
        double sum = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("Число " + i + ": ");
            sum += in.nextDouble();
        }
        System.out.println("Результат: Среднее арифметическое = " + (sum / n));
    }

    public static void task6(Scanner in) {
        System.out.print("Введите размер матрицы (строки/столбцы): ");
        int n = in.nextInt();
        int[][] a = new int[n][n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            for (int j = 0; j < n; j++) {
                System.out.print("A["+i+"]["+j+"]: ");
                a[i][j] = in.nextInt();
                if (a[i][j] < 0) rowSum += a[i][j];
            }
            b[i] = rowSum;
        }
        System.out.println("Результат: Массив B (суммы отрицательных): " + Arrays.toString(b));
    }

    public static void task7(Scanner in) {
        System.out.print("Введите размер матрицы: ");
        int n = in.nextInt();
        int[][] b = new int[n][n];
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            for (int j = 0; j < n; j++) {
                System.out.print("B["+i+"]["+j+"]: ");
                b[i][j] = in.nextInt();
                if (b[i][j] > 0) rowSum += b[i][j];
            }
            a[i] = rowSum;
        }
        System.out.println("Результат: Массив A (суммы положительных): " + Arrays.toString(a));
    }

    public static void task8(Scanner in) {
        System.out.print("Строк: "); int r = in.nextInt();
        System.out.print("Столбцов: "); int c = in.nextInt();
        int[][] matrix = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print("["+i+"]["+j+"]: ");
                matrix[i][j] = in.nextInt();
            }
        }
        System.out.print("Произведения отр. по столбцам: ");
        for (int j = 0; j < c; j++) {
            long p = 1;
            for (int i = 0; i < r; i++) {
                if (matrix[i][j] < 0) p *= matrix[i][j];
            }
            System.out.print(p + " ");
        }
        System.out.println();
    }

    public static void task9(Scanner in) {
        System.out.print("Размер квадратной матрицы: ");
        int n = in.nextInt();
        int[][] mat = new int[n][n];
        long p = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("["+i+"]["+j+"]: ");
                mat[i][j] = in.nextInt();
            }
            if (mat[i][i] > 0) p *= mat[i][i];
        }
        System.out.println("Произведение положительных на диагонали: " + p);
    }

    public static void task10(Scanner in) {
        System.out.print("Размер квадратной матрицы: ");
        int n = in.nextInt();
        double sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("["+i+"]["+j+"]: ");
                int val = in.nextInt();
                if (i == j) sum += val;
            }
        }
        System.out.println("Среднее на главной диагонали: " + (sum / n));
    }

    public static void task11(Scanner in) {
        System.out.print("Размер массива: ");
        int n = in.nextInt();
        int[] a = new int[n];
        int minI = 0, maxI = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("A["+i+"]: ");
            a[i] = in.nextInt();
            if (a[i] < a[minI]) minI = i;
            if (a[i] > a[maxI]) maxI = i;
        }
        int temp = a[minI];
        a[minI] = a[maxI];
        a[maxI] = temp;
        System.out.println("Обмен завершен: " + Arrays.toString(a));
    }

    public static void task12(Scanner in) {
        System.out.print("Размер: ");
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Элемент " + i + ": ");
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        System.out.println("Результат: " + Arrays.toString(arr));
    }

    public static void task13(Scanner in) {
        task5(in); // Логика идентична
    }

    public static void task14(Scanner in) {
        System.out.print("Размер: ");
        int n = in.nextInt();
        int even = 0, odd = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("Число: ");
            int v = in.nextInt();
            if (v % 2 == 0) even += v; else odd += v;
        }
        System.out.println("Сумма четных: " + even + ", нечетных: " + odd);
    }

    public static void task15(Scanner in) {
        System.out.println("Таблица 3x5 (случайные числа < 10):");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print((int)(Math.random() * 10) + "\t");
            }
            System.out.println();
        }
    }

    public static void task16(Scanner in) {
        System.out.print("Введите сколько чисел проверить: ");
        int n = in.nextInt();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            System.out.print("Число " + i + ": ");
            int v = in.nextInt();
            if (v > max) max = v;
        }
        System.out.println("Максимальный элемент: " + max);
    }

    public static void task17(Scanner in) {
        in.nextLine();
        System.out.print("S1: "); String s1 = in.nextLine();
        System.out.print("S2: "); String s2 = in.nextLine();
        System.out.print("S3: "); String s3 = in.nextLine();
        System.out.print("S4: "); String s4 = in.nextLine();
        System.out.print("S5: "); String s5 = in.nextLine();
        if (s4.equals(s5)) System.out.println("S4==S5! Итог: " + s1 + s2);
        else System.out.println("S4!=S5! Итог: " + s1 + s3);
    }
}
