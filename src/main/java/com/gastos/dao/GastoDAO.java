package com.gastos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.gastos.db.ConexionPostgres;

public class GastoDAO {

    private ConexionPostgres conexion;

    public GastoDAO() {
        this.conexion = new ConexionPostgres();
    }

    public boolean insertarGasto(String concepto, double cantidad, java.sql.Date fecha) {
        String sql = "INSERT INTO gastos (concepto, cantidad, fecha) VALUES (?, ?, ?)";

        try (Connection conn = conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, concepto);
            stmt.setDouble(2, cantidad);
            stmt.setDate(3, fecha);

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al insertar gasto: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarGasto(int id) {
        String sql = "DELETE FROM gastos WHERE id = ?";

        try (Connection conn = conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int filas = stmt.executeUpdate();

            return filas > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar gasto: " + e.getMessage());
            return false;
        }
    }
}