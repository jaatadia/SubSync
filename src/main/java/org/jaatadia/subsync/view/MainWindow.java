package org.jaatadia.subsync.view;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public FilePanel filePanel = new FilePanel();
    public SubtitlePanel subtitlePanel = new SubtitlePanel();
    public DelayPanel delayPanel = new DelayPanel();
    public RangePanel rangePanel = new RangePanel();
    public JButton applyButton = new JButton("Apply");

    public MainWindow() {
        super("Subtitle Synchronizer");
        setBounds(100, 100, 640, 480);
        setMinimumSize(new Dimension(640, 480));
        initWindow();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initWindow(){
        setLayout(new GridBagLayout());

        GridBagConstraints cFile = new GridBagConstraints();
        cFile.gridwidth=2;
        cFile.gridheight=1;
        cFile.gridx = 0;
        cFile.gridy = 0;
        cFile.weightx=1;
        cFile.weighty=0;
        cFile.fill=GridBagConstraints.HORIZONTAL;
        cFile.insets=new Insets(2,2,2,2);
        add(filePanel,cFile);

        GridBagConstraints cSubtitle = new GridBagConstraints();
        cSubtitle.gridwidth=2;
        cSubtitle.gridheight=1;
        cSubtitle.gridx = 0;
        cSubtitle.gridy = 1;
        cSubtitle.weightx=1;
        cSubtitle.weighty=1;
        cSubtitle.fill=GridBagConstraints.BOTH;
        cSubtitle.insets=new Insets(2,2,2,2);
        add(subtitlePanel,cSubtitle);

        GridBagConstraints cRange = new GridBagConstraints();
        cRange.gridwidth=1;
        cRange.gridheight=1;
        cRange.gridx = 0;
        cRange.gridy = 2;
        cRange.weightx=0;
        cRange.weighty=0;
        cRange.fill=GridBagConstraints.NONE;
        cRange.insets=new Insets(2,2,2,2);
        add(rangePanel,cRange);

        GridBagConstraints cDelay = new GridBagConstraints();
        cDelay.gridwidth=1;
        cDelay.gridheight=1;
        cDelay.gridx = 1;
        cDelay.gridy = 2;
        cDelay.weightx=0;
        cDelay.weighty=0;
        cDelay.fill=GridBagConstraints.BOTH;
        cDelay.anchor=GridBagConstraints.EAST;
        cDelay.insets=new Insets(2,2,2,2);
        add(delayPanel,cDelay);

        GridBagConstraints cApply = new GridBagConstraints();
        cApply.gridwidth=1;
        cApply.gridheight=1;
        cApply.gridx = 1;
        cApply.gridy = 3;
        cApply.weightx=0;
        cApply.weighty=0;
        cApply.fill=GridBagConstraints.NONE;
        cApply.anchor=GridBagConstraints.EAST;
        cApply.insets=new Insets(2,2,2,2);
        add(applyButton,cApply);


    }

}
