package util;

import java.sql.Connection;
import java.sql.SQLException;
import  java.sql.DriverManager;


public class Conexion {

    private final String URL = "jdbc:postgresql://localhost:5432/course-db";
    private final String USER = "alumno";
    private final String PASSWORD = "123456";

    public Connection getConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public String getURL() {
        return URL;
    }

    public String getUSER() {
        return USER;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }
}
