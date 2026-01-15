package rrDataAccess.rrDAOs;

import database.rrHelpers.rrDataHelper;
import java.sql.*;;

public class rrEntomologoDAO extends rrDataHelper {
    public boolean rrLogin(String rrUsuario, String rrPassword) throws Exception {
        String rrSql = "SELECT COUNT(*) FROM Entomologo WHERE Usuario = ? AND Password = ? AND Estado = 'A'";
        try (Connection rrConn = rrGetConnection();
             PreparedStatement rrPstmt = rrConn.prepareStatement(rrSql)) {
            rrPstmt.setString(1, rrUsuario);
            rrPstmt.setString(2, rrPassword);
            try (ResultSet rrRs = rrPstmt.executeQuery()) {
                return rrRs.next() && rrRs.getInt(1) > 0;
            }
        }
    }
}