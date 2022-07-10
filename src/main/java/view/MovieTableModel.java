/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Movie;

/**
 *
 * @author ragnar
 */
public class MovieTableModel extends AbstractTableModel {

    List<Movie> movieList;

    String [] columnNames ={"NAME","GENRE","FEE","THEATRE","START TIME","SHOWING FROM"};
    
    public void setMovieData(List<Movie> movieList) {

        this.movieList = movieList;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column]; 
    }

    @Override
    public int getRowCount() {

        return movieList.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Movie movie = movieList.get(rowIndex);

        switch (columnIndex) {
    
            case 0 -> {
                return movie.getMovieName();
            }
            case 1 -> {
                return movie.getGenre();
            }
            case 2 -> {
                return movie.getMovieFee();
            }
            case 3 -> {
                return movie.getTheatre();
            }
            case 4 -> {
                return movie.getStartTime();
            }
            case 5 -> {
                return movie.getShowingFrom();
            }

        }
        return null;
    }

}
