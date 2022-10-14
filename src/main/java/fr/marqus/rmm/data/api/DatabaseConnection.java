package fr.marqus.rmm.data.api;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * HSQLDB database connection.
 */
public final class DatabaseConnection {

    private static final String CREATE_TABLE_QUEUE_CONFIG =
            "CREATE CACHED TABLE RMM_QUEUECONFIG (LABEL VARCHAR(64) PRIMARY KEY, HOST VARCHAR(256), PORT INT, NAME VARCHAR(256), TYPE VARCHAR(32), LOGIN VARCHAR(128), PASSWORD VARCHAR(128))";

    private static final String DATABASE_URL =
            "jdbc:hsqldb:file:rmmdb/rmmdb";

    private static final String DATABASE_USR = "rmmusr";

    private static final String DATABASE_PASSWORD = "RmmP@ssw0rd";

    private static Connection connection = null;

    /**
     * Get SQL connection.
     *
     * @return SQL connection
     */
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (connection == null) {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USR, DATABASE_PASSWORD);

            if (!checkDatabase()) {
                try (Statement stmt = connection.createStatement()) {
                    stmt.executeUpdate(CREATE_TABLE_QUEUE_CONFIG);
                }
            }
        }
        return connection;
    }

    private static boolean checkDatabase() throws SQLException, ClassNotFoundException {
        DatabaseMetaData dbm = getConnection().getMetaData();
        try (ResultSet result = dbm.getTables(null, "PUBLIC", null, null)) {
            return result.next();
        }
    }

    private DatabaseConnection() {
        // Nothing to do
    }
}
