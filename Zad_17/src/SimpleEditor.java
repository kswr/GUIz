import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.*;

import static java.awt.event.ActionEvent.CTRL_MASK;
import static java.awt.event.ActionEvent.SHIFT_MASK;

public class SimpleEditor extends JFrame {
    public SimpleEditor() {
        initUI();
    }

    String filename = "";

    private void initUI() {

        // getting current directory
        File workingDirectory = new File(System.getProperty("user.dir"));

        // creating JTextPane for editing text and wraping it in JScrollPane
        JTextPane textPane = new JTextPane();
        JScrollPane spane = new JScrollPane(textPane);
        // removin border from JScrollPane
        spane.setBorder(null);

        // settings for JTextPane - editable and taking text
        textPane.setContentType("text");
        textPane.setEditable(true);

        // produce border
        Border raisedBevelBorder = BorderFactory.createRaisedBevelBorder();

        // apply border to MenuItems and Menus (J...)
        UIManager.put("MenuItem.border", raisedBevelBorder);
        UIManager.put("Menu.border", raisedBevelBorder);

        // arrays of colors with codes and sizes of letters
        String[][] colors = {{"Blue","#0000FF"}, {"Yellow","#FFFF00"}, {"Orange","#FFBB33"}, {"Red","#FF3333"}, {"White","#FFFFFF"}, {"Black","#000000"}, {"Green","#58FC37"}};
        int[] pts = {8, 10, 12, 14, 16, 20, 22, 24};

        // creating menuBar with Menus and MenuItems, adding mnemonics
        JMenuBar menuBar = new JMenuBar();
        JMenuNew fileMe = new JMenuNew("File", KeyEvent.VK_F);
        JMenuNew editMe = new JMenuNew("Edit", KeyEvent.VK_E);
        JMenuNew optionsMe = new JMenuNew("Options", KeyEvent.VK_O);
        JMenuNew adressMe = new JMenuNew("Adresy", KeyEvent.VK_A);
        JMenuNew foreMe = new JMenuNew("Foreground", KeyEvent.VK_R);
        JMenuNew backMe = new JMenuNew("Background", KeyEvent.VK_B);
        JMenuNew fontMe = new JMenuNew("Font size", KeyEvent.VK_N);

        // MenuItem Open with mnemonic and accelerator (custom class)
        JMenuItemNew openMi = new JMenuItemNew("Open", KeyEvent.VK_O, KeyStroke.getKeyStroke(KeyEvent.VK_O, CTRL_MASK));

        // creating actionListener
        openMi.addActionListener((ActionEvent event) -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(workingDirectory);
            chooser.showOpenDialog(null);
            // exception for cancelled window
            try {
                File f = chooser.getSelectedFile();
                filename = f.getAbsolutePath();
                FileReader reader = new FileReader(filename);
                BufferedReader br = new BufferedReader(reader);
                textPane.read(br,null);
                br.close();
                setTitle(filename);
                textPane.requestFocus();
            } catch (Exception e) {

            }
        });

