import models.Movie;
import services.RecommendationService;
import utils.DataLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialize the movie recommendation engine
        DataLoader dataLoader = new DataLoader();
        ArrayList<Movie> movies = dataLoader.loadMovies();

        // Create a recommendation service
        RecommendationService recommendationService = new RecommendationService(movies);

        // Simulate user interaction
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Movie Recommendation Engine!");
        System.out.print("Enter your preferred genre: ");
        String genre = scanner.nextLine().trim().toLowerCase();

        // Get recommendations based on user input
        List<Movie> recommendedMovies = recommendationService.recommendByGenre(genre);
        
        // Display recommended movies
        if (recommendedMovies.isEmpty()) {
            System.out.println("No movies found for the genre: " + genre);
        } else {
            System.out.println("Recommended Movies:");
            for (Movie movie : recommendedMovies) {
                System.out.println(movie.getDetails());
            }
        }

        System.out.print("Enter minimum rating for recommendations: ");
        double rating = scanner.nextDouble();

        // Get recommendations based on rating
        List<Movie> recommendedByRating = recommendationService.recommendByRating(rating);

        // Display recommended movies by rating
        if (recommendedByRating.isEmpty()) {
            System.out.println("No movies found with rating >= " + rating);
        } else {
            System.out.println("Recommended Movies by Rating:");
            for (Movie movie : recommendedByRating) {
                System.out.println(movie.getDetails());
            }
        }

        scanner.close();
    }
}