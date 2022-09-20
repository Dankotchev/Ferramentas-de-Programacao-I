package br.edu.ifsp.pep.locadora.modelo;

import java.math.BigDecimal;
import javax.persistence.Column;

public class Van extends Veiculo{
    @Column(name = "capacidade", nullable = false)
    private Integer capacidade;
    
    @Column(name = "valor_diaria")
    private final BigDecimal valorDiaria = new BigDecimal(400);
    
    //

    public Van(Integer capacidade, String placa, String cidade, String modelo, Integer anoFabricacao, Boolean estado) {
        super(placa, cidade, modelo, anoFabricacao, estado);
        this.capacidade = capacidade;
    }

    public Van() {
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }
}
