package run;

import Dao.VisitDao;
import Models.Visit;
import util.Conexion;

import java.sql.Connection;
import java.util.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        Connection conn = null;

        try {
            conn = conexion.getConexion();
            if (conn != null) {
                System.out.println("Conexion establecida");
            }
            else {
                System.out.println("Error al conectar con la base de datos");
            }

            // Crear el DAO inyectando la conexión
            Visit visit = new Visit("Juan", "Perez", "12345678", "", "Estoy en el hotel");
            VisitDao visitDao = new VisitDao(conn);
            visitDao.agregar(visit);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar la conexión cuando ya no se necesite
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}