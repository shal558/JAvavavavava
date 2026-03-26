import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AllInOneSwing extends JFrame
        implements ActionListener, MouseListener, KeyListener, ItemListener {

    String msg = "";
    JTextField tf1, tf2, tfName, xField, yField;
    int result = 0;
    int x = 50, y = 50;
    int mouseX, mouseY;
    char ch;
    Color color = Color.RED;

    JButton btnHello, btnCalc, btnName, btnDraw;
    JCheckBox red, green, blue;

    int animX = 0;

    DrawPanel panel;

    public AllInOneSwing() {
        setTitle("All In One Swing App");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        btnHello = new JButton("Hello");
        btnCalc = new JButton("Add");
        btnName = new JButton("Name");
        btnDraw = new JButton("Draw");

        add(btnHello);
        add(btnCalc);
        add(btnName);
        add(btnDraw);

        btnHello.addActionListener(this);
        btnCalc.addActionListener(this);
        btnName.addActionListener(this);
        btnDraw.addActionListener(this);

        tf1 = new JTextField(5);
        tf2 = new JTextField(5);
        tfName = new JTextField(10);
        xField = new JTextField(3);
        yField = new JTextField(3);

        add(new JLabel("A:")); add(tf1);
        add(new JLabel("B:")); add(tf2);
        add(new JLabel("Name:")); add(tfName);
        add(new JLabel("X:")); add(xField);
        add(new JLabel("Y:")); add(yField);

        red = new JCheckBox("Red");
        green = new JCheckBox("Green");
        blue = new JCheckBox("Blue");

        add(red); add(green); add(blue);

        red.addItemListener(this);
        green.addItemListener(this);
        blue.addItemListener(this);

        panel = new DrawPanel();
        panel.setPreferredSize(new Dimension(450, 250));
        panel.setBackground(Color.WHITE);

        add(panel);

        panel.addMouseListener(this);
        panel.addKeyListener(this);
        panel.setFocusable(true);

        // Анимация (Timer вместо Thread)
        Timer timer = new Timer(100, e -> {
            animX += 5;
            if (animX > panel.getWidth()) animX = 0;
            panel.repaint();
        });
        timer.start();

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == btnHello) {
                msg = "Hello Java";
            }

            if (e.getSource() == btnCalc) {
                int a = Integer.parseInt(tf1.getText());
                int b = Integer.parseInt(tf2.getText());
                result = a + b;
                msg = "Result: " + result;
            }

            if (e.getSource() == btnName) {
                msg = "Сәлем, " + tfName.getText();
            }

            if (e.getSource() == btnDraw) {
                x = Integer.parseInt(xField.getText());
                y = Integer.parseInt(yField.getText());
            }

        } catch (Exception ex) {
            msg = "Ошибка ввода!";
        }

        panel.repaint();
        panel.requestFocus();
    }

    public void itemStateChanged(ItemEvent e) {
        if (red.isSelected()) color = Color.RED;
        if (green.isSelected()) color = Color.GREEN;
        if (blue.isSelected()) color = Color.BLUE;

        panel.repaint();
    }

    public void mousePressed(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        panel.repaint();
    }

    public void keyTyped(KeyEvent e) {
        ch = e.getKeyChar();
        panel.repaint();
    }

    class DrawPanel extends JPanel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // 1. Фигуры
            g.drawRect(50, 50, 100, 60);
            g.drawString("Rectangle", 50, 45);

            g.drawOval(200, 50, 60, 60);
            g.drawString("Circle", 200, 45);

            g.drawLine(50, 150, 150, 150);
            g.drawString("Line", 50, 140);

            // 2. Сообщение
            g.drawString(msg, 50, 200);

            // 3. Координаты
            g.fillOval(x, y, 30, 30);

            // 4. Мышь
            g.fillOval(mouseX, mouseY, 5, 5);
            g.drawString("Mouse: " + mouseX + "," + mouseY, 50, 220);

            // 5. Клавиатура
            g.drawString("Key: " + ch, 50, 240);

            // 6. Цвет
            g.setColor(color);
            g.fillRect(300, 50, 50, 50);

            g.setColor(Color.BLACK);

            // 7. Анимация
            g.fillOval(animX, 10, 30, 30);
        }
    }

    public void mouseClicked(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        new AllInOneSwing();
    }
}

