package DAO;

import Entities.Professor;

import java.util.List;

public interface ProfessorDAO {
    void save(Professor professor);
    void update(Professor professor);
    void delete(int id);
    Professor findById(int id);
    List<Professor> findAll();
}
