package Frames;

import javax.swing.*;
import java.awt.*;

public class LandingFrame extends JFrame {

    public LandingFrame() {
        setTitle("My Watchlist Application");
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(new GradientPanel());
    }

    private static class GradientPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            GradientPaint gradient = new GradientPaint(0, 0, Color.PINK, getWidth(), getHeight(), Color.WHITE);

            Graphics2D g2d = (Graphics2D) g;
            g2d.setPaint(gradient);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
    }
}