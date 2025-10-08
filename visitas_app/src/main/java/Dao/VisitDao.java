package Dao;

import Interfaces.IVisita;
import Models.Visit;
import util.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        ArrayList<Visit> visitas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM visit ORDER BY visit_date DESC";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                var rs = ps.executeQuery();
                while (rs.next()) {
                    Visit visita = new Visit();
                    visita.setId(rs.getLong("id"));
                    visita.setVisitor_name(rs.getString("visitor_name"));
                    visita.setHost_name(rs.getString("host_name"));
                    visita.setVisitor_document(rs.getString("visitor_document"));
                    visita.setVisitor_email(rs.getString("visitor_email"));
                    visita.setReason(rs.getString("reason"));
                    visita.setVisit_date(rs.getObject("visit_date", java.time.LocalDateTime.class));
                    visita.setVisit_exit(rs.getObject("visit_exit", java.time.LocalDateTime.class));
                    visitas.add(visita);
                }
            }
        } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        return visitas;
    }



}