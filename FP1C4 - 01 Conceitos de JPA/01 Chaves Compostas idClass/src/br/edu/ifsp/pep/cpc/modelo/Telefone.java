package br.edu.ifsp.pep.cpc.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "telefone")
@IdClass(TelefonePK.class)
public class Telefone implements Serializable {

    @Id
    @Column(name = "ddd")
    private Integer ddd;

    @Id
    @Column(name = "numero", length = 20)
    private String numero;
    
    @Column(name = "descricao", length = 40, nullable = false)
    private String descricao;

    // Código Gerado ...
    public Integer getDdd() {
        return ddd;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Telefone() {
    }

}
