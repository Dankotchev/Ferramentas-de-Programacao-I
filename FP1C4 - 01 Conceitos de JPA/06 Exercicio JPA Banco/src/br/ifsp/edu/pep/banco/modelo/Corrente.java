package br.ifsp.edu.pep.banco.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@IdClass(CorrentePK.class)
@Table(name = "corrente")
public class Corrente implements Serializable {

    @Id
    @Column(name = "agencia")
    private Integer agencia;

    @Id
    @Column(name = "numero_conta")
    private Integer numeroConta;

    @Column(name = "saldo", nullable = false)
    private BigDecimal saldo;

    // Código Gerado ....
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

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Corrente(Integer agencia, Integer numeroConta, BigDecimal saldo) {
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public Corrente() {
    }

    @Override
    public String toString() {
        return "Corrente{" + "agencia=" + agencia + ", numeroConta=" + numeroConta + ", saldo=" + saldo + '}';
    }

}
