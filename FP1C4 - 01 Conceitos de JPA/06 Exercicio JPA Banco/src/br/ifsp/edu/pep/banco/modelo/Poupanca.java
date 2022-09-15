package br.ifsp.edu.pep.banco.modelo;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "poupanca")
public class Poupanca extends Corrente {

    @Column(name = "aniversario", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date aniversario;

    public Date getAniversario() {
        return aniversario;
    }

    public void setAniversario(Date aniversario) {
        this.aniversario = aniversario;
    }

    public Poupanca(Date aniversario, Integer agencia, Integer numeroConta, BigDecimal saldo) {
        super(agencia, numeroConta, saldo);
        this.aniversario = aniversario;
    }

    public Poupanca() {
    }

    @Override
    public String toString() {
        return "Poupanca{" + "agencia=" + getAgencia() + ", numeroConta=" + 
                getNumeroConta() + ", saldo=" +getSaldo() +", aniversario=" + aniversario + '}';
    }


}
