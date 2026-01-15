package rrDataAccess.rrDAOs;

import rrDataAccess.rrDataHelper;
import java.sql.*;

public class rrHormigaDao extends rrDataHelper {
    public boolean rrUpdateEstado(int rrIdHormiga, int rrIdEstado) throws Exception {
        String rrQuery = "UPDATE Hormiga SET IdEstado = ?, FechaModifica = CURRENT_TIMESTAMP WHERE IdHormiga = ?";
        try (PreparedStatement rrPstmt = rrGetConnection().prepareStatement(rrQuery)) {
            rrPstmt.setInt(1, rrIdEstado);
            rrPstmt.setInt(2, rrIdHormiga);
            return rrPstmt.executeUpdate() > 0;
        }
    }

    public boolean rrDeleteLogico(int rrIdHormiga) throws Exception {
        String rrQuery = "UPDATE Hormiga SET Estado = 'X' WHERE IdHormiga = ?";
        try (PreparedStatement rrPstmt = rrGetConnection().prepareStatement(rrQuery)) {
            rrPstmt.setInt(1, rrIdHormiga);
            return rrPstmt.executeUpdate() > 0;
        }
    }
}
