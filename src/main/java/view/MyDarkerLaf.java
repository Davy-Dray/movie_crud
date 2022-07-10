/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import com.formdev.flatlaf.FlatDarkLaf;

/**
 *
 * @author ragnar
 */
public class MyDarkerLaf extends FlatDarkLaf {

    public static boolean setup() {
        return setup(new MyDarkerLaf());
    }

    @Override
    public String getName() {
        return "MyDarkerLaf";
    }
}
