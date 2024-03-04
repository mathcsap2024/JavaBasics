package GUI.Animation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Application implements Runnable{

    private JFrame mainFrame;
    private MainPanel mainPanel;

    private Integer refreshRate;
    private Timer frameTimer;

    private static final int DEFAULT_REFRESH_RATE = 10;

    private void initPanel() {
        mainPanel = new MainPanel();
    }

    private void initFrame() {
        refreshRate = Application.DEFAULT_REFRESH_RATE;

        mainFrame = new JFrame();
        mainFrame.setSize(800,600);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        initPanel();
        mainFrame.getContentPane().add(mainPanel);

        JButton button = new JButton("Reset Spinner");
        mainFrame.getContentPane().add(button, BorderLayout.SOUTH);
    }

    private void initTimer() {
        frameTimer = new Timer(
                1000 / refreshRate,
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mainPanel.nextTurn();
                        mainPanel.revalidate();
                        mainPanel.repaint();
                    }
                }
        );
    }

    @Override
    public void run() {
        initFrame();
        initTimer();
        mainFrame.setVisible(true);
        frameTimer.start();
    }
}
