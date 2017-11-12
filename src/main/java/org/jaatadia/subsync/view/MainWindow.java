package org.jaatadia.subsync.view;

import org.jaatadia.subsync.model.SubtitleGroup;
import org.jaatadia.subsync.model.exceptions.InvalidSubtitleException;
import org.jaatadia.subsync.model.exceptions.SubtitleTable;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {


    public JTextArea pathToFile = new JTextArea ("PathToFile");
    public JButton browseButton = new JButton("Browse");
    private JPanel filePanel;

    public SubtitleTable subtitles = new SubtitleTable();
    private JPanel subtitlePanel = new JPanel();

    private JPanel parameterPanel = new JPanel();
    public JButton applyButton = new JButton("Apply");

    public MainWindow() {
        super("Subtitle Synchronizer");
        setBounds(100, 100, 600, 500);
        initPanels();
        initWindow();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void initWindow(){
        setLayout(new GridBagLayout());

        GridBagConstraints c1 = new GridBagConstraints();
        c1.gridwidth=1;
        c1.gridheight=1;
        c1.gridx = 0;
        c1.gridy = 0;
        c1.weightx=1;
        c1.weighty=0;
        c1.fill=GridBagConstraints.HORIZONTAL;
        c1.insets=new Insets(2,2,2,2);
        add(filePanel,c1);

        GridBagConstraints c2 = new GridBagConstraints();
        c2.gridwidth=1;
        c2.gridheight=1;
        c2.gridx = 0;
        c2.gridy = 1;
        c2.weightx=1;
        c2.weighty=1;
        c2.fill=GridBagConstraints.BOTH;
        c2.insets=new Insets(2,2,2,2);
        add(subtitlePanel,c2);

        GridBagConstraints c3 = new GridBagConstraints();
        c3.gridwidth=1;
        c3.gridheight=1;
        c3.gridx = 0;
        c3.gridy = 2;
        c3.weightx=1;
        c3.weighty=0;
        c3.fill=GridBagConstraints.HORIZONTAL;
        c3.insets=new Insets(2,2,2,2);
        add(parameterPanel,c3);

        GridBagConstraints c4 = new GridBagConstraints();
        c4.gridwidth=1;
        c4.gridheight=1;
        c4.gridx = 0;
        c4.gridy = 3;
        c4.weightx=0;
        c4.weighty=0;
        c4.fill=GridBagConstraints.NONE;
        c4.anchor=GridBagConstraints.EAST;
        c4.insets=new Insets(2,2,2,2);
        add(applyButton,c4);
    }

    private void initPanels(){
        filePanel = new FilePanel(pathToFile,browseButton);
        subtitlePanel = new SubtitlePanel(subtitles);
        parameterPanel.setBorder(BorderFactory.createTitledBorder("Parameters"));
    }

    public void update(){
        //getContentPane().validate();
        getContentPane().repaint();
    }

}
