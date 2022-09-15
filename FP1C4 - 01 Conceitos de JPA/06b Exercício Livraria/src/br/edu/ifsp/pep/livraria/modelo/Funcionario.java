package br.edu.ifsp.pep.livraria.modelo;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "funcionario")
@PrimaryKeyJoinColumn(name = "pessoa_id")
public class Funcionario extends Pessoa {

    @Column(name = "contrato", nullable = false)
    private Integer contrato;

    @Column(name = "data_contrato", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataContrato;

    @Column(name = "salario", precision = 8, scale = 2)
    private BigDecimal salrio;

    public Integer getContrato() {
        return contrato;
    }

    public void setContrato(Integer contrato) {
        this.contrato = contrato;
    }

    public Date getDataContrato() {
        return dataContrato;
    }

    public void setDataContrato(Date dataContrato) {
        this.dataContrato = dataContrato;
    }

    public BigDecimal getSalrio() {
        return salrio;
    }

    public void setSalrio(BigDecimal salrio) {
        this.salrio = salrio;
    }

    public Funcionario(Integer contrato, Date dataContrato, BigDecimal salrio,
            String nome, String cpf, Date dataNascimento, String telefone) {
        super(nome, cpf, dataNascimento, telefone);
        this.contrato = contrato;
        this.dataContrato = dataContrato;
        this.salrio = salrio;
    }

    public Funcionario() {
    }
}
