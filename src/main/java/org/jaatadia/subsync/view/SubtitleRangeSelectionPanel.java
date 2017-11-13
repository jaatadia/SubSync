package org.jaatadia.subsync.view;

import javax.swing.*;
import java.awt.*;

public class SubtitleRangeSelectionPanel extends JPanel{

    public SubtitleRangeSelectionPanel(JRadioButton optionAll, JRadioButton optionFrom, JRadioButton optionFromTo, SpinnerNumberModel spinnerModelFrom, SpinnerNumberModel spinnerModelTo) {
        setBorder(BorderFactory.createTitledBorder("Subtitle Range"));
        setLayout(new GridBagLayout());

        ButtonGroup b = new ButtonGroup();
        b.add(optionAll);
        b.add(optionFrom);
        b.add(optionFromTo);
        optionAll.setSelected(true);

        JSpinner fromSpinner = new JSpinner(spinnerModelFrom);
        JSpinner fromToSPinnerFrom = new JSpinner(spinnerModelFrom);
        JSpinner fromToSPinnerTo = new JSpinner(spinnerModelTo);
        fromSpinner.setEnabled(false);
        fromToSPinnerFrom.setEnabled(false);
        fromToSPinnerTo.setEnabled(false);

        GridBagConstraints c1 = new GridBagConstraints();
        c1.gridwidth=1;
        c1.gridheight=1;
        c1.gridx = 0;
        c1.gridy = 0;
        c1.weightx=0;
        c1.weighty=0;
        c1.fill=GridBagConstraints.NONE;
        c1.anchor=GridBagConstraints.WEST;
        c1.insets=new Insets(2,2,2,2);

        GridBagConstraints c2 = new GridBagConstraints();
        c2.gridwidth=1;
        c2.gridheight=1;
        c2.gridx = 0;
        c2.gridy = 1;
        c2.weightx=0;
        c2.weighty=0;
        c2.fill=GridBagConstraints.NONE;
        c2.anchor=GridBagConstraints.WEST;
        c2.insets=new Insets(2,2,2,2);

        GridBagConstraints c3 = new GridBagConstraints();
        c3.gridwidth=1;
        c3.gridheight=1;
        c3.gridx = 0;
        c3.gridy = 2;
        c3.weightx=0;
        c3.weighty=0;
        c3.fill=GridBagConstraints.NONE;
        c3.anchor=GridBagConstraints.WEST;
        c3.insets=new Insets(2,2,2,2);

        GridBagConstraints c4 = new GridBagConstraints();
        c4.gridwidth=2;
        c4.gridheight=1;
        c4.gridx = 2;
        c4.gridy = 1;
        c4.weightx=1;
        c4.weighty=0;
        c4.fill=GridBagConstraints.HORIZONTAL;
        c4.anchor=GridBagConstraints.WEST;
        c4.insets=new Insets(2,2,2,2);


        GridBagConstraints c5 = new GridBagConstraints();
        c5.gridwidth=1;
        c5.gridheight=1;
        c5.gridx = 2;
        c5.gridy = 2;
        c5.weightx=1;
        c5.weighty=0;
        c5.fill=GridBagConstraints.HORIZONTAL;
        c5.anchor=GridBagConstraints.WEST;
        c5.insets=new Insets(2,2,2,2);

        GridBagConstraints c6 = new GridBagConstraints();
        c6.gridwidth=1;
        c6.gridheight=1;
        c6.gridx = 3;
        c6.gridy = 2;
        c6.weightx=1;
        c6.weighty=0;
        c6.fill=GridBagConstraints.HORIZONTAL;
        c6.anchor=GridBagConstraints.WEST;
        c6.insets=new Insets(2,2,2,2);

        add(optionAll,c1);
        add(optionFrom,c2);
        add(optionFromTo,c3);
        add(fromSpinner,c4);
        add(fromToSPinnerFrom,c5);
        add(fromToSPinnerTo,c6);

        optionAll.addActionListener( e -> {
            fromSpinner.setEnabled(false);
            fromToSPinnerFrom.setEnabled(false);
            fromToSPinnerTo.setEnabled(false);
        });

        optionFrom.addActionListener( e -> {
            fromSpinner.setEnabled(true);
            fromToSPinnerFrom.setEnabled(false);
            fromToSPinnerTo.setEnabled(false);
        });

        optionFromTo.addActionListener( e -> {
            fromSpinner.setEnabled(false);
            fromToSPinnerFrom.setEnabled(true);
            fromToSPinnerTo.setEnabled(true);
        });

    }




}
