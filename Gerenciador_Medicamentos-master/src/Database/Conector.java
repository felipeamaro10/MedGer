package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector{

    private static final String url = "jdbc:mysql://localhost:3306/TreinamentoBD";
    private static final String user = "root";
    private static final String password = "root";

    private static Connection connection;

    private Conector(){

    }

    public static Connection getConnection(){
        if(connection == null) {
            try {
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Conexão estabelecida");
                CreateTable.createTable();
            } catch (SQLException e) {
                System.err.println("Erro ao realizar conexão com o banco de dados: ");
                e.getMessage();
            }
        }
        return connection;
    }

    public static void closeConecction(){
        if(connection != null){
            try {
                connection.close();
                System.out.println("Conexão fechada");
            } catch (SQLException e){
                System.err.println("Erro ao fechar conexão");
                e.getMessage();
            }
        }
    }
}
