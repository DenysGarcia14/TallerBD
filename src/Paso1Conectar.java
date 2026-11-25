import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Paso1Conectar {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:cooperativa.db";
        try (Connection con = DriverManager.getConnection(url)) {
            System.out.println("Conectado a la base de datos");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}