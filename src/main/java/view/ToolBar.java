/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ragnar
 */
public class ToolBar extends JPanel implements ActionListener {

    private JButton updateBuuton, bookButton;

    private StringListener textListener;

    public ToolBar() {

        setBorder(BorderFactory.createEtchedBorder());

        bookButton = new JButton("Book");

        updateBuuton = new JButton("Update");

        bookButton.addActionListener(this);

        updateBuuton.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(updateBuuton);
        add(bookButton);
        // add(new JLabel("RAGNAR"));

    }

    public void setTextListener(StringListener textListener) {
        this.textListener = textListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton clicked = (JButton) e.getSource();

        if (clicked == bookButton) {
            if (textListener != null) {
                textListener.textEmitted("book\n");
                
            }

        } else if (clicked == updateBuuton) {
            if (textListener != null) {
                textListener.textEmitted("update\n");
            }

        }
    }

}
