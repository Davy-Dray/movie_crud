package service;


import java.util.List;
import model.Movie;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ragnar
 */
public interface MovieService {

  //  Movie findByName(String movieName);

    public  List<Movie> getAllMovies();

    boolean existsByName(String movieName);

    public void saveMovie(List<Movie> movieList);

}
