/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.SQLiteUtility;

import Business.EcoSystem;
import Business.ConfigureASystem;
import com.google.gson.Gson;
import Business.GsonFactory;

import Business.OperatingSystem.OperatingSystem;
import java.nio.file.Paths;
import java.sql.*;


/**
 *
 * @author anushaprakash
 */
public class SQLiteUtility {
    
    private static final String DATABASE_URL = "jdbc:sqlite:" + Paths.get("Databank.sqlite").toAbsolutePath().toString();
    private static SQLiteUtility sqliteUtil;

    public synchronized static SQLiteUtility getInstance() {
        if (sqliteUtil == null) {
            sqliteUtil = new SQLiteUtility();
            sqliteUtil.initializeDatabase();
        }
        return sqliteUtil;
    }

    private void initializeDatabase() {
        String createTableSQL = """
            CREATE TABLE IF NOT EXISTS EcoSystem (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                systemData TEXT NOT NULL
            );
        """;
        try (Connection connection = getConnection();
             Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSQL);
        } catch (SQLException e) {
            System.out.println("Error initializing database: " + e.getMessage());
        }
    }

    private Connection getConnection() {
        try {
            return DriverManager.getConnection(DATABASE_URL);
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
            return null;
        }
    }

    public synchronized void storeSystem(EcoSystem system) {
        String sql = "INSERT INTO EcoSystem (systemData) VALUES (?)";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            String serializedData = GsonFactory.getGson().toJson(system); // Use the custom Gson
            pstmt.setString(1, serializedData);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error storing system: " + e.getMessage());
        }
    }

    public EcoSystem retrieveSystem() {
        String sql = "SELECT systemData FROM EcoSystem ORDER BY id DESC LIMIT 1";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet resultSet = pstmt.executeQuery()) {
            if (resultSet.next()) {
                String serializedData = resultSet.getString("systemData");
                return GsonFactory.getGson().fromJson(serializedData, EcoSystem.class); // Use the custom Gson
            } else {
                EcoSystem newSystem = ConfigureASystem.configure();
                storeSystem(newSystem);
                return newSystem;
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving system: " + e.getMessage());
            return ConfigureASystem.configure();
        }
    }
}
