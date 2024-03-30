package Frames;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LandingFrame extends JFrame implements ActionListener {
    GradientButton button = new GradientButton("Continue");
    ImageIcon image = new ImageIcon("Frames\\pictures\\photo_2024-03-31_00-00-54-removebg-preview.png");
    Border border = BorderFactory.createLineBorder(new Color(254, 200, 216), 5);

    LandingFrame() {
        // Frame settings
        setTitle("WatchmeList");
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setVisible(true);
        ImageIcon icon = new ImageIcon("Frames\\pictures\\photo_2024-03-30_23-39-13.jpg");
        setIconImage(icon.getImage());

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1100, 700));
        setContentPane(layeredPane);

        JLabel imageLabel = new JLabel(image);
        imageLabel.setBounds(0, 150, 1100, 300); 
        layeredPane.add(imageLabel, JLayeredPane.DEFAULT_LAYER);

        GradientPanel gradientPanel = new GradientPanel();
        gradientPanel.setBounds(0, 0, 1100, 700); 
        layeredPane.add(gradientPanel, JLayeredPane.DEFAULT_LAYER);

        button.setBounds(475, 450, 150, 50); 
        button.setFocusable(false);
        button.addActionListener(this);
        layeredPane.add(button, JLayeredPane.POPUP_LAYER);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            HomeFrame home = new HomeFrame();
            home.setVisible(true);
            home.setLocationRelativeTo(null);
            this.dispose();
        }
    }
}

class GradientButton extends JButton {
    public GradientButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setOpaque(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        int width = getWidth();
        int height = getHeight();

        GradientPaint gradientPaint = new GradientPaint(0, 0, Color.PINK, 0, height, Color.PINK);

        g2d.setPaint(gradientPaint);

        g2d.fillRect(0, 0, width, height);

        g2d.dispose();

        super.paintComponent(g);
    }
}
