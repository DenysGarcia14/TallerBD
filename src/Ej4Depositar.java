import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ej4Depositar {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:cooperativa.db";
        String sql = "UPDATE socio SET saldo = saldo + ? WHERE id = ?";
        try (Connection con = DriverManager.getConnection(url);
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, 50);
            ps.setInt(2, 3);
            int filas = ps.executeUpdate();
            System.out.println("Filas modificadas: " + filas);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
