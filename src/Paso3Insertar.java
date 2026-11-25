import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Paso3Insertar {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:cooperativa.db";
        String sql = "INSERT INTO socio (nombre, saldo) VALUES (?, ?)";
        try (Connection con = DriverManager.getConnection(url);
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "Ana");
            ps.setInt(2, 100);
            ps.executeUpdate();

            ps.setString(1, "Luis");
            ps.setInt(2, 250);
            ps.executeUpdate();

            ps.setString(1, "Marta");
            ps.setInt(2, 80);
            ps.executeUpdate();

            System.out.println("3 socios guardados");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}