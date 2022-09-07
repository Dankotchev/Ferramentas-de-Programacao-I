package br.ifsp.edu.pep.banco.modelo;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "poupanca")
public class Poupanca extends Corrente {

    @Column(name = "aniversario", nullable = false)
    private Date aniversario;

    public Date getAniversario() {
        return aniversario;
    }

    public void setAniversario(Date aniversario) {
        this.aniversario = aniversario;
    }

    public Poupanca(Date aniversario, Integer numeroConta, BigDecimal saldo) {
        super(numeroConta, saldo);
        this.aniversario = aniversario;
    }

    public Poupanca() {
    }
}
