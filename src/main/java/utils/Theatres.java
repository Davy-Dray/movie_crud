/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author ragnar
 */
public class Theatres {

    private String text;
    private int id;

    public Theatres(int id, String text) {
        this.id = id;
        this.text = text;

    }

    @Override
    public String toString() {
        return text;
    }

    public Theatres() {
    }

   

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

}
