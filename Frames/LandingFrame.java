//pagawa ng design para sa icon tas title

package Frames;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LandingFrame extends JFrame  implements ActionListener {
  JLabel label = new JLabel();
  JButton button = new JButton("Continue"); 
  //ImageIcon image = new ImageIcon("");
  Border border = BorderFactory.createLineBorder(new Color(254, 200, 216), 5);

    LandingFrame() {
        //frame settings
        add(label);
        setTitle("WatchmeList");
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(new GradientPanel());
        setResizable(false);
        setLayout(null);
        setVisible(true);
        //ImageIcon icon = new ImageIcon("");
        //setIconImage(icon.getImage());

        // image/logo design
        //label.setIcon(image);
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);

        // button design to continue to next window
        button.setBounds(475, 500, 150, 50);
        button.setFocusable(false);
        button.setBackground(new Color(210, 145, 188));
        button.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        button.setBorder(BorderFactory.createLineBorder(new Color(149, 125, 173), 3));
        button.addActionListener((ActionListener) this);
        add(button);
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
            HomeFrame home= new HomeFrame();
            home.setVisible(true);
            home.setLocationRelativeTo(null);
            this.dispose();
          }
    }
}