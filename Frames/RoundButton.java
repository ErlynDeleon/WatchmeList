package Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RoundButton extends JButton {
    private Color backgroundColor;
    private Color foregroundColor;
    private Color hoverColor;

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
        int arc = Math.min(width, height) / 4;

        g2d.setColor(getBackground());
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
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
