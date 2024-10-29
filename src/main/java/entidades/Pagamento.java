package entidades;


import java.math.BigDecimal;
import java.time.LocalDate;


public class Pagamento {
    private Long id;
    private BigDecimal valor;
    private LocalDate dataPagamento;
    private String metodoPagamento; // Ex: Cartão, Boleto, Transferência
    private Aluno aluno; // Aluno que fez o pagamento

    
    public Pagamento(Long id, BigDecimal valor, LocalDate dataPagamento, String metodoPagamento, Aluno aluno) {
        this.id = id;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.metodoPagamento = metodoPagamento;
        this.aluno = aluno;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}