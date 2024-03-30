package Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Define an interface to notify the main panel after successful save
interface SaveListener {
    void onSaveSuccess();
}

public class SaveButton extends JPanel {
    private SaveListener saveListener; // Listener reference

    public SaveButton(SaveListener saveListener) {
        this.saveListener = saveListener; // Assign listener reference

        // Create the "Save" button
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the action when the "Save" button is clicked
                try {
                    saveWatchlistToFile();
                    JOptionPane.showMessageDialog(null, "Watchlist data saved successfully.", "Saved", JOptionPane.INFORMATION_MESSAGE);
                    // Notify the main panel after successful save
                    saveListener.onSaveSuccess();
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
        try (FileWriter writer = new FileWriter(filename, false); // Pass 'false' to overwrite the existing file
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

            // Write each movie's details to the file
            for (Movie movie : movieList.getMovies()) {
                bufferedWriter.write(movie.getTitle() + ", " + movie.getGenre() + ", " + movie.getReleaseYear());
                bufferedWriter.newLine(); // Move to the next line for the next movie
            }
        }
    }
}
