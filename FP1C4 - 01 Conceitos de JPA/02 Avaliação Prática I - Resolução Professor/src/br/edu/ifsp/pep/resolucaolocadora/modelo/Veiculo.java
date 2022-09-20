package br.edu.ifsp.pep.resolucaolocadora.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "veiculo",
        uniqueConstraints = {
            @UniqueConstraint(name = "uniquePlacaCidade",
                    columnNames = {"placa", "cidade"})
        })
@NamedQueries({
    @NamedQuery(name = "Veiculo.buscarTodos",
            query = "SELECT v FROM Veiculo v"),
    @NamedQuery(name = "Veiculo.buscarPorPlacaECidade",
            query = "SELECT v FROM Veiculo v WHERE v.placa = :placa AND v.cidade = :cidade")
})
public class Veiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "placa", length = 8, nullable = false)
    private String placa;

    @Column(name = "cidade", length = 60, nullable = false)
    private String cidade;

    @Column(name = "modelo", length = 40, nullable = false)
    private String modelo;

    @Column(name = "ano", nullable = false)
    private Integer ano;

    @ManyToOne
    @JoinColumn(name = "tipo_veiculo_id", nullable = false)
    private TipoVeiculo tipo;

    // 
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public TipoVeiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVeiculo tipo) {
        this.tipo = tipo;
    }

    public Veiculo() {
    }

    public Veiculo(String placa, String cidade, String modelo, Integer ano, TipoVeiculo tipo) {
        this.placa = placa;
        this.cidade = cidade;
        this.modelo = modelo;
        this.ano = ano;
        this.tipo = tipo;
    }
}
