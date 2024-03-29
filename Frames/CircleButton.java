package Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;

public class CircleButton extends JButton {
    private Color backgroundColor;
    private Color foregroundColor;
    private Image iconImage;

    public CircleButton() {
        super();
        init();
    }

    public CircleButton(String text) {
        super(text);
        init();
    }

    public CircleButton(Icon icon) {
        super(icon);
        init();
    }

    public CircleButton(String text, Icon icon) {
        super(text, icon);
        init();
    }

    public CircleButton(ImageIcon icon) {
        super();
        this.iconImage = icon.getImage();
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
        g2d.fillOval(0, 0, getWidth() - 1, getHeight() - 1);
        super.paintComponent(g);
        if (iconImage != null) {
            int iconWidth = Math.min(iconImage.getWidth(this), getWidth() - 6); 
            int iconHeight = Math.min(iconImage.getHeight(this), getHeight() - 6); 
            int x = (getWidth() - iconWidth) / 2;
            int y = (getHeight() - iconHeight) / 2;
            g.drawImage(iconImage, x, y, iconWidth, iconHeight, this);
        }
        g2d.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(foregroundColor != null ? foregroundColor : getForeground());
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawOval(0, 0, getWidth() - 1, getHeight() - 1);
        g2d.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(50, 50); 
    }

    @Override
    public Dimension getMinimumSize() {
        return new Dimension(50, 50); 
    }

    @Override
    public Dimension getMaximumSize() {
        return new Dimension(50, 50); 
    }
}
