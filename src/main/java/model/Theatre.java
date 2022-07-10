/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package model;

/**
 *
 * @author ragnar
 */
public enum Theatre {

    Theatre1("Theatre1"),
    Theatre2("Theatre2");

    private String name;

    Theatre(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    
}
