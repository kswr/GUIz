package com.company;

import java.awt.*;
import javax.swing.*;

public class DrawSwing {

    public static void main(String[] args)
    {
        new DrawSwing();
    }

    public DrawSwing()
    {
        SwingUtilities.invokeLater(() -> createGUI());
    }

    protected void createGUI()
    {
        JFrame jf = new JFrame();

        jf.setTitle("Rysowanie");

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.setLocation(50,50);

//        jf.setResizable(true);

        MyPanel p = new MyPanel();

        jf.setContentPane(p);

        // upakowanie okna
        jf.pack( );

        jf.setVisible(true);
    }
}

class MyPanel
        extends JPanel {

    // konstruktor
    MyPanel()
    {
        // ustalenie rozmiarĂłw poczÄtkowych
        setPreferredSize(new Dimension(400,400));
    }


    public void paintComponent(Graphics g)
    {
        // musi byÄ jako pierwsza instrukcja
        super.paintComponent(g);

        // pobranie aktualnych rozmiarĂłw
        int width = getWidth();
        int height = getHeight();

        // TU RYSUJEMY!
        // ........
        g.setColor(Color.red);
        g.setFont(new Font("Dialog", Font.BOLD|Font.ITALIC, 30));
        g.drawString("Tu rysujemy!", width/2, height/2);
        // ........
    }
}
