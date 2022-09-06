package br.ifsp.edu.pep.banco.modelo;

import java.io.Serializable;
import java.util.Objects;

public class CorrentePK implements Serializable {

    private Integer agencia;
    private Integer numeroConta;

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Integer getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Integer numeroConta) {
        this.numeroConta = numeroConta;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.agencia);
        hash = 23 * hash + Objects.hashCode(this.numeroConta);
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
        final CorrentePK other = (CorrentePK) obj;
        if (!Objects.equals(this.agencia, other.agencia)) {
            return false;
        }
        return Objects.equals(this.numeroConta, other.numeroConta);
    }
}
