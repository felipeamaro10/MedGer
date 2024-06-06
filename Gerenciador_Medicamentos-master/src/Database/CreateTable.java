package Database;

import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public static void createTable(){
        Conector.getConnection();

        String sql = "CREATE TABLE IF NOT EXISTS medicamentos (id INT PRIMARY KEY AUTO_INCREMENT," +
                "numero_lote VARCHAR(60) UNIQUE, medicamento VARCHAR(80), quantidade VARCHAR(10), validade VARCHAR(30))";

        try{
            Statement stmt = Conector.getConnection().createStatement();
            stmt.executeUpdate(sql);
            System.out.println("Tabela criada");
            stmt.close();
        } catch (SQLException e){
            System.err.println("Erro ao criar tabela" + e.getMessage());
        }
    }
}
