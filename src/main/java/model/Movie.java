/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Date;

/**
 *
 * @author ragnar
 */
public class Movie implements Serializable {

    private long id;
    public String movieName;
    public String genre;
    public float movieFee;
    public Time startTime;
    private Date showingFrom;
    private String theatre;

    public Movie(String movieName, String genre, float movieFee, Time startTime, Date showingFrom, String theatre) {
        this.movieName = movieName;
        this.genre = genre;
        this.movieFee = movieFee;
        this.startTime = startTime;
        this.showingFrom = showingFrom;
        this.theatre = theatre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public float getMovieFee() {
        return movieFee;
    }

    public void setMovieFee(float movieFee) {
        this.movieFee = movieFee;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Date getShowingFrom() {
        return showingFrom;
    }

    public void setShowingFrom(Date showingFrom) {
        this.showingFrom = showingFrom;
    }

    public String getTheatre() {
        return theatre;
    }

    public void setTheatre(String theatre) {
        this.theatre = theatre;
    }

}
