package helper;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.Vector;

/**
 * Created by yaltes on 21.07.2015.
 */
public class IntelligenceDataTable extends JTable {
/***
 * Row selection from table
 */
    public IntelligenceDataTable() {
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setResizingAllowed(false);
        getTableHeader().setEnabled(false);
        setModel(new IntelligenceDataTableModel());
        setRowSelectionAllowed(true);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component c = super.prepareRenderer(renderer, row, column);
        int selectedRow = getSelectedRow();
        if (c instanceof JComponent) {
            JComponent jc = (JComponent) c;
            jc.setToolTipText(prepareTooltip(row, column));
            jc.setBackground((row % 2 == 0) ? new Color(201, 211, 214) : Color.WHITE);

            if (row == selectedRow) {
                jc.setBackground(Color.CYAN);
            }

        }
        return c;
    }

    public void setTableData(Vector<Vector<Object>> data, Vector<String> columnHeaders) {
        ((IntelligenceDataTableModel) getModel()).setDataVector(data, columnHeaders);
    }

    private String prepareTooltip(int row, int column) {
        StringBuffer stringBuffer = new StringBuffer();

        // TODO : Make it smarter !!!
        stringBuffer
                .append("<html>")
                .append("<tr bgcolor=\"#B2A5A9\"><td><b>ID :</td></b> <td>").append(getValueAt(row, 0)).append("</td></tr>")
                .append("<tr bgcolor=\"#C1C1C1\"><td><b>Date :</b> <td>").append(getValueAt(row, 1)).append("</td></tr>")
                .append("<tr bgcolor=\"#B2A5A9\"><td><b>Country :</b> <td>").append(getValueAt(row, 2)).append("</td></tr>")
                .append("<tr bgcolor=\"#C1C1C1\"><td><b>City :</b> <td>").append(getValueAt(row, 3)).append("</td></tr>")
                .append("<tr bgcolor=\"#B2A5A9\"><td><b>County :</b> <td>").append(getValueAt(row, 4)).append("</td></tr>")
                .append("<tr bgcolor=\"#C1C1C1\"><td><b>Reporter name :</b> <td>").append(getValueAt(row, 5)).append("</td></tr>")
                .append("<tr bgcolor=\"#B2A5A9\"><td><b>Reporter surname :</b> <td>").append(getValueAt(row, 6)).append("</td></tr>")
                .append("<tr bgcolor=\"#C1C1C1\"><td><b>Reporter phone :</b> <td>").append(getValueAt(row, 7)).append("</td></tr>")
                .append("<tr bgcolor=\"#B2A5A9\"><td><b>Reporter e-mail :</b><td> ").append(getValueAt(row, 8)).append("</td></tr>")
                .append("<tr bgcolor=\"#C1C1C1\"><td><b>Subject :</b> <td>").append(getValueAt(row, 9)).append("</td></tr>")
                .append("<tr bgcolor=\"#B2A5A9\"><td halign:\"top\"><b>Details :</b><td width=\"400\">").append(getValueAt(row, 10))
                .append("</td></tr><html>");

        return stringBuffer.toString();
    }

    @Override
    public JTableHeader getTableHeader() {
        JTableHeader tableHeader1 = super.getTableHeader();
        tableHeader1.setToolTipText("rfrfr");
        return tableHeader1;
    }
}
