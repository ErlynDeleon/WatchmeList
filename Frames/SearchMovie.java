package Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SearchMovie extends JFrame {
    JPanel titlePanel = new JPanel();;
    JLabel textLabel;
    GradientPanel resultsPanel = new GradientPanel();;
    JButton okayButton = new RoundButton("Okay");;

    public SearchMovie(List<Movie> searchResults, String errorMessage) {
        initializeComponents(searchResults, errorMessage);
    }

    private void initializeComponents(List<Movie> searchResults, String errorMessage) {
        // Main frame settings
        setTitle("Search Results");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        // Create title panel
        titlePanel.setLayout(null);
        titlePanel.setBounds(0, 0, 700, 60);
        titlePanel.setBackground(new Color(255, 148, 148));
        add(titlePanel);

        // Create title label
        textLabel = new JLabel(searchResults != null && searchResults.size() > 1 ? "Search Results" : "Search Result");
        textLabel.setBounds(230, 10, 400, 40);
        textLabel.setForeground(new Color(255, 245, 228));
        textLabel.setFont(new Font("Serif", Font.ITALIC, 40));
        titlePanel.add(textLabel);

        // Create results panel
        resultsPanel.setLayout(null);
        resultsPanel.setBounds(0, 60, 700, 350);
        add(resultsPanel);

        // Display search results or error message
        if (searchResults != null && !searchResults.isEmpty()) {
            displaySearchResults(searchResults);
        } else {
            displayErrorMessage(errorMessage);
        }

        // Create "Okay" button
        okayButton.setBounds(290, 420, 100, 30);
        okayButton.addActionListener(e -> dispose());
        add(okayButton);

        setVisible(true);
    }

    private void displaySearchResults(List<Movie> searchResults) {
        int y = 5;
        for (Movie movie : searchResults) {
            JPanel moviePanel = new JPanel();
            moviePanel.setLayout(new BorderLayout());
            moviePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            moviePanel.setBackground(new Color(239, 188, 155));
            moviePanel.setBounds(50, y, 600, 60);

            JLabel movieLabel = new JLabel(movie.getTitle() + " - " + movie.getGenre() + " - " + movie.getReleaseYear());
            movieLabel.setHorizontalAlignment(SwingConstants.CENTER);
            moviePanel.add(movieLabel, BorderLayout.CENTER);

            resultsPanel.add(moviePanel);
            y += 70;
        }
    }

    private void displayErrorMessage(String errorMessage) {
        JLabel errorLabel = new JLabel(errorMessage);
        errorLabel.setBounds(50, 10, 600, 40);
        errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultsPanel.add(errorLabel);
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
}
