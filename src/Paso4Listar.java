import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Paso4Listar {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:cooperativa.db";
        String sql = "SELECT id, nombre, saldo FROM socio";
        try (Connection con = DriverManager.getConnection(url);
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int saldo = rs.getInt("saldo");
                System.out.println(id + " | " + nombre + " | $" + saldo);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}