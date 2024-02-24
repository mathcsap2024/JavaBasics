package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Application implements Runnable{

    @Override
    public void run() {
        JFrame frame = new JFrame("Main Window");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel panel = (JPanel)frame.getContentPane();
        panel.setLayout(null);

        JButton button = new JButton("Click Me!");
        button.setLocation(new java.awt.Point(100,100));
        button.setSize(new Dimension(180,80));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        panel.add(button);

    }
}
