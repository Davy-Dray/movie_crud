package App;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.SwingUtilities;
import view.MainFrame;
import view.MyDarkerLaf;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ragnar
 */
public class App {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            FlatLightLaf.setup();
             MyDarkerLaf.setup();
                 new MainFrame();
        });

    }
}
