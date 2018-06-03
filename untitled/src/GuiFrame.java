import javax.swing.*;
import java.awt.*;

public class GuiFrame extends JFrame {

    public GuiFrame() {
        InitUI();
    }

    private void InitUI() {

        setTitle("Main Window");
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

