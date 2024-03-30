package Frames;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.text.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

interface SaveListener {
    void onSaveSuccess();
}

public class HomeFrame extends JFrame implements ActionListener, SaveListener {
    JLabel label = new JLabel();

    // For navigation panel
    JPanel navigationPanel = new JPanel(null);
    ImageIcon addImageIcon = new ImageIcon("Frames\\pictures\\plus.png");
    JButton addButton = new CircleButton(addImageIcon);
    ImageIcon removeImageIcon = new ImageIcon("Frames\\pictures\\trash.png");
    JButton removeButton = new CircleButton(removeImageIcon);
    ImageIcon updateImageIcon = new ImageIcon("Frames\\pictures\\refresh.png");
    JButton updateButton = new CircleButton(updateImageIcon);
    JButton saveButton = new RoundButton("Save");
    JButton exitButton = new RoundButton("Continue");

    // For menu bar
    JPanel menuBar = new JPanel(null);
    ImageIcon searchImageIcon = new ImageIcon("Frames\\pictures\\search.png");
    JButton searchButton = new CircleButton(searchImageIcon);
    JTextField searchTextField = new JTextField();
    ImageIcon logoImageIcon = new ImageIcon();

    // For main panel
    JPanel mainPanel = new JPanel(null);

    HomeFrame() {
        // Navigation panel settings
        navigationPanel.setBackground(new Color(135, 133, 162));
        navigationPanel.setBounds(970, 0, 120, 700);

        // Navigation panel components
        // Add button settings
        addButton.setBounds(32, 170, 50, 50);
        addButton.addActionListener(this);
        navigationPanel.add(addButton);

        // Remove button settings
        removeButton.setBounds(32, 270, 50, 50);
        removeButton.addActionListener(this);
        navigationPanel.add(removeButton);

        // Update button settings
        updateButton.setBounds(32, 370, 50, 50);
        updateButton.addActionListener(this);
        navigationPanel.add(updateButton);

        // Save button settings
        saveButton.setBounds(5, 530, 105, 40);
        saveButton.addActionListener(this);
        navigationPanel.add(saveButton);

        // Continue button settings
        exitButton.setBounds(5, 580, 105, 40);
        exitButton.addActionListener(this);
        navigationPanel.add(exitButton);

        // Menu bar settings
        menuBar.setBackground(new Color(255, 148, 148));
        menuBar.setBounds(0, 0, 970, 60);

        // Menu bar components
        // Search text field settings
        searchTextField.setBounds(450, 10, 430, 40);
        menuBar.add(searchTextField);

        // Search button settings
        searchButton.setBounds(900, 5, 50, 50);
        searchButton.addActionListener(this);
        menuBar.add(searchButton);

        // Main panel settings
        mainPanel.setBackground(new Color(246, 246, 246));
        mainPanel.setBounds(0, 60, 970, 660);

        // Load movies from the watchlist file
        loadMoviesFromWatchlist();

        // Frame settings
        add(label);
        setTitle("WatchmeList");
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setVisible(true);
        ImageIcon icon = new ImageIcon("Frames\\pictures\\photo_2024-03-30_23-39-13.jpg");
        setIconImage(icon.getImage());
        add(navigationPanel);
        add(menuBar);
        add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // For navigation buttons
        if (e.getSource() == addButton) {
            AddMovie add = new AddMovie();
            add.setVisible(true);
            add.setLocationRelativeTo(null);

            add.addWindowListener((WindowListener) new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    displayMovies();
                }
            });
        } else if (e.getSource() == removeButton) {
            if (mainPanel.getComponentCount() == 0) {
                JOptionPane.showMessageDialog(null, "There are no movies to remove. Please add movies first.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            boolean anySelected = false;
            for (Component component : mainPanel.getComponents()) {
                if (component instanceof JPanel) {
                    JPanel moviePanel = (JPanel) component;
                    JCheckBox checkBox = (JCheckBox) moviePanel.getComponent(3);
                    if (checkBox.isSelected()) {
                        anySelected = true;
                        break;
                    }
                }
            }
            if (!anySelected) {
                JOptionPane.showMessageDialog(null, "Please select a movie to remove.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove the selected movies?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                Component[] components = mainPanel.getComponents();
                for (Component component : components) {
                    if (component instanceof JPanel) {
                        JPanel moviePanel = (JPanel) component;
                        JCheckBox checkBox = (JCheckBox) moviePanel.getComponent(3);
                        if (checkBox.isSelected()) {
                            mainPanel.remove(moviePanel);
                            String title = ((JLabel) moviePanel.getComponent(0)).getText().substring(7);
                            String genre = ((JLabel) moviePanel.getComponent(1)).getText().substring(7);
                            int releaseYear = Integer.parseInt(((JLabel) moviePanel.getComponent(2)).getText().substring(6));
                            MovieList.getInstance().removeMovie(title, genre, releaseYear);
                        }
                    }
                }
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        } else if (e.getSource() == updateButton) {
           // UpdateMovie update = new UpdateMovie();
           // update.setVisible(true);
           // update.setLocationRelativeTo(null);
        } else if (e.getSource() == saveButton) {
            try {
                SaveButton saveButton = new SaveButton(this); 
                saveButton.saveWatchlistToFile();
                JOptionPane.showMessageDialog(null, "Watchlist data saved successfully.", "Saved", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Failed to save watchlist data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == exitButton) {
            ProgrammersProfileExit profileExit = new ProgrammersProfileExit();
            profileExit.setVisible(true);
            profileExit.setLocationRelativeTo(null);
            this.dispose();
        }
        // For menu bar button
        else if (e.getSource() == searchButton) {
            SearchMovie searchMovie = new SearchMovie();
            searchMovie.setVisible(true);
            searchMovie.setLocationRelativeTo(null);
        }
    }

    private void displayMovies() {
        mainPanel.removeAll();

        List<Movie> movies = MovieList.getInstance().getMovies();
    
        mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 33, 40));
    
        int count = 0; 
    
        for (Movie movie : movies) {
            if (count >= 12) {
                JOptionPane.showMessageDialog(null, "We apologize, but the program cannot handle more than 12 movies at once. Please remove a movie to add another one.", "Limit Exceeded", JOptionPane.ERROR_MESSAGE);
                break; 
            }
    
            JPanel moviePanel = new JPanel(new GridLayout(4, 1));
            moviePanel.setBackground(new Color(255, 199, 199));
            moviePanel.setBorder(BorderFactory.createLineBorder(Color.black));
    
            JLabel titleLabel = new JLabel("Title: " + movie.getTitle());
            JLabel genreLabel = new JLabel("Genre: " + movie.getGenre());
            JLabel yearLabel = new JLabel("Year: " + movie.getReleaseYear());
    
            JCheckBox checkBox = new JCheckBox();
    
            moviePanel.setPreferredSize(new Dimension(200, 150));
    
            moviePanel.add(titleLabel);
            moviePanel.add(genreLabel);
            moviePanel.add(yearLabel);
            moviePanel.add(checkBox);
    
            mainPanel.add(moviePanel);
            count++; 
        }
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void loadMoviesFromWatchlist() {
        try (BufferedReader reader = new BufferedReader(new FileReader("watchlist.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length >= 3) {
                    String title = parts[0];
                    String genre = parts[1];
                    int releaseYear = Integer.parseInt(parts[2]);
                    Movie movie = new Movie(title, genre, releaseYear);
                    MovieList.getInstance().addMovie(movie);
                }
            }
            displayMovies();
        } catch (IOException | NumberFormatException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void onSaveSuccess() {
        displayMovies();
        JOptionPane.showMessageDialog(this, "Watchlist data saved successfully.", "Saved", JOptionPane.INFORMATION_MESSAGE);
    }
}
