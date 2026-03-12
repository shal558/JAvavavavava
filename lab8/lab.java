package lab8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Основной класс приложения.
 * Запускает меню выбора графиков.
 */
public class Main extends JFrame {

    public Main(String title) {
        super(title);
        setSize(300, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Окно по центру экрана
        setLayout(new GridLayout(9, 1, 5, 5)); // Сетка для кнопок

        // Массив названий функций для кнопок (Задания 1-7 + пример 8)
        String[] labels = {
                "1. y = kx (k=0.5)",
                "2. y = 3x²",
                "3. y = -x² + x³",
                "4. y = x³ + x² + x",
                "5. y = x⁵",
                "6. y = sin(x)",
                "7. y = cos(x-1) + x",
                "8. y = 1/x (Рациональная)"
        };

        // Создание кнопок в цикле
        for (int i = 0; i < labels.length; i++) {
            final int taskNum = i + 1;
            JButton btn = new JButton(labels[i]);
            btn.addActionListener(e -> new PlotterWindow(labels[taskNum-1], taskNum));
            add(btn);
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        // Запуск GUI в специальном потоке рассылки событий
        SwingUtilities.invokeLater(() -> new Main("Лабораторная №8"));
    }
}

/**
 * Класс окна для отрисовки графиков.
 */
class PlotterWindow extends JFrame {
    private final int taskType;

    public PlotterWindow(String title, int taskType) {
        super(title);
        this.taskType = taskType;
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        // Очистка и подготовка холста
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();
        int centerX = w / 2;
        int centerY = h / 2;
        double scale = 30.0; // Масштаб: 30 пикселей = 1 единица

        // 1. Рисуем сетку (светло-серая)
        g2.setColor(new Color(220, 220, 220));
        for (int i = 0; i <= w; i += 30) g2.drawLine(i, 0, i, h);
        for (int i = 0; i <= h; i += 30) g2.drawLine(0, i, w, i);

        // 2. Рисуем оси (черные)
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(2));
        g2.drawLine(0, centerY, w, centerY); // X
        g2.drawLine(centerX, 0, centerX, h); // Y

        // 3. Рисуем график (синий)
        g2.setColor(Color.BLUE);
        g2.setStroke(new BasicStroke(1.5f));

        for (int px = -centerX; px < centerX; px++) {
            double x1 = px / scale;
            double x2 = (px + 1) / scale;

            Double y1 = calculate(x1);
            Double y2 = calculate(x2);

            // Проверка на разрывы (для рациональных функций типа 1/x)
            if (y1 != null && y2 != null && Math.abs(y1 - y2) < 50) {
                int sy1 = centerY - (int) (y1 * scale);
                int sy2 = centerY - (int) (y2 * scale);

                // Рисуем, если точки в пределах окна
                if (Math.abs(sy1) < 2000 && Math.abs(sy2) < 2000) {
                    g2.drawLine(centerX + px, sy1, centerX + px + 1, sy2);
                }
            }
        }
    }

    /**
     * Метод вычисления значения функции в зависимости от номера задания
     */
    private Double calculate(double x) {
        try {
            switch (taskType) {
                case 1: return 0.5 * x;                    // y = kx
                case 2: return 3 * Math.pow(x, 2);         // y = 3x^2
                case 3: return -Math.pow(x, 2) + Math.pow(x, 3);
                case 4: return Math.pow(x, 3) + Math.pow(x, 2) + x;
                case 5: return Math.pow(x, 5);
                case 6: return Math.sin(x);
                case 7: return Math.cos(x - 1) + x;
                case 8: // Пример рациональной функции
                    if (Math.abs(x) < 0.01) return null;   // Область определения (x != 0)
                    return 1.0 / x;
                default: return 0.0;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
