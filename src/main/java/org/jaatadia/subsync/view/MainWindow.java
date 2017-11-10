package org.jaatadia.subsync.view;

import javax.swing.*;

public class MainWindow extends JFrame {

    public MainWindow() {
        setBounds(100, 100, 600, 500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void update(){
        //getContentPane().validate();
        getContentPane().repaint();
    }

}
