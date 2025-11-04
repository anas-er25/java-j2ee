package factories;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSource {
    private static HikariDataSource ds;
    private static HikariConfig conf = new HikariConfig("db.properties");
    private DataSource() {
    }
    public static Connection getConnection() throws SQLException {
        ds = new HikariDataSource(conf);
        return ds.getConnection();
    }

}
