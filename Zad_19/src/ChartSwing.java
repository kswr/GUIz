import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class ChartSwing {

    private JTextField jTextField0;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private JTextField jTextField5;
    private MyPanel myPanel;
    private int a = -10;
    private int b = 10;
    private int c = -10;
    private int d = 10;
    private Polygon p;
    private Polygon p1;
    private Polygon p2;

    public static void main(String[] args) {
        ChartSwing gui = new ChartSwing();
        gui.go();
    }

    public void go() {
        // creating JFrame and JPanels
        JFrame jFrame = new JFrame();
        JPanel jPanel0 = new JPanel();
        JPanel jPanel1 = new JPanel();
        JPanel jPanel2 = new JPanel();
        // TODO validation of input values, recommend dialog locking on focus
        // initializing JTextFields
        jTextField0 = new JTextField();
        jTextField0.setText(String.valueOf(a));
        jTextField0.addFocusListener(new ActListA());
        jTextField1 = new JTextField();
        jTextField1.setText(String.valueOf(b));
        jTextField1.addFocusListener(new ActListB());
        jTextField2 = new JTextField();
        jTextField2.setText(String.valueOf(c));
        jTextField2.addFocusListener(new ActListC());
        jTextField3 = new JTextField();
        jTextField3.setText(String.valueOf(d));
        jTextField3.addFocusListener(new ActListD());
        jTextField4 = new JTextField();
        jTextField4.setText("a^2");
        jTextField4.addFocusListener(new ActListE());
        jTextField5 = new JTextField();
        myPanel = new MyPanel();

        // creating layout managers
        GridLayout gl0 = new GridLayout(1,4);
        GridLayout gl1 = new GridLayout(1,1);
        GridLayout gl2 = new GridLayout(2,1);

        // applying layouts
        jPanel0.setLayout(gl2);
        jPanel1.setLayout(gl0);
        jPanel2.setLayout(gl1);

        jPanel1.add(jTextField0);
        jPanel1.add(jTextField1);
        jPanel1.add(jTextField2);
        jPanel1.add(jTextField3);

        jPanel2.add(jTextField4);

        jPanel0.add(jPanel1);
        jPanel0.add(jPanel2);

        jFrame.add(BorderLayout.SOUTH,jPanel0);
        jFrame.add(BorderLayout.CENTER,myPanel);

        // some settings of window
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setSize(600,400);
        jFrame.setResizable(true);
        jFrame.setVisible(true);
    }

    class MyPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // getting data about drawing area
            int width = Math.abs(a) + b;
            int height = Math.abs(c) + d;
            int x_centre = (int) (getWidth()*(Math.abs(a)/(double)width));
            int y_centre = (int) (getHeight()*(d/(double)height));

            // adding grid
            g.setColor(Color.GRAY);

            for (int i = 0; i < height; i++) {
                g.drawLine(0,(int)((double)getHeight()*((double)i/(double)height)),getWidth(),(int)((double)getHeight()*((double)i/(double)height)));
            }
            for (int i = 0; i < width; i++) {
                g.drawLine((int)((double)getWidth()*((double)i/(double)width)),0,(int)((double)getWidth()*((double)i/(double)width)),getHeight());
            }

            // calculating factors
            double factor = (double)getHeight()/(double)getWidth();
            double factor_grid = (float)width/(float)height;
            double width_factor = (double)getWidth()/width;
            double width_factor1 = Math.pow((double)getWidth(),2)/width;
            double width_factor2 = getWidth()/Math.pow(width,2);
//            double q_factor_grid = Math.pow((float)width,2)/Math.pow((float)height,2);

            // assigning objects to reference variables
            p = new Polygon();
            p1 = new Polygon();
            p2 = new Polygon();

            // debugging prints
            System.out.println("X centre: " + x_centre);
            System.out.println("Y centre: " + y_centre);
            System.out.println("pix height/pix width: " + factor);
            System.out.println("grid width/grid height: " + factor_grid);
            System.out.println("pix width/grid width: " + width_factor);
            System.out.println(width_factor1);
            System.out.println(width_factor2);

            // historical
//            for (int i = 0 - getWidth()/2; i < getWidth(); i++) {
//                p.addPoint((x_centre + i), (int)(y_centre - Math.abs(i)*factor));
//            }
//            for (int i = 0 - getWidth()/2; i< getWidth(); i++) {
//                p1.addPoint(x_centre + i,y_centre - Math.abs(i));
//            }

            // this one works!
            for (int i = 0 - getWidth(); i < getWidth(); i++) {
                p2.addPoint((x_centre + i), (int)(y_centre - Math.abs(i)*factor*factor_grid));
            }

            // let's try to the power of 3
            for (int i = 0 - getWidth(); i< getWidth(); i++) {
                p1.addPoint((x_centre + i), (int)(y_centre -
                        Math.pow(Math.abs(i),3)/width_factor1*width
                                *factor*factor_grid));
            }

            // does not work, let's try this
            // WORKS FOR QUADRATIC FUNCTION
            for (int i = 0 - getWidth(); i < getWidth(); i++) {
                p.addPoint((x_centre + i), (int)(y_centre -
                        Math.pow(i,2)/(width_factor)
                        *factor*factor_grid));
            }

            // drawing axis
            g.setColor(Color.BLUE);
            g.drawLine(0,(int)(getHeight()*((double)Math.abs(d)/(double)height)),getWidth(),(int)(getHeight()*((double)Math.abs(d)/(double)height)));
            g.drawLine((int)(getWidth()*((double)Math.abs(a)/(double)width)),0,(int)(getWidth()*((double)Math.abs(a)/(double)width)), getHeight());

            // drawing chart
            g.setColor(Color.BLACK);
            g.drawPolyline(p.xpoints,p.ypoints,p.npoints);
            g.drawPolyline(p1.xpoints,p1.ypoints,p1.npoints);
            g.drawPolyline(p2.xpoints,p2.ypoints,p2.npoints);
        }
    }

    class ActListA implements FocusListener {
        @Override
        public void focusGained(FocusEvent e) {
            // nothing
        }

        @Override
        public void focusLost(FocusEvent e) {
            a = Integer.parseInt(jTextField0.getText());
            myPanel.repaint();
        }
    }

    class ActListB implements FocusListener {
        @Override
        public void focusGained(FocusEvent e) {
            // nothing
        }

        @Override
        public void focusLost(FocusEvent e) {
            b = Integer.parseInt(jTextField1.getText());
            myPanel.repaint();
        }
    }

    class ActListC implements FocusListener {
        @Override
        public void focusGained(FocusEvent e) {
            // nothing
        }

        @Override
        public void focusLost(FocusEvent e) {
            c = Integer.parseInt(jTextField2.getText());
            myPanel.repaint();
        }
    }

    class ActListD implements FocusListener {
        @Override
        public void focusGained(FocusEvent e) {
            // nothing
        }

        @Override
        public void focusLost(FocusEvent e) {
            d = Integer.parseInt(jTextField3.getText());
            myPanel.repaint();
        }
    }

    class ActListE implements FocusListener {
        @Override
        public void focusGained(FocusEvent e) {
            // nothing
        }

        @Override
        public void focusLost(FocusEvent e) {
            myPanel.repaint();
        }
    }
}

