package org.jaatadia.subsync.controller;

import org.jaatadia.subsync.model.SubtitleGroup;
import org.jaatadia.subsync.view.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Files;

public class Controller {

    private MainWindow mainWindow;

    public Controller(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        mainWindow.browseButton.addActionListener(new BrowseListener());
        mainWindow.applyButton.addActionListener(new ApplyActionListener());
    }


    private class BrowseListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                final JFileChooser fc = new JFileChooser();
                int returnVal = fc.showOpenDialog(mainWindow);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    if (!file.getName().matches("^.*\\.srt$")) {
                        JOptionPane.showMessageDialog(mainWindow, file.getName() + " not compatible, must be srt file.");
                        return;
                    }
                    String fileContent = new String(Files.readAllBytes(file.toPath())).replace("\r\n","\n").trim();
                    SubtitleGroup subs = new SubtitleGroup(fileContent);
                    mainWindow.subtitles.setSubs(subs);
                    mainWindow.pathToFile.setText(file.getAbsolutePath());
                } else {
                    System.out.println("Open command cancelled by user.");
                }
            } catch ( Exception ex ) {
                JOptionPane.showMessageDialog(mainWindow, ex.getMessage());
            }
        }
    }

    private class ApplyActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                PrintWriter out = new PrintWriter(mainWindow.pathToFile.getText());
                out.print(mainWindow.subtitles.toString());
                out.close();
                JOptionPane.showMessageDialog(mainWindow, "Subtitles saved to: "+mainWindow.pathToFile.getText());
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(mainWindow, e1.getMessage());
            }
        }
    }

}
