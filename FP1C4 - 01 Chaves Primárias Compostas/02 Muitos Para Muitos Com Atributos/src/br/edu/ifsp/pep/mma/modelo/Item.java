package br.edu.ifsp.pep.mma.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "itens")
public class Itens implements Serializable {

    @EmbeddedId
    private ItensPK itensPK;

    // Relacionamento de Muitos para Um
    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "venda_id", nullable = false)
    private Venda venda;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidae;

    @Column(name = "preco", nullable = false, precision = 8, scale = 2)
    private BigDecimal preco;

    // Código Gerado ...
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Integer getQuantidae() {
        return quantidae;
    }

    public void setQuantidae(Integer quantidae) {
        this.quantidae = quantidae;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Itens() {
    }

}
