/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author ragnar
 */
public class PreferenceDialog extends JDialog {

    private JButton okbtn;
    private JButton cancelBtn;
    private JSpinner portSpinner;
    private SpinnerNumberModel spnnerModel;

    public PreferenceDialog(JFrame parent) {

        super(parent, "Preferences", false);

        okbtn = new JButton("ok");
        cancelBtn = new JButton("cancel");

        spnnerModel = new SpinnerNumberModel(3306, 0, 9999, 1);
        portSpinner = new JSpinner(spnnerModel);

        GridBagConstraints gc = new GridBagConstraints();

        setLayout(new GridBagLayout());
        setSize(400, 300);
        setLocationRelativeTo(parent);

        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;
        add(new JLabel("Port: "), gc);

        gc.gridx++;
        add(portSpinner, gc);

        //////////////
        gc.gridy++;

        gc.gridx = 0;
        add(okbtn, gc);

        //////////////
        gc.gridx++;
        add(cancelBtn, gc);

        okbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Integer value = (Integer) portSpinner.getValue();

                System.out.println(value);
            }

        });

    }

}
