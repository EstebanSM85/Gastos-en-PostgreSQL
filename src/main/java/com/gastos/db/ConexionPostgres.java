package com.gastos.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionPostgres {

    private static final String URL = "jdbc:postgresql://localhost:5432/gastos_db";
    private static final String USUARIO = "postgres";
    private static final String PASSWORD = "P3p83pyv1609+pos";

    public Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USUARIO, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error al conectar con PostgreSQL: " + e.getMessage());
            return null;
        }
    }
}