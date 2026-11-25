import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ej3Contar {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:cooperativa.db";
        String sql = "SELECT COUNT(*) AS total FROM socio";
        try (Connection con = DriverManager.getConnection(url);
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            rs.next();
            System.out.println("Socios registrados: " + rs.getInt("total"));
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}