import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class StringLab12GUI {

    public static void main(String[] args) {
        JFrame frame = new JFrame("String Lab 12");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Поле ввода
        JTextField inputField = new JTextField();
        frame.add(inputField, BorderLayout.NORTH);

        // Область вывода
        JTextArea outputArea = new JTextArea();
        frame.add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Панель кнопок
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4)); // 20 кнопок

        // КНОПКИ

        // 1. Длина
        JButton btn1 = new JButton("1 Длина");
        btn1.addActionListener(e -> {
            String input = inputField.getText();
            outputArea.setText("Длина: " + input.length());
        });
        panel.add(btn1);

        // 2. Регистр
        JButton btn2 = new JButton("2 Регистр");
        btn2.addActionListener(e -> {
            String input = inputField.getText();
            outputArea.setText(
                    "UPPER: " + input.toUpperCase() +
                    "\nLOWER: " + input.toLowerCase()
            );
        });
        panel.add(btn2);

        // 3. Кол-во слов
        JButton btn3 = new JButton("3 Слова");
        btn3.addActionListener(e -> {
            String input = inputField.getText();
            String[] words = input.trim().split("\\s+");
            outputArea.setText("Слов: " + words.length);
        });
        panel.add(btn3);

        // 4. Разворот слов
        JButton btn4 = new JButton("4 Reverse words");
        btn4.addActionListener(e -> {
            String input = inputField.getText();
            StringBuilder result = new StringBuilder();
            for (String w : input.split("\\s+")) {
                result.append(new StringBuilder(w).reverse()).append(" ");
            }
            outputArea.setText(result.toString());
        });
        panel.add(btn4);

        // 5. Поиск
        JButton btn5 = new JButton("5 Поиск");
        btn5.addActionListener(e -> {
            String input = inputField.getText();
            String word = JOptionPane.showInputDialog("Введите слово:");
            outputArea.setText("Найдено? " + input.contains(word));
        });
        panel.add(btn5);

        // 6. Замена
        JButton btn6 = new JButton("6 Замена");
        btn6.addActionListener(e -> {
            String input = inputField.getText();
            String oldW = JOptionPane.showInputDialog("Что заменить:");
            String newW = JOptionPane.showInputDialog("На что:");
            outputArea.setText(input.replace(oldW, newW));
        });
        panel.add(btn6);

        // 7. Палиндром
        JButton btn7 = new JButton("7 Палиндром");
        btn7.addActionListener(e -> {
            String input = inputField.getText()
                    .replaceAll("\\s+", "")
                    .toLowerCase();
            String rev = new StringBuilder(input).reverse().toString();
            outputArea.setText("Палиндром? " + input.equals(rev));
        });
        panel.add(btn7);

        // 8. Сравнение
        JButton btn8 = new JButton("8 Сравнение");
        btn8.addActionListener(e -> {
            String input = inputField.getText();
            String second = JOptionPane.showInputDialog("Вторая строка:");
            outputArea.setText("Равны? " + input.equals(second));
        });
        panel.add(btn8);

        // 9. Split
        JButton btn9 = new JButton("9 Split");
        btn9.addActionListener(e -> {
            String input = inputField.getText();
            String[] words = input.split("\\s+");
            outputArea.setText(String.join("\n", words));
        });
        panel.add(btn9);

        // 10. Гласные/согласные
        JButton btn10 = new JButton("10 Буквы");
        btn10.addActionListener(e -> {
            String input = inputField.getText().toLowerCase();
            int v = 0, c = 0;
            String vowels = "aeiouаеёиоуыэюя";
            for (char ch : input.toCharArray()) {
                if (Character.isLetter(ch)) {
                    if (vowels.indexOf(ch) != -1) v++;
                    else c++;
                }
            }
            outputArea.setText("Гласные: " + v + ", согласные: " + c);
        });
        panel.add(btn10);

        // 11. Без пробелов
        JButton btn11 = new JButton("11 Без пробелов");
        btn11.addActionListener(e -> {
            outputArea.setText(inputField.getText().replace(" ", ""));
        });
        panel.add(btn11);

        // 12. Длинное слово
        JButton btn12 = new JButton("12 Длинное слово");
        btn12.addActionListener(e -> {
            String longest = "";
            for (String w : inputField.getText().split("\\s+")) {
                if (w.length() > longest.length()) longest = w;
            }
            outputArea.setText(longest);
        });
        panel.add(btn12);

        // 13. Без пробелов длина
        JButton btn13 = new JButton("13 Длина без пробелов");
        btn13.addActionListener(e -> {
            String s = inputField.getText().replace(" ", "");
            outputArea.setText(String.valueOf(s.length()));
        });
        panel.add(btn13);

        // 14. startsWith
        JButton btn14 = new JButton("14 startsWith");
        btn14.addActionListener(e -> {
            String start = JOptionPane.showInputDialog("Начало:");
            outputArea.setText(
                    String.valueOf(inputField.getText().startsWith(start))
            );
        });
        panel.add(btn14);

        // 15. endsWith
        JButton btn15 = new JButton("15 endsWith");
        btn15.addActionListener(e -> {
            String end = JOptionPane.showInputDialog("Конец:");
            outputArea.setText(
                    String.valueOf(inputField.getText().endsWith(end))
            );
        });
        panel.add(btn15);

        // 16. Полный разворот
        JButton btn16 = new JButton("16 Reverse");
        btn16.addActionListener(e -> {
            outputArea.setText(
                    new StringBuilder(inputField.getText()).reverse().toString()
            );
        });
        panel.add(btn16);

        // 17. Удалить цифры
        JButton btn17 = new JButton("17 Без цифр");
        btn17.addActionListener(e -> {
            outputArea.setText(
                    inputField.getText().replaceAll("\\d", "")
            );
        });
        panel.add(btn17);

        // 18. Гласные *
        JButton btn18 = new JButton("18 * гласные");
        btn18.addActionListener(e -> {
            outputArea.setText(
                    inputField.getText().replaceAll("(?i)[aeiouаеёиоуыэюя]", "*")
            );
        });
        panel.add(btn18);

        // 19. Частота
        JButton btn19 = new JButton("19 Частота");
        btn19.addActionListener(e -> {
            Map<Character, Integer> map = new HashMap<>();
            for (char ch : inputField.getText().toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            outputArea.setText(map.toString());
        });
        panel.add(btn19);

        // 20. Только цифры
        JButton btn20 = new JButton("20 Только цифры");
        btn20.addActionListener(e -> {
            outputArea.setText(
                    String.valueOf(inputField.getText().matches("\\d+"))
            );
        });
        panel.add(btn20);

        frame.add(panel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
