/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ragnar
 */
@Getter
@Setter
@NoArgsConstructor
public class Transactions {

    private long transcationId;
    private List<Movie> movieList;
    private long movieId;
    private float total;
    private String theatreName;
    Date viewDate;

    public Transactions(List<Movie> movieList, long movieId, float total, String theatreName, Date viewDate) {
        this.movieList = movieList;
        this.movieId = movieId;
        this.total = total;
        this.theatreName = theatreName;
        this.viewDate = viewDate;
    }

    
}
