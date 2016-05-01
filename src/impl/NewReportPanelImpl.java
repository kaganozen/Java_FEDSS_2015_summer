package impl;

import gui.Attachment;
import gui.IntelligenceDataView;
import gui.MainUI;
import gui.NewReportPanel;
import helper.IntelligenceDataTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;


/**
 * Implementation of NewReportPanel Panel and includes action listeners of Update, Save, Delete, Clear Form, Attachment button.
 *
 * @author Kaan Ozen
 */
public class NewReportPanelImpl {
    private final static String SAVE_BUTTON_QUERY = "insert into IntelligenceDatabase.intelligence_reports (`ir_country`," +
            "`ir_city`,`ir_county`,`ir_reportername`,`ir_reportersurname`,`ir_reporterphone`,`ir_reporteremail`,`ir_subject`," +
            "`ir_details`,`ir_creationdate`) values(?,?,?,?,?,?,?,?,?,?)";
    private final static String UPDATE_BUTTON_QUERY = "UPDATE intelligence_reports SET ir_country=?, ir_city=?,  " +
            "ir_county=?, ir_reportername=?, ir_reportersurname=?," +
            "ir_reporterphone=?, ir_reporteremail=?, ir_subject=?, " +
            "ir_details=? " +
            "WHERE ir_id=?";
    private final static String DELETE_BUTTON_QUERY = "DELETE FROM intelligence_reports where ir_id=?";
    private final static String ATTACHMENTDEL_ON_USER_DELETE = "DELETE FROM Attachment where fileid_Attachment=?";
    private final static String SELECT_DOWNLOAD_PATH = "SELECT * FROM IntelligenceDatabase.Attachment where fileid_Attachment=?  ";
    private final static String TABLE_VALUES ="SELECT * FROM IntelligenceDatabase.intelligence_reports where ir_id=?";

    private String dbName;
    private String dbPassword;
    private String dbUrl;

    private final NewReportPanel newReportPanel;
    private final IntelligenceDataView intelligenceDataView;

    public NewReportPanelImpl(MainUI mainUI, String db_username, String db_password, String intelligence_db_url) {
        this.newReportPanel = mainUI.getNewReportPanel();
        this.intelligenceDataView = mainUI.getIntelligenceDataView();
        this.dbName = db_username;
        this.dbPassword = db_password;
        this.dbUrl = intelligence_db_url;



        newReportPanel.getUpdateButton().addActionListener(new UpdateListener());
        newReportPanel.getDeleteButton().addActionListener(new DeleteListener());

        newReportPanel.getClearFormButton().addActionListener(new ClearFormListener());
        newReportPanel.getAttachmentButton().addActionListener(new AttachmentListener());
        newReportPanel.getSaveButton().addActionListener(new SaveListener());


    }

    /**
     * Action listener of Update button.
     * Gets textFields entries of NewReportPanel and update related column(s) of selected row.
     *
     * @author
     */
    private class UpdateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            Object cmbvCountry = newReportPanel.getCountryCombobox().getSelectedItem();
            String txtvCity = newReportPanel.getCityTextfield().getText();
            String txtvCounty = newReportPanel.getCountyTextfield().getText();
            String txtvName = newReportPanel.getNameTextfield().getText();
            String txtvSurname = newReportPanel.getSurnameTextfield().getText();
            String txtvPhone = newReportPanel.getPhoneTextfield().getText();
            String txtvEmail = newReportPanel.getEmailTextfield().getText();
            String txtvSubject = newReportPanel.getSubjectTextfield().getText();
            String txtvDetails = newReportPanel.getDetailsTextarea().getText();
            String txtvshow = newReportPanel.getLblidv().getText();

