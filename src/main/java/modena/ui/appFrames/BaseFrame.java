package modena.ui.appFrames;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BaseFrame extends JFrame {
    private JPanel currentPanel;

    void init() {
        setTitle("Modena Santos RH");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void setContent(JPanel panel) {
        System.out.println("Current panel: " + panel);
        System.out.println("Esse painel é o mesmo? " + (currentPanel == panel));
        if (currentPanel != null && currentPanel != panel) {
            remove(currentPanel);
        }

        currentPanel = panel;
        add(panel);
        revalidate();
        repaint();
    }
}
