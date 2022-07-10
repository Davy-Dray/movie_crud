/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import dao.ConnectingDb;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Movie;
import service.MovieService;
import utils.Theatres;

/**
 *
 * @author ragnar
 */
public class MovieRepo implements MovieService {

    static ConnectingDb db = new ConnectingDb();
    Theatres theatres = new Theatres();

    @Override
    public List<Movie> getAllMovies() {

        List<Movie> movieList = new ArrayList<>();

        try {
            Connection connection = db.getConnection();

            Statement selectStatement = connection.createStatement();

            ResultSet results = selectStatement.executeQuery("select * from movies");

            while (results.next()) {
                String movieName = results.getString("Movie_Name");
                String movieGenre = results.getString("Movie_Info");
                float fee = results.getFloat("Viewing_Fee");
                Time startTime = results.getTime("Start_Time");

                Date showDate = results.getDate("showing_from");

                String viewingTheatre = results.getString("Streaming_theatre");

                Movie myMovie = new Movie(movieName, movieGenre, fee, startTime, showDate, viewingTheatre);

                movieList.add(myMovie);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MovieRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return movieList;

    }

    @Override
    public void saveMovie(List<Movie> movieList) {

        movieList.forEach(movie -> {
            try {
                String movieName = movie.getMovieName();

                String movieGenre = movie.getGenre();

                float fee = movie.getMovieFee();

                Time startTime = movie.getStartTime();

                Date showDate = movie.getShowingFrom();

                String viewingTheatre = movie.getTheatre();

                Movie myMovie = new Movie(movieName, movieGenre, fee, startTime, showDate, viewingTheatre);

                addMovie(myMovie);
            } catch (SQLException ex) {
                Logger.getLogger(MovieRepo.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

    private static void addMovie(Movie movie) throws SQLException {

        Connection connection = db.getConnection();

        PreparedStatement preparedstatement = connection.prepareStatement(ConnectingDb.INSERT_INTO_MOVIE_TABLE);

        preparedstatement.setString(1, movie.getMovieName());
        preparedstatement.setString(2, movie.getGenre());
        preparedstatement.setFloat(3, movie.getMovieFee());
        preparedstatement.setTime(4, movie.getStartTime());
        preparedstatement.setString(5, movie.getTheatre());
        preparedstatement.setDate(6, movie.getShowingFrom());

        preparedstatement.executeUpdate();

    }

    @Override
    public boolean existsByName(String movieName) {

        try {
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement(ConnectingDb.FIND_MOVIE_BY_NAME);

            ps.setString(1, movieName);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return true;

            }
        } catch (SQLException ex) {
            Logger.getLogger(MovieRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
