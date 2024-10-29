package entidades;

import java.math.BigDecimal;
import java.util.List;

public class Professor {
    private Long id;
    private String nome;
    private String cpf;
    private String especialidade; // Ex: Musculação, Yoga, Crossfit
    private String email;
    private String telefone;
    private BigDecimal salario;
    private List<String> horariosDisponiveis; // Horários em que o professor está disponível

    
    public Professor(Long id, String nome, String cpf, String especialidade, String email, String telefone, BigDecimal salario, List<String> horariosDisponiveis) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.especialidade = especialidade;
        this.email = email;
        this.telefone = telefone;
        this.salario = salario;
        this.horariosDisponiveis = horariosDisponiveis;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public List<String> getHorariosDisponiveis() {
        return horariosDisponiveis;
    }

    public void setHorariosDisponiveis(List<String> horariosDisponiveis) {
        this.horariosDisponiveis = horariosDisponiveis;
    }
}