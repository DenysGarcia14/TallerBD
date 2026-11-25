import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Paso2CrearTabla {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:cooperativa.db";
        String sql = "CREATE TABLE IF NOT EXISTS socio ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "nombre TEXT, "
                + "saldo INTEGER)";
        try (Connection con = DriverManager.getConnection(url);
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.executeUpdate();
            System.out.println("Tabla socio creada");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}