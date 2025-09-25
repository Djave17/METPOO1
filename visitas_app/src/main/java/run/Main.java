package run;

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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
