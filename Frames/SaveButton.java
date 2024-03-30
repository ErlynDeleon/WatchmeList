package Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class SaveButton extends JPanel {
    public SaveButton() {
        // Since we're using JPanel as the base class, we don't need to call super() explicitly
        //setLayout(new BorderLayout()); // No need for layout in this case
        
        // Create the "Save" button
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the action when the "Save" button is clicked
                try {
                    saveWatchlistToFile();
                    JOptionPane.showMessageDialog(null, "Watchlist data saved successfully.", "Saved", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Failed to save watchlist data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        // Add the button to the panel
        add(saveButton); // Add button directly to this panel
    }

    void saveWatchlistToFile() throws IOException {
        // Get the watchlist from MovieList singleton
        MovieList movieList = MovieList.getInstance();
        String filename = "watchlist.txt"; // Define the filename for saving the watchlist
        
        // Open a FileWriter with append mode to avoid overwriting existing data
        try (FileWriter writer = new FileWriter(filename, true); // false pag gusto idelete
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

            // Write each movie's details to the file
            for (Movie movie : movieList.getMovies()) {
                bufferedWriter.write(movie.getTitle() + ", " + movie.getGenre() + ", " + movie.getReleaseYear());
                bufferedWriter.newLine(); // Move to the next line for the next movie
            }
        }
    }
}
