package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import models.Movie;

public class DataLoader {
    private List<Movie> movieList;

    public DataLoader() {
        movieList = new ArrayList<>();
    }

    public List<Movie> loadMovies(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] movieData = line.split(",");
                if (movieData.length == 3) {
                    String title = movieData[0].trim();
                    String genre = movieData[1].trim();
                    double rating = Double.parseDouble(movieData[2].trim());
                    Movie movie = new Movie(title, genre, rating);
                    movieList.add(movie);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movieList;
    }

    public ArrayList<Movie> loadMovies() {
        ArrayList<Movie> movies = new ArrayList<>();
        // Sci-Fi movies
        movies.add(new Movie("Inception", "Sci-Fi", 8.8));
        movies.add(new Movie("Interstellar", "Sci-Fi", 8.6));
        movies.add(new Movie("The Matrix", "Sci-Fi", 8.7));
        movies.add(new Movie("Blade Runner 2049", "Sci-Fi", 8.0));
        
        // Action movies
        movies.add(new Movie("The Dark Knight", "Action", 9.0));
        movies.add(new Movie("Mad Max: Fury Road", "Action", 8.1));
        movies.add(new Movie("John Wick", "Action", 7.4));
        movies.add(new Movie("Gladiator", "Action", 8.5));
        
        // Drama movies
        movies.add(new Movie("The Prestige", "Drama", 8.5));
        movies.add(new Movie("Forrest Gump", "Drama", 8.8));
        movies.add(new Movie("The Shawshank Redemption", "Drama", 9.3));
        movies.add(new Movie("Fight Club", "Drama", 8.8));
        
        // Thriller movies
        movies.add(new Movie("Memento", "Thriller", 8.4));
        movies.add(new Movie("Se7en", "Thriller", 8.6));
        movies.add(new Movie("Gone Girl", "Thriller", 8.1));
        movies.add(new Movie("Zodiac", "Thriller", 7.7));
        
        // Comedy movies
        movies.add(new Movie("The Grand Budapest Hotel", "Comedy", 8.1));
        movies.add(new Movie("Superbad", "Comedy", 7.6));
        movies.add(new Movie("Step Brothers", "Comedy", 6.9));
        movies.add(new Movie("Anchorman: The Legend of Ron Burgundy", "Comedy", 7.2));
        
        return movies;
    }
}