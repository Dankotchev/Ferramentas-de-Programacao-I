package br.edu.ifsp.pep.locadora.modelo;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "carro",
        uniqueConstraints = {
            @UniqueConstraint(name = "UniquePlacaAndCidade",
                    columnNames = {"placa", "cidade"})
        })
public class Carro extends Veiculo{
    
    @Column(name = "valor_diaria")
    private final BigDecimal valorDiaria = new BigDecimal(150);

    public Carro(String placa, String cidade, String modelo, Integer anoFabricacao, Boolean estado) {
        super(placa, cidade, modelo, anoFabricacao, estado);
    }

    public Carro() {
    }

    public BigDecimal getValorDiaria() {
        return valorDiaria;
    }
    
    
}
