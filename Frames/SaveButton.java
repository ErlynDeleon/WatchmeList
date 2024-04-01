package Frames;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveButton {
    private SaveListener listener;

    public SaveButton(SaveListener listener) {
        this.listener = listener;
    }

    public void saveWatchlistToFile() throws IOException {
        // Check if any changes have been made
        if (MovieList.getInstance().isModified()) {
            // save the watchlist data to a file
            try (PrintWriter writer = new PrintWriter(new FileWriter("watchlist.txt"))) {
                for (Movie movie : MovieList.getInstance().getMovies()) {
                    writer.println(movie.getTitle() + ", " + movie.getGenre() + ", " + movie.getReleaseYear());
                }
                if (listener != null) {
                    listener.onSaveSuccess();
                }
            } catch (IOException ex) {
                // If an error occurs during saving, throw the exception
                throw ex;
            }
        } 
    }
}

