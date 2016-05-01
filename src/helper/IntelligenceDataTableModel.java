package helper;

import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * Created by balis on 21.05.2015.
 */
public class IntelligenceDataTableModel extends DefaultTableModel {

    private final Map<String, String> columnNameToDisplay;

    public IntelligenceDataTableModel() {
        columnNameToDisplay = new HashMap<String, String>() {};

        columnNameToDisplay.put("ir_id", "ID");
        columnNameToDisplay.put("ir_creationdate", "Date");
        columnNameToDisplay.put("ir_country", "Country");
        columnNameToDisplay.put("ir_city", "City");
        columnNameToDisplay.put("ir_county", "County");
        columnNameToDisplay.put("ir_reportername", "Rep. name");
        columnNameToDisplay.put("ir_reportersurname", "Rep. surname");
        columnNameToDisplay.put("ir_reporterphone", "Rep. phone");
        columnNameToDisplay.put("ir_reporteremail", "Rep. e-mail");
        columnNameToDisplay.put("ir_subject", "Subject");
        columnNameToDisplay.put("ir_details", "Details");
    }

    @Override
    public synchronized void setDataVector(Vector dataVector, Vector columnIdentifiers) {
        super.setDataVector(dataVector, columnIdentifiers);
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return columnNameToDisplay.get(super.getColumnName(column));
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

}
