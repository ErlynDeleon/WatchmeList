package Frames;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MovieList {
    private static MovieList instance;
    private List<Movie> movies;

    private MovieList() {
        movies = new ArrayList<>();
    }

    public static MovieList getInstance() {
        if (instance == null) {
            instance = new MovieList();
        }
        return instance;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void removeMovie(String title, String genre, int releaseYear) {
        Iterator<Movie> iterator = movies.iterator();
        while (iterator.hasNext()) {
            Movie movie = iterator.next();
            if (movie.getTitle().equals(title) && movie.getGenre().equals(genre) && movie.getReleaseYear() == releaseYear) {
                iterator.remove();
                break; 
            }
        }
    }
}


