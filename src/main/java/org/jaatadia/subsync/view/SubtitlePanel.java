package org.jaatadia.subsync.view;

import org.jaatadia.subsync.model.SubtitleTable;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class SubtitlePanel extends JPanel {

    public SubtitleTable subtitles = new SubtitleTable();

    SubtitlePanel(){
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createTitledBorder("Subtitles"));

        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth=1;
        c.gridheight=1;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx=1;
        c.weighty=1;
        c.fill=GridBagConstraints.BOTH;
        c.insets=new Insets(2,2,2,2);


        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );

        JTable t = new JTable(subtitles);
        t.setColumnSelectionAllowed(false);
        t.setRowSelectionAllowed(false);
        t.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        t.getColumnModel().getColumn(0).setMinWidth(50);
        t.getColumnModel().getColumn(0).setMaxWidth(50);
        t.getColumnModel().getColumn(0).setResizable(false);

        t.getColumnModel().getColumn(1).setMinWidth(180);
        t.getColumnModel().getColumn(1).setMaxWidth(180);
        t.getColumnModel().getColumn(1).setResizable(false);

        t.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        t.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );

        JScrollPane scrollPane = new JScrollPane(t);
        scrollPane.getViewport().setViewPosition(new Point(0, 0));
        add(scrollPane,c);
    }

}
