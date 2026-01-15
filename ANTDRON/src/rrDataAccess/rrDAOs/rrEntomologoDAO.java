package database.rrDAOs;

import java.sql.*;

import database.rrDataHelper;

public class rrEntomologoDao extends rrDataHelper {
    public boolean rrLogin(String rrUsuario, String rrPassword) throws Exception {
        // Simulación de validación según requerimiento: patmic / 123
        return (rrUsuario.equals("patmic") && rrPassword.equals("123"));
    }

    public void rrRegistrarLog(String rrAccion) throws Exception {
        String rrQuery = "INSERT INTO LogEntomologo (Accion, Fecha) VALUES (?, CURRENT_TIMESTAMP)";
        try (PreparedStatement rrPstmt = rrGetConnection().prepareStatement(rrQuery)) {
            rrPstmt.setString(1, rrAccion);
            rrPstmt.executeUpdate();
        }
    }
}