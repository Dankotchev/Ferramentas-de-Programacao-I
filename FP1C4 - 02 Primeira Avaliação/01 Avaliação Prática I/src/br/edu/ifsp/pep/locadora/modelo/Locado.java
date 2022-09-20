package br.edu.ifsp.pep.locadora.modelo;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "locado", uniqueConstraints = {
    @UniqueConstraint(name = "UniqueNumeroLocacao",
            columnNames = {"numero_locacao"})
})
public class Locado {

    @EmbeddedId
    private LocadoPK locadoPK;

    @Column(name = "numero_locacao")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numeroLocacao;

    @ManyToOne
    @JoinColumn(name = "veiculo_id", nullable = false)
    private Veiculo veiculo;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @Column(name = "data_locado")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataLocado;

    @Column(name = "valor_diaria", precision = 8, scale = 2)
    private BigDecimal valorDiaria;

    @Column(name = "data_entrega")
    private Date dataEntrega;

    //
    public LocadoPK getLocadoPK() {
        return locadoPK;
    }

    public void setLocadoPK(LocadoPK locadoPK) {
        this.locadoPK = locadoPK;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Integer getId() {
        return numeroLocacao;
    }

    public void setId(Integer id) {
        this.numeroLocacao = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataLocado() {
        return dataLocado;
    }

    public void setDataLocado(Date dataLocado) {
        this.dataLocado = dataLocado;
    }

    public BigDecimal getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(BigDecimal valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Locado(Veiculo veiculo, Cliente cliente, Date dataLocado, BigDecimal valorDiaria, Date dataEntrega) {
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.dataLocado = dataLocado;
        this.valorDiaria = valorDiaria;
        this.dataEntrega = dataEntrega;
    }

    public Locado() {
    }
}
