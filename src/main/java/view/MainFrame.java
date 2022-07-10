/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view;

import controller.MovieController;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author ragnar
 */
public class MainFrame extends JFrame {

    private TextPanel textpanel;
    private FormPanel formPanel;
    private ToolBar toolBar;
    private MovieController movieController;
    private TablePanel tablePanel;
    private PreferenceDialog preferenceDialog;


    public MainFrame() {

        super("Movie Ticket System");

        toolBar = new ToolBar();
        tablePanel = new TablePanel();
        textpanel = new TextPanel();
        formPanel = new FormPanel();
        movieController = new MovieController();
        preferenceDialog = new PreferenceDialog(this);
        setJMenuBar(createMenuBar());

        try {
            movieController.loadMovieFromDb();
            
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        tablePanel.setMovieData(movieController.getMovies());

        toolBar.setTextListener(new StringListener() {
            @Override
            public void textEmitted(String text) {
                textpanel.appendText(text);
            }
        });

        formPanel.setFormListener((FormEvent form) -> {
            if (!movieController.existsByName(form.getName())) {
                try {
                    movieController.saveToDb(form);
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(formPanel, form.getName() + " exists");
            }
            tablePanel.refresh();
        });

        
        
        tablePanel.setMovieTableListener((int row) -> {
            movieController.removeMovie(row);
        });
        
        
        
        setLayout(new BorderLayout());
        add(formPanel, BorderLayout.WEST);
        add(toolBar, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.CENTER);
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    private JMenuBar createMenuBar() {

        var menubar = new JMenuBar();

        var windowMenu = new JMenu("Window");

        var prefrence = new JMenuItem("Preferences");

        prefrence.addActionListener((ActionEvent e) -> {
           // preferenceDialog.setVisible(true);
        });
        
        windowMenu.add(prefrence);
        menubar.add(windowMenu);
        return menubar;
    }

}
