
/* 
  SearchMovie(){
    //frame settings
        add(label);
        setTitle("WatchmeList");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        ImageIcon icon = new ImageIcon("Frames\\pictures\\photo_2024-03-30_23-39-13.jpg");
        setIconImage(icon.getImage());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
  }
}
*/

package Frames;

import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.*;

public class SearchMovie extends JFrame {
  JLabel label = new JLabel();
  private JTextArea resultArea;

  SearchMovie() {
    // background color of the window
    getContentPane().setBackground(new Color(131, 88, 88));

    // layout to BorderLayout
    setLayout(new BorderLayout());

    // create the result area with the specified color
    resultArea = new JTextArea(10, 30);
    resultArea.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(resultArea);
    scrollPane.setBackground(new Color(235, 212, 212)); // Set background color of the scroll pane
    add(scrollPane, BorderLayout.CENTER);

    // frame settings
    add(label);
    setTitle("WatchmeList");
    setSize(700, 500);
    setLocationRelativeTo(null);
    setResizable(false);
    ImageIcon icon = new ImageIcon("Frames\\pictures\\photo_2024-03-30_23-39-13.jpg");
    setIconImage(icon.getImage());
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setVisible(true);
  }

  // Your searchMovies() method and other methods go here
}

/*
 * public void searchMovies(String searchText) {
 * List<Movie> movies = MovieList.getInstance().getMovies();
 * 
 * // Perform interpolation search
 * int index = interpolationSearch(searchText, movies);
 * 
 * // Display matched movies
 * if (index != -1) {
 * resultArea.setText("");
 * resultArea.append("Title: " + movies.get(index).getTitle() + "\n");
 * resultArea.append("Genre: " + movies.get(index).getGenre() + "\n");
 * resultArea.append("Year: " + movies.get(index).getReleaseYear() + "\n\n");
 * } else {
 * resultArea.setText("No movies found.");
 * }
 * revalidate();
 * repaint();
 * }
 * 
 * private int interpolationSearch(String searchText, List<Movie> movies) {
 * int low = 0;
 * int high = movies.size() - 1;
 * 
 * while (low <= high &&
 * searchText.compareToIgnoreCase(movies.get(low).getTitle()) >= 0 &&
 * searchText.compareToIgnoreCase(movies.get(high).getTitle()) <= 0) {
 * 
 * // Interpolation formula
 * double fraction = (double) (searchText.toLowerCase().hashCode()
 * - movies.get(low).getTitle().toLowerCase().hashCode()) /
 * (movies.get(high).getTitle().toLowerCase().hashCode() -
 * movies.get(low).getTitle().toLowerCase().hashCode());
 * int pos = low + (int) ((high - low) * fraction);
 * 
 * // Check if the found position is out of bounds
 * if (pos < 0 || pos >= movies.size()) {
 * return -1; // Not found
 * }
 * 
 * // Compare the movie title at the found position with the search text
 * int titleComparison =
 * searchText.compareToIgnoreCase(movies.get(pos).getTitle());
 * 
 * if (titleComparison == 0) {
 * return pos; // Found
 * } else if (titleComparison < 0) {
 * high = pos - 1; // Move to the left half
 * } else {
 * low = pos + 1; // Move to the right half
 * }
 * }
 * return -1; // Not found
 * }
 * }
 * 
 */
