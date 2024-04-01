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
    public boolean isModified() {
    
        return !movies.isEmpty();
    }
    

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> getMovies() {
        return movies;
    }
    

    public void updateMovie(String currentTitle, String currentGenre, int currentYear, String newTitle, String newGenre, int newYear) {
        for (Movie movie : movies) {
            if (movie.getTitle().equals(currentTitle) && movie.getGenre().equals(currentGenre) && movie.getReleaseYear() == currentYear) {
                movie.setTitle(newTitle);
                movie.setGenre(newGenre);
                movie.setReleaseYear(newYear);
                break;
            }
        }
    }

    public void removeMovie(String title, String genre, int releaseYear) {
        movies.removeIf(movie ->
                movie.getTitle().equals(title) &&
                        movie.getGenre().equals(genre) &&
                        movie.getReleaseYear() == releaseYear
        );
    }

    public Movie searchMovieByTitle(String title) {
        sortMovies();
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

    public void sortMovies() {
        Collections.sort(movies, Comparator.comparing(Movie::getTitle));
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

    public List<Movie> searchMovieByReleaseYear(int releaseYear) {
        List<Movie> results = new ArrayList<>();
    
        Collections.sort(movies, Comparator.comparingInt(Movie::getReleaseYear));
    
        int low = 0;
        int high = movies.size() - 1;
    
        while (low <= high && releaseYear >= movies.get(low).getReleaseYear() && releaseYear <= movies.get(high).getReleaseYear()) {
            // Calculate the position using interpolation formula
            int pos = low + ((releaseYear - movies.get(low).getReleaseYear()) * (high - low) / (movies.get(high).getReleaseYear() - movies.get(low).getReleaseYear()));
    
            if (movies.get(pos).getReleaseYear() == releaseYear) {
                // If the movie at pos matches the release year, include it in the results
                results.add(movies.get(pos));
    
                // Check for other movies with the same release year towards the left
                int left = pos - 1;
                while (left >= low && movies.get(left).getReleaseYear() == releaseYear) {
                    results.add(movies.get(left));
                    left--;
                }
    
                // Check for other movies with the same release year towards the right
                int right = pos + 1;
                while (right <= high && movies.get(right).getReleaseYear() == releaseYear) {
                    results.add(movies.get(right));
                    right++;
                }
    
                return results;
            }
    
            if (movies.get(pos).getReleaseYear() < releaseYear) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }
    
        return results;
    }
}    