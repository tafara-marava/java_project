package services;

import models.Movie;
import java.util.ArrayList;
import java.util.List;

public class RecommendationService {
    private List<Movie> movies;

    public RecommendationService(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> recommendByGenre(String genre) {
        List<Movie> recommendedMovies = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getGenre().equalsIgnoreCase(genre)) {
                recommendedMovies.add(movie);
            }
        }
        return recommendedMovies;
    }

    public List<Movie> recommendByRating(double rating) {
        List<Movie> recommendedMovies = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getRating() >= rating) {
                recommendedMovies.add(movie);
            }
        }
        return recommendedMovies;
    }
}