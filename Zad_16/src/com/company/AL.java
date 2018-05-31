package com.company;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class AL extends Frame implements WindowListener,ActionListener {
    TextField text = new TextField(20);
    Button b;
    private int numClicks = 0;
//    private static ArrayList<Color> colors = new ArrayList<>();
    private static col1 cols = new col1();

    public static class col1 {
        private ArrayList<Color> colors = new ArrayList<>();
        private ListIterator iterator;

        public col1() {
            Random r = new Random();
            for (int i = 0; i <= 10; i++) {
                this.colors.add(new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256),r.nextInt(256)));
            }
            this.iterator = this.colors.listIterator();
        }

        public ListIterator getIterator() {
            return iterator;
        }

        public ArrayList<Color> getColors() {
            return colors;
        }
    }

    public static void main(String[] args) {
        AL myWindow = new AL("My first window");
        myWindow.pack();
        myWindow.setVisible(true);
    }

    public AL(String title) {
        super(title);
        setLayout(new FlowLayout());
        addWindowListener(this);
        b = new Button("Click me");
        add(b);
//        add(text);
        b.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        ArrayList<Color> colors = cols.getColors();
        if (numClicks < colors.size()) {
            b.setBackground(colors.get(numClicks));
//            text.setText("Button Clicked " + numClicks + " times");
            numClicks++;
        } else {
            numClicks = 0;
        }
    }

    public void windowClosing(WindowEvent e) {
        dispose();
        System.exit(0);
    }

    public void windowOpened(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
    public void windowClosed(WindowEvent e) {}

}