        // MenuItem Save with mnemonic and accelerator (custom class)
        JMenuItemNew saveMi = new JMenuItemNew("Save", KeyEvent.VK_S, KeyStroke.getKeyStroke(KeyEvent.VK_S, CTRL_MASK));
        // creating actionListener
        saveMi.addActionListener((ActionEvent event) -> {
            // excepton for non-existing file
            try {
                FileWriter writer = new FileWriter(filename);
                BufferedWriter bw = new BufferedWriter(writer);
                bw.write(textPane.getText());
                bw.close();
                textPane.requestFocus();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "File does not exist");
            }
        });

        // MenuItem SaveAs with mnemonic and accelerator (custom class)
        JMenuItemNew saveasMi = new JMenuItemNew("Save as...", KeyEvent.VK_A, KeyStroke.getKeyStroke(KeyEvent.VK_A, CTRL_MASK));
        // creating actionListener
        saveasMi.addActionListener((ActionEvent event) -> {
            // exception for cancelled window
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(workingDirectory);
            chooser.showSaveDialog(null);
            try {
                File f = chooser.getSelectedFile();
                filename = f.getAbsolutePath();
                FileWriter writer = new FileWriter(filename);
                BufferedWriter bw = new BufferedWriter(writer);
//                f.setWritable(true);
                bw.write(textPane.getText());
                setTitle(filename);
                bw.close();
                textPane.requestFocus();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "File not saved");
            }
        });

        // MenuItem Exit with mnemonic and accelerator (custom class)
        JMenuItemNew exitMi =new JMenuItemNew("Exit", KeyEvent.VK_X, KeyStroke.getKeyStroke(KeyEvent.VK_X, CTRL_MASK));
        // creating actionListener
        exitMi.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });

        // buttons for inserting text with adresses
        JMenuItemNew workMi = new JMenuItemNew("Praca", KeyEvent.VK_P, KeyStroke.getKeyStroke(KeyEvent.VK_P, CTRL_MASK | SHIFT_MASK));
        insertText(workMi, "Miasteczko Orange, Aleje Jerozolimskie 160, 02-326 Warszawa", textPane);
        JMenuItemNew schoolMi = new JMenuItemNew("Szkoła", KeyEvent.VK_S, KeyStroke.getKeyStroke(KeyEvent.VK_S, CTRL_MASK | SHIFT_MASK));
        insertText(schoolMi, "Polsko-Japońska Akademia Technik Komputerowych, Koszykowa 86, 02-008 Warszawa", textPane);
        JMenuItemNew homeMi = new JMenuItemNew("Dom", KeyEvent.VK_D, KeyStroke.getKeyStroke(KeyEvent.VK_D, CTRL_MASK | SHIFT_MASK));
        insertText(homeMi, "Mahatmy Gandhiego 68, 02-352 Warszawa", textPane);

        // adding buttons for text sizes
        for (int i: pts) {
            fontMe.add(new JMenuItem(String.valueOf(i) + " pts"));
        }

        // adding action listener for above
        for (int i = 0; i < pts.length; i++) {
            int size = pts[i];
            fontMe.getItem(i).addActionListener((ActionEvent event) -> {
                    textPane.setFont(new Font(Font.SANS_SERIF, 0, size));
            });
        }

        // Background
        // adding buttons for colors with icons (custom class roundIcon)
        for (String[] str: colors) {
            backMe.add(new JMenuItem(str[0], new roundIcon(Color.decode(str[1]))));
        }

        // adding action listener for above
        for (int i = 0; i < backMe.getItemCount(); i++) {
            Color tempColor = Color.decode(colors[i][1]);
            backMe.getItem(i).addActionListener((ActionEvent event) -> {
                textPane.setBackground(tempColor);
            });
        }

        // Foreground
        // adding buttons for colors with icons (custom class roundIcon)
        for (String[] str: colors) {
            foreMe.add(new JMenuItem(str[0], new roundIcon(Color.decode(str[1]))));
        }
//        for (String str[]: colors) {
//            foreMe.add(new JMenuItem(str[0]));
//        }

        // adding action listener for above
        for (int i = 0; i < foreMe.getItemCount(); i++) {
            Color tempColor = Color.decode(colors[i][1]);
            foreMe.getItem(i).addActionListener((ActionEvent event) -> {
                if (textPane.getText().length()>0) {
                    textPane.setForeground(tempColor);
                }
            });
        }

        // putting all together
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

        // basic window settings (overwritten setTitle)
        setTitle("Bez tytułu");
        setSize(720,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // method for inserting text with adress
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


    // custom setTitle
    @Override
    public void setTitle(String title) {
        super.setTitle("Prosty edytor - " + title);
    }

    // psvm with thread synchronisation
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            SimpleEditor se = new SimpleEditor();
            se.setVisible(true);
        });
    }

    // custom class for creating round icons
    public class roundIcon implements Icon {
        private Color color;

        public roundIcon(Color color) {
            this.color = color;
        }


        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            g.setColor(color);
            g.fillOval(8,4,10,10);
            g.setColor(Color.BLACK);

        }

        @Override
        public int getIconWidth() {
            return 0;
        }

        @Override
        public int getIconHeight() {
            return 0;
        }
    }

    // JmenuItem with mnemonic
    public class JMenuItemNew extends JMenuItem {
        public JMenuItemNew(String text, int mnemonic, KeyStroke accelerator) {
            super(text, mnemonic);
            setAccelerator(accelerator);
        }
    }

    // Jmenu with mnemonic
    public class JMenuNew extends JMenu {
        public JMenuNew(String s, int mnemonic) {
            super(s);
            setMnemonic(mnemonic);
        }
    }
}