package Frames;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ProgrammersProfileExit extends JFrame implements ActionListener {
    // Main panel
    private JPanel mainPanel = new JPanel();
    private static List<Programmer> programmers = new ArrayList<>();

    // Button exit panel
    private JPanel exitPanel = new JPanel();
    private JButton exitButton = new JButton("EXIT");

    ProgrammersProfileExit() {
        // Frame settings
        this.setTitle("WatchmeList");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(243, 248, 255));
        this.setResizable(false);
        this.setSize(1100, 700);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);

        // Background gradient
        setContentPane(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                int w = getWidth();
                int h = getHeight();
                Color color1 = new Color(251, 213, 228);
                Color color2 = new Color(246, 230, 188);
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }
        });
        JPanel topMarginPanel = new JPanel();
        topMarginPanel.setPreferredSize(new Dimension(0, 80)); // Adjust the preferred size as needed
        this.add(topMarginPanel, BorderLayout.NORTH);

        // Title panel
        JLabel titleLabel = new JLabel("PROGRAMMERS", SwingConstants.CENTER);
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 30));
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.add(titleLabel, BorderLayout.CENTER);
        titlePanel.setOpaque(false); // Make the panel transparent
        this.add(titlePanel, BorderLayout.NORTH);

        // Main panel
        mainPanel.setLayout(new GridLayout(2, 2, 10, 10));
        mainPanel.setBackground(new Color(243, 248, 255));
        mainPanel.setOpaque(false);
        this.add(mainPanel, BorderLayout.CENTER);

        // Add programmers' profile panels
        for (Programmer programmer : programmers) {
            JPanel programmerPanel = createProgrammerPanel(programmer);
            mainPanel.add(programmerPanel);
        }

        exitButton.setFocusable(false);
        exitButton.setBackground(new Color(255, 182, 193));
        exitButton.setPreferredSize(new Dimension(200, 50));
        exitButton.addActionListener(this);

        // Create an empty border for padding
        Border paddingBorder = BorderFactory.createEmptyBorder(0, 0, 0, 0);
        // Create a soft bevel border
        Border softBevelBorder = BorderFactory.createSoftBevelBorder(SoftBevelBorder.RAISED);
        // Combine the two borders
        Border compoundBorder = BorderFactory.createCompoundBorder(paddingBorder, softBevelBorder);
        // Set the compound border to the button
        exitButton.setBorder(compoundBorder);

        exitPanel.setOpaque(false); // Make the panel transparent
        exitPanel.add(exitButton);

        // Layout adjustment for the exit button
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        // Make the bottom panel transparent
        bottomPanel.setOpaque(false);
        bottomPanel.add(exitPanel);
        this.add(bottomPanel, BorderLayout.SOUTH);
    }

    private JPanel createProgrammerPanel(Programmer programmer) {
        JPanel programmerPanel = new JPanel(new BorderLayout());
        programmerPanel.setBackground(new Color(255, 182, 193));
        programmerPanel.setOpaque(false);

        // Picture Panel
        JPanel picturePanel = new JPanel(new GridBagLayout());
        picturePanel.setBackground(new Color(255, 182, 193)); // Floral Pink
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER; // Center the image
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding around the image

        ImageIcon imageIcon = new ImageIcon(programmer.imagePath);
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH); // Larger size
        JLabel pictureLabel = new JLabel(new ImageIcon(image));
        picturePanel.add(pictureLabel, gbc);
        programmerPanel.add(picturePanel, BorderLayout.WEST);

        // Name, Role, and Role Panel
        JPanel nameRolePanel = new JPanel(new GridBagLayout());
        nameRolePanel.setBackground(new Color(255, 182, 193)); // Floral Pink
        GridBagConstraints nameRoleGbc = new GridBagConstraints();
        nameRoleGbc.anchor = GridBagConstraints.WEST;

        JLabel nameLabel = new JLabel(programmer.fullName);
        nameLabel.setForeground(new Color(0, 0, 0));
        nameLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
        nameRolePanel.add(nameLabel, nameRoleGbc);

        String[] roles = programmer.role.split(", ");
        JLabel roleLabel = new JLabel(roles[0]);
        roleLabel.setForeground(new Color(0, 0, 0));
        roleLabel.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
        GridBagConstraints roleGbc = new GridBagConstraints();
        roleGbc.anchor = GridBagConstraints.WEST;
        roleGbc.gridy = 1;
        nameRolePanel.add(roleLabel, roleGbc);

        programmerPanel.add(nameRolePanel, BorderLayout.CENTER);

        return programmerPanel;
    }

    static class Programmer {
        String imagePath;
        String fullName;
        String role;

        Programmer(String imagePath, String fullName, String role) {
            this.imagePath = imagePath;
            this.fullName = fullName;
            this.role = role;
        }
    }

    static {
        programmers.add(new Programmer("Frames\\pictures\\jhoana.jpeg", "Jhoana Decarla Barrameda", "Tester"));
        programmers.add(
                new Programmer("Frames\\pictures\\erlyn.jpeg", "Erlyn Queen De Leon", "Project and Layout Manager"));
        programmers.add(new Programmer("Frames\\pictures\\lyrine.jpeg", "Lyrine Poliarco", "Researcher"));
        programmers.add(new Programmer("Frames\\pictures\\angelica.jpeg", "Angelica Toquero", "Debugger"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

}
