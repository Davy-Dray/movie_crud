/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.util.List;
import model.Movie;
import dao.MovieDAO;
import view.FormEvent;

/**
 *
 * @author ragnar
 */
public class MovieController {

    MovieDAO theMovie = new MovieDAO();    

    public List<Movie> getMovies() {

        return theMovie.getMovies();

    }

    public void saveToDb(FormEvent form) throws IOException {

        theMovie.save(form);

    }

    public void loadMovieFromDb() throws IOException {

        theMovie.loadMovieFromDb();

    }

    public void removeMovie(int row) {
        theMovie.removeMovie(row);
    }

    public boolean existsByName(String movieName) {

        return theMovie.existsByName(movieName);

    }
}
