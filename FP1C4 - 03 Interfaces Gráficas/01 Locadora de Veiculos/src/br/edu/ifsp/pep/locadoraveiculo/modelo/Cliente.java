package br.edu.ifsp.pep.locadoraveiculo.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
@NamedQueries(value = {
    @NamedQuery(name = "Cliente.retornarTodos",
            query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.buscarPorNome",
            query = "SELECT c FROM Cliente c WHERE c.nome LIKE :nome")
})
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "nome", length = 40, nullable = false)
    private String nome;

    public Cliente() {
    }

    public Cliente(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
