import gui.MainUI;
import impl.IntelligenceDataViewImpl;
import impl.NewReportPanelImpl;

import javax.swing.table.DefaultTableModel;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

/**
 * Created by balis on 20.05.2015.
 */
public class Main {

    private final static String USERS_QUERY = "select * from intelligence_reports";

    private Connection conn = null;
    private MainUI mainUI = null;
    private Timer dbConnectionTimer;

    private Properties prop = null;
    private boolean isOnScreen = false;

    /**
     * @param args
     */
    public static void main(String[] args) {

        final Main main = new Main();
        main.readProperties();
        main.getStarted();

    }

    private void readProperties(){
        prop = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream("src/resources/config.properties");
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void getStarted() {

        mainUI = new MainUI();
        new NewReportPanelImpl(mainUI, prop.getProperty("DB_USERNAME"), prop.getProperty("DB_PASSWORD"), prop.getProperty("INTELLIGENCE_DB_URL"));
        new IntelligenceDataViewImpl(mainUI, prop.getProperty("DB_USERNAME"), prop.getProperty("DB_PASSWORD"), prop.getProperty("INTELLIGENCE_DB_URL"));

        if (tryConnection()) {
            updateTableData();
        }

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                tryConnection();
            }
        };

        dbConnectionTimer = new Timer();
        dbConnectionTimer.schedule(timerTask, 0L, 1000L);

    }


    private boolean tryConnection() {
        try {
            if (conn == null || !conn.isValid(1000)) {
                conn = null;
                mainUI.getIntelligenceDataView().getDbDisconnectedLabel().setVisible(true);
                mainUI.getIntelligenceDataView().getDbConnectedLabel().setVisible(false);
                conn = DriverManager.getConnection(prop.getProperty("INTELLIGENCE_DB_URL"), prop.getProperty("DB_USERNAME"), prop.getProperty("DB_PASSWORD"));
            }
            else {
                if (!isOnScreen) {
                    mainUI.getIntelligenceToolFrame().setSize(1000, 700);
                    mainUI.getIntelligenceToolFrame().setVisible(true);
                    isOnScreen = true;
                }
                mainUI.getIntelligenceDataView().getDbDisconnectedLabel().setVisible(false);
                mainUI.getIntelligenceDataView().getDbConnectedLabel().setVisible(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn != null;
    }

    private void updateTableData() {

        try (Connection conn = DriverManager.getConnection(prop.getProperty("INTELLIGENCE_DB_URL"), prop.getProperty("DB_USERNAME"), prop.getProperty("DB_PASSWORD"));
             PreparedStatement ps = conn.prepareStatement(USERS_QUERY)) {

            ResultSet resultSet = ps.executeQuery();
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            Vector<String> headers = new Vector<String>();

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            // Adaptive to table column changes. Maybe unnecessary to repeat here
            for (int i = 1; i <= columnCount; i++) {
                headers.addElement(metaData.getColumnName(i));
            }

            while (resultSet.next()) {
                Vector<Object> tempVector = new Vector<Object>();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    tempVector.add(resultSet.getObject(columnIndex));
                }
                data.add(tempVector);
            }

            mainUI.getIntelligenceDataView().getIntelligenceDataTable().setTableData(data, headers);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
