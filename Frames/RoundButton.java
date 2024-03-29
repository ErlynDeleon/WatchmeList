package Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class RoundButton extends JButton {
    private Color backgroundColor;
    private Color foregroundColor;

    public RoundButton() {
        super();
        init();
    }

    public RoundButton(String text) {
        super(text);
        init();
    }

    private void init() {
        setOpaque(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setBackground(Color.WHITE); 
        setForeground(Color.BLACK); 
    }

    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
    }

    public void setForegroundColor(Color color) {
        this.foregroundColor = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(backgroundColor != null ? backgroundColor.brighter() : getBackground().brighter());
        } else {
            g.setColor(backgroundColor != null ? backgroundColor : getBackground());
        }
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth() - 1;
        int height = getHeight() - 1;
        int arc = Math.min(width, height) / 4; 
        g2d.fillRoundRect(0, 0, width, height, arc, arc);
        super.paintComponent(g);
        g2d.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(foregroundColor != null ? foregroundColor : getForeground());
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth() - 1;
        int height = getHeight() - 1;
        int arc = Math.min(width, height) / 4;
        g2d.drawRoundRect(0, 0, width, height, arc, arc);
        g2d.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(100, 50); 
    }

    @Override
    public Dimension getMinimumSize() {
        return new Dimension(100, 50); 
    }

    @Override
    public Dimension getMaximumSize() {
        return new Dimension(100, 50); 
    }
}
