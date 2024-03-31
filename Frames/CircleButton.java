package Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CircleButton extends JButton {
    private Color backgroundColor;
    private Color foregroundColor;
    private Color hoverColor;
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
        setBackground(new Color(246, 246, 246)); 
        setForeground(Color.BLACK);
        hoverColor = new Color(255, 192, 203); 

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(new Color(246, 246, 246)); 
            }
        });
    }

    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
        setBackground(color);
    }

    public void setForegroundColor(Color color) {
        this.foregroundColor = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        int width = getWidth() - 1;
        int height = getHeight() - 1;

        g2d.setColor(getBackground());
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillOval(0, 0, width, height);

        super.paintComponent(g);

        if (iconImage != null) {
            int iconWidth = Math.min(iconImage.getWidth(this), width - 6);
            int iconHeight = Math.min(iconImage.getHeight(this), height - 6);
            int x = (width - iconWidth) / 2;
            int y = (height - iconHeight) / 2;
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
