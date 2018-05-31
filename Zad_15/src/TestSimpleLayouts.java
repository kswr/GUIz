import javax.swing.*;
import java.awt.*;

public class TestSimpleLayouts extends JFrame {

    public TestSimpleLayouts(){
        initUI();
    }

    private void initUI() {

        String inputValue = "";
        int counter = 0;

        while (!inputValue.matches("[a-g]")) {
            if (counter==0) {
                try {
                    inputValue = JOptionPane.showInputDialog(null, "Choose layout between a-g", "Type here").toLowerCase();
                }
                catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "FlowLayout will be applied (default)");
                    break;
                }
            } else {
                try{
                    inputValue = JOptionPane.showInputDialog(null, "Incorrect selection!\nChoose layout between a-g", "Type here").toLowerCase();
                }
                catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "FlowLayout will be applied (default)");
                    break;
                }
            }
            counter++;
        }

        JPanel panel = new JPanel();

        JButton button1 = new JButton("Przycisk 1");
        JButton button2 = new JButton("P 2");
        JButton button3 = new JButton("Większy przycisk numer 3");
        JButton button4 = new JButton("Przycisk 4");
        JButton button5 = new JButton("P5");

            switch (inputValue) {
//a) w układzie BorderLayout
                case "a":
                    panel.setLayout(new BorderLayout());
                    JOptionPane.showMessageDialog(null, "BorderLayout will be applied");
                    break;
//b) w układzie FlowLayout
                case "b":
                    panel.setLayout(new FlowLayout());
                    JOptionPane.showMessageDialog(null, "FlowLayout will be applied");
                    break;
//c) w układzie FlowLayout z wyrównaniem do lewej
                case "c":
                    panel.setLayout(new FlowLayout(FlowLayout.LEFT));
                    JOptionPane.showMessageDialog(null, "FlowLayout aligned to left will be applied");
                    break;
//d) w układzie FlowLayout z wyrównaniem do prawej
                case "d":
                    panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
                    JOptionPane.showMessageDialog(null, "FlowLayout aligned to right will be applied");
                    break;
//e) w układzie GridLayout jako jeden wiersz
                case "e":
                    panel.setLayout(new GridLayout());
                    JOptionPane.showMessageDialog(null, "GridLayout will be applied");
                    break;
//f) w układzie GridLayout jako jedną kolumnę
                case "f":
                    panel.setLayout(new GridLayout(0,1));
                    JOptionPane.showMessageDialog(null, "GridLayout with one column will be applied");
                    break;
//g) w układzie GridLayout jako tablice (3, 2)
                case "g":
                    panel.setLayout(new GridLayout(3,2));
                    JOptionPane.showMessageDialog(null, "GridLayout (3,2) will be applied");
                    break;
            }

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        add(panel);

        setTitle("Zadanie 15");
//        pack();
        setSize(360, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            TestSimpleLayouts test = new TestSimpleLayouts();
            test.setVisible(true);
        });
    }
}
