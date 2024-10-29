package entidades;

import java.time.LocalDate;

public class Aluno {
    private Long id;
    private String nome;
    private String matricula;
    private String email;
    private String curso;
    private LocalDate dataNascimento;

    
    public Aluno(Long id, String nome, String matricula, String email, String curso, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.curso = curso;
        this.dataNascimento = dataNascimento;
    }

  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}