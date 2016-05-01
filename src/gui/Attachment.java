/*
 * Created by JFormDesigner on Fri Jul 24 14:39:00 EEST 2015
 */

package gui;

import java.awt.*;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author KaÄan Ãzen
 */
public class Attachment extends JDialog {
    public Attachment(Frame owner) {
        super(owner);
        initComponents();
    }

    public Attachment(Dialog owner) {
        super(owner);
        initComponents();
    }

    public JLabel getAttachmentidLabel() {
        return attachmentidLabel;
    }

    public JLabel getAttachmentNameLabel() {
        return attachmentNameLabel;
    }

    public JLabel getAttachmentSurnameLabel() {
        return attachmentSurnameLabel;
    }

    public JTextField getAttachmentTextField1() {
        return attachmentTextField1;
    }

    public JButton getAddButton1() {
        return addButton1;
    }

    public JButton getDownloadButton1() {
        return downloadButton1;
    }

    public JButton getDownloadToButton1() {
        return downloadToButton1;
    }

    public JButton getDeleteButton1() {
        return deleteButton1;
    }

    public JTextField getAttachmentTextField2() {
        return attachmentTextField2;
    }

    public JButton getAddButton2() {
        return addButton2;
    }

    public JButton getDownloadButton2() {
        return downloadButton2;
    }

    public JButton getDownloadToButton2() {
        return downloadToButton2;
    }

    public JButton getDeleteButton2() {
        return deleteButton2;
    }

    public JTextField getAttachmentTextField3() {
        return attachmentTextField3;
    }

    public JButton getAddButton3() {
        return addButton3;
    }

    public JButton getDownloadButton3() {
        return downloadButton3;
    }

    public JButton getDownloadToButton3() {
        return downloadToButton3;
    }

    public JButton getDeleteButton3() {
        return deleteButton3;
    }

    public JTextField getLocationTextField() {
        return locationTextField;
    }

