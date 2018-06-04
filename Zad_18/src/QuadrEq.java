import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import static java.lang.Math.pow;
import static java.lang.StrictMath.sqrt;

public class QuadrEq extends JFrame {

    public QuadrEq() {
        InitUI();
    }

    private void InitUI() {

        GridLayout layout = new GridLayout(4,1);
        layout.setHgap(0);
        layout.setVgap(0);
        setLayout(layout);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1,3));
        JLabel label = new JLabel();
        JTextField textField1 = new JTextField();
        textField1.setHorizontalAlignment(0);
        textField1.setToolTipText("Enter a");
        JTextField textField2 = new JTextField();
        textField2.setHorizontalAlignment(0);
        textField2.setToolTipText("Enter b");
        JTextField textField3 = new JTextField();
        textField3.setHorizontalAlignment(0);
        textField3.setToolTipText("Enter c");
        JButton button1 = new JButton("Solve");
        button1.setMnemonic(KeyEvent.VK_S);
        button1.addActionListener((ActionEvent event) -> {
            String string1 = textField1.getText();
            String string2 = textField2.getText();
            String string3 = textField3.getText();
            if (string1.isEmpty() | string2.isEmpty() | string3.isEmpty()) {
                label.setBackground(Color.RED);
                label.setForeground(Color.BLACK);
                label.setText("Type in values");
            } else if (!StringUtils.isNumeric(string1) | !StringUtils.isNumeric(string2) | !StringUtils.isNumeric(string3)) {
                label.setBackground(Color.RED);
                label.setForeground(Color.BLACK);
                label.setText("Number format error");
            } else if (Double.valueOf(string1) == 0) {
                label.setBackground(Color.RED);
                label.setForeground(Color.BLACK);
                label.setText("Not a quadratic equation");
            } else {
                label.setBackground(Color.WHITE);
                label.setForeground(Color.BLUE);
                label.setText(solveEquation(Double.valueOf(string1), Double.valueOf(string2), Double.valueOf(string3)));
            }
        });
        JButton button2 = new JButton("Clear");
        button2.setMnemonic(KeyEvent.VK_C);
        button2.addActionListener((ActionEvent event) -> {
            label.setText("");
            label.setBackground(Color.WHITE);
            textField1.setText("");
            textField2.setText("");
            textField3.setText("");
        });

        panel1.add(textField1);
        panel1.add(textField2);
        panel1.add(textField3);

        add(label);
        add(panel1);
        add(button1);
        add(button2);

        label.setHorizontalAlignment(0);
        label.setOpaque(true);
        label.setBackground(Color.WHITE);

        setTitle("Quadratic Equation");
        setSize(360, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            QuadrEq ex = new QuadrEq();
            ex.setVisible(true);
        });

    }

    public static String solveEquation(double a, double b, double c) {
        String solution = "";
        double x1 = ((-b + sqrt(pow(b,2)-4*(a*c)))/(2*a));
        double x2 = ((-b - sqrt(pow(b,2)-4*(a*c)))/(2*a));
        if (Double.isNaN(x1) & Double.isNaN(x2)) {
            solution = "No solution";
        } else if (Double.isNaN(x1)) {
            solution = "x = " + String.valueOf(x2);
        } else if (Double.isNaN(x2)) {
            solution = "x = " + String.valueOf(x1);
        } else {
            solution = "x1 = " + String.valueOf(x1) + ", x2 = " + String.valueOf(x2);
        }
        return solution;
    }
}

