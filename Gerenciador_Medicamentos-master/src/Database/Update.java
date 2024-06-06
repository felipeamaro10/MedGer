package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
    public static void update(int id, String coluna, String att){

        Connection connection = Conector.getConnection();
        String sql = "UPDATE medicamentos SET " + coluna + " = ? WHERE id = ?";


        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, att);
            stmt.setInt(2, id);
            int updateRegister = stmt.executeUpdate();

            if(updateRegister > 0){
                System.out.println("Medicamento atualizado");
            } else {
                System.err.println("Erro ao atualizar medicamento");
            }
        } catch (SQLException e){
            System.err.println("Ocorreu um erro ao atualizar o medicamento: " + e.getMessage());
        }
    }
}
