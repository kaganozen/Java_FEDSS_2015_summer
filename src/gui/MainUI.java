/*
 * Created by JFormDesigner on Thu May 21 10:36:01 EEST 2015
 */

package gui;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author User #1
 */
public class MainUI {
    
    public MainUI() {
        initComponents();
    }

    public JFrame getIntelligenceToolFrame() {
        return intelligenceToolFrame;
    }

    public IntelligenceDataView getIntelligenceDataView() {
        return intelligenceDataView;
    }

    public NewReportPanel getNewReportPanel() {
        return newReportPanel;
    }

    private void initComponents() {

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        intelligenceToolFrame = new JFrame();
        newReportPanel = new NewReportPanel();
        intelligenceDataView = new IntelligenceDataView(newReportPanel);

        //======== intelligenceToolFrame ========
        {
            intelligenceToolFrame.setTitle("FedSS - Intelligence Management");
            Container intelligenceToolFrameContentPane = intelligenceToolFrame.getContentPane();
            intelligenceToolFrameContentPane.setLayout(new FormLayout(
                "$ugap, default:grow, $ugap",
                "$ugap, fill:default:grow, $ugap, fill:pref, $ugap"));
            intelligenceToolFrameContentPane.add(intelligenceDataView, CC.xy(2, 2));
            intelligenceToolFrameContentPane.add(newReportPanel, CC.xy(2, 4));
            intelligenceToolFrame.pack();
            intelligenceToolFrame.setLocationRelativeTo(intelligenceToolFrame.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JFrame intelligenceToolFrame;
    private IntelligenceDataView intelligenceDataView;
    private NewReportPanel newReportPanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
