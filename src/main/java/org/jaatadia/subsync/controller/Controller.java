package org.jaatadia.subsync.controller;

import org.jaatadia.subsync.controller.delay.DelayMode;
import org.jaatadia.subsync.controller.delay.DelayModeMillis;
import org.jaatadia.subsync.controller.delay.DelayModeTimeStamp;
import org.jaatadia.subsync.controller.range.RangeMode;
import org.jaatadia.subsync.controller.range.RangeModeAll;
import org.jaatadia.subsync.controller.range.RangeModeFrom;
import org.jaatadia.subsync.controller.range.RangeModeFromTo;
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
    private RangeMode rangeMode;
    private DelayMode delayMode;

    public Controller(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        rangeMode = new RangeModeAll();
        delayMode = new DelayModeMillis(mainWindow.delayPanel);
        mainWindow.filePanel.browseButton.addActionListener(new BrowseListener());
        mainWindow.applyButton.addActionListener(new ApplyActionListener());
        mainWindow.rangePanel.optionAll.addActionListener( e -> rangeMode = new RangeModeAll());
        mainWindow.rangePanel.optionFrom.addActionListener( e -> rangeMode = new RangeModeFrom(mainWindow.rangePanel));
        mainWindow.rangePanel.optionFromTo.addActionListener( e -> rangeMode = new RangeModeFromTo(mainWindow.rangePanel));
        mainWindow.delayPanel.optionDelay.addActionListener( e -> delayMode = new DelayModeMillis(mainWindow.delayPanel));
        mainWindow.delayPanel.optionToTime.addActionListener( e -> delayMode = new DelayModeTimeStamp(mainWindow.delayPanel));
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

        private String getFileName(){
            String fileName = mainWindow.filePanel.pathToFile.getText();
            if (mainWindow.replaceBox.isSelected()) return fileName;
            String baseName=fileName.replaceAll("[0-9]*\\.srt$","");
            int i;
            for (i=1;i<999;i++){
                if(!new File(baseName+String.format("%03d.srt",i)).exists()) break;
            }
            return baseName+String.format("%03d.srt",i);
        }

        private void printToFile() throws FileNotFoundException {
            String fileName = getFileName();
            PrintWriter out = new PrintWriter(fileName);
            out.print(mainWindow.subtitlePanel.subtitles.toString());
            out.close();
            mainWindow.filePanel.pathToFile.setText(fileName);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if(mainWindow.subtitlePanel.subtitles.getRowCount()==0) throw new Exception("Must select a valid subtitle file first");
                rangeMode.sync(mainWindow.subtitlePanel.subtitles,delayMode);
                printToFile();
                JOptionPane.showMessageDialog(mainWindow, "Subtitles saved to: "+mainWindow.filePanel.pathToFile.getText());
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(mainWindow, e1.getMessage());
            }
        }
    }

}