    public JButton getChangeButton() {
        return changeButton;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - KaÄan Ãzen
        panel1 = new JPanel();
        attachmentidLabel = new JLabel();
        attachmentNameLabel = new JLabel();
        attachmentSurnameLabel = new JLabel();
        label1 = new JLabel();
        attachmentTextField1 = new JTextField();
        panel2 = new JPanel();
        addButton1 = new JButton();
        downloadButton1 = new JButton();
        downloadToButton1 = new JButton();
        deleteButton1 = new JButton();
        label2 = new JLabel();
        attachmentTextField2 = new JTextField();
        panel3 = new JPanel();
        addButton2 = new JButton();
        downloadButton2 = new JButton();
        downloadToButton2 = new JButton();
        deleteButton2 = new JButton();
        label3 = new JLabel();
        attachmentTextField3 = new JTextField();
        panel4 = new JPanel();
        addButton3 = new JButton();
        downloadButton3 = new JButton();
        downloadToButton3 = new JButton();
        deleteButton3 = new JButton();
        lblSave = new JLabel();
        locationTextField = new JTextField();
        panel5 = new JPanel();
        changeButton = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setPreferredSize(new Dimension(570, 200));

            // JFormDesigner evaluation mark
            panel1.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            panel1.setLayout(new FormLayout(
                "default, left:94dlu:grow, [196px,pref]:grow",
                "fill:default, 4*($lgap, default)"));

            //---- attachmentidLabel ----
            attachmentidLabel.setText("-");
            panel1.add(attachmentidLabel, CC.xy(1, 1));

            //---- attachmentNameLabel ----
            attachmentNameLabel.setText("-");
            panel1.add(attachmentNameLabel, CC.xy(2, 1));

            //---- attachmentSurnameLabel ----
            attachmentSurnameLabel.setText("-");
            panel1.add(attachmentSurnameLabel, CC.xy(3, 1));

            //---- label1 ----
            label1.setText("Attachment1:  ");
            panel1.add(label1, CC.xy(1, 3));

            //---- attachmentTextField1 ----
            attachmentTextField1.setPreferredSize(new Dimension(200, 34));
            attachmentTextField1.setEditable(false);
            panel1.add(attachmentTextField1, CC.xy(2, 3, CC.DEFAULT, CC.CENTER));

            //======== panel2 ========
            {
                panel2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                panel2.setPreferredSize(new Dimension(500, 40));
                panel2.setLayout(new FlowLayout(FlowLayout.LEFT));

                //---- addButton1 ----
                addButton1.setText("Add");
                addButton1.setPreferredSize(new Dimension(80, 34));
                panel2.add(addButton1);

                //---- downloadButton1 ----
                downloadButton1.setText("Download");
                downloadButton1.setPreferredSize(new Dimension(130, 34));
                panel2.add(downloadButton1);

                //---- downloadToButton1 ----
                downloadToButton1.setText("Download to...");
                downloadToButton1.setPreferredSize(new Dimension(145, 34));
                panel2.add(downloadToButton1);

                //---- deleteButton1 ----
                deleteButton1.setText("Delete");
                deleteButton1.setPreferredSize(new Dimension(120, 34));
                panel2.add(deleteButton1);
            }
            panel1.add(panel2, CC.xy(3, 3));

            //---- label2 ----
            label2.setText("Attachment2:   ");
            panel1.add(label2, CC.xy(1, 5));

            //---- attachmentTextField2 ----
            attachmentTextField2.setPreferredSize(new Dimension(200, 34));
            attachmentTextField2.setEditable(false);
            panel1.add(attachmentTextField2, CC.xy(2, 5));

            //======== panel3 ========
            {
                panel3.setPreferredSize(new Dimension(500, 40));
                panel3.setLayout(new FlowLayout(FlowLayout.LEFT));

                //---- addButton2 ----
                addButton2.setText("Add");
                addButton2.setPreferredSize(new Dimension(80, 34));
                panel3.add(addButton2);

                //---- downloadButton2 ----
                downloadButton2.setText("Download");
                downloadButton2.setPreferredSize(new Dimension(130, 34));
                panel3.add(downloadButton2);

                //---- downloadToButton2 ----
                downloadToButton2.setText("Download to...");
                downloadToButton2.setPreferredSize(new Dimension(145, 34));
                panel3.add(downloadToButton2);

                //---- deleteButton2 ----
                deleteButton2.setText("Delete");
                deleteButton2.setPreferredSize(new Dimension(120, 34));
                panel3.add(deleteButton2);
            }
            panel1.add(panel3, CC.xy(3, 5));

            //---- label3 ----
            label3.setText("Attachment3:   ");
            panel1.add(label3, CC.xy(1, 7));

            //---- attachmentTextField3 ----
            attachmentTextField3.setPreferredSize(new Dimension(200, 34));
            attachmentTextField3.setEditable(false);
            panel1.add(attachmentTextField3, CC.xy(2, 7));

            //======== panel4 ========
            {
                panel4.setPreferredSize(new Dimension(500, 40));
                panel4.setLayout(new FlowLayout(FlowLayout.LEFT));

                //---- addButton3 ----
                addButton3.setText("Add");
                addButton3.setPreferredSize(new Dimension(80, 34));
                panel4.add(addButton3);

                //---- downloadButton3 ----
                downloadButton3.setText("Download");
                downloadButton3.setPreferredSize(new Dimension(130, 34));
                panel4.add(downloadButton3);

                //---- downloadToButton3 ----
                downloadToButton3.setText("Download to...");
                downloadToButton3.setPreferredSize(new Dimension(145, 34));
                panel4.add(downloadToButton3);

                //---- deleteButton3 ----
                deleteButton3.setText("Delete");
                deleteButton3.setPreferredSize(new Dimension(120, 34));
                panel4.add(deleteButton3);
            }
            panel1.add(panel4, CC.xy(3, 7));

            //---- lblSave ----
            lblSave.setText("Save Location :");
            panel1.add(lblSave, CC.xy(1, 9));

            //---- locationTextField ----
            locationTextField.setPreferredSize(new Dimension(200, 34));
            locationTextField.setEditable(false);
            panel1.add(locationTextField, CC.xy(2, 9));

            //======== panel5 ========
            {
                panel5.setPreferredSize(new Dimension(260, 40));
                panel5.setLayout(new FlowLayout(FlowLayout.LEFT));

                //---- changeButton ----
                changeButton.setText("Change");
                changeButton.setPreferredSize(new Dimension(100, 34));
                panel5.add(changeButton);
            }
            panel1.add(panel5, CC.xy(3, 9));
        }
        contentPane.add(panel1, BorderLayout.CENTER);
        setSize(840, 245);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - KaÄan Ãzen
    private JPanel panel1;
    private JLabel attachmentidLabel;
    private JLabel attachmentNameLabel;
    private JLabel attachmentSurnameLabel;
    private JLabel label1;
    private JTextField attachmentTextField1;
    private JPanel panel2;
    private JButton addButton1;
    private JButton downloadButton1;
    private JButton downloadToButton1;
    private JButton deleteButton1;
    private JLabel label2;
    private JTextField attachmentTextField2;
    private JPanel panel3;
    private JButton addButton2;
    private JButton downloadButton2;
    private JButton downloadToButton2;
    private JButton deleteButton2;
    private JLabel label3;
    private JTextField attachmentTextField3;
    private JPanel panel4;
    private JButton addButton3;
    private JButton downloadButton3;
    private JButton downloadToButton3;
    private JButton deleteButton3;
    private JLabel lblSave;
    private JTextField locationTextField;
    private JPanel panel5;
    private JButton changeButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
