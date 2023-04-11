package com.argentina.programa.db;

import org.sqlite.SQLiteConnection;

import java.io.File;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connect {
    Connection conn = null;
    String urldb = "/Users/adriana/Programacion/ejercicios/arprog4.0/Clase9/guia9/src/db/guia9.db";
    String createDepartamentos = "create table Departamentos(" +
            "id integer primary key autoincrement, nombre character(30)" +
            ");";
    String createEmpleados = "create table Empleados(" +
            "id integer primary key autoincrement, " +
            "departamento_fk int, dni integer, nombre character(30), " +
            "apellido character(30), nacionalidad character(30), " +
            "foreign key (departamento_fk) references Departamentos(id));";

    public void connect() {
        if (conn != null) {
            return;
        }
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:" + urldb);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public boolean tableExists(String tableName) {
        connect();
        try {
            DatabaseMetaData md = conn.getMetaData();
            ResultSet rs = md.getTables(null, null, tableName, null);
            rs.next();
            return rs.getRow() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void listTables() {
        connect();
        try {
            DatabaseMetaData md = conn.getMetaData();
            ResultSet rs = md.getTables(null, null, "%", null);
            while (rs.next()) {
                Logger.getLogger(Connect.class.getName()).log(Level.INFO, rs.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteConnection.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    public void createTableDepartamento() {
        connect();
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(createDepartamentos);
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteConnection.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    public void createTableEmpleado() {
        connect();
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(createEmpleados);
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteConnection.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    public void checkDbExist() {
        File fileDb = new File (urldb);
        if (!fileDb.exists()) {
            try {
                connect();
                if (conn != null) {
                    DatabaseMetaData meta = conn.getMetaData();
                    System.out.println("The driver name is " + meta.getDriverName());
                    System.out.println("A new database has been created.");
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
