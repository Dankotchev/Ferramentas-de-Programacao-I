package br.edu.ifsp.pep.mma.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    
    @Column(name = "valor", nullable = false, precision = 8, scale = 2)
    private BigDecimal valor;
    private Integer quantidade;
    
    // Relacionamento de Muitos para Um
    @JoinColumn(name = "itens_id", nullable = false)
    @OneToMany(mappedBy = "categoria")
    private Itens itens;
    
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

    public Produto() {
    }

    public Produto(BigDecimal valor, Integer quantidade) {
        this.valor = valor;
        this.quantidade = quantidade;
    }
    
}
