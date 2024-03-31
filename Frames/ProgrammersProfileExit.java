package Frames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class ProgrammersProfileExit extends JFrame implements ActionListener {
    JLabel label = new JLabel();

    // title panel
    JLabel titleText = new JLabel("PROGRAMMERS");
    JPanel titlePanel = new JPanel();

    // main panel
    JPanel mainPanel = new JPanel(new GridLayout(2, 2));
    static List<Programmers> programmers = new ArrayList<>();

    // button exit panel
    JPanel exitPanel = new JPanel();
    JButton exitButton = new JButton("Exit");

    ProgrammersProfileExit() {
        // title panel
        titlePanel.setVisible(true);
        titlePanel.setBounds(0, 0, 800, 80);
        titlePanel.setBackground(new Color(226, 110, 229));
        this.add(titlePanel);

        titleText.setBounds(400, 60, 200, 60);
        titleText.setForeground(new Color(126, 48, 225));
        titleText.setFont(new Font("Monospaced", Font.BOLD, 50));
        titlePanel.add(titleText);

        // mainPanel
        mainPanel.setBounds(0, 80, 800, 900);
        mainPanel.setLayout(null);

        int panelWidth = 340;
        int panelHeight = 170;
        int gap = 20;
        int startX = 50;
        int startY = 40;

        for (Programmers programmer : programmers) {
            JPanel programmerPanel = new JPanel(new GridLayout(1, 2));
            programmerPanel.setBackground(new Color(255, 181, 235));
            programmerPanel.setBounds(startX, startY, panelWidth, panelHeight);
            mainPanel.add(programmerPanel);

            // Picture Panel
            JPanel picturePanel = new JPanel();
            picturePanel.setLayout(null);
            picturePanel.setBounds(0, 0, panelWidth, panelHeight);
            picturePanel.setBackground(new Color(255, 171, 171));
            programmerPanel.add(picturePanel);

            ImageIcon imageIcon = new ImageIcon(programmer.imagePath);
            Image image = imageIcon.getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH);
            ImageIcon scaledImageIcon = new ImageIcon(image);

            JLabel pictureLabel = new JLabel(scaledImageIcon);
            pictureLabel.setBounds(15, 10, 140, 140);
            picturePanel.add(pictureLabel);

            // Name and Role Panel
            JPanel nameRolePanel = new JPanel();
            nameRolePanel.setLayout(null);
            nameRolePanel.setBounds(panelWidth / 2, 0, panelWidth / 2, panelHeight);
            nameRolePanel.setBackground(new Color(255, 171, 171));
            programmerPanel.add(nameRolePanel);

            JLabel nameLabel = new JLabel(programmer.fullName);
            nameLabel.setForeground(Color.BLACK);
            nameLabel.setFont(new Font("Monospaced", Font.BOLD, 18));
            nameLabel.setBounds(10, 10, panelWidth / 2 - 20, 30);
            nameRolePanel.add(nameLabel);

            String[] roles = programmer.role.split(", ");

            // Main Role Label
            JLabel mainRoleLabel = new JLabel(roles[0]);
            mainRoleLabel.setForeground(Color.BLACK);
            mainRoleLabel.setFont(new Font("Monospaced", Font.PLAIN, 16));
            mainRoleLabel.setBounds(10, 60, panelWidth / 2 - 20, 20);
            nameRolePanel.add(mainRoleLabel);

            // Secondary Role Label
            if (roles.length > 1) {
                JLabel secondaryRoleLabel = new JLabel(roles[1]);
                secondaryRoleLabel.setForeground(Color.BLACK);
                secondaryRoleLabel.setFont(new Font("Monospaced", Font.PLAIN, 16));
                secondaryRoleLabel.setBounds(10, 90, panelWidth / 2 - 20, 20);
                nameRolePanel.add(secondaryRoleLabel);
            }

            startY += panelHeight + gap;
        }

        exitPanel.setBounds(0, 820, 800, 70);
        exitPanel.setBackground(new Color(226, 110, 229));
        mainPanel.add(exitPanel);

        exitButton.setFocusable(false);
        exitButton.setBackground(new Color(210, 145, 188));
        exitButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        exitButton.setBorder(BorderFactory.createLineBorder(new Color(149, 125, 173), 3));
        exitButton.setPreferredSize(new Dimension(200, 50));
        Dimension buttonSize = exitButton.getPreferredSize();

        int buttonX = (exitPanel.getWidth() - buttonSize.width) / 2;
        int buttonY = (exitPanel.getHeight() - buttonSize.height) / 2;

        exitButton.setBounds(buttonX, buttonY, buttonSize.width, buttonSize.height);
        exitButton.addActionListener(this);
        exitPanel.add(exitButton);

        setContentPane(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                // Define gradient colors
                Color color1 = new Color(239, 51, 177); // #EF33B1
                Color color2 = new Color(246, 230, 188); // #F6E6BC

                // Create gradient paint
                GradientPaint gradient = new GradientPaint(
                        0, 0, color1,
                        getWidth(), getHeight(), color2);

                // Set the gradient paint
                g2d.setPaint(gradient);

                // Fill the background with the gradient
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        });

        // Frame settings
        this.add(label);
        ImageIcon icon = new ImageIcon("Frames\\\\pictures\\\\photo_2024-03-30_23-39-13.jpg");
        this.setIconImage(icon.getImage());
        this.setTitle("WatchmeList");
        this.setSize(1100, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        // Add main panel to gradient background panel
        this.add(mainPanel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    static class Programmers {
        String imagePath;
        String fullName;
        String role;

        Programmers(String imagePath, String fullName, String role) {
            this.imagePath = imagePath;
            this.fullName = fullName;
            this.role = role;
        }
    }

    static {
        programmers.add(new Programmers("Frames\\pictures\\jhoana.jpeg", "Jhoana Decarla Barrameda", "Tester"));
        programmers.add(
                new Programmers("Frames\\pictures\\erlyn.jpeg", "Erlyn Queen De Leon", "Project and Layout Manager"));
        programmers.add(new Programmers("Frames\\pictures\\lyrine.jpeg", "Lyrine Poliarco", "Researcher"));
        programmers.add(new Programmers("Frames\\pictures\\angelica.jpeg", "Angelica Toquero", "Debugger"));
    }

}