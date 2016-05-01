package impl;

import gui.IntelligenceDataView;
import gui.MainUI;
import gui.NewReportPanel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.*;

/**
 * Implementation of IntelligenceDataView Panel and includes action listeners of searchTextField and rowSelection.
 *
 * @author Kaan Ozen
 */
public class IntelligenceDataViewImpl {

    private final static String SHOW_ATTACHMENT_QUERY ="SELECT * FROM intelligence_reports WHERE ir_id=? ";

    private TableRowSorter<TableModel> sorter;
    private TableModel model;

    private NewReportPanel newReportPanel = null;
    private IntelligenceDataView intelligenceDataView = null;

    private String dbName;
    private String dbPassword;
    private String dbUrl;

    public IntelligenceDataViewImpl(MainUI mainUI, String db_username, String db_password, String intelligence_db_url) {
        this.newReportPanel = mainUI.getNewReportPanel();
        this.intelligenceDataView = mainUI.getIntelligenceDataView();

        this.dbName = db_username;
        this.dbPassword = db_password;
        this.dbUrl = intelligence_db_url;

        this.model = intelligenceDataView.getIntelligenceDataTable().getModel();
        this.sorter = new TableRowSorter<TableModel>(model);

        this.intelligenceDataView.getSearchTextField().addKeyListener(new ChangeAttachmentListener());
        this.intelligenceDataView.getIntelligenceDataTable().setRowSorter(sorter);

        this.intelligenceDataView.getIntelligenceDataTable().getSelectionModel().addListSelectionListener(new RowSelectionListener());
    }

/**
 *Action listener of searchTextField
 * Search all columns and gets row(s) when searchTextField key entered, changed and removed.
 *
 * @author
 */
    private class ChangeAttachmentListener implements KeyListener {

        @Override
        public void keyPressed(KeyEvent e) {

            intelligenceDataView.getSearchTextField().getDocument().addDocumentListener(
                    new DocumentListener() {
                        @Override
                        public void changedUpdate(DocumentEvent e) {
                            String text = intelligenceDataView.getSearchTextField().getText();
                            int i;
                            i = intelligenceDataView.getSearchComboBox().getSelectedIndex();
                            if (text.trim().length() == 0) {
                                sorter.setRowFilter(null);
                            } else if (i == 0) {
                                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                            } /*else {
                                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                            }*/
                        }

                        @Override
                        public void insertUpdate(DocumentEvent e) {
                            String text = intelligenceDataView.getSearchTextField().getText();
                            int i;
                            i = intelligenceDataView.getSearchComboBox().getSelectedIndex();
                            if (text.trim().length() == 0) {
                                sorter.setRowFilter(null);
                            } else if (i == 0) {
                                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                            } /*else {
                                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                            }*/
                        }

                        @Override
                        public void removeUpdate(DocumentEvent e) {
                            String text = intelligenceDataView.getSearchTextField().getText();
                            int i;
                            i = intelligenceDataView.getSearchComboBox().getSelectedIndex();
                            if (text.trim().length() == 0) {
                                sorter.setRowFilter(null);
                            } else if (i == 0) {
                                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                            } /*else {
                                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                            }*/
                        }
                    }
            );

        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
    /**
     *Action listener of rowSelection.
     * Gets column values of selected row and sets to NewReportPanel's related textFields.
     *
     * @author
     */
    private class RowSelectionListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            ListSelectionModel lsm = (ListSelectionModel) e.getSource();
            boolean anyRowSelected = !(lsm.isSelectionEmpty());
            newReportPanel.getUpdateButton().setEnabled(anyRowSelected);
            newReportPanel.getDeleteButton().setEnabled(anyRowSelected);

            try(Connection conn = DriverManager.getConnection(dbUrl, dbName, dbPassword);
                PreparedStatement pst = conn.prepareStatement(SHOW_ATTACHMENT_QUERY)){
                int row = intelligenceDataView.getIntelligenceDataTable().getSelectedRow();

                if (row != -1) { // if there is a selection

                    String Table_click = (intelligenceDataView.getIntelligenceDataTable().getModel().getValueAt(row, 0).toString());
                    pst.setString(1,Table_click);

                    ResultSet rs = pst.executeQuery();
                    if (rs.next()) {
                        String ad1 = rs.getString("ir_country");
                        newReportPanel.getCountryCombobox().setSelectedItem(ad1);
                        String ad2 = rs.getString("ir_city");
                        newReportPanel.getCityTextfield().setText(ad2);
                        String ad3 = rs.getString("ir_county");
                        newReportPanel.getCountyTextfield().setText(ad3);
                        String ad4 = rs.getString("ir_reportername");
                        newReportPanel.getNameTextfield().setText(ad4);
                        String ad5 = rs.getString("ir_reportersurname");
                        newReportPanel.getSurnameTextfield().setText(ad5);
                        String ad6 = rs.getString("ir_reporterphone");
                        newReportPanel.getPhoneTextfield().setText(ad6);
                        String ad7 = rs.getString("ir_reporteremail");
                        newReportPanel.getEmailTextfield().setText(ad7);
                        String ad8 = rs.getString("ir_subject");
                        newReportPanel.getSubjectTextfield().setText(ad8);
                        String ad9 = rs.getString("ir_details");
                        newReportPanel.getDetailsTextarea().setText(ad9);
                        String ad0 = rs.getString("ir_id");
                        newReportPanel.getLblidv().setText(ad0);

                    }
                    newReportPanel.getSaveButton().setEnabled(false);
                }
            }

            catch (SQLException e4) {
                System.out.println(e4);
                //JOptionPane.showMessageDialog(null, e4);
            }
        }

    }

}

