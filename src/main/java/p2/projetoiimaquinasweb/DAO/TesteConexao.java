package p2.projetoiimaquinasweb.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/VendingMachine";
        String user = "postgres";
        String password = "qwerty";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT version()";
            conn.createStatement().executeQuery(sql);

            System.out.println("Conexão estabelecida com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
