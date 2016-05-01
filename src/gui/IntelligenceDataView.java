/*
 * Created by JFormDesigner on Thu May 21 10:37:35 EEST 2015
 */

package gui;

import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.layout.FormLayout;
import helper.IntelligenceDataTable;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;

/**
 * @author User #1
 *
 */

public class IntelligenceDataView extends JPanel {
    private TableRowSorter<TableModel> sorter;
    private TableModel model;

    public IntelligenceDataView(NewReportPanel newReportPanel) {

        initComponents();
        model=getIntelligenceDataTable().getModel();
        sorter=new TableRowSorter<TableModel>(model);
        searchComboBox.setVisible(false);
        searchComboBox.addItem("");
        searchComboBox.addItem("ID");
        searchComboBox.addItem("Country");
        searchComboBox.addItem("City");
        searchComboBox.addItem("County");
        searchComboBox.addItem("Name");
        searchComboBox.addItem("Surname");
        searchComboBox.addItem("Phone");
        searchComboBox.addItem("E-mail");
        searchComboBox.addItem("Subject");
        searchComboBox.addItem("Details");


        getIntelligenceDataTable().setModel(model);
        getIntelligenceDataTable().setRowSorter(sorter);
}
    public IntelligenceDataTable getIntelligenceDataTable() {
        return intelligenceDataTable;
    }

    public JLabel getDbConnectedLabel() {
        return dbConnectedLabel;
    }

    public JLabel getDbDisconnectedLabel() {
        return dbDisconnectedLabel;
    }

    public JTextField getSearchTextField() {
        return searchTextField;
    }

    public JComboBox getSearchComboBox() {
        return searchComboBox;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - KaÄan Ãzen
        intelligenceDataLabel = new JLabel();
        dbConnectedLabel = new JLabel();
        dbDisconnectedLabel = new JLabel();
        searchComboBox = new JComboBox();
        label1 = new JLabel();
        searchTextField = new JTextField();
        scrollPane1 = new JScrollPane();
        intelligenceDataTable = new IntelligenceDataTable();

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new FormLayout(
            "pref, default:grow, [150px,pref]",
            "fill:pref, 2*($lgap, default), $lgap, fill:pref:grow"));

        //---- intelligenceDataLabel ----
        intelligenceDataLabel.setText("Intelligence Data Table");
        intelligenceDataLabel.setFont(intelligenceDataLabel.getFont().deriveFont(intelligenceDataLabel.getFont().getStyle() | Font.BOLD));
        add(intelligenceDataLabel, CC.xy(1, 1));

        //---- dbConnectedLabel ----
        dbConnectedLabel.setText("DB connected");
        dbConnectedLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dbConnectedLabel.setBackground(new Color(0, 255, 51));
        dbConnectedLabel.setForeground(new Color(0, 102, 102));
        dbConnectedLabel.setOpaque(true);
        dbConnectedLabel.setFont(dbConnectedLabel.getFont().deriveFont(dbConnectedLabel.getFont().getStyle() | Font.BOLD));
        dbConnectedLabel.setBorder(LineBorder.createGrayLineBorder());
        dbConnectedLabel.setVisible(false);
        dbConnectedLabel.setToolTipText("MySQL database connection established.");
        add(dbConnectedLabel, CC.xy(3, 1, CC.FILL, CC.DEFAULT));

        //---- dbDisconnectedLabel ----
        dbDisconnectedLabel.setText("No DB connection");
        dbDisconnectedLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dbDisconnectedLabel.setBackground(new Color(255, 0, 51));
        dbDisconnectedLabel.setForeground(Color.white);
        dbDisconnectedLabel.setOpaque(true);
        dbDisconnectedLabel.setFont(dbDisconnectedLabel.getFont().deriveFont(dbDisconnectedLabel.getFont().getStyle() | Font.BOLD));
        dbDisconnectedLabel.setBorder(LineBorder.createGrayLineBorder());
        dbDisconnectedLabel.setToolTipText("No MySQL Database Connection");
        add(dbDisconnectedLabel, CC.xy(3, 1, CC.FILL, CC.DEFAULT));
        add(searchComboBox, CC.xy(1, 3));

        //---- label1 ----
        label1.setText("Search :");
        add(label1, CC.xy(2, 3, CC.RIGHT, CC.DEFAULT));

        //---- searchTextField ----
        searchTextField.setPreferredSize(new Dimension(150, 30));
        add(searchTextField, CC.xy(3, 3, CC.LEFT, CC.DEFAULT));

        //======== scrollPane1 ========
        {
            scrollPane1.setPreferredSize(new Dimension(0, 0));
            scrollPane1.setViewportView(intelligenceDataTable);
        }
        add(scrollPane1, CC.xywh(1, 7, 3, 1));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents


    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - KaÄan Ãzen
    private JLabel intelligenceDataLabel;
    private JLabel dbConnectedLabel;
    private JLabel dbDisconnectedLabel;
    private JComboBox searchComboBox;
    private JLabel label1;
    private JTextField searchTextField;
    private JScrollPane scrollPane1;
    private IntelligenceDataTable intelligenceDataTable;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
