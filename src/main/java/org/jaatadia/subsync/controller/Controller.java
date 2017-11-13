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
    private RangeMode rangeMode = new RangeModeAll();

    public Controller(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        mainWindow.filePanel.browseButton.addActionListener(new BrowseListener());
        mainWindow.applyButton.addActionListener(new ApplyActionListener());
        mainWindow.rangePanel.optionAll.addActionListener( e -> rangeMode = new RangeModeAll());
        mainWindow.rangePanel.optionFrom.addActionListener( e -> rangeMode = new RangeModeFrom());
        mainWindow.rangePanel.optionFromTo.addActionListener( e -> rangeMode = new RangeModeFromTo());
    }

    private interface RangeMode {
        void sync();
    }

    private class RangeModeAll implements RangeMode {
        @Override
        public void sync() {
            int millis = 1;
            mainWindow.subtitlePanel.subtitles.synchronize(millis);
        }
    }

    private class RangeModeFrom implements RangeMode {
        @Override
        public void sync() {
            int from = mainWindow.rangePanel.spinnerModelFrom.getNumber().intValue();
            int millis = 1;
            mainWindow.subtitlePanel.subtitles.synchronize(millis, from);
        }
    }

    private class RangeModeFromTo implements RangeMode {
        @Override
        public void sync() {
            int from = mainWindow.rangePanel.spinnerModelFrom.getNumber().intValue();
            int to = mainWindow.rangePanel.spinnerModelTo.getNumber().intValue();
            int millis = 1;
            mainWindow.subtitlePanel.subtitles.synchronize(millis, from, to);
        }
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
                    mainWindow.subtitlePanel.subtitles.setSubs(subs);
                    mainWindow.filePanel.pathToFile.setText(file.getAbsolutePath());
                } else {
                    System.out.println("Open command cancelled by user.");
                }
            } catch ( Exception ex ) {
                JOptionPane.showMessageDialog(mainWindow, ex.getMessage());
            }
        }
    }

    private class ApplyActionListener implements ActionListener{

        private void printToFile() throws FileNotFoundException {
            PrintWriter out = new PrintWriter(mainWindow.filePanel.pathToFile.getText());
            out.print(mainWindow.subtitlePanel.subtitles.toString());
            out.close();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if(mainWindow.subtitlePanel.subtitles.getRowCount()==0) throw new Exception("Must select a valid subtitle file first");
                rangeMode.sync();
                printToFile();
                JOptionPane.showMessageDialog(mainWindow, "Subtitles saved to: "+mainWindow.filePanel.pathToFile.getText());
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(mainWindow, e1.getMessage());
            }
        }


    }

}
