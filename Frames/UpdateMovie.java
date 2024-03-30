package Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateMovie extends JFrame {
    JLabel label = new JLabel();

    // Title bar
    JPanel titlePanel = new JPanel();
    JLabel textLabel = new JLabel("UPDATE MOVIE");

    // Update section panel
    GradientPanel updatePanel = new GradientPanel();
    JLabel titleLabel = new JLabel("Title: ");
    JTextField titleTextField = new JTextField();

    JLabel genreLabel = new JLabel("Genre: ");
    JTextField genreTextField = new JTextField();

    JLabel yearLabel = new JLabel("Year: ");
    JTextField yearTextField = new JTextField();

    JButton updateButton = new RoundButton("Update");

    boolean movieSelected = false;

    UpdateMovie(String currentTitle, String currentGenre, String currentYear) {
        // Title bar settings
        titlePanel.setBackground(new Color(255, 148, 148));
        titlePanel.setBounds(0, 0, 700, 60);

        // Title text label
        textLabel.setBounds(310, 10, 200, 40);
        textLabel.setForeground(new Color(255, 245, 228));
        textLabel.setFont(new Font("Serif", Font.ITALIC, 40));
        titlePanel.add(textLabel);

        // Update panel settings
        updatePanel.setBounds(0, 60, 700, 440);
        updatePanel.setLayout(null);
        updatePanel.setOpaque(false);

        // Add components to updatePanel
        titleLabel.setBounds(100, 30, 200, 100);
        titleLabel.setForeground(new Color(255, 148, 148));
        titleLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        titleTextField.setBounds(350, 60, 250, 40);
        titleTextField.setText(currentTitle);

        genreLabel.setBounds(100, 130, 200, 100);
        genreLabel.setForeground(new Color(255, 148, 148));
        genreLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        genreTextField.setBounds(350, 160, 250, 40);
        genreTextField.setText(currentGenre);

        yearLabel.setBounds(100, 230, 200, 100);
        yearLabel.setForeground(new Color(255, 148, 148));
        yearLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        yearTextField.setBounds(350, 260, 250, 40);
        yearTextField.setText(currentYear);

        updateButton.setBounds(290, 350, 120, 30);
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!movieSelected) {
                    JOptionPane.showMessageDialog(null, "Please select a movie before updating.");
                    return;
                }

                // Get updated movie information
                String newTitle = titleTextField.getText();
                String newGenre = genreTextField.getText();
                String newYear = yearTextField.getText();

                // Validate if a movie is selected
                if (newTitle.isEmpty() || newGenre.isEmpty() || newYear.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill out all fields.");
                    return;
                }

                // Update the movie (Implement this part according to your MovieList implementation)
                // For example:
                // movieList.updateMovie(currentTitle, newTitle, newGenre, newYear);

                JOptionPane.showMessageDialog(null, "Movie updated successfully!");
            }
        });

        updatePanel.add(titleLabel);
        updatePanel.add(titleTextField);
        updatePanel.add(genreLabel);
        updatePanel.add(genreTextField);
        updatePanel.add(yearLabel);
        updatePanel.add(yearTextField);
        updatePanel.add(updateButton);

        // Frame settings
        add(label);
        setTitle("WatchmeList");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        add(titlePanel);
        add(updatePanel);
    }

    private static class GradientPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Color color1 = new Color(255, 209, 209);
            Color color2 = new Color(255, 245, 228);

            GradientPaint gradient = new GradientPaint(0, 0, color1, getWidth(), getHeight(), color2);
            Graphics2D g2d = (Graphics2D) g;

            g2d.setPaint(gradient);
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    // Method to set movieSelected flag
    public void setNewMovie(boolean selected) {
        this.movieSelected = selected;
    }
}
