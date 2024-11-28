package DAO;
import Entities.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    private static final String URL = "jdbc:sqlite:db_test.db";

    public StudentDAOImpl(){
        try(Connection conn = DriverManager.getConnection(URL)){
            Statement stmt = conn.createStatement();

            String createTableSQL = """
                    CREATE TABLE IF NOT EXISTS students(
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        name TEXT NOT NULL,
                        phone TEXT,
                        imgSrc TEXT,
                        dataNasc TEXT
                    );
                    """;
            stmt.executeUpdate(createTableSQL);

            // Confirma as colunas criadas
            ResultSet rs = stmt.executeQuery("PRAGMA table_info(students);");

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void save(Student student) {
        String sql = "INSERT INTO students (name, phone, imgSrc, dataNasc) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getPhone());
            pstmt.setString(3, student.getImgSrc());
            pstmt.setString(4, student.getDataNasc());

            pstmt.executeUpdate();

            //Recupera o ID gerado automaticamente pelo SQLite em 'id INTEGER PRIMARY KEY AUTOINCREMENT'
            ResultSet rs = pstmt.getGeneratedKeys();
            if(rs.next()){
                student.setId(rs.getInt(1)); //Define o ID getado no objeto
            }

        } catch (SQLException e){
            e.printStackTrace();
            System.err.println("Erro ao salvar estudante: " + e.getMessage());
        }
    }

    @Override
    public void update(Student student) {
        String sql = "UPDATE students SET name = ?, phone = ?, imgSrc = ?, dataNasc = ? WHERE id = ?";
        try(Connection conn = DriverManager.getConnection(URL);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getPhone());
            pstmt.setString(3, student.getImgSrc());
            pstmt.setString(4, student.getDataNasc());
            pstmt.setInt(5, student.getId());

            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM students WHERE id = ?";
        try( Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Student findById(int id) {
        String sql = "SELECT * FROM students WHERE id = ?";  // Corrigido o nome da tabela
        Student student = null;
        try( Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){
                student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setPhone(rs.getString("phone"));
                student.setImgSrc(rs.getString("imgSrc"));
                student.setDataNasc(rs.getString("dataNasc"));
            }

        }catch ( SQLException e){
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try(Connection conn = DriverManager.getConnection(URL);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {
            while(rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setPhone(rs.getString("phone"));
                student.setImgSrc(rs.getString("imgSrc"));
                student.setDataNasc(rs.getString("dataNasc"));
                students.add(student);
            }

        }catch(SQLException e){
            e.printStackTrace();
            System.err.println("Erro ao buscar estudantes: " + e.getMessage());
        }
        return students;
    }
}
