package Dao;

import Interfaces.IVisita;
import Models.Visit;
import util.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class VisitDao implements IVisita {
    private Connection connection;
    private Conexion conexion;

    // Agregar un constructor para inyectar la conexión y evitar NPEs
    public VisitDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void agregar(Visit visita) {
        try{
            String sql = "INSERT INTO visit (visitor_name, host_name, visitor_document, visitor_email, reason) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, visita.getVisitor_name());
                ps.setString(2, visita.getHost_name());
                ps.setString(3, visita.getVisitor_document());
                ps.setString(4, visita.getVisitor_email());
                ps.setString(5, visita.getReason());
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al agregar visita");
        }
    }

    @Override
    public ArrayList<Visit> obtenerVisitas() {
        return null;
    }
}