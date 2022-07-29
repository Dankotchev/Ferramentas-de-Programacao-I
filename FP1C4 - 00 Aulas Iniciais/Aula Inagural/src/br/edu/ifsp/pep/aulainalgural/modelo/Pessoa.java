package br.edu.ifsp.pep.aulainalgural.modelo;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")     // Define o nome da tabela associada a essa classe
public class Pessoa {
    @Id     // Define a linha abaixo como chave primária para o Banco de Dados
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DEfinir como será gerado os códigos (auto incremento)
    private Long codigo;
    private String nome;
    private Double salario;
    private Date dataNascimento;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
