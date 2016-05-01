package impl;

import gui.Attachment;
import gui.NewReportPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.*;

/**
 * Implementation of Attachment Panel and includes action listeners of Add, Download, Download To, Delete, Change buttons.
 *
 * @author Kaan Ozen
 */
public class AttachmentImpl {

    private final static String ADD_ATTACHMENT_QUERY = "INSERT INTO IntelligenceDatabase.Attachment (name_Attachment,path_Attachment,file_Attachment,fileid_Attachment,no_Attachment) values(?,?,?,?,?)";
    private final static String DELETE_ATTACHMENT_QUERY ="DELETE FROM IntelligenceDatabase.Attachment WHERE fileid_Attachment=? AND no_Attachment=?";
    private final static String DOWNLOAD_ATTACHMENT_QUERY= "SELECT * FROM IntelligenceDatabase.Attachment WHERE fileid_Attachment=? and no_Attachment=?";
    private final static String DOWNLOAD_ATTACHMENT_QUERY_2= "SELECT * FROM IntelligenceDatabase.Attachment WHERE fileid_Attachment=?";
    private final static String LOCATION_ATTACHMENT_QUERY = "SELECT * FROM IntelligenceDatabase.down_loc";
    private final static String SET_LOCATION_ATTACHMENT_QUERY  = "UPDATE IntelligenceDatabase.down_loc SET down_locc=?";
    private final static String INSERT_DOWNLOAD_LOC ="UPDATE IntelligenceDatabase.Attachment SET downpath_Attachment=? WHERE fileid_Attachment=? and no_Attachment=?";

    private final NewReportPanel newReportPanel;
    private final Attachment attachmentq;

    private String dbName;
    private String dbPassword;
    private String dbUrl;

    /**
     *
     * Constructor.
     * Adds listeners to buttons.
     *
     * @param newReportPanel
     * @param attachment
     * @param dbName
     * @param dbPassword
     * @param dbUrl
     */
    public AttachmentImpl(NewReportPanel newReportPanel, Attachment attachment, String dbName, String dbPassword, String dbUrl) {

        this.newReportPanel = newReportPanel;
        this.attachmentq = attachment;
        this.dbName = dbName;
        this.dbPassword = dbPassword;
        this.dbUrl = dbUrl;

        attachment.getAddButton1().addActionListener(new AddAttachmentListener(1, attachment.getAttachmentTextField1()));
        attachment.getAddButton2().addActionListener(new AddAttachmentListener(2, attachment.getAttachmentTextField2()));
        attachment.getAddButton3().addActionListener(new AddAttachmentListener(3, attachment.getAttachmentTextField3()));

        attachment.getDeleteButton1().addActionListener(new DeleteAttachmentListener(1, attachment.getAttachmentTextField1()));
        attachment.getDeleteButton2().addActionListener(new DeleteAttachmentListener(2, attachment.getAttachmentTextField2()));
        attachment.getDeleteButton3().addActionListener(new DeleteAttachmentListener(3, attachment.getAttachmentTextField3()));

        attachment.getDownloadButton1().addActionListener(new DownloadAttachmentListener(1));
        attachment.getDownloadButton2().addActionListener(new DownloadAttachmentListener(2));
        attachment.getDownloadButton3().addActionListener(new DownloadAttachmentListener(3));

        attachment.getDownloadToButton1().addActionListener(new DownloadToAttachmentListener(1));
        attachment.getDownloadToButton2().addActionListener(new DownloadToAttachmentListener(2));
        attachment.getDownloadToButton3().addActionListener(new DownloadToAttachmentListener(3));

        attachment.getChangeButton().addActionListener(new ChangeAttachmentListener());

        initializeComponents();

    }

    /**
     * Gets id, name and surname from NewReportPanel to Attachment dialog's label.
     * Gets attachment (String)name from database to attachment textFields.
     * Gets download location (String)path from database to locationTextField.
     *
     */
    private void initializeComponents() {

        String attid = newReportPanel.getLblidv().getText();
        attachmentq.getAttachmentidLabel().setText(attid);
        String attname = newReportPanel.getNameTextfield().getText();
        attachmentq.getAttachmentNameLabel().setText(attname);
        String attsur = newReportPanel.getSurnameTextfield().getText();
        attachmentq.getAttachmentSurnameLabel().setText(attsur);

        String idd = attachmentq.getAttachmentidLabel().getText();
        int fow = Integer.parseInt(idd);

        try(Connection conn = DriverManager.getConnection(dbUrl, dbName, dbPassword);
            PreparedStatement pst = conn.prepareStatement(LOCATION_ATTACHMENT_QUERY);
            PreparedStatement pst1 = conn.prepareStatement(DOWNLOAD_ATTACHMENT_QUERY_2)) {

            ResultSet rs = pst.executeQuery();
            rs.first();
            attachmentq.getLocationTextField().setText(rs.getString("down_locc"));

            pst1.setInt(1, fow);
            ResultSet rs1 = pst1.executeQuery();

            while(rs1.next()) {

                if (rs1.getInt("no_Attachment") == 1) {
                    attachmentq.getAttachmentTextField1().setText(rs1.getString("name_Attachment"));
                } else if (rs1.getInt("no_Attachment") == 2) {
                    attachmentq.getAttachmentTextField2().setText(rs1.getString("name_Attachment"));
                } else if (rs1.getInt("no_Attachment") == 3) {
                    attachmentq.getAttachmentTextField3().setText(rs1.getString("name_Attachment"));
                }

            }

            rs.close();
        } catch (SQLException e20){
            e20.printStackTrace();
            JOptionPane.showMessageDialog(null, e20);
        }

    }

    /**
     * Action listener of Add button.
     * Adds attachment (blob)file to database.
     *
     */
    private class AddAttachmentListener implements ActionListener {

        private int attachmentNumber;
        private JTextField textField;

