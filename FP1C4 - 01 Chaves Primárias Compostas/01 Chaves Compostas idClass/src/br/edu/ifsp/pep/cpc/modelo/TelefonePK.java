package br.edu.ifsp.pep.cpc.modelo;

import java.io.Serializable;
import java.util.Objects;

public class TelefonePK implements Serializable{

    private Integer ddd;
    private String numero;

    
    // Código Gerado ...
    public TelefonePK() {
    }

    public Integer getDdd() {
        return ddd;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.ddd);
        hash = 43 * hash + Objects.hashCode(this.numero);
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
        final TelefonePK other = (TelefonePK) obj;
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return Objects.equals(this.ddd, other.ddd);
    }
    
    
}
