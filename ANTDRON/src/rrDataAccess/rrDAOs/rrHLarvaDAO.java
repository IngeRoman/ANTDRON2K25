package rrDataAccess.rrDAOs;

import rrDataAccess.rrDataHelper;
import java.sql.*;

public class rrHLarvaDao extends rrDataHelper {
    public boolean rrCreate(String rrNombre, int rrIdSexo, int rrIdGenoma) throws Exception {
        String rrQuery = "INSERT INTO Hormiga (IdTipoHormiga, IdSexo, IdEstado, Nombre) VALUES (1, ?, 1, ?)";
        try (PreparedStatement rrPstmt = rrGetConnection().prepareStatement(rrQuery)) {
            rrPstmt.setInt(1, rrIdSexo);
            rrPstmt.setString(2, rrNombre);
            return rrPstmt.executeUpdate() > 0;
        }
    }

    public boolean rrEvolucionar(int rrIdHormiga, int rrNuevoTipo) throws Exception {
        String rrQuery = "UPDATE Hormiga SET IdTipoHormiga = ? WHERE IdHormiga = ?";
        try (PreparedStatement rrPstmt = rrGetConnection().prepareStatement(rrQuery)) {
            rrPstmt.setInt(1, rrNuevoTipo);
            rrPstmt.setInt(2, rrIdHormiga);
            return rrPstmt.executeUpdate() > 0;
        }
    }
}