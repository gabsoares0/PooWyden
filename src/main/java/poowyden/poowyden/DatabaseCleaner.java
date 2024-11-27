package poowyden.poowyden;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseCleaner {

    private static final String URL = "jdbc:sqlite:db_test.db";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {

            // Script SQL para apagar as tabelas
            String sql = """
                    DROP TABLE IF EXISTS students;
                    DROP TABLE IF EXISTS professors;
                    DROP TABLE IF EXISTS professor;
                    """;

            stmt.executeUpdate(sql);
            System.out.println("Tabelas apagadas com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
