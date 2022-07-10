/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.sql.Date;
import java.sql.Time;
import java.util.EventObject;

/**
 *
 * @author ragnar
 */
public class FormEvent extends EventObject {

    private String name;
    private Date date;
    private String theatre;
    private String genre;
    public float movieFee;
    public Time startTime;

    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(String name, Date date, String theatre, String genre, float movieFee, Time startTime, Object source) {
        super(source);
        this.name = name;
        this.date = date;
        this.theatre = theatre;
        this.genre = genre;
        this.movieFee = movieFee;
        this.startTime = startTime;      
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTheatre() {
        return theatre;
    }

    public void setTheatre(String theatre) {
        this.theatre = theatre;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    /**
     *
     * @param startTime
     */
    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    @Override
    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

}
