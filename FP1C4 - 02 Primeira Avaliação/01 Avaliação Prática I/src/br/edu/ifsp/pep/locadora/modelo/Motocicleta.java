package br.edu.ifsp.pep.locadora.modelo;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "motocicleta")
public class Motocicleta extends Veiculo{
    
    @Column(name = "valor_diaria")
    private final BigDecimal valorDiaria = new BigDecimal(75);
    
}
