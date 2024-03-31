package Frames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        movies.removeIf(movie ->
                movie.getTitle().equals(title) &&
                        movie.getGenre().equals(genre) &&
                        movie.getReleaseYear() == releaseYear
        );
    }

    public Movie searchMovieByTitle(String title) {
        int lo = 0;
        int hi = movies.size() - 1;

        while (lo <= hi && title.compareToIgnoreCase(movies.get(lo).getTitle()) >= 0 && title.compareToIgnoreCase(movies.get(hi).getTitle()) <= 0) {
            int pos = lo + ((hi - lo) / (movies.get(hi).getTitle().compareToIgnoreCase(movies.get(lo).getTitle()))) * (title.compareToIgnoreCase(movies.get(lo).getTitle()));

            if (movies.get(pos).getTitle().equalsIgnoreCase(title)) {
                return movies.get(pos);
            }

            if (movies.get(pos).getTitle().compareToIgnoreCase(title) < 0) {
                lo = pos + 1;
            } else {
                hi = pos - 1;
            }
        }
        return null;
    }

    public Movie searchMovieByGenre(String genre) {
        int lo = 0;
        int hi = movies.size() - 1;

        while (lo <= hi && genre.compareToIgnoreCase(movies.get(lo).getGenre()) >= 0 && genre.compareToIgnoreCase(movies.get(hi).getGenre()) <= 0) {
            int pos = lo + ((hi - lo) / (movies.get(hi).getGenre().compareToIgnoreCase(movies.get(lo).getGenre()))) * (genre.compareToIgnoreCase(movies.get(lo).getGenre()));

            if (movies.get(pos).getGenre().equalsIgnoreCase(genre)) {
                return movies.get(pos);
            }

            if (movies.get(pos).getGenre().compareToIgnoreCase(genre) < 0) {
                lo = pos + 1;
            } else {
                hi = pos - 1;
            }
        }
        return null;
    }

    public Movie searchMovieByReleaseYear(int releaseYear) {
        Collections.sort(movies, Comparator.comparingInt(Movie::getReleaseYear));

        int lo = 0;
        int hi = movies.size() - 1;

        if (movies.isEmpty()) {
            return null;
        }

        if (releaseYear < movies.get(0).getReleaseYear() || releaseYear > movies.get(hi).getReleaseYear()) {
            return null;
        }

        while (lo <= hi && releaseYear >= movies.get(lo).getReleaseYear() && releaseYear <= movies.get(hi).getReleaseYear()) {
            int yearRange = movies.get(hi).getReleaseYear() - movies.get(lo).getReleaseYear();

            if (yearRange == 0) {
                return movies.get(lo);
            }

            int pos = lo + ((hi - lo) / yearRange) * (releaseYear - movies.get(lo).getReleaseYear());

            if (movies.get(pos).getReleaseYear() == releaseYear) {
                return movies.get(pos);
            }

            if (movies.get(pos).getReleaseYear() < releaseYear) {
                lo = pos + 1;
            } else {
                hi = pos - 1;
            }
        }
        return null;
    }
}
