package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Application implements Runnable{

    private Random random;

    @Override
    public void run() {
        random = new Random();

        JFrame frame = new JFrame("Main Window");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel mainPanel = (JPanel)frame.getContentPane();
        MyPanel panel = new MyPanel();
        mainPanel.add(panel);

        panel.setLayout(null);

        JButton button = new JButton("Click Me!");
        button.setLocation(new java.awt.Point(100,100));
        button.setSize(new Dimension(180,80));

        button.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyChar()=='R') {
                    panel.setBackground(Color.RED);
                }
                if(e.getKeyChar()=='Y') {
                    panel.setBackground(Color.YELLOW);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panel.setBackground(Color.CYAN);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                button.setLocation(
                        random.nextInt(panel.getWidth()-10),
                        random.nextInt(panel.getHeight()-8)
                );
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        button.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(Color.BLUE);
            }
        });

        panel.add(button);

        Timer timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.setLocation(
                        random.nextInt(panel.getWidth()-10),
                        random.nextInt(panel.getHeight()-8)
                );
            }
        });
        timer.start();
    }
}
