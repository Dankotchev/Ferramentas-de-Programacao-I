package br.edu.ifsp.pep.livraria.modelo;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ItemVendaPK {
    @Column(name = "livro_codigo", insertable = false, updatable = false)
    private Integer livro_codigo;
    
    @Column(name = "venda_id", insertable = false, updatable = false)
    private Integer venda_id;
    
    // Código gerado...

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.livro_codigo);
        hash = 79 * hash + Objects.hashCode(this.venda_id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemVendaPK other = (ItemVendaPK) obj;
        if (!Objects.equals(this.livro_codigo, other.livro_codigo)) {
            return false;
        }
        return Objects.equals(this.venda_id, other.venda_id);
    }

    public Integer getLivro_codigo() {
        return livro_codigo;
    }

    public void setLivro_codigo(Integer livro_codigo) {
        this.livro_codigo = livro_codigo;
    }

    public Integer getVenda_id() {
        return venda_id;
    }

    public void setVenda_id(Integer venda_id) {
        this.venda_id = venda_id;
    }
    
}
