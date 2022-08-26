package br.edu.ifsp.pep.mm.dao;

import br.edu.ifsp.pep.mm.modelo.Veiculo;
import java.util.List;
import javax.persistence.TypedQuery;

public class VeiculoDAO extends AbstractDAO<Veiculo> {

    // Retornando o resultado da consulta em uma lista de Produtos
    public List<Veiculo> buscar() {
        // Retornando a consulta: Pensar em classes
        TypedQuery<Veiculo> query = super.getEntityManager().
                createQuery("SELECT v FROM Veiculo v", Veiculo.class);
        return query.getResultList();
    }
}
