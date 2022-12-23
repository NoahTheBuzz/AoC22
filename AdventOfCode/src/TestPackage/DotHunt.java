package TestPackage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DotHunt extends JFrame implements MouseMotionListener {
    // size of the game window
    static final int WIDTH = 800;
    static final int HEIGHT = 600;

    // the dot that will be chasing the crosses
    static final int DOT_SIZE = 20;
    int dotX = WIDTH / 2;
    int dotY = HEIGHT / 2;

    // the crosses that the dot will be chasing
    static final int CROSS_SIZE = 10;
    int[] crossX = new int[10];
    int[] crossY = new int[10];

    public static void main(String[] args) {
        new DotHunt().setVisible(true);
    }

    public DotHunt() {
        // set up the window
        setSize(WIDTH, HEIGHT);
        setTitle("Dot Hunt");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // initialize the positions of the crosses
        for (int i = 0; i < crossX.length; i++) {
            crossX[i] = (int)(Math.random() * WIDTH);
            crossY[i] = (int)(Math.random() * HEIGHT);
        }

        // listen for mouse movement
        addMouseMotionListener(this);
    }

    public void paint(Graphics g) {
        // draw the dot
        g.setColor(Color.RED);
        g.fillOval(dotX, dotY, DOT_SIZE, DOT_SIZE);

        // draw the crosses
        g.setColor(Color.BLACK);
        for (int i = 0; i < crossX.length; i++) {
            g.drawLine(crossX[i] - CROSS_SIZE, crossY[i] - CROSS_SIZE,
                    crossX[i] + CROSS_SIZE, crossY[i] + CROSS_SIZE);
            g.drawLine(crossX[i] - CROSS_SIZE, crossY[i] + CROSS_SIZE,
                    crossX[i] + CROSS_SIZE, crossY[i] - CROSS_SIZE);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // move the dot to the mouse cursor
        dotX = e.getX();
        dotY = e.getY();
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // move the dot to the mouse cursor
        dotX = e.getX();
        dotY = e.getY();
        repaint();
    }
}
