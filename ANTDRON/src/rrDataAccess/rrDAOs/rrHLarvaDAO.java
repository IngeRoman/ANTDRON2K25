package rrDataAccess.rrDAOs;

import database.rrHelpers.rrDataHelper;
import java.sql.*;

public class rrHLarvaDAO extends rrDataHelper {
    public boolean rrEvolucionar(int rrIdHormiga, int rrNuevoTipo) throws Exception {
        String rrSql = "UPDATE Hormiga SET IdTipoHormiga = ? WHERE IdHormiga = ?";
        try (Connection rrConn = rrGetConnection();
             PreparedStatement rrPstmt = rrConn.prepareStatement(rrSql)) {
            rrPstmt.setInt(1, rrNuevoTipo);
            rrPstmt.setInt(2, rrIdHormiga);
            return rrPstmt.executeUpdate() > 0;
        }
    }

    public boolean rrCreate(String rrNombre, int rrTipo, int rrSexo) throws Exception {
        String rrSql = "INSERT INTO Hormiga (Nombre, IdTipoHormiga, IdSexo, IdEstado) VALUES (?, ?, ?, 1)";
        try (Connection rrConn = rrGetConnection();
             PreparedStatement rrPstmt = rrConn.prepareStatement(rrSql)) {
            rrPstmt.setString(1, rrNombre);
            rrPstmt.setInt(2, rrTipo);
            rrPstmt.setInt(3, rrSexo);
            return rrPstmt.executeUpdate() > 0;
        }
    }
}