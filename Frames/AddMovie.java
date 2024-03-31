package Frames;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMovie extends JFrame {
    JLabel label = new JLabel();

    // title bar
    JPanel titlePanel = new JPanel();
    JLabel textLabel = new JLabel("ADD MOVIE");

    // add section panel
    GradientPanel addPanel = new GradientPanel();
    JLabel titleLabel = new JLabel("Title: ");
    JTextField titleTextField = new JTextField();

    JLabel genreLabel = new JLabel("Genre: ");
    JTextField genreTextField = new JTextField();

    JLabel yearLabel = new JLabel("Year: ");
    JTextField yearTextField = new JTextField();

    JButton submitButton = new RoundButton("Submit");

    AddMovie() {
        // title bar settings
        titlePanel.setBackground(new Color(255, 148, 148));
        titlePanel.setBounds(0, 0, 700, 60);

        //title text label 
        textLabel.setBounds(355, 10, 200, 40);
        textLabel.setForeground(new Color(255, 245, 228));
        textLabel.setFont(new Font("Serif", Font.ITALIC, 40));
        titlePanel.add(textLabel);

        // add panel settings
        addPanel.setBounds(0, 60, 700, 440);
        addPanel.setLayout(null);
        addPanel.setOpaque(false);

        // add components to addPanel
        titleLabel.setBounds(100, 30, 200, 100);
        titleLabel.setForeground(new Color(255, 148, 148));
        titleLabel.setFont(new Font("Serif", Font.PLAIN, 40));
        titleTextField.setBounds(350, 60, 250, 40);

        genreLabel.setBounds(100, 130, 200, 100);
        genreLabel.setForeground(new Color(255, 148, 148));
        genreLabel.setFont(new Font("Serif", Font.PLAIN, 40));
        genreTextField.setBounds(350, 160, 250, 40);

        yearLabel.setBounds(100, 230, 200, 100);
        yearLabel.setForeground(new Color(255, 148, 148));
        yearLabel.setFont(new Font("Serif", Font.PLAIN, 40));
        yearTextField.setBounds(350, 260, 250, 40);

        submitButton.setBounds(290, 350, 100, 30);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleTextField.getText();
                String genre = genreTextField.getText();
                String yearText = yearTextField.getText();

                if (title.isEmpty() || genre.isEmpty() || yearText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill out all fields.");
                    titleTextField.setText("");
                    genreTextField.setText("");
                    yearTextField.setText("");
                    return;
                }

                int year;
                try {
                    year = Integer.parseInt(yearText);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid year format. Please enter a valid year.");
                    yearTextField.setText("");
                    return;
                }

                List<Movie> movies = MovieList.getInstance().getMovies();
                for (Movie movie : movies) {
                    if (movie.getTitle().equalsIgnoreCase(title)) {
                        JOptionPane.showMessageDialog(null, "Movie with the same title already exists.");
                        return;
                    }
                }

                Movie newMovie = new Movie(title, genre, year);

                MovieList.getInstance().addMovie(newMovie);

                JOptionPane.showMessageDialog(null, "Movie added successfully!");

                dispose();
            }
        });

        addPanel.add(titleLabel);
        addPanel.add(titleTextField);
        addPanel.add(genreLabel);
        addPanel.add(genreTextField);
        addPanel.add(yearLabel);
        addPanel.add(yearTextField);
        addPanel.add(submitButton);

        // frame settings
        add(label);
        setTitle("WatchmeList");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setVisible(true);
        ImageIcon icon = new ImageIcon("Frames\\pictures\\photo_2024-03-30_23-39-13.jpg");
        setIconImage(icon.getImage());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(titlePanel);
        add(addPanel);
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
