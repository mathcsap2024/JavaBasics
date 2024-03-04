package GUI.Animation;

import Geometry.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {
    private Integer clock;
    private Integer increaseRate;

    private MyCircle spinner;

    private JButton resetButton;

    private static final int SPINNER_RADIUS = 300;
    private static final int SPINNER_INITIAL_THETA = 0;
    private static final int SPINNER_DEFAULT_INCREASE_THETA = 1;

    public MainPanel() {
        initPanel();
    }

    private void initPanel() {
        this.setLayout(null);

        clock = 0;
        increaseRate = MainPanel.SPINNER_DEFAULT_INCREASE_THETA;

        spinner = new MyCircle(new Point(
                MainPanel.SPINNER_RADIUS,
                MainPanel.SPINNER_INITIAL_THETA
        ));

        addResetButton();
    }

    private void addResetButton() {
        resetButton = new JButton("Reset Spinner");
//        resetButton.setSize(new Dimension(100,80));
//        resetButton.setLocation(100,200);

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spinner.resetTheta();
            }
        });

        this.add(resetButton);
    }

    private java.awt.Point getCenter() {
        return new java.awt.Point(
                this.getWidth()/2,
                this.getHeight()/2
        );
    }

    private void drawSpinner(Graphics g) {
        java.awt.Point center = getCenter();
        g.drawLine(
                center.x,
                center.y,
                center.x+spinner.getDirection().getX(),
                center.y+spinner.getDirection().getY()
        );
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        drawSpinner(g);
    }

    public void nextTurn() {
        spinner.increaseTheta(increaseRate);
    }
}
