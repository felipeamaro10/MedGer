package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {
    public static void insert(String numero_lote, String medicamento, String quantidade, String validade){

        Connection connection = Conector.getConnection();
        String sql = "INSERT INTO medicamentos(numero_lote, medicamento, quantidade, validade) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, numero_lote);
            stmt.setString(2, medicamento);
            stmt.setString(3, quantidade);
            stmt.setString(4, validade);

            int entrada = stmt.executeUpdate();

            if(entrada > 0){
                System.out.println("Medicamento inserido");
            } else {
                System.err.println("Erro ao inserir medicamento");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir medicamento " + e.getMessage());
        }
    }
}
