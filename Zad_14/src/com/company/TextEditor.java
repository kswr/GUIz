package com.company;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class TextEditor {
    public static void main(String[] args) {
        Font font = new Font("Dialog", Font.BOLD, 14);
        JFrame frame = new JFrame("Edytor tekstu");
        JPanel panel = new JPanel();
        JTextArea jta = new JTextArea();
        jta.setFont(font);
        jta.setBackground(Color.green);
        jta.setForeground(Color.red);

        panel.setLayout(new BorderLayout());
        panel.setBorder(new EtchedBorder(Color.green, Color.green));
        panel.add(jta);
        frame.add(panel);
        frame.setSize(600,400);
        frame.setVisible(true);
    }
}
