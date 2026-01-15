package database.rrHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class rrDataHelper {
    private static String rrDBPath = "jdbc:sqlite:database/rrAntBot.db";
    private static Connection rrConn = null;

    protected static Connection rrGetConnection() throws Exception {
        try {
            if (rrConn == null || rrConn.isClosed()) {
                Class.forName("org.sqlite.JDBC");
                rrConn = DriverManager.getConnection(rrDBPath);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new Exception(e.getMessage());
        }
        return rrConn;
    }

    public static void rrCloseConnection() throws Exception {
        try {
            if (rrConn != null && !rrConn.isClosed()) {
                rrConn.close();
            }
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

    protected ResultSet rrExecuteResultSet(String rrSql) throws Exception {
        Connection rrC = rrGetConnection();
        PreparedStatement rrPstmt = rrC.prepareStatement(rrSql);
        return rrPstmt.executeQuery();
    }

    protected int rrExecuteUpdate(String rrSql) throws Exception {
        try (Connection rrC = rrGetConnection();
             PreparedStatement rrPstmt = rrC.prepareStatement(rrSql)) {
            return rrPstmt.executeUpdate();
        }
    }
}