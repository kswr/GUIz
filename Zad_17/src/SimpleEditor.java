import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class SimpleEditor extends JFrame {
    public SimpleEditor() {
        initUI();
    }

    private void initUI() {

        File workingDirectory = new File(System.getProperty("user.dir"));

        JTextPane textPane = new JTextPane();
        JScrollPane spane = new JScrollPane(textPane);
        spane.setBorder(null);

        textPane.setContentType("text");
        textPane.setEditable(true);

        Border raisedBevelBorder = BorderFactory.createRaisedBevelBorder();

        UIManager.put("MenuItem.border", raisedBevelBorder);
        UIManager.put("Menu.border", raisedBevelBorder);

        String[][] colors = {{"Blue","#0000FF"}, {"Yellow","#FFFF00"}, {"Orange","#FFBB33"}, {"Red","#FF3333"}, {"White","#FFFFFF"}, {"Black","#000000"}, {"Green","#58FC37"}};
        int[] pts = {8, 10, 12, 14, 16, 20, 22, 24};

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMe = new JMenu("File");
        JMenu editMe = new JMenu("Edit");
        JMenu optionsMe = new JMenu("Options");
        JMenu adressMe = new JMenu("Adresy");
        JMenu foreMe = new JMenu("Foreground");
        JMenu backMe = new JMenu("Background");
        JMenu fontMe = new JMenu("Font size");
        JMenuItem openMi = new JMenuItem("Open");
        openMi.addActionListener((ActionEvent event) -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(workingDirectory);
            chooser.showOpenDialog(null);
            try {
                File f = chooser.getSelectedFile();
                String filename = f.getAbsolutePath();
                FileReader reader = new FileReader(filename);
                BufferedReader br = new BufferedReader(reader);
                textPane.read(br,null);
                br.close();
                textPane.requestFocus();
            } catch (Exception e) {

            }
        });

        JMenuItem saveMi = new JMenuItem("Save");
        JMenuItem saveasMi = new JMenuItem("Save as...");
        saveasMi.addActionListener((ActionEvent event) -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(workingDirectory);
            chooser.showSaveDialog(null);
            try {
                File f = chooser.getSelectedFile();
                String filename = f.getAbsolutePath();
                FileWriter writer = new FileWriter(filename);
                BufferedWriter bw = new BufferedWriter(writer);
//                f.setWritable(true);
                bw.write(textPane.getText());
                bw.close();
                textPane.requestFocus();

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "File not found");
            }
        });

        JMenuItem exitMi = new JMenuItem("Exit");
        exitMi.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });

        JMenuItem workMi = new JMenuItem("Praca");
        insertText(workMi, "Miasteczko Orange, Aleje Jerozolimskie 160, 02-326 Warszawa", textPane);
        JMenuItem schoolMi = new JMenuItem("Szkoła");
        insertText(schoolMi, "Polsko-Japońska Akademia Technik Komputerowych, Koszykowa 86, 02-008 Warszawa", textPane);
        JMenuItem homeMi = new JMenuItem("Dom");
        insertText(homeMi, "Mahatmy Gandhiego 68, 02-352 Warszawa", textPane);

        for (int i: pts) {
            fontMe.add(new JMenuItem(String.valueOf(i) + " pts"));
        }

        for (int i = 0; i < pts.length; i++) {
            int size = pts[i];
            fontMe.getItem(i).addActionListener((ActionEvent event) -> {
                textPane.setFont(new Font(Font.SANS_SERIF, 0, size));
            });
        }

        for (String[] str: colors) {
            backMe.add(new JMenuItem(str[0]));
        }

        for (int i = 0; i < backMe.getItemCount(); i++) {
            Color tempColor = Color.decode(colors[i][1]);
            backMe.getItem(i).addActionListener((ActionEvent event) -> {
                textPane.setBackground(tempColor);
            });
        }

        for (String str[]: colors) {
            foreMe.add(new JMenuItem(str[0]));
        }

        for (int i = 0; i < foreMe.getItemCount(); i++) {
            Color tempColor = Color.decode(colors[i][1]);
            foreMe.getItem(i).addActionListener((ActionEvent event) -> {
                textPane.setForeground(tempColor);
            });
        }

        fileMe.add(openMi);
        fileMe.add(saveMi);
        fileMe.add(saveasMi);
        fileMe.addSeparator();
        fileMe.add(exitMi);
        adressMe.add(workMi);
        adressMe.add(schoolMi);
        adressMe.add(homeMi);
        optionsMe.add(foreMe);
        optionsMe.add(backMe);
        optionsMe.add(fontMe);
        editMe.add(adressMe);
        menuBar.add(fileMe);
        menuBar.add(editMe);
        menuBar.add(optionsMe);
        setJMenuBar(menuBar);

        add(spane);

        setTitle("Prosty edytor");
        setSize(720,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private JMenuItem insertText(JMenuItem item, String string, JTextPane pane) {
        item.addActionListener((ActionEvent event) -> {
            try {
                pane.getDocument().insertString(pane.getCaretPosition(), string, null);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        });
        return item;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            SimpleEditor se = new SimpleEditor();
            se.setVisible(true);
        });
    }
}
