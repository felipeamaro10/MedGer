package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Read {
    public static void read(){

        Connection connection = Conector.getConnection();
        String sql = "SELECT * FROM medicamentos";

        try(PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery()){
            System.out.println("\n\nRegistros:");
            while (rs.next()){
                System.out.println("ID: " + rs.getInt("id") +
                        ", Número do lote: " + rs.getString("numero_lote") +
                        ", Medicamento: " + rs.getString("medicamento") +
                        ", Quantidade: " + rs.getString("quantidade") +
                        ", Validade: " + rs.getString("validade"));
            }
        } catch (SQLException e){
            System.err.println("Erro ao ler registros:" + e.getMessage());
        }
    }
}
