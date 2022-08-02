package br.edu.ifsp.pep.aulainalgural.modelo;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;


// Toda entidade tem que ter o construtor vazio
@Entity
@Table(name = "pessoa")     // Define o nome da tabela associada a essa classe
public class Pessoa {
    @Id                                                         // Define a linha abaixo como chave primária para o Banco de Dados
    @GeneratedValue(strategy = GenerationType.IDENTITY)         // Definir como será gerado os códigos (auto incremento)
    @Column(name = "codigo", nullable = false)                  // Definindo o nome do atributo e caracteristicas no Banco de Dados
    private Long codigo;
    
    @Column(name = "nome", length = 40, nullable = false)       // Define parametros do atributos: length = tamanho do varchar
    private String nome;
    
                                                                // Precision (tamanho total de digitos) Scale (tamanho de casas decimais)
                                                                // BigDecimal é o necessário para ter essa precisão no Banco de Dados
    @Column(name = "salario", precision = 8, scale = 2)        
    private BigDecimal salario;
    
    @Column(name = "data_nascimento", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
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

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    // Esse construtor pode ser usado no código sem problemas
    public Pessoa(String nome, BigDecimal salario, Date dataNascimento) {
        this.nome = nome;
        this.salario = salario;
        this.dataNascimento = dataNascimento;
    }

    // Mas o construtor vazio é necessário para o JPA
    public Pessoa() {
    }
    
}
