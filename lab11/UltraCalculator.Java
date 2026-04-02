import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UltraCalculator extends JFrame {

    // Поле для вывода и список истории (Задание 10)
    private JTextField display;
    private ArrayList<String> history = new ArrayList<>();

    public UltraCalculator() {
        // --- ЗАДАНИЕ 4: ГРАФИЧЕСКИЙ ИНТЕРФЕЙС ---
        setTitle("Инженерный калькулятор (14 заданий)");
        setSize(450, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Дисплей (Задание 1, 8)
        display = new JTextField();
        display.setFont(new Font("Monospaced", Font.BOLD, 28));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        // Панель кнопок (Задание 9)
        JPanel panel = new JPanel(new GridLayout(7, 4, 3, 3));

        // Список всех необходимых кнопок
        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "sin", "cos", "tan", "cot",
                "sqrt", "^", "%", "(",
                ")", "Hist", "C", "Del"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 16));
            btn.addActionListener(e -> handlePress(e.getActionCommand()));
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    // Обработка нажатий (Задание 3 - разделение логики)
    private void handlePress(String cmd) {
        if (cmd.equals("=")) {
            try {
                String exp = display.getText();
                double res = evaluate(exp); // Задание 14: Парсинг выражения
                history.add(exp + " = " + res); // Задание 10: История
                display.setText(String.valueOf(res));
            } catch (Exception ex) {
                display.setText("Error"); // Задание 8: Ошибки
            }
        } else if (cmd.equals("C")) {
            display.setText(""); // Задание 11: Очистка
        } else if (cmd.equals("Del")) {
            String s = display.getText();
            if (s.length() > 0) display.setText(s.substring(0, s.length() - 1));
        } else if (cmd.equals("Hist")) {
            // Окно истории
            JOptionPane.showMessageDialog(this, String.join("\n", history), "История", 1);
        }
        // ЗАДАНИЕ 12: Нахождение процента (мгновенное вычисление доли)
        else if (cmd.equals("%")) {
            try {
                double val = evaluate(display.getText());
                display.setText(String.valueOf(val / 100.0));
            } catch (Exception ex) {
                display.setText("Error");
            }
        }
        // ЗАДАНИЕ 13: Инженерные функции (sin, cos, tan, cot)
        else if (cmd.matches("sin|cos|tan|cot|sqrt")) {
            display.setText(display.getText() + cmd + "(");
        } else {
            // ЗАДАНИЕ 7: Поддержка чисел и знаков (в т.ч. отрицательных)
            display.setText(display.getText() + cmd);
        }
    }

    // --- ЗАДАНИЕ 14: ПАРСЕР ВЫРАЖЕНИЙ (Рекурсивный спуск) ---
    public double evaluate(final String str) {
        return new Object() {
            int pos = -1, ch;
            void nextChar() { ch = (++pos < str.length()) ? str.charAt(pos) : -1; }
            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) { nextChar(); return true; }
                return false;
            }
            double parse() { nextChar(); return parseExpression(); }

            // Сложение и вычитание (Задание 1)
            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if (eat('+')) x += parseTerm();
                    else if (eat('-')) x -= parseTerm();
                    else return x;
                }
            }
            // Умножение и деление (Задание 1, 5 - проверка на ноль)
            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if (eat('*')) x *= parseFactor();
                    else if (eat('/')) {
                        double divisor = parseFactor();
                        if (divisor == 0) throw new ArithmeticException();
                        x /= divisor;
                    } else return x;
                }
            }
            // Числа, скобки и функции (Задание 5, 6, 13)
            double parseFactor() {
                if (eat('+')) return parseFactor();
                if (eat('-')) return -parseFactor(); // Задание 7
                double x;
                int startPos = this.pos;
                if (eat('(')) { x = parseExpression(); eat(')'); }
                else if ((ch >= '0' && ch <= '9') || ch == '.') {
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') {
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else if (func.equals("cot")) x = 1.0 / Math.tan(Math.toRadians(x));
                    else throw new RuntimeException();
                } else throw new RuntimeException();

                // Задание 5: Степень
                if (eat('^')) x = Math.pow(x, parseFactor());
                return x;
            }
        }.parse();
    }

    // Точка входа в программу
    public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> new UltraCalculator());
    }
}
