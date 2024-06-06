package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Exclude {
    public static void exclude(int id){

        String sql = "DELETE FROM medicamentos WHERE id = ?";

        Connection connection = Conector.getConnection();

        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, id);
            int registerDelete = stmt.executeUpdate();
            if(registerDelete > 0){
                System.out.println("Medicamento excluido");
            } else {
                System.err.println("Nenhum medicamento foi excluido");
            }
        } catch (SQLException e){
            System.err.println("Erro ao excluir medicamento " + e.getMessage());
        }
    }
}
