package Frames;

import java.util.ArrayList;
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
}

