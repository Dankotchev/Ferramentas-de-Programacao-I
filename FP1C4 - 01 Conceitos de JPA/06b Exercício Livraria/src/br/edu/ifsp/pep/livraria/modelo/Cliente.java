package br.edu.ifsp.pep.livraria.modelo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
@PrimaryKeyJoinColumn(name = "pessoa_id")
public class Cliente extends Pessoa {

    @Column(name = "credito", precision = 8, scale = 2)
    private BigDecimal credito;

    public BigDecimal getCredito() {
        return credito;
    }
    
    // Relacionamento de um Cliente para muitas Vendas
    @OneToMany(mappedBy = "cliente")
    private List<Venda> compras;

    public void setCredito(BigDecimal credito) {
        this.credito = credito;
    }

    public List<Venda> getCompras() {
        return compras;
    }

    public void setCompras(List<Venda> compras) {
        this.compras = compras;
    }

    public Cliente(BigDecimal credito, String nome, String cpf,
            Date dataNascimento, String telefone) {
        super(nome, cpf, dataNascimento, telefone);
        this.credito = credito;
    }

    public Cliente() {
    }
}
