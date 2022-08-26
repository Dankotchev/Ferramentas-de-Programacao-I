package br.edu.ifsp.pep.relacionamento.dao;

import br.edu.ifsp.pep.relacionamento.modelo.Produto;
import java.util.List;
import javax.persistence.TypedQuery;

public class ProdutoDAO extends AbstractDAO<Produto> {

    // Retornando o resultado da consulta em uma lista de Produtos
    public List<Produto> buscar() {
        // Retornando a consulta: Pensar em classes
        TypedQuery<Produto> query = super.getEntityManager().
                createQuery("SELECT p FROM Produto p", Produto.class);
        return query.getResultList();
    }
}
