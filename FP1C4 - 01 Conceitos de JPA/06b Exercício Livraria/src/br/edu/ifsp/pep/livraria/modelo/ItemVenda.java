package br.edu.ifsp.pep.livraria.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item_venda")
public class ItemVenda implements Serializable {
    
    @EmbeddedId
    private ItemVendaPK itemVendaPK;
    
    @ManyToOne
    @JoinColumn(name = "livro_codigo", nullable = false)
    private Livro livro;
    
    @ManyToOne
    @JoinColumn(name = "venda_id", nullable = false)
    private Venda venda;
    
    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;
    
    @Column(name = "valor_unitario", precision = 8, scale = 2)
    private BigDecimal valorUnitario;
    
    // Código gerado....

    public ItemVendaPK getItemVendaPK() {
        return itemVendaPK;
    }

    public void setItemVendaPK(ItemVendaPK itemVendaPK) {
        this.itemVendaPK = itemVendaPK;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public ItemVenda() {
    }
}