            try (Connection conn = DriverManager.getConnection(dbUrl, dbName, dbPassword);
                 PreparedStatement ps = conn.prepareStatement(UPDATE_BUTTON_QUERY)) {

                ps.setObject(1, cmbvCountry);
                ps.setString(2, txtvCity);
                ps.setString(3, txtvCounty);
                ps.setString(4, txtvName);
                ps.setString(5, txtvSurname);
                ps.setString(6, txtvPhone);
                ps.setString(7, txtvEmail);
                ps.setString(8, txtvSubject);
                ps.setString(9, txtvDetails);
                ps.setString(10, txtvshow);

                ps.executeUpdate();

                updateTableData();

                JOptionPane.showMessageDialog(null, "Data Updated");
            } catch (SQLException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "ID error");
            }
        }

        private void updateTableData() {

            DefaultTableModel model = (DefaultTableModel) intelligenceDataView.getIntelligenceDataTable().getModel();

            String id = newReportPanel.getLblidv().getText();
            int userId = Integer.parseInt(id);

            try (Connection conn = DriverManager.getConnection(dbUrl, dbName, dbPassword);
                 PreparedStatement ps = conn.prepareStatement(TABLE_VALUES)) {

                ps.setInt(1, userId);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {

                    String country = rs.getString("ir_country");
                    String city = rs.getString("ir_city");
                    String county = (rs.getString("ir_county"));
                    String name = (rs.getString("ir_reportername"));
                    String surname = (rs.getString("ir_reportersurname"));
                    String phone = (rs.getString("ir_reporterphone"));
                    String email = (rs.getString("ir_reporteremail"));
                    String subject = (rs.getString("ir_subject"));
                    String details = (rs.getString("ir_details"));

                    model.setValueAt(country, intelligenceDataView.getIntelligenceDataTable().getSelectedRow(),2);
                    model.setValueAt(city, intelligenceDataView.getIntelligenceDataTable().getSelectedRow(),3);
                    model.setValueAt(county, intelligenceDataView.getIntelligenceDataTable().getSelectedRow(),4);
                    model.setValueAt(name, intelligenceDataView.getIntelligenceDataTable().getSelectedRow(),5);
                    model.setValueAt(surname, intelligenceDataView.getIntelligenceDataTable().getSelectedRow(),6);
                    model.setValueAt(phone, intelligenceDataView.getIntelligenceDataTable().getSelectedRow(),7);
                    model.setValueAt(email, intelligenceDataView.getIntelligenceDataTable().getSelectedRow(),8);
                    model.setValueAt(subject, intelligenceDataView.getIntelligenceDataTable().getSelectedRow(),9);
                    model.setValueAt(details, intelligenceDataView.getIntelligenceDataTable().getSelectedRow(),10);


                }

            }
            catch(SQLException e1){
                e1.printStackTrace();
            }

        }

    }

    /**
     * Action listener of Delete button.
     * Gets selected row's id and delete row from database.
     * Also delete attachment of desired to be deleted.
     *
     * @author
     */
    private class DeleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Delete?", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {

                try (Connection conn = DriverManager.getConnection(dbUrl, dbName, dbPassword);
                     PreparedStatement ps = conn.prepareStatement(DELETE_BUTTON_QUERY);
                     PreparedStatement ps1 = conn.prepareStatement(ATTACHMENTDEL_ON_USER_DELETE);
                     PreparedStatement ps2 = conn.prepareStatement(SELECT_DOWNLOAD_PATH)) {

                    int attachmentId = Integer.parseInt(newReportPanel.getLblidv().getText());
                    ps.setInt(1, attachmentId);
                    ps.execute();

                    ps2.setInt(1, attachmentId);
                    ResultSet rs2 = ps2.executeQuery();

                    while (rs2.next()) {
                        String filepath = (rs2.getString("downpath_Attachment"));
                        File f = new File(filepath);

                        if (f.delete()) {
                            System.out.println(f.getName() + " is deleted!");
                        } else {
                            System.out.println("Delete operation is failed.");
                        }
                    }

                    ps1.setString(1, newReportPanel.getLblidv().getText());
                    ps1.execute();

                    deleteTableData();



                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null, e1);
                }
            }

        }

        private void deleteTableData() {

            DefaultTableModel model = (DefaultTableModel) intelligenceDataView.getIntelligenceDataTable().getModel();
            model.removeRow(intelligenceDataView.getIntelligenceDataTable().getSelectedRow());
        }

        }



    private class ClearFormListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            newReportPanel.getCountryCombobox().setSelectedItem(null);
            newReportPanel.getCityTextfield().setText(null);
            newReportPanel.getCountyTextfield().setText(null);
            newReportPanel.getNameTextfield().setText(null);
            newReportPanel.getSurnameTextfield().setText(null);
            newReportPanel.getPhoneTextfield().setText(null);
            newReportPanel.getEmailTextfield().setText(null);
            newReportPanel.getSubjectTextfield().setText(null);
            newReportPanel.getDetailsTextarea().setText(null);
            newReportPanel.getSaveButton().setEnabled(true);
        }

    }

    private class AttachmentListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            Attachment attachment = new Attachment((JFrame) newReportPanel.getTopLevelAncestor());
            attachment.setVisible(true);

            new AttachmentImpl(newReportPanel, attachment, dbName, dbPassword, dbUrl);
        }

    }

    private class SaveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            int userId = -1;

            Object cntry = newReportPanel.getCountryCombobox().getSelectedItem();
            String cty = newReportPanel.getCityTextfield().getText();
            String cnty = newReportPanel.getCountyTextfield().getText();
            String nm = newReportPanel.getNameTextfield().getText();
            String snm = newReportPanel.getSurnameTextfield().getText();
            String phn = newReportPanel.getPhoneTextfield().getText();
            String ml = newReportPanel.getEmailTextfield().getText();
            String sbj = newReportPanel.getSubjectTextfield().getText();
            String dts = newReportPanel.getDetailsTextarea().getText();

            /*String[] elems = new String[]{
                    cnty, cty, cnty, nm, snm, phn, ml, sbj, dts
            };*/


            try (Connection conn = DriverManager.getConnection(dbUrl, dbName, dbPassword);
                 PreparedStatement st = conn.prepareStatement(SAVE_BUTTON_QUERY, Statement.RETURN_GENERATED_KEYS)) {

                DateFormat formatter2 = new SimpleDateFormat("yyyyMMdd");
                Date date = new Date();
                String currentDate = formatter2.format(date);

                st.setString(1, (String) cntry);
                st.setString(2, cty);
                st.setString(3, cnty);
                st.setString(4, nm);
                st.setString(5, snm);
                st.setString(6, phn);
                st.setString(7, ml);
                st.setString(8, sbj);
                st.setString(9, dts);
                st.setString(10, currentDate);

                int rowId = st.executeUpdate();

                JOptionPane.showMessageDialog(null, "Intelligence added");
                newReportPanel.getCityTextfield().setText(null);
                newReportPanel.getCountyTextfield().setText(null);
                newReportPanel.getNameTextfield().setText(null);
                newReportPanel.getSurnameTextfield().setText(null);
                newReportPanel.getPhoneTextfield().setText(null);
                newReportPanel.getEmailTextfield().setText(null);
                newReportPanel.getDetailsTextarea().setText(null);

                if (rowId  == 0) {
                    throw new SQLException("Creating user failed, no rows affected.");
                } else {
                    ResultSet generatedKeys = st.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        userId = (int) generatedKeys.getLong(1);
                        insertTableData(userId);
                    } else {
                        throw new SQLException("Creating user failed, no ID obtained.");
                    }
                }


            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

        private void insertTableData(int userId) {

            DefaultTableModel model = (DefaultTableModel) intelligenceDataView.getIntelligenceDataTable().getModel();

            try (Connection conn = DriverManager.getConnection(dbUrl, dbName, dbPassword);
                 PreparedStatement ps = conn.prepareStatement(TABLE_VALUES)) {

                ps.setInt(1, userId);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {

                    int id = (rs.getInt("ir_id"));
                    String date = rs.getString("ir_creationdate");
                    String country = rs.getString("ir_country");
                    String city = rs.getString("ir_city");
                    String county = (rs.getString("ir_county"));
                    String name = (rs.getString("ir_reportername"));
                    String surname = (rs.getString("ir_reportersurname"));
                    String phone = (rs.getString("ir_reporterphone"));
                    String email = (rs.getString("ir_reporteremail"));
                    String subject = (rs.getString("ir_subject"));
                    String details = (rs.getString("ir_details"));

                    model.insertRow(intelligenceDataView.getIntelligenceDataTable().getRowCount(), new Object[]{
                            id,
                            date,
                            country,
                            city,
                            county,
                            name,
                            surname,
                            phone,
                            email,
                            subject,
                            details
                    });



                }

            }
            catch(SQLException e1){
                e1.printStackTrace();
            }

        }
    }

}