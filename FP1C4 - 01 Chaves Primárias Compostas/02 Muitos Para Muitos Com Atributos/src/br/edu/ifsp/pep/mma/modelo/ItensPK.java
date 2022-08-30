package br.edu.ifsp.pep.mma.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

@Embeddable
public class ItensPK implements Serializable{
    private Integer produto_id;
    private Integer venda_id;
    
    //

    public Integer getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(Integer produto_id) {
        this.produto_id = produto_id;
    }

    public Integer getVenda_id() {
        return venda_id;
    }

    public void setVenda_id(Integer venda_id) {
        this.venda_id = venda_id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.produto_id);
        hash = 29 * hash + Objects.hashCode(this.venda_id);
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
        final ItensPK other = (ItensPK) obj;
        if (!Objects.equals(this.produto_id, other.produto_id)) {
            return false;
        }
        return Objects.equals(this.venda_id, other.venda_id);
    }
    
    
}
