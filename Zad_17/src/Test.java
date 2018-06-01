import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Test extends JFrame {
    public Test() {
       initUI();
    }

    private void initUI() {

        UIManager.put("MenuItem.border", new LineBorder(Color.RED));
        UIManager.put("Menu.border", BorderFactory.createLineBorder(Color.red, 3));

        // creating menuBar
        JMenuBar menuBar = new JMenuBar();

        // creating menu and adding border
        JMenu menu = new JMenu("Some menu");
        menu.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        UIManager.put("Menu.border", new LineBorder(Color.RED));

        // creating item and adding border (the same way)
        JMenuItem item1 = new JMenuItem("Some item");
        JMenuItem item2 = new JMenuItem("Some item");
        UIManager.put("Menu.border", new LineBorder(Color.RED));


        // adding all together
        menu.add(item1);
        menu.add(item2);
        menuBar.add(menu);
        setJMenuBar(menuBar);
        UIManager.put("Menu.border", new LineBorder(Color.RED));

        // basic settings for the window
        setTitle("Testing JMenu");
        setSize(360, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        UIManager.put("Menu.border", new LineBorder(Color.RED));
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Test test =new Test();
            test.setVisible(true);
        });
    }
}
