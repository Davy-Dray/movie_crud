/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ragnar
 */
public class ConnectingDb {

    public static final String CREATE_TABLE_QUERY_MOVIES = "CREATE TABLE IF NOT EXISTS  MOVIES"
            + "(Id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,"
            + "Movie_Name VARCHAR (50) NOT NULL UNIQUE,"
            + "Movie_Info VARCHAR (225) NOT NULL,"
            + "Viewing_Fee DOUBLE (8,2) NOT NULL,"
            + "Start_Time Time NOT NULL,"
            + "Streaming_theatre VARCHAR (50) NOT NULL,"
            + "showing_from Date NOT NULL)";

    public static final String INSERT_INTO_MOVIE_TABLE = "insert into Movies"
            + "(Movie_Name, Movie_Info, Viewing_Fee,Start_time,Streaming_theatre,showing_from) "
            + "values (?, ?, ?, ?, ?, ?)";

    public static final String FIND_MOVIE_BY_NAME = "SELECT * FROM MOVIES WHERE Movie_Name =?";

    public Connection getConnection() {

        Connection conn = null;
        try {
            conn = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/Movie_Ticket_System_db?createDatabaseIfNotExist=true&serverTimezone=UTC", "root", "");

        } catch (SQLException ex) {
            Logger.getLogger(ConnectingDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;

    }

    public static void main(String[] args) {

        try {
            ConnectingDb db = new ConnectingDb();
//
            Connection con = db.getConnection();
//
            Statement stmt = con.createStatement();
//
            stmt.execute(CREATE_TABLE_QUERY_MOVIES);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectingDb.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
