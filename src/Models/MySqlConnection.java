package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import factories.MyDataSourceFactory;

public class MySqlConnection {
    private static Connection connexion = null;
    static {
        try {
            DataSource dataSource = MyDataSourceFactory.getMySQLDataSource();
            connexion = dataSource.getConnection();

            try (Statement stmt = connexion.createStatement()) {
                String sql = """
                CREATE TABLE IF NOT EXISTS personne (
                    num INT AUTO_INCREMENT PRIMARY KEY,
                    nom VARCHAR(100) NOT NULL,
                    prenom VARCHAR(100) NOT NULL
                );
                """;
                stmt.executeUpdate(sql);
            }

            try (Statement stmt = connexion.createStatement()) {
                String sql = """
                CREATE TABLE IF NOT EXISTS student (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    firstName VARCHAR(100) NOT NULL,
                    lastName VARCHAR(100) NOT NULL,
                    average DOUBLE
                );
                """;
                stmt.executeUpdate(sql);
            }

            System.out.println("Connexion et tables initialisées avec succès.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private MySqlConnection() {
        DataSource dataSource = MyDataSourceFactory.getMySQLDataSource();
        try {
            connexion = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        if (connexion == null) {
            new MySqlConnection();
        }
        return connexion;
    }
}
