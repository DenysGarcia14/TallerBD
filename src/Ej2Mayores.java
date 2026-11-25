import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ej2Mayores {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:cooperativa.db";
        String sql = "SELECT nombre, saldo FROM socio WHERE saldo > ?";
        try (Connection con = DriverManager.getConnection(url);
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, 100);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getString("nombre") + " tiene $" + rs.getInt("saldo"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

