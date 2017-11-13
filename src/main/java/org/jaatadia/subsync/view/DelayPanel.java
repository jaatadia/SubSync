package org.jaatadia.subsync.view;

import javax.swing.*;
import java.awt.*;

public class DelayPanel extends JPanel{

    public JRadioButton optionDelay = new JRadioButton("Delay");
    public JRadioButton optionToTime = new JRadioButton("First subtitle to:");
    public SpinnerNumberModel spinnerModelDelay = new SpinnerNumberModel(0,0,3600*1000*99,1);
    public SpinnerNumberModel spinnerModelHs = new SpinnerNumberModel(0,0,99,1);
    public SpinnerNumberModel spinnerModelMin = new SpinnerNumberModel(0,0,59,1);
    public SpinnerNumberModel spinnerModelSec = new SpinnerNumberModel(0,0,59,1);
    public SpinnerNumberModel spinnerModelMillis = new SpinnerNumberModel(0,0,999,1);

    DelayPanel() {
        setBorder(BorderFactory.createTitledBorder("Subtitle delay"));
        setLayout(new GridBagLayout());

        ButtonGroup b = new ButtonGroup();
        b.add(optionDelay);
        b.add(optionToTime);
        optionDelay.setSelected(true);

        JSpinner delaySpinner = new JSpinner(spinnerModelDelay);
        JSpinner spinnerHs = new JSpinner(spinnerModelHs);
        JSpinner spinnerMin = new JSpinner(spinnerModelMin);
        JSpinner spinnerSec = new JSpinner(spinnerModelSec);
        JSpinner spinnerMillis = new JSpinner(spinnerModelMillis);

        delaySpinner.setEnabled(true);
        spinnerHs.setEnabled(false);
        spinnerMin.setEnabled(false);
        spinnerSec.setEnabled(false);
        spinnerMillis.setEnabled(false);

        GridBagConstraints cDelay = new GridBagConstraints();
        cDelay.gridwidth=1;
        cDelay.gridheight=1;
        cDelay.gridx = 0;
        cDelay.gridy = 0;
        cDelay.weightx=0;
        cDelay.weighty=0;
        cDelay.fill=GridBagConstraints.NONE;
        cDelay.anchor=GridBagConstraints.WEST;
        cDelay.insets=new Insets(2,2,2,2);

        GridBagConstraints cToTime = new GridBagConstraints();
        cToTime.gridwidth=1;
        cToTime.gridheight=1;
        cToTime.gridx = 0;
        cToTime.gridy = 1;
        cToTime.weightx=0;
        cToTime.weighty=0;
        cToTime.fill=GridBagConstraints.NONE;
        cToTime.anchor=GridBagConstraints.WEST;
        cToTime.insets=new Insets(2,2,2,2);

        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth=4;
        c.gridheight=1;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx=1;
        c.weighty=0;
        c.fill=GridBagConstraints.HORIZONTAL;
        c.anchor=GridBagConstraints.WEST;
        c.insets=new Insets(2,2,2,2);

        GridBagConstraints cHs = new GridBagConstraints();
        cHs.gridwidth=1;
        cHs.gridheight=1;
        cHs.gridx = 1;
        cHs.gridy = 1;
        cHs.weightx=1;
        cHs.weighty=0;
        cHs.fill=GridBagConstraints.HORIZONTAL;
        cHs.anchor=GridBagConstraints.WEST;
        cHs.insets=new Insets(2,2,2,2);

        GridBagConstraints cMin = new GridBagConstraints();
        cMin.gridwidth=1;
        cMin.gridheight=1;
        cMin.gridx = 2;
        cMin.gridy = 1;
        cMin.weightx=1;
        cMin.weighty=0;
        cMin.fill=GridBagConstraints.HORIZONTAL;
        cMin.anchor=GridBagConstraints.WEST;
        cMin.insets=new Insets(2,2,2,2);

        GridBagConstraints cSec = new GridBagConstraints();
        cSec.gridwidth=1;
        cSec.gridheight=1;
        cSec.gridx = 3;
        cSec.gridy = 1;
        cSec.weightx=1;
        cSec.weighty=0;
        cSec.fill=GridBagConstraints.HORIZONTAL;
        cSec.anchor=GridBagConstraints.WEST;
        cSec.insets=new Insets(2,2,2,2);

        GridBagConstraints cMillis = new GridBagConstraints();
        cMillis.gridwidth=1;
        cMillis.gridheight=1;
        cMillis.gridx = 4;
        cMillis.gridy = 1;
        cMillis.weightx=1;
        cMillis.weighty=0;
        cMillis.fill=GridBagConstraints.HORIZONTAL;
        cMillis.anchor=GridBagConstraints.WEST;
        cMillis.insets=new Insets(2,2,2,2);

        add(optionDelay,cDelay);
        add(optionToTime,cToTime);

        add(delaySpinner,c);
        add(spinnerHs,cHs);
        add(spinnerMin,cMin);
        add(spinnerSec,cSec);
        add(spinnerMillis,cMillis);



        optionDelay.addActionListener( e -> {
            delaySpinner.setEnabled(true);
            spinnerHs.setEnabled(false);
            spinnerMin.setEnabled(false);
            spinnerSec.setEnabled(false);
            spinnerMillis.setEnabled(false);
        });

        optionToTime.addActionListener( e -> {
            delaySpinner.setEnabled(false);
            spinnerHs.setEnabled(true);
            spinnerMin.setEnabled(true);
            spinnerSec.setEnabled(true);
            spinnerMillis.setEnabled(true);
        });

    }




}
