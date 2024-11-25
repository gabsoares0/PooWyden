package DAO;

import Entities.Payment;
import java.time.LocalDate;

import java.sql.*;
import java.util.List;

public class PaymentDAOImpl implements PaymentDAO {
    private static final String URL = "jdbc:sqlite:db_test.db";
    public PaymentDAOImpl() {
        try(Connection conn = DriverManager.getConnection(URL)){
            Statement stmt = conn.createStatement();

            String createTableSQL = """
                    CREATE TABLE IF NOT EXISTS payments(
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        date DATE NOT NULL,
                        amount FLOAT,
                        type_plan TEXT,
                        payerId int NOT NULL,
                    );
                    """;
            stmt.executeUpdate(createTableSQL);

            // Confirma as colunas criadas
            ResultSet rs = stmt.executeQuery("PRAGMA table_info(students);");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void save(Payment payment) {
        String sql = "INSERT INTO payments (date, amount, type_plan, payerId) VALUES (?, ?, ?, ?)";
        try(Connection conn = DriverManager.getConnection(URL);
        PreparedStatement pstmt = conn.prepareStatement(sql);){

            pstmt.setDate(1, payment.getDate());
            pstmt.setDouble(2, payment.getAmount());
            pstmt.setString(3, payment.getType_plan());
            pstmt.setInt(4, payment.getPayerId());

            pstmt.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
            System.err.println("Erro ao salvar pagamento");
        }

    }
    @Override
    public void update(Payment payment) {
        String sql = "UPDATE payments SET date = ?, amount = ?, type_plan = ?, payerId = ? WHERE id = ?";
        try(Connection conn = DriverManager.getConnection(URL);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, payment.getDate());
            pstmt.setDouble(2, payment.getAmount());
            pstmt.setString(3, payment.getType_plan());
            pstmt.setInt(4, payment.getPayerId());

            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    public void delete(int id) {
        String sql = "DELETE FROM payments WHERE id = ?";
        try( Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Payment FindById(int id) {
        return null;
    }

    @Override
    public List<Payment> findAll() {
        return List.of();
    }


}
