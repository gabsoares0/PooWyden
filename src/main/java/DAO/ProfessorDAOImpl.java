package DAO;
import Entities.Professor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAOImpl implements ProfessorDAO{
    private static final String URL = "jdbc:sqlite:db_test.db";

    public ProfessorDAOImpl() {
        try(Connection conn = DriverManager.getConnection(URL)){

            Statement stmt = conn.createStatement();

            String createTableSQL = """
                    CREATE TABLE IF NOT EXISTS professors(
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        name TEXT NOT NULL,
                        phone TEXT,
                        imgSrc TEXT,
                        dataNasc TEXT,
                        cpf TEXT,
                        street TEXT,
                        street_number TEXT,
                        city TEXT,
                        state TEXT
                    )
                    """;
            stmt.executeUpdate(createTableSQL);

            // Confirma as colunas criadas
            ResultSet rs = stmt.executeQuery("PRAGMA table_info(students);");

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    public void save(Professor professor){
        String sql = "INSERT INTO professors (name, phone, imgSrc, dataNasc, cpf, street, street_number, city, state) VALUES (?,?,?,?,?,?,?,?,?)";
        try(Connection conn = DriverManager.getConnection(URL)){

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, professor.getName());
            pstmt.setString(2, professor.getPhone());
            pstmt.setString(3, professor.getImgSrc());
            pstmt.setString(4, professor.getDataNasc());
            pstmt.setString(5, professor.getCpf());
            pstmt.setString(6, professor.getStreet());
            pstmt.setString(7, professor.getStreet_number());
            pstmt.setString(8, professor.getCity());
            pstmt.setString(9, professor.getState());

            pstmt.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
            System.err.println("Erro ao salvar professor: " + e.getMessage());
        }
    }

    @Override
    public void update(Professor professor) {
        String sql = "UPDATE professors SET name = ?, phone = ?, imgSrc = ?, dataNasc = ?, cpf = ?, street = ?, street_number = ?, city = ?, state = ? WHERE id = ?";
        try(Connection conn = DriverManager.getConnection(URL);
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1, professor.getName());
            pstmt.setString(2, professor.getPhone());
            pstmt.setString(3, professor.getImgSrc());
            pstmt.setString(4, professor.getDataNasc());
            pstmt.setString(5, professor.getCpf());
            pstmt.setString(6, professor.getStreet());
            pstmt.setString(7, professor.getStreet_number());
            pstmt.setString(8, professor.getCity());
            pstmt.setString(9, professor.getState());

            pstmt.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM professor WHERE id = ?";
        try(Connection conn = DriverManager.getConnection(URL);
            PreparedStatement pstmt = conn.prepareStatement(sql);){
            pstmt.setInt(1, id);

            pstmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Professor findById(int id) {
        String sql = "SELECT * FROM professor WHERE id = ?";
        Professor professor = null;
        try(Connection conn = DriverManager.getConnection(URL);
            PreparedStatement pstmt = conn.prepareStatement(sql);){

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){
                professor = new Professor();
                professor.setId(rs.getInt("id"));
                professor.setName(rs.getString("name"));
                professor.setPhone(rs.getString("phone"));
                professor.setImgSrc(rs.getString("imgSrc"));
                professor.setDataNasc(rs.getString("dataNasc"));
                professor.setCpf(rs.getString("cpf"));
                professor.setStreet(rs.getString("street"));
                professor.setStreet_number(rs.getString("street_number"));
                professor.setCity(rs.getString("city"));
                professor.setState(rs.getString("state"));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return professor;
    }

    @Override
    public List<Professor> findAll() {
        List<Professor> professors = new ArrayList<Professor>();
        String sql = "SELECT * FROM professors";

        try(Connection conn = DriverManager.getConnection(URL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while(rs.next()){
                Professor professor = new Professor();
                professor.setId(rs.getInt("id"));
                professor.setName(rs.getString("name"));
                professor.setPhone(rs.getString("phone"));
                professor.setImgSrc(rs.getString("imgSrc"));
                professor.setDataNasc(rs.getString("dataNasc"));
                professor.setCpf(rs.getString("cpf"));
                professor.setStreet(rs.getString("street"));
                professor.setStreet_number(rs.getString("street_number"));
                professor.setCity(rs.getString("city"));
                professor.setState(rs.getString("state"));
                professors.add(professor);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return professors;
    }
}
