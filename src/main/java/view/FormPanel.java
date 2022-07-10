/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Date;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author ragnar
 */
public class FormPanel extends JPanel {

    private JLabel nameLabel;
    private JLabel genreLabel;
    private JTextField nameField;
    private JTextField genreField;
    private JLabel feeLabel;
    private JTextField feeField;
    private JButton subMitBtn;
    private JComboBox startTimeCombo;
    private FormListener formListener;
    private JList theatreList;
    private JLabel thearterLabel;
    private JLabel timeLabel;
    private JLabel dateLabel;

    UtilDateModel model;
    JDatePanelImpl datePanel;
    JDatePickerImpl datePicker;

    public FormPanel() {

        model = new UtilDateModel();
        datePanel = new JDatePanelImpl(model);
        datePicker = new JDatePickerImpl(datePanel);
        dateLabel = new JLabel("Showing From: ");
        dateLabel.putClientProperty("FlatLaf.style", "font: $h3.font");

        Dimension dim = getPreferredSize();
        dim.width = 400;
        setPreferredSize(dim);

        theatreList = new JList();
        thearterLabel = new JLabel("Theatre: ");
        thearterLabel.putClientProperty("FlatLaf.style", "font: $h3.font");

        nameLabel = new JLabel("Name: ");
        nameLabel.putClientProperty("FlatLaf.style", "font: $h3.font");
        nameField = new JTextField(20);

        genreLabel = new JLabel("Genre: ");
        genreLabel.putClientProperty("FlatLaf.style", "font: $h3.font");
        genreField = new JTextField(10);

        feeLabel = new JLabel("Fee: ");
        feeLabel.putClientProperty("FlatLaf.style", "font: $h3.font");
        feeField = new JTextField(10);

        timeLabel = new JLabel("StartTime: ");
        timeLabel.putClientProperty("FlatLaf.style", "font: $h3.font");
        startTimeCombo = new JComboBox();

        subMitBtn = new JButton("submit");
        subMitBtn.putClientProperty("JButton.buttonType", "roundRect");

        List<LocalTime> list = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            list.add(LocalTime.of(i, 0));
        }
        DefaultComboBoxModel startTimeModel = new DefaultComboBoxModel();

        list.forEach(time -> {
            startTimeModel.addElement(time);
        });
        startTimeCombo.setModel(startTimeModel);
        startTimeCombo.setSelectedIndex(8);

        DefaultListModel theatreListModel = new DefaultListModel();
        theatreListModel.addElement("Theatre1");
        theatreListModel.addElement("Theatre2");
        theatreList.setModel(theatreListModel);
        theatreList.setSelectedIndex(0);
        theatreList.setPreferredSize(new Dimension(100, 60));
        theatreList.setBorder(BorderFactory.createEtchedBorder());

        subMitBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String movieName = nameField.getText();

                String genre = genreField.getText();

                String theatre = (String) theatreList.getSelectedValue();
                LocalTime time = (LocalTime) startTimeCombo.getSelectedItem();
                Time showTime = Time.valueOf(time);

                String fee = feeField.getText();

                float movieFee = 0;
                try {
                    if (!fee.isEmpty()) {
                        movieFee = Float.parseFloat(fee);
                    } else {
                        JOptionPane.showMessageDialog(FormPanel.this, "field(s) cannot be blank");
                        return;
                    }
                } catch (NumberFormatException nf) {
                    JOptionPane.showMessageDialog(FormPanel.this, "invalid  fee entered");
                    return;
                }
                Date formDate = getFormDate();

                java.sql.Date releaseDate = null;

                if (formDate != null) {
                    releaseDate = new java.sql.Date(formDate.getTime());
                   // return;
                }

                if (releaseDate != null && !movieName.isEmpty() && !genre.isEmpty()) {
                    FormEvent event
                            = new FormEvent(StringUtils.capitalize(movieName), releaseDate, theatre, StringUtils.capitalize(genre), movieFee, showTime, this);

                    if (formListener != null) {

                        formListener.formEventOccured(event);

                    } else {
                        JOptionPane.showMessageDialog(FormPanel.this, "field(s) cannot be blank");

                    }
                } else {
                    JOptionPane.showMessageDialog(FormPanel.this, "field(s) cannot be blank");
                    
                }

            }
        });

        Border innerBorder = BorderFactory.createTitledBorder("ADD MOVIE");

        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);

        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        layoutComponent();
    }

    void setFormListener(FormListener formListener) {

        this.formListener = formListener;
    }

    private void layoutComponent() {

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        // ////////// First row ///////////////////////////////////
        gc.gridy = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(nameLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(nameField, gc);

        // //////////Second row ///////////////////////////////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(genreLabel, gc);

        gc.gridx = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(genreField, gc);

        // //////////Third row ///////////////////////////////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(feeLabel, gc);

        gc.gridx = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(feeField, gc);

        // //////////fourth row ///////////////////////////////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(thearterLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(theatreList, gc);

        // //////////fifth row ///////////////////////////////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(timeLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(startTimeCombo, gc);

        // //////////fifth row ///////////////////////////////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(dateLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(datePicker, gc);

        // //////////sixth row ///////////////////////////////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 2.0;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(subMitBtn, gc);

    }

    public Date getFormDate() {

        Date selectedDate = (Date) datePicker.getModel().getValue();

        return selectedDate;

    }
}
