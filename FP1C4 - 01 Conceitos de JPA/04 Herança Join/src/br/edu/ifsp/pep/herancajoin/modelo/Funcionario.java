package br.edu.ifsp.pep.herancajoin.modelo;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "funcionario")
@DiscriminatorValue(value = "FUNCIONARIO")  // Nome que identifica as classes na Tabela
public class Funcionario extends Pessoa {

    @Column(name = "salario", precision = 8, scale = 2)
    private BigDecimal salario;

    // Código Gerado ...
    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
}
