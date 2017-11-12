package org.jaatadia.subsync.view;

import javax.swing.*;
import java.awt.*;

public class FilePanel extends JPanel {

    public FilePanel(JTextArea textArea, JButton browseButton) {
        super(new GridBagLayout());
        setBorder(BorderFactory.createTitledBorder("File to Sync"));

        textArea.setEditable(false);
        textArea.setBorder(BorderFactory.createLoweredBevelBorder());
        GridBagConstraints c1 = new GridBagConstraints();
        c1.gridwidth = 1;
        c1.gridheight = 1;
        c1.gridx = 0;
        c1.gridy = 0;
        c1.weightx = 1;
        c1.weighty = 0;
        c1.fill = GridBagConstraints.HORIZONTAL;
        add(textArea, c1);

        GridBagConstraints c2 = new GridBagConstraints();
        c2.gridwidth = 1;
        c2.gridheight = 1;
        c2.gridx = 1;
        c2.gridy = 0;
        c2.weightx = 0;
        c2.weighty = 0;
        c2.fill = GridBagConstraints.NONE;
        c2.insets = new Insets(2, 2, 2, 2);
        add(browseButton, c2);
    }

}
