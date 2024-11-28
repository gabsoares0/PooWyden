package DAO;

import Entities.Payment;

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
                        payday DATE NOT NULL,
                        amount FLOAT NOT NULL,
                        payerId INTEGER NOT NULL,
                        paymentMethod TEXT NOT NULL,
                        accountId INTEGER NOT NULL,
                        status TEXT NOT NULL,
                        type_plan TEXT NOT NULL,
                        expirePayDay TEXT NOT NULL,
                        expired BOOLEAN NOT NULL
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
        String sql = "INSERT INTO payments (payday, amount, payerId, paymentMethod, accountId, status, type_plan, expirePayDay, expired) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try(Connection conn = DriverManager.getConnection(URL);
        PreparedStatement pstmt = conn.prepareStatement(sql);){

            //Converte java.util.date para java.sql.Date
            java.sql.Date sqlDatePayday = new java.sql.Date(payment.getPayDay().getTime());

            //Conver java.utils.date para java.sql.Date
            java.sql.Date sqlDateExpireDay = new java.sql.Date(payment.getExpirePayDay().getTime());

            pstmt.setDate(1, sqlDatePayday);
            pstmt.setDouble(2, payment.getAmount());
            pstmt.setInt(3, payment.getPayerId());
            pstmt.setString(4, payment.getPaymentMethod());
            pstmt.setInt(5, payment.getAccountId());
            pstmt.setString(6, payment.getStatus());
            pstmt.setString(7, payment.getType_plan());
            pstmt.setDate(8, sqlDateExpireDay);
            pstmt.setBoolean(9, payment.isExpired());

            pstmt.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
            System.err.println("Erro ao salvar pagamento");
        }

    }
    @Override
    public void update(Payment payment) {
        String sql = "UPDATE payments SET payday = ?, amount = ?, payerId = ?, payerId = ?, payment_method = ?, accounId = ?, status = ?, type_plan = ? WHERE id = ?";
        try(Connection conn = DriverManager.getConnection(URL);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            //Converte java.util.date para java.sql.Date
            java.sql.Date sqlDate = new java.sql.Date(payment.getPayDay().getTime());

            pstmt.setDate(1, sqlDate);
            pstmt.setDouble(2, payment.getAmount());
            pstmt.setInt(3, payment.getPayerId());
            pstmt.setString(4, payment.getPaymentMethod());
            pstmt.setInt(5, payment.getAccountId());
            pstmt.setString(6, payment.getStatus());
            pstmt.setString(7, payment.getType_plan());

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
