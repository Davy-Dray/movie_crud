/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import model.Movie;

/**
 *
 * @author ragnar
 */
public class TablePanel extends JPanel {

    private JTable movieTable;
    private MovieTableModel tableModel;
    private JPopupMenu popup;
    private MovieTableListener movieTableListener;
    private final JMenuItem removeItem;
    JTextField textField;

    public TablePanel() {

        textField = new JTextField(1);

        popup = new JPopupMenu();
        tableModel = new MovieTableModel();
        movieTable = new JTable(tableModel);

        removeItem = new JMenuItem("delete");
        popup.add(removeItem);

        movieTable.putClientProperty("FlatLaf.style", "font: $h3.font");
        Dimension dim = new Dimension(50, 2);
        movieTable.setIntercellSpacing(new Dimension(dim));
        UIManager.put("TableHeader.separatorColor", new Color(0xFF0000));

        movieTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int row = movieTable.rowAtPoint(e.getPoint());

                movieTable.getSelectionModel().setSelectionInterval(row, row);
                if (e.getButton() == MouseEvent.BUTTON3) {
                    popup.show(movieTable, e.getX(), e.getY());
                }
            }

        });

        removeItem.addActionListener((ActionEvent e) -> {
            int row = movieTable.getSelectedRow();

            if (movieTableListener != null) {

                movieTableListener.rowDeleted(row);
                tableModel.fireTableRowsDeleted(row, row);
            }
        });
        setLayout(new BorderLayout());

        add(new JScrollPane(movieTable), BorderLayout.CENTER);
        add(textField, BorderLayout.NORTH);



    }

    public void setMovieData(List<Movie> movies) {

        tableModel.setMovieData(movies);
    }

    public void refresh() {

        tableModel.fireTableDataChanged();
    }

    public void setMovieTableListener(MovieTableListener movieTableListener) {

        this.movieTableListener = movieTableListener;
    }
}
