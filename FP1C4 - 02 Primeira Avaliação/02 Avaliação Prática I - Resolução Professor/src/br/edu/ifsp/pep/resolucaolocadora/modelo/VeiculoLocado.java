package br.edu.ifsp.pep.resolucaolocadora.modelo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "veiculo_locado")
public class VeiculoLocado {

    @EmbeddedId
    private VeiculoLocadoPK veiculoLocadoPK;

    @ManyToOne
    @JoinColumn(name = "veiculo_id", nullable = false)
    private Veiculo veiculo;

    @ManyToOne
    @JoinColumn(name = "locacao_id", nullable = false)
    private Locacao locacao;

    @Column(name = "dias_locado", nullable = false)
    private Integer diasLocado;

    @Column(name = "data_devolucao")
    private Date dataDevolucao;

    //
    public VeiculoLocadoPK getVeiculoLocadoPK() {
        return veiculoLocadoPK;
    }

    public void setVeiculoLocadoPK(VeiculoLocadoPK veiculoLocadoPK) {
        this.veiculoLocadoPK = veiculoLocadoPK;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Locacao getLocacao() {
        return locacao;
    }

    public void setLocacao(Locacao locacao) {
        this.locacao = locacao;
    }

    public Integer getDiasLocado() {
        return diasLocado;
    }

    public void setDiasLocado(Integer diasLocado) {
        this.diasLocado = diasLocado;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public VeiculoLocado() {
    }

    public VeiculoLocado(VeiculoLocadoPK veiculoLocadoPK, Veiculo veiculo, Locacao locacao, Integer diasLocado, Date dataDevolucao) {
        this.veiculoLocadoPK = veiculoLocadoPK;
        this.veiculo = veiculo;
        this.locacao = locacao;
        this.diasLocado = diasLocado;
        this.dataDevolucao = dataDevolucao;
    }

}
