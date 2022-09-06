package br.edu.ifsp.pep.mma.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "valor", nullable = false, precision = 8, scale = 2)
    private BigDecimal valor;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;
    
    @Column(name = "descricao", nullable = false, length = 60)
    private String descricao;

    // Código Gerado ...
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Produto() {
    }

    public Produto(BigDecimal valor, Integer quantidade, String descricao) {
        this.valor = valor;
        this.quantidade = quantidade;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", valor=" + valor + ", quantidade=" + quantidade + ", descricao=" + descricao + '}';
    }
}
