package java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseCleaner {

    private static final String URL = "jdbc:sqlite:db_test.db";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {

            // Script SQL para limpar as tabelas
            String sql = """
                    DELETE FROM students;
                    DELETE FROM professors;
                    DELETE FROM payments;
                    DELETE FROM sqlite_sequence WHERE name='students';
                    DELETE FROM sqlite_sequence WHERE name='professors';
                    DELETE FROM sqlite_sequence WHERE name='payments';
                    """;

            stmt.executeUpdate(sql);
            System.out.println("Banco de dados limpo com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
