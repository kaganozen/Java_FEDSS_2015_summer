/*
 * Created by JFormDesigner on Thu May 21 09:43:10 EEST 2015
 */

package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;


/**
 * @author unknown
 */
public class NewReportPanel extends JPanel {
    public static Dialog getUpdateButton;



    public NewReportPanel() {
        initComponents();
        getUpdateButton().setEnabled(false);
        getDeleteButton().setEnabled(false);
        lblidv.setVisible(false);



    }

    public  JComboBox getCountryCombobox() {
        return countryCombobox;
    }

    public  JTextField getSubjectTextfield() {
        return subjectTextfield;
    }

    public  JTextField getCityTextfield() {
        return cityTextfield;
    }

    public  JTextField getCountyTextfield() {
        return countyTextfield;
    }

    public  JTextArea getDetailsTextarea() {
        return detailsTextarea;
    }

    public  JTextField getNameTextfield() {
        return nameTextfield;
    }

    public  JTextField getSurnameTextfield() {return surnameTextfield;}

    public  JTextField getPhoneTextfield() {
        return phoneTextfield;
    }

    public  JTextField getEmailTextfield() {
        return emailTextfield;
    }



    public  JButton getSaveButton() {
        return saveButton;
    }

    public  JButton getUpdateButton() { return updateButton; }

    public  JButton getDeleteButton() { return deleteButton; }

    public  JButton getClearFormButton() { return clearFormButton;}

    public JButton getAttachmentButton() {
        return attachmentButton;
    }

