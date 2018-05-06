package com.company;

import java.awt.*;
import java.util.Collections;
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

        int circleFi;
        circleFi = Integer.parseInt(JOptionPane.showInputDialog("Choose size of the logo"));

        // utworzenie okna
        JFrame jf = new JFrame();

        // okreĹlenie tytuĹu okna
        jf.setTitle("Rysowanie");

        // obsĹuga zamkniÄcia okna JFrame
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // okreĹlenie poĹoĹźenia okna
        jf.setLocation(50,50);

        // uniemoĹźliwienie zmiany rozmiarĂłw okna
        jf.setResizable(true);

        // utworzenie obszaru rysowania - pulpitu
        MyPanel p = new MyPanel(circleFi);

        // wymiana domyĹlnego pulpitu na wĹasny
        jf.setContentPane(p);

        // upakowanie okna
        jf.pack( );

        // wyĹwietlenie okna
        jf.setVisible(true);


    }
}

class MyPanel
        extends JPanel {
    int circleFi;

    // konstruktor
    MyPanel(int r)
    {
        // ustalenie rozmiarĂłw poczÄtkowych
        setPreferredSize(new Dimension(400,400));
        this.circleFi = r;
    }


    public void paintComponent(Graphics g)
    {
        // musi byÄ jako pierwsza instrukcja
        super.paintComponent(g);
        int circleFi = this.circleFi;

        // pobranie aktualnych rozmiarĂłw
        int width = getWidth();
        int height = getHeight();

        // TU RYSUJEMY!
        // ........
        g.setColor(Color.red);
        g.setFont(new Font("Dialog", Font.BOLD|Font.ITALIC, 30));
//        g.drawString("Tu rysujemy!", width/2, height/2);
        g.fillOval((width-circleFi)/2, (height-circleFi)/2, circleFi,circleFi);
        g.setColor(Color.white);
        circleFi = (int) (circleFi*0.85);
        g.fillArc((width-circleFi)/2, (height-circleFi)/2, circleFi, circleFi, 0, 180);
        // ........
    }
}