        public AddAttachmentListener(int number, JTextField textField) {
            this.attachmentNumber = number;
            this.textField = textField;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new java.io.File("."));
            fileChooser.setDialogTitle("Choose Destination");
            int returnValue = fileChooser.showOpenDialog(null);
            if(returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();

                String attname = fileChooser.getSelectedFile().getName();
                String absolutePath = fileChooser.getSelectedFile().getAbsolutePath();
                String idd = attachmentq.getAttachmentidLabel().getText();
                int foo = Integer.parseInt(idd);

                try(Connection conn = DriverManager.getConnection(dbUrl, dbName, dbPassword);
                    PreparedStatement preparedStmt = conn.prepareStatement(ADD_ATTACHMENT_QUERY);
                    InputStream attachment = new FileInputStream(new File(absolutePath))){

                    preparedStmt.setString(1, attname);
                    preparedStmt.setString(2, absolutePath);
                    preparedStmt.setBlob(3, attachment);
                    preparedStmt.setInt(4, foo);
                    preparedStmt.setInt(5, attachmentNumber);
                    preparedStmt.executeUpdate();
                    textField.setText(selectedFile.getName());

                    JOptionPane.showMessageDialog(null, "Attachment added");
                } catch (SQLException e5) {
                    JOptionPane.showMessageDialog(null, e5);
                }
                catch (IOException e30){
                    JOptionPane.showMessageDialog(null, e30);
                }
            }
        }

    }

    /**
     * Action listener of Delete button.
     * Delete attachment from database.
     *
     * @author
     */
    private class DeleteAttachmentListener implements ActionListener {

        private int attachmentNumber;
        private JTextField textField;

        public DeleteAttachmentListener(int number, JTextField textField) {
            this.attachmentNumber = number;
            this.textField = textField;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            String atdel1 = attachmentq.getAttachmentidLabel().getText();
            int del1 = Integer.parseInt(atdel1);

            try(Connection conn = DriverManager.getConnection(dbUrl, dbName, dbPassword);
                PreparedStatement ps = conn.prepareStatement(DELETE_ATTACHMENT_QUERY)){
                ps.setInt(1, del1);
                ps.setInt(2, attachmentNumber);
                ps.execute();
                textField.setText(null);
                JOptionPane.showMessageDialog(null, "Attachment 1 deleted");
            }
            catch(SQLException e6){
                JOptionPane.showMessageDialog(null, e6);

            }

        }

    }

    /**
     * Action listener of Download button.
     * Downloads the file to the specified location.
     *
     * @author
     */
    private class DownloadAttachmentListener implements ActionListener {

        private int attachmentNumber;

        public DownloadAttachmentListener(int number) {
            this.attachmentNumber = number;
        }

        @Override
        public void actionPerformed(ActionEvent e) {


            try(Connection conn = DriverManager.getConnection(dbUrl, dbName, dbPassword);
                PreparedStatement ps = conn.prepareStatement(DOWNLOAD_ATTACHMENT_QUERY);
                PreparedStatement ps1 = conn.prepareStatement(LOCATION_ATTACHMENT_QUERY);
                PreparedStatement ps2 = conn.prepareStatement(INSERT_DOWNLOAD_LOC)){
                int del3 = Integer.parseInt(attachmentq.getAttachmentidLabel().getText());
                String attachmentFileName = null;

                if (attachmentNumber == 1) {
                    attachmentFileName = attachmentq.getAttachmentTextField1().getText();
                } else if (attachmentNumber == 2) {
                    attachmentFileName = attachmentq.getAttachmentTextField2().getText();
                } else if (attachmentNumber == 3) {
                    attachmentFileName = attachmentq.getAttachmentTextField3().getText();
                }

                ps2.setString(1, attachmentq.getLocationTextField().getText() + "/" + attachmentFileName);
                ps2.setInt(2, del3);
                ps2.setInt(3, attachmentNumber);

                ps.setInt(1, del3);
                ps.setInt(2, attachmentNumber);

                ResultSet rs = ps.executeQuery();
                ResultSet rs1 = ps1.executeQuery();
                ps2.executeUpdate();

                if (rs.next() && rs1.next()) {//now on 1st row
                    Blob b = rs.getBlob("file_Attachment");

                    byte barr[] = b.getBytes(1, (int) b.length());//1 means first blob
                    try  (FileOutputStream fout = new FileOutputStream(rs1.getString("down_locc") + "/" + rs.getString("name_Attachment") )){
                        fout.write(barr);
                        JOptionPane.showMessageDialog(null, "File downloaded to:" + rs1.getString("down_locc"));
                    }
                    catch (IOException e2){
                        JOptionPane.showMessageDialog(null, e2);
                    }

                }
                ps.close();
                ps1.close();
                conn.close();
            }

            catch (SQLException e21) {
                JOptionPane.showMessageDialog(null, e21);
            }

        }

    }

    /***
     * Action Listener of Download to... button.
     * Chooses file location and download the file to choosen location.
     *
     *@author
     */
    private class DownloadToAttachmentListener implements ActionListener {

        private int attachmentNumber;

        public DownloadToAttachmentListener(int number) {
            this.attachmentNumber = number;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            JFileChooser fileChooser4 = new JFileChooser();
            fileChooser4.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fileChooser4.setAcceptAllFileFilterUsed(false);
            int result = fileChooser4.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {

                File f = fileChooser4.getSelectedFile();
                String path4 = f.getAbsolutePath();

                try(Connection conn = DriverManager.getConnection(dbUrl, dbName, dbPassword);
                    PreparedStatement ps = conn.prepareStatement(DOWNLOAD_ATTACHMENT_QUERY)){
                    String atdel3 = attachmentq.getAttachmentidLabel().getText();
                    int del3 = Integer.parseInt(atdel3);

                    //PreparedStatement ps = conn.prepareStatement(DOWNLOAD_ATTACHMENT_QUERY);
                    ps.setInt(1, del3);
                    ps.setInt(2, attachmentNumber);

                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {//now on 1st row
                        String attname = (rs.getString("name_Attachment"));
                        Blob b = rs.getBlob("file_Attachment");

                        System.out.println("file length is: " + b.length());

                        byte barr[] = b.getBytes(1, (int) b.length());//1 means first blob
                        try (FileOutputStream fout = new FileOutputStream(path4 + "/" + attname)){
                            //FileOutputStream fout = new FileOutputStream(path4 + "/" + attname);
                            fout.write(barr);
                            JOptionPane.showMessageDialog(null, "File downloaded to:" + path4);

                        } catch (IOException e14) {
                            JOptionPane.showMessageDialog(null, e14);
                            System.out.println(e14);
                        }

                    }//end of if
                    System.out.println("ok");
                    ps.close();
                    conn.close();
                }
                catch(SQLException e13){
                    JOptionPane.showMessageDialog(null, e13);

                }

            }

        }

    }

    /**
     * Action listener of Change button.
     * Chooses specific download location path.
     *
     * @author
     */
    private class ChangeAttachmentListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            /*String url = "jdbc:mysql://localhost:3306/IntelligenceDatabase";
            String user = "root";
            String pass = "rootroot";*/

            JFileChooser fileChooser4 = new JFileChooser();
            fileChooser4.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fileChooser4.setAcceptAllFileFilterUsed(false);
            int result = fileChooser4.showOpenDialog(null);


            if (result == JFileChooser.APPROVE_OPTION) {

                File f = fileChooser4.getSelectedFile();
                String path4 = f.getAbsolutePath();


                try (Connection conn = DriverManager.getConnection(dbUrl, dbName, dbPassword);
                     PreparedStatement ps = conn.prepareStatement(SET_LOCATION_ATTACHMENT_QUERY)) {

                    ps.setString(1, path4);

                    ps.executeUpdate();
                    attachmentq.getLocationTextField().setText(path4);

                }
                catch (SQLException e7) {
                    System.out.println("7" + e7);
                }

            }

        }

    }


}
