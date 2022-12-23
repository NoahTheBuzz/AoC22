package TestPackage;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SinusGraph extends JPanel {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final double SCALE = 50;

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Zeichne die x- und y-Achse
        g.drawLine(0, HEIGHT / 2, WIDTH, HEIGHT / 2);
        g.drawLine(WIDTH / 2, 0, WIDTH / 2, HEIGHT);

        // Berechne die Koordinaten des Sinus-Graphs
        int x0 = 0;
        int y0 = (int) (SCALE * Math.sin(x0));
        for (int x = 1; x < WIDTH; x++) {
            int y = (int) (SCALE * Math.sin(x / SCALE));
            g.drawLine(x0 + WIDTH / 2, y0 + HEIGHT / 2, x + WIDTH / 2, y + HEIGHT / 2);
            x0 = x;
            y0 = y;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SinusGraph());
        frame.setVisible(true);
    }
}