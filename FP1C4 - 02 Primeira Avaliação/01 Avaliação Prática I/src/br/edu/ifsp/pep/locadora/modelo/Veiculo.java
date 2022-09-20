package br.edu.ifsp.pep.locadora.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "veiculo",
        uniqueConstraints = {
            @UniqueConstraint(name = "UniquePlacaAndCidade",
                    columnNames = {"placa", "cidade"})
        })
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Veiculo implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "placa", length = 8)
    private String placa;

    @Column(name = "cidade", length = 60)
    private String cidade;

    @Column(name = "modelo", length = 60)
    private String modelo;

    @Column(name = "ano_fabricacao")
    private Integer anoFabricacao;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

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

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Veiculo(String placa, String cidade, String modelo, Integer anoFabricacao, Boolean estado) {
        this.placa = placa;
        this.cidade = cidade;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.estado = estado;
    }

    public Veiculo() {
    }

}
