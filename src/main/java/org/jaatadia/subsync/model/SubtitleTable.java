package org.jaatadia.subsync.model;

import javax.swing.table.AbstractTableModel;

public class SubtitleTable extends AbstractTableModel {

    private SubtitleGroup subs;

    public SubtitleGroup getSubs() {
        return subs;
    }

    public void setSubs(SubtitleGroup subs) {
        this.subs = subs;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        if(subs==null) return 0;
        else return subs.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int columnIndex) {
        if(columnIndex == 0) return "Index";
        else if(columnIndex == 1) return "Time Range";
        else return "Text";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex==2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex == 0) return Integer.toString(subs.get(rowIndex).getNumber());
        else if(columnIndex == 1) return subs.get(rowIndex).getTimeRange().toString();
        else return subs.get(rowIndex).getText().replace("\n","\\n");
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(columnIndex==2) subs.get(rowIndex).setText(aValue.toString().replace("\\n","\n"));
        fireTableCellUpdated(rowIndex,columnIndex);
    }

    @Override
    public String toString(){
        if(subs==null) return "";
        else return subs.toString();
    }


    public void synchronize(int millis) {
        if(subs==null) return;
        subs.synchronize(millis);
        fireTableDataChanged();
    }

    public void synchronize(int millis, int from) {
        if(subs==null) return;
        subs.synchronize(millis,from);
        fireTableDataChanged();
    }

    public void synchronize(int millis, int from, int to) {
        if(subs==null) return;
        subs.synchronize(millis,from,to);
        fireTableDataChanged();
    }
}
