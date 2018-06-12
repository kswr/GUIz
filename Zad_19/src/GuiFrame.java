import javax.swing.*;
import java.awt.*;

public class GuiFrame extends JFrame {

    public GuiFrame() {
        InitUI();
    }

    private void InitUI() {

        BorderLayout bl1 = new BorderLayout();
        bl1.setHgap(0);
        bl1.setVgap(0);
        setLayout(bl1);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        JTextField textField1 = new JTextField();
        JTextField textField2 = new JTextField();
        JTextField textField3 = new JTextField();
        JTextField textField4 = new JTextField();
        JTextField textField5 = new JTextField();

        MyPanel myPanel = new MyPanel();
        myPanel.setBackground(Color.WHITE);

//        setContentPane(myPanel);

        GridLayout gl1 = new GridLayout(1,4);
        gl1.setVgap(0);
        gl1.setHgap(0);

        GridLayout gl2 = new GridLayout(2,1);
        gl2.setVgap(0);
        gl2.setHgap(0);

        panel1.setLayout(gl1);
        panel2.setLayout(gl2);

        panel1.add(textField1);
        panel1.add(textField2);
        panel1.add(textField3);
        panel1.add(textField4);

        panel2.add(panel1);
        panel2.add(textField5);

//        add(myPanel, BorderLayout.PAGE_START);
        add(myPanel);
        add(panel2, BorderLayout.PAGE_END);

        setTitle("Wykres");
        setSize(360, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            GuiFrame ex = new GuiFrame();
            ex.setVisible(true);
        });

    }
}

class MyPanel extends JPanel {
    MyPanel() {
    }

    double f(double x) {
        return Math.sin(x);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();

//        g2.setBackground(Color.WHITE);
        g2.setColor(Color.BLUE);
        g2.setStroke(new BasicStroke(1.5f));
        g2.drawLine(0,height/2, width,height/2);
        g2.drawLine(width/2, 0, width/2, height);

        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke());
        Polygon p = new Polygon();

        for (int x = -170; x <= 170; x++) {
            p.addPoint(x + 200, 100 - (int) (50 * f((x / 100.0) * 2
                    * Math.PI)));
        }

        g2.drawPolyline(p.xpoints, p.ypoints, p.npoints);

    }
}
