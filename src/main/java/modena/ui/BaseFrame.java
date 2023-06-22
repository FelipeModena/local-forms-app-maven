package modena.ui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class BaseFrame extends JFrame {
    protected JPanel mainPanel = new JPanel();

    public void initialize(String title) {
        baseConfig(title);

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        getContentPane().add(scrollPane);

    }

    void baseConfig(String title) {
        setTitle(title);

        //TODO ennable this for fullscreen
        // setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(500, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
