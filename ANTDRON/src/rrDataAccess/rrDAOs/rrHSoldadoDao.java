package rrDataAccess.rrDAOs;

import rrDataAccess.rrDataHelper;
import java.sql.*;

public class rrHSoldadoDao extends rrDataHelper {
    public boolean rrCreate(String rrNombre, int rrIdSexo) throws Exception {
        String rrQuery = "INSERT INTO Hormiga (IdTipoHormiga, IdSexo, IdEstado, Nombre) VALUES (2, ?, 1, ?)";
        try (PreparedStatement rrPstmt = rrGetConnection().prepareStatement(rrQuery)) {
            rrPstmt.setInt(1, rrIdSexo);
            rrPstmt.setString(2, rrNombre);
            return rrPstmt.executeUpdate() > 0;
        }
    }

    public ResultSet rrReadSoldadosActivos() throws Exception {
        String rrQuery = "SELECT * FROM Hormiga WHERE IdTipoHormiga = 2 AND Estado = 'A'";
        return rrGetConnection().createStatement().executeQuery(rrQuery);
    }
}