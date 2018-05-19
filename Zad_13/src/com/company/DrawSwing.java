package com.company;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

public class DrawSwing {

    public static void main(String[] args)
    {
        new DrawSwing();

    }

    public DrawSwing()
    {
        SwingUtilities.invokeLater(() -> {
            try {
                createGUI();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    protected void createGUI() throws FileNotFoundException {

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

        ArrayList<Color> colorTable = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            colorTable.add(colorRandomizer());
        }

        // utworzenie obszaru rysowania - pulpitu
        MyPanel p = new MyPanel(colorTable);

        // wymiana domyĹlnego pulpitu na wĹasny
        jf.setContentPane(p);

        // upakowanie okna
        jf.pack( );

        // wyĹwietlenie okna
        jf.setVisible(true);
    }

    public static Color colorRandomizer() {
        final Random r = new Random();
        Color c=new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256),r.nextInt(256));
        return c;
    }
}

class MyPanel
        extends JPanel {
    private ArrayList<Color> colors;

    // konstruktor
    MyPanel(ArrayList<Color> colors)
    {
        // ustalenie rozmiarĂłw poczÄtkowych
        setPreferredSize(new Dimension(400,400));
        this.colors = colors;
    }


    public void paintComponent(Graphics g)
    {
        // musi byÄ jako pierwsza instrukcja
        super.paintComponent(g);

        // pobranie aktualnych rozmiarĂłw
        int width = getWidth();
        int height = getHeight();
        int xcentre = width/2;
        int ycentre = height/2;

        ArrayList<String> parameters = new ArrayList<>();
        try {
            parameters = reader("data.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<int[]> arguments = new ArrayList<>();
        for (String str : parameters) {
            arguments.add(intConverter(str));
        }

        g.setColor(Color.red);
        g.setFont(new Font("Dialog", Font.BOLD|Font.ITALIC, 30));

        for (int[] dims : arguments) {
            int counter = 0;
            if (dims.length == 3) {
                g.setColor(colors.get(arguments.indexOf(dims)));
                g.drawOval(dims[0]-dims[2], dims[1]-dims[2], dims[2], dims[2]);
            }
            if (dims.length == 4) {
                g.setColor(colors.get(arguments.indexOf(dims)));
                int[] xp = {dims[2], dims[2], dims[0], dims[0]};
                int[] xy = {dims[3], dims[1], dims[1], dims[3]};
                g.drawPolygon(xp, xy, 4);
            }
            counter++;
        }
    }

    public static ArrayList<String> reader(String filename) throws FileNotFoundException {
        ArrayList<String> tempArray = new ArrayList<>();
        File file = new File("./data/" + filename);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (validator(line)){
                tempArray.add(line);
            }
        }
        return tempArray;
    }

    public static boolean validator(String toValidate) {
        boolean temp = false;
        String pattern1 = "[\\d]+[ ][\\d]+[ ][\\d]+";
        String pattern2 = "[\\d]+[ ][\\d]+[ ][\\d]+[ ][\\d]+";
        Pattern stringPattern1 = Pattern.compile(pattern1);
        Pattern stringPattern2 = Pattern.compile(pattern2);
        Matcher stringMatcher1 = stringPattern1.matcher(toValidate);
        Matcher stringMatcher2 = stringPattern2.matcher(toValidate);
        if (stringMatcher1.matches() || stringMatcher2.matches()) {
            temp = true;
        }
        return temp;
    }

    public static int[] intConverter(String toConversion) {
        String[] integersString = toConversion.split(" ");
        int[] integers = new int[integersString.length];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = Integer.parseInt(integersString[i]);
        }
        return integers;
    }
}