    private void clearFormButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void deleteButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - KaÄan Ãzen
        panel1 = new JPanel();
        countryLabel = new JLabel();
        countryCombobox = new JComboBox<>();
        subjectLabel = new JLabel();
        subjectTextfield = new JTextField();
        cityLabel = new JLabel();
        cityTextfield = new JTextField();
        detailsLabel = new JLabel();
        countyLabel = new JLabel();
        countyTextfield = new JTextField();
        detailsScrollpane = new JScrollPane();
        detailsTextarea = new JTextArea();
        nameLabel = new JLabel();
        nameTextfield = new JTextField();
        surnameLabel = new JLabel();
        surnameTextfield = new JTextField();
        phoneLabel = new JLabel();
        phoneTextfield = new JTextField();
        emailLabel = new JLabel();
        emailTextfield = new JTextField();
        lblidv = new JLabel();
        label1 = new JLabel();
        attachmentButton = new JButton();
        clearFormButton = new JButton();
        panel2 = new JPanel();
        deleteButton = new JButton();
        updateButton = new JButton();
        saveButton = new JButton();

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new FormLayout(
            "default:grow",
            "fill:default:grow"));

        //======== panel1 ========
        {
            panel1.setBorder(new TitledBorder("Create/Update/Delete  intelligence"));
            panel1.setLayout(new FormLayout(
                "$ugap, pref, $lcgap, [pref,150px], 20px, default, $lcgap, [120px,default]:grow, $ugap",
                "7*($lgap, fill:default), default:grow, 2*($lgap, default), $lgap"));
            ((FormLayout)panel1.getLayout()).setRowGroups(new int[][] {{2, 4, 6, 8, 10, 12, 14}});

            //---- countryLabel ----
            countryLabel.setText("Country*");
            countryLabel.setLabelFor(countryCombobox);
            panel1.add(countryLabel, CC.xy(2, 2));

            //---- countryCombobox ----
            countryCombobox.setModel(new DefaultComboBoxModel<>(new String[] {
                "Afghanistan",
                "\u00c5land Islands",
                "Albania",
                "Algeria",
                "American Samoa",
                "Andorra",
                "Angola",
                "Anguilla",
                "Antarctica",
                "Antigua And Barbuda",
                "Argentina",
                "Armenia",
                "Aruba",
                "Australia",
                "Austria",
                "Azerbaijan",
                "Bahamas",
                "Bahrain",
                "Bangladesh",
                "Barbados",
                "Belarus",
                "Belgium",
                "Belize",
                "Benin",
                "Bermuda",
                "Bhutan",
                "Bolivia",
                "Bosnia And Herzegovina",
                "Botswana",
                "Bouvet Island",
                "Brazil",
                "British Indian Ocean Territory",
                "Brunei Darussalam",
                "Bulgaria",
                "Burkina Faso",
                "Burundi",
                "Cambodia",
                "Cameroon",
                "Canada",
                "Cape Verde",
                "Cayman Islands",
                "Central African Republic",
                "Chad",
                "Chile",
                "China",
                "Christmas Island",
                "Cocos (Keeling) Islands",
                "Colombia",
                "Comoros",
                "Congo",
                "Congo, The Democratic Republic Of The",
                "Cook Islands",
                "Costa Rica",
                "Cote D'ivoire",
                "Croatia",
                "Cuba",
                "Cyprus",
                "Czech Republic",
                "Denmark",
                "Djibouti",
                "Dominica",
                "Dominican Republic",
                "Ecuador",
                "Egypt",
                "El Salvador",
                "Equatorial Guinea",
                "Eritrea",
                "Estonia",
                "Ethiopia",
                "Falkland Islands (Malvinas)",
                "Faroe Islands",
                "Fiji",
                "Finland",
                "France",
                "French Guiana",
                "French Polynesia",
                "French Southern Territories",
                "Gabon",
                "Gambia",
                "Georgia",
                "Germany",
                "Ghana",
                "Gibraltar",
                "Greece",
                "Greenland",
                "Grenada",
                "Guadeloupe",
                "Guam",
                "Guatemala",
                "Guernsey",
                "Guinea",
                "Guinea-bissau",
                "Guyana",
                "Haiti",
                "Heard Island And Mcdonald Islands",
                "Holy See (Vatican City State)",
                "Honduras",
                "Hong Kong",
                "Hungary",
                "Iceland",
                "India",
                "Indonesia",
                "Iran, Islamic Republic Of",
                "Iraq",
                "Ireland",
                "Isle Of Man",
                "Israel",
                "Italy",
                "Jamaica",
                "Japan",
                "Jersey",
                "Jordan",
                "Kazakhstan",
                "Kenya",
                "Kiribati",
                "Korea, Democratic People's Republic Of",
                "Korea, Republic Of",
                "Kuwait",
                "Kyrgyzstan",
                "Lao People's Democratic Republic",
                "Latvia",
                "Lebanon",
                "Lesotho",
                "Liberia",
                "Libyan Arab Jamahiriya",
                "Liechtenstein",
                "Lithuania",
                "Luxembourg",
                "Macao",
                "Macedonia, The Former Yugoslav Republic Of",
                "Madagascar",
                "Malawi",
                "Malaysia",
                "Maldives",
                "Mali",
                "Malta",
                "Marshall Islands",
                "Martinique",
                "Mauritania",
                "Mauritius",
                "Mayotte",
                "Mexico",
                "Micronesia, Federated States Of",
                "Moldova, Republic Of",
                "Monaco",
                "Mongolia",
                "Montenegro",
                "Montserrat",
                "Morocco",
                "Mozambique",
                "Myanmar",
                "Namibia",
                "Nauru",
                "Nepal",
                "Netherlands",
                "Netherlands Antilles",
                "New Caledonia",
                "New Zealand",
                "Nicaragua",
                "Niger",
                "Nigeria",
                "Niue",
                "Norfolk Island",
                "Northern Mariana Islands",
                "Norway",
                "Oman",
                "Pakistan",
                "Palau",
                "Palestinian Territory, Occupied",
                "Panama",
                "Papua New Guinea",
                "Paraguay",
                "Peru",
                "Philippines",
                "Pitcairn",
                "Poland",
                "Portugal",
                "Puerto Rico",
                "Qatar",
                "Reunion",
                "Romania",
                "Russian Federation",
                "Rwanda",
                "Saint Helena",
                "Saint Kitts And Nevis",
                "Saint Lucia",
                "Saint Pierre And Miquelon",
                "Saint Vincent And The Grenadines",
                "Samoa",
                "San Marino",
                "Sao Tome And Principe",
                "Saudi Arabia",
                "Senegal",
                "Serbia",
                "Seychelles",
                "Sierra Leone",
                "Singapore",
                "Slovakia",
                "Slovenia",
                "Solomon Islands",
                "Somalia",
                "South Africa",
                "South Georgia And The South Sandwich Islands",
                "Spain",
                "Sri Lanka",
                "Sudan",
                "Suriname",
                "Svalbard And Jan Mayen",
                "Swaziland",
                "Sweden",
                "Switzerland",
                "Syrian Arab Republic",
                "Taiwan, Province Of China",
                "Tajikistan",
                "Tanzania, United Republic Of",
                "Thailand",
                "Timor-leste",
                "Togo",
                "Tokelau",
                "Tonga",
                "Trinidad And Tobago",
                "Tunisia",
                "Turkey",
                "Turkmenistan",
                "Turks And Caicos Islands",
                "Tuvalu",
                "Uganda",
                "Ukraine",
                "United Arab Emirates",
                "United Kingdom",
                "United States",
                "United States Minor Outlying Islands",
                "Uruguay",
                "Uzbekistan",
                "Vanuatu",
                "Venezuela",
                "Viet Nam",
                "Virgin Islands, British",
                "Virgin Islands, U.S.",
                "Wallis And Futuna",
                "Western Sahara",
                "Yemen",
                "Zambia",
                "Zimbabwe"
            }));
            countryCombobox.setNextFocusableComponent(cityTextfield);
            panel1.add(countryCombobox, CC.xy(4, 2));

            //---- subjectLabel ----
            subjectLabel.setText("Subject*");
            subjectLabel.setLabelFor(subjectTextfield);
            panel1.add(subjectLabel, CC.xy(6, 2));

            //---- subjectTextfield ----
            subjectTextfield.setNextFocusableComponent(detailsTextarea);
            panel1.add(subjectTextfield, CC.xy(8, 2));

            //---- cityLabel ----
            cityLabel.setText("City*");
            cityLabel.setLabelFor(cityTextfield);
            panel1.add(cityLabel, CC.xy(2, 4));

            //---- cityTextfield ----
            cityTextfield.setNextFocusableComponent(countyTextfield);
            panel1.add(cityTextfield, CC.xy(4, 4));

            //---- detailsLabel ----
            detailsLabel.setText("Details*");
            detailsLabel.setLabelFor(detailsTextarea);
            panel1.add(detailsLabel, CC.xy(6, 4));

            //---- countyLabel ----
            countyLabel.setText("County");
            countyLabel.setLabelFor(countyTextfield);
            panel1.add(countyLabel, CC.xy(2, 6));

            //---- countyTextfield ----
            countyTextfield.setNextFocusableComponent(nameTextfield);
            panel1.add(countyTextfield, CC.xy(4, 6));

            //======== detailsScrollpane ========
            {

                //---- detailsTextarea ----
                detailsTextarea.setNextFocusableComponent(saveButton);
                detailsTextarea.setLineWrap(true);
                detailsScrollpane.setViewportView(detailsTextarea);
            }
            panel1.add(detailsScrollpane, CC.xywh(8, 4, 1, 12));

            //---- nameLabel ----
            nameLabel.setText("Name");
            nameLabel.setLabelFor(nameTextfield);
            panel1.add(nameLabel, CC.xy(2, 8));

            //---- nameTextfield ----
            nameTextfield.setNextFocusableComponent(surnameTextfield);
            panel1.add(nameTextfield, CC.xy(4, 8));

            //---- surnameLabel ----
            surnameLabel.setText("Surname");
            surnameLabel.setLabelFor(surnameTextfield);
            panel1.add(surnameLabel, CC.xy(2, 10));

            //---- surnameTextfield ----
            surnameTextfield.setNextFocusableComponent(phoneTextfield);
            panel1.add(surnameTextfield, CC.xy(4, 10));

            //---- phoneLabel ----
            phoneLabel.setText("Phone");
            phoneLabel.setLabelFor(phoneTextfield);
            panel1.add(phoneLabel, CC.xy(2, 12));

            //---- phoneTextfield ----
            phoneTextfield.setNextFocusableComponent(emailTextfield);
            panel1.add(phoneTextfield, CC.xy(4, 12));

            //---- emailLabel ----
            emailLabel.setText("E-mail");
            emailLabel.setLabelFor(emailTextfield);
            panel1.add(emailLabel, CC.xy(2, 14));

            //---- emailTextfield ----
            emailTextfield.setNextFocusableComponent(subjectTextfield);
            panel1.add(emailTextfield, CC.xy(4, 14));

            //---- lblidv ----
            lblidv.setText("-");
            panel1.add(lblidv, CC.xy(2, 15));

            //---- label1 ----
            label1.setText("Attach.");
            panel1.add(label1, CC.xy(2, 17));

            //---- attachmentButton ----
            attachmentButton.setText("...");
            panel1.add(attachmentButton, CC.xy(4, 17));

            //---- clearFormButton ----
            clearFormButton.setText("Clear Form");
            panel1.add(clearFormButton, CC.xy(4, 19));

            //======== panel2 ========
            {
                panel2.setLayout(new FlowLayout());

                //---- deleteButton ----
                deleteButton.setText("Delete");
                deleteButton.setPreferredSize(new Dimension(140, 34));
                panel2.add(deleteButton);

                //---- updateButton ----
                updateButton.setText("Update");
                updateButton.setPreferredSize(new Dimension(140, 34));
                panel2.add(updateButton);

                //---- saveButton ----
                saveButton.setText("Save ");
                saveButton.setNextFocusableComponent(countryCombobox);
                saveButton.setPreferredSize(new Dimension(140, 34));
                panel2.add(saveButton);
            }
            panel1.add(panel2, CC.xy(8, 19));
        }
        add(panel1, CC.xy(1, 1));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JLabel getCountryLabel() {
        return countryLabel;
    }

    public void setCountryLabel(JLabel countryLabel) {
        this.countryLabel = countryLabel;
    }

    public void setCountryCombobox(JComboBox countryCombobox) {
        this.countryCombobox = countryCombobox;
    }

    public JLabel getSubjectLabel() {
        return subjectLabel;
    }

    public void setSubjectLabel(JLabel subjectLabel) {
        this.subjectLabel = subjectLabel;
    }

    public void setSubjectTextfield(JTextField subjectTextfield) {
        this.subjectTextfield = subjectTextfield;
    }

    public JLabel getCityLabel() {
        return cityLabel;
    }

    public void setCityLabel(JLabel cityLabel) {
        this.cityLabel = cityLabel;
    }

    public void setCityTextfield(JTextField cityTextfield) {
        this.cityTextfield = cityTextfield;
    }

    public JLabel getDetailsLabel() {
        return detailsLabel;
    }

    public void setDetailsLabel(JLabel detailsLabel) {
        this.detailsLabel = detailsLabel;
    }

    public JLabel getCountyLabel() {
        return countyLabel;
    }

    public void setCountyLabel(JLabel countyLabel) {
        this.countyLabel = countyLabel;
    }

    public void setCountyTextfield(JTextField countyTextfield) {
        this.countyTextfield = countyTextfield;
    }

    public JScrollPane getDetailsScrollpane() {
        return detailsScrollpane;
    }

    public void setDetailsScrollpane(JScrollPane detailsScrollpane) {
        this.detailsScrollpane = detailsScrollpane;
    }

    public void setDetailsTextarea(JTextArea detailsTextarea) {
        this.detailsTextarea = detailsTextarea;
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public void setNameLabel(JLabel nameLabel) {
        this.nameLabel = nameLabel;
    }

    public void setNameTextfield(JTextField nameTextfield) {
        this.nameTextfield = nameTextfield;
    }

    public JLabel getSurnameLabel() {
        return surnameLabel;
    }

    public void setSurnameLabel(JLabel surnameLabel) {this.surnameLabel = surnameLabel;
    }

    public void setSurnameTextfield(JTextField surnameTextfield) {
        this.surnameTextfield = surnameTextfield;
    }

    public JLabel getPhoneLabel() {
        return phoneLabel;
    }

    public void setPhoneLabel(JLabel phoneLabel) {
        this.phoneLabel = phoneLabel;
    }

    public void setPhoneTextfield(JTextField phoneTextfield) {
        this.phoneTextfield = phoneTextfield;
    }

    public JLabel getEmailLabel() {
        return emailLabel;
    }

    public void setEmailLabel(JLabel emailLabel) {
        this.emailLabel = emailLabel;
    }

    public void setEmailTextfield(JTextField emailTextfield) {
        this.emailTextfield = emailTextfield;
    }

    public void setSaveButton(JButton saveButton) {
        this.saveButton = saveButton;
    }

    public void setUpdateButton(JButton updateButton) {
        this.updateButton = updateButton;
    }

    public void setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
    }

    public void setClearFormButton(JButton clearFormButton) {
        this.clearFormButton = clearFormButton;
    }

    public JLabel getLblidv() {return lblidv;}

    public void setLblidv(JLabel lblidv) {
        this.lblidv = lblidv;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - KaÄan Ãzen
    private JPanel panel1;
    private JLabel countryLabel;
    private JComboBox<String> countryCombobox;
    private JLabel subjectLabel;
    private JTextField subjectTextfield;
    private JLabel cityLabel;
    private JTextField cityTextfield;
    private JLabel detailsLabel;
    private JLabel countyLabel;
    private JTextField countyTextfield;
    private JScrollPane detailsScrollpane;
    private JTextArea detailsTextarea;
    private JLabel nameLabel;
    private JTextField nameTextfield;
    private JLabel surnameLabel;
    private JTextField surnameTextfield;
    private JLabel phoneLabel;
    private JTextField phoneTextfield;
    private JLabel emailLabel;
    private JTextField emailTextfield;
    private JLabel lblidv;
    private JLabel label1;
    private JButton attachmentButton;
    private JButton clearFormButton;
    private JPanel panel2;
    private JButton deleteButton;
    private JButton updateButton;
    private JButton saveButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
