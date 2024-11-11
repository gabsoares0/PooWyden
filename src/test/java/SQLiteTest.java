//Conecta-se ao banco de dados SQLite db_test.db
//Se a conexão for bem sucedida, tenta criar a tabela students se ela não existir
//Caso ocorra algum erro ao tentar criar a tabela, captura a exceção e exibe a mensagem de erro

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//Cria banco de dados de teste
public class SQLiteTest {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:sqlite:db_test.db";

        try(Connection conn = DriverManager.getConnection(url)){
            if (conn != null){
                System.out.println("Banco de dados conectado!");
                String sql = "CREATE TABLE IF NOT EXISTS students(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "phone TEXT NOT NULL," +
                "imgsSrc TEXT," +
                "dataNasc TEXT);";

                try(Statement stmt = conn.createStatement()){
                    stmt.execute(sql);
                    System.out.println("Tabela criada com sucesso!");
                } catch (SQLException e) {
                    System.out .println(e.getMessage());
                    System.out.println("Erro ao criar Tabela!");
                }
            }

        }
    }
}
