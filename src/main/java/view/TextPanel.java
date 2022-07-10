/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


/**
 *
 * @author ragnar
 */
public class TextPanel extends JPanel {
    
    private JTextArea textArea;
    
    public TextPanel() {
        
        textArea = new JTextArea();
        
        setLayout(new BorderLayout());
        
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        
     }
    
    public void appendText(String text) {
        
        textArea.append(text);
        
    }
}
