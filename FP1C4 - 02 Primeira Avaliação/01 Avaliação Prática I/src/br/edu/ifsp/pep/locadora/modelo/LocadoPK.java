package br.edu.ifsp.pep.locadora.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LocadoPK implements Serializable {
    
    @Column(name = "veiculo_id", insertable = false, updatable = false)
    private Integer veiculo_id;
    
    @Column(name = "cliente_id", insertable = false, updatable = false)
    private Integer cliente_id;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.veiculo_id);
        hash = 13 * hash + Objects.hashCode(this.cliente_id);
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
        final LocadoPK other = (LocadoPK) obj;
        if (!Objects.equals(this.veiculo_id, other.veiculo_id)) {
            return false;
        }
        return Objects.equals(this.cliente_id, other.cliente_id);
    }

    public Integer getVeiculo_id() {
        return veiculo_id;
    }

    public void setVeiculo_id(Integer veiculo_id) {
        this.veiculo_id = veiculo_id;
    }

    public Integer getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Integer cliente_id) {
        this.cliente_id = cliente_id;
    }
}
