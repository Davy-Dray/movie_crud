/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.*;
import Repository.MovieRepo;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import service.MovieService;
import view.FormEvent;

/**
 *
 * @author ragnar
 */
public class MovieDAO {

    List<Movie> movies;

    private final MovieService movieService = new MovieRepo();


    public MovieDAO() {
        movies = new ArrayList<>();
        
    }

    public void addMovie(Movie movie) {

        movies.add(movie);
    }

    public List<Movie> getMovies() {

        return movies = movieService.getAllMovies();
    }

    public void save(FormEvent form) throws IOException {

        String name = form.getName();
        String genre = form.getGenre();
        String theatre = form.getTheatre();
        Date showdate = form.getDate();
        float fee = form.getMovieFee();
        Time time = form.getStartTime();

        Movie movie = new Movie(name, genre, fee, time, showdate, theatre);

        List<Movie> myMovie = new ArrayList<>();
        myMovie.add(movie);
   
        movies.add(movie);
        movieService.saveMovie(myMovie);

    }

    public void loadMovieFromDb() throws IOException {

        movieService.getAllMovies();

    }

    public void removeMovie(int index) {

        movies.remove(index);
    }

    public boolean existsByName(String movieName) {

        return movieService.existsByName(movieName);

    }
}
