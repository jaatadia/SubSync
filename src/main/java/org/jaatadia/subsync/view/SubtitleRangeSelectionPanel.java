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

        GridBagConstraints cOptionAll = new GridBagConstraints();
        cOptionAll.gridwidth=1;
        cOptionAll.gridheight=1;
        cOptionAll.gridx = 0;
        cOptionAll.gridy = 0;
        cOptionAll.weightx=0;
        cOptionAll.weighty=0;
        cOptionAll.fill=GridBagConstraints.NONE;
        cOptionAll.anchor=GridBagConstraints.WEST;
        cOptionAll.insets=new Insets(2,2,2,2);

        GridBagConstraints cOptionFrom = new GridBagConstraints();
        cOptionFrom.gridwidth=1;
        cOptionFrom.gridheight=1;
        cOptionFrom.gridx = 0;
        cOptionFrom.gridy = 1;
        cOptionFrom.weightx=0;
        cOptionFrom.weighty=0;
        cOptionFrom.fill=GridBagConstraints.NONE;
        cOptionFrom.anchor=GridBagConstraints.WEST;
        cOptionFrom.insets=new Insets(2,2,2,2);

        GridBagConstraints cOptionFromTo = new GridBagConstraints();
        cOptionFromTo.gridwidth=1;
        cOptionFromTo.gridheight=1;
        cOptionFromTo.gridx = 0;
        cOptionFromTo.gridy = 2;
        cOptionFromTo.weightx=0;
        cOptionFromTo.weighty=0;
        cOptionFromTo.fill=GridBagConstraints.NONE;
        cOptionFromTo.anchor=GridBagConstraints.WEST;
        cOptionFromTo.insets=new Insets(2,2,2,2);

        GridBagConstraints cFromSpinner = new GridBagConstraints();
        cFromSpinner.gridwidth=2;
        cFromSpinner.gridheight=1;
        cFromSpinner.gridx = 2;
        cFromSpinner.gridy = 1;
        cFromSpinner.weightx=1;
        cFromSpinner.weighty=0;
        cFromSpinner.fill=GridBagConstraints.HORIZONTAL;
        cFromSpinner.anchor=GridBagConstraints.WEST;
        cFromSpinner.insets=new Insets(2,2,2,2);


        GridBagConstraints cFromToSpinnerFrom = new GridBagConstraints();
        cFromToSpinnerFrom.gridwidth=1;
        cFromToSpinnerFrom.gridheight=1;
        cFromToSpinnerFrom.gridx = 2;
        cFromToSpinnerFrom.gridy = 2;
        cFromToSpinnerFrom.weightx=1;
        cFromToSpinnerFrom.weighty=0;
        cFromToSpinnerFrom.fill=GridBagConstraints.HORIZONTAL;
        cFromToSpinnerFrom.anchor=GridBagConstraints.WEST;
        cFromToSpinnerFrom.insets=new Insets(2,2,2,2);

        GridBagConstraints cFromToSpinnerTo = new GridBagConstraints();
        cFromToSpinnerTo.gridwidth=1;
        cFromToSpinnerTo.gridheight=1;
        cFromToSpinnerTo.gridx = 3;
        cFromToSpinnerTo.gridy = 2;
        cFromToSpinnerTo.weightx=1;
        cFromToSpinnerTo.weighty=0;
        cFromToSpinnerTo.fill=GridBagConstraints.HORIZONTAL;
        cFromToSpinnerTo.anchor=GridBagConstraints.WEST;
        cFromToSpinnerTo.insets=new Insets(2,2,2,2);

        fromSpinner.setMaximumSize(new Dimension(100,20));
        fromSpinner.setMinimumSize(new Dimension(100,20));

        fromToSPinnerFrom.setMaximumSize(new Dimension(50,20));
        fromToSPinnerFrom.setMinimumSize(new Dimension(50,20));

        fromToSPinnerTo.setMaximumSize(new Dimension(50,20));
        fromToSPinnerTo.setMinimumSize(new Dimension(50,20));

        add(optionAll,cOptionAll);
        add(optionFrom,cOptionFrom);
        add(optionFromTo,cOptionFromTo);
        add(fromSpinner,cFromSpinner);
        add(fromToSPinnerFrom,cFromToSpinnerFrom);
        add(fromToSPinnerTo,cFromToSpinnerTo);

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
