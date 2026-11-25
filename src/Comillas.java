import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Comillas {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:cooperativa.db";
        String nombre = "O'Brien";

        String pegado = "INSERT INTO socio (nombre, saldo) VALUES ('" + nombre + "', 50)";
        try (Connection con = DriverManager.getConnection(url);
             PreparedStatement ps = con.prepareStatement(pegado)) {
            ps.executeUpdate();
            System.out.println("Pegando el texto: guardado");
        } catch (SQLException e) {
            System.out.println("Pegando el texto: ERROR");
        }

        String conSignos = "INSERT INTO socio (nombre, saldo) VALUES (?, ?)";
        try (Connection con = DriverManager.getConnection(url);
             PreparedStatement ps = con.prepareStatement(conSignos)) {
            ps.setString(1, nombre);
            ps.setInt(2, 50);
            ps.executeUpdate();
            System.out.println("Con signos ?: guardado");
        } catch (SQLException e) {
            System.out.println("Con signos ?: ERROR");
        }
    }
}