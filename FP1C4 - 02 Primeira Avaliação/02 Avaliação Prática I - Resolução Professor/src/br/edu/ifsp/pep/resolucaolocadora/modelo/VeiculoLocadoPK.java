package br.edu.ifsp.pep.resolucaolocadora.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class VeiculoLocadoPK implements Serializable {
    
    @Column(name = "veiculo_id", insertable = false, updatable = false)
    private Integer veiculo_id;
    
    @Column(name = "locacao_id", insertable = false, updatable = false)
    private Integer locacao_id;
    
    //

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.veiculo_id);
        hash = 79 * hash + Objects.hashCode(this.locacao_id);
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
        final VeiculoLocadoPK other = (VeiculoLocadoPK) obj;
        if (!Objects.equals(this.veiculo_id, other.veiculo_id)) {
            return false;
        }
        return Objects.equals(this.locacao_id, other.locacao_id);
    }

    public Integer getVeiculo_id() {
        return veiculo_id;
    }

    public void setVeiculo_id(Integer veiculo_id) {
        this.veiculo_id = veiculo_id;
    }

    public Integer getLocacao_id() {
        return locacao_id;
    }

    public void setLocacao_id(Integer locacao_id) {
        this.locacao_id = locacao_id;
    }


    
}
