package rrDataAccess.rrDAOs;

import rrDataAccess.rrDataHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class rrAlimentoTipoDao extends rrDataHelper {
    public boolean rrCreate(String rrNombre, String rrDescripcion) throws Exception {
        String rrQuery = "INSERT INTO AlimentoTipo (Nombre, Descripcion) VALUES (?, ?)";
        try (PreparedStatement rrPstmt = rrGetConnection().prepareStatement(rrQuery)) {
            rrPstmt.setString(1, rrNombre);
            rrPstmt.setString(2, rrDescripcion);
            return rrPstmt.executeUpdate() > 0;
        }
    }

    public ResultSet rrReadAll() throws Exception {
        String rrQuery = "SELECT IdAlimentoTipo, Nombre, Descripcion FROM AlimentoTipo WHERE Estado = 'A'";
        return rrGetConnection().createStatement().executeQuery(rrQuery);
    }
}
