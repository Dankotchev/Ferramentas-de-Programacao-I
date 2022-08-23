package br.edu.ifsp.pep.mm.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "veiculo")
public class Veiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Long codigo;

    @Column(name = "ano_fabricacao", nullable = false)
    private Integer anoFabricacao;

    @Column(name = "ano_modelo", nullable = false)
    private Integer anoModelo;

    @Column(name = "data_cadastro", nullable = false)
    private Date dataCadastro;

    @Column(name = "fabricante", nullable = false, length = 60)
    private String fabricante;

    @Column(name = "modelo", nullable = false, length = 60)
    private String modelo;

    @Column(name = "tipo_combustivel", nullable = false, length = 60)
    private String tipoCombustivel;

    @Column(name = "valor", precision = 8, scale = 2)
    private BigDecimal valor;

    @ManyToMany
    @JoinTable(name = "veiculo_acessorio", 
            joinColumns = @JoinColumn(name = "veiculo_codigo"),
            inverseJoinColumns = @JoinColumn(name = "acessorio_codigo"))
    private List<Acessorio> acessorios;

    // Código gerado
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }

    public Veiculo() {
    }

    public Veiculo(Integer anoFabricacao, Integer anoModelo, Date dataCadastro, String fabricante, String modelo, String tipoCombustivel, BigDecimal valor, List<Acessorio> acessorios) {
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
        this.dataCadastro = dataCadastro;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.tipoCombustivel = tipoCombustivel;
        this.valor = valor;
        this.acessorios = acessorios;
    }

}
