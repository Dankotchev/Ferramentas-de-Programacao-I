package br.edu.ifsp.pep.relacionamento.dao;

import br.edu.ifsp.pep.relacionamento.modelo.Categoria;
import java.util.List;
import javax.persistence.TypedQuery;

public class CategoriaDAO extends AbstractDAO<Categoria> {

    // Retornando o resultado da consulta em uma lista de Produtos
    public List<Categoria> buscar() {
        // Retornando a consulta: Pensar em classes
        TypedQuery<Categoria> query = super.getEntityManager().
                createQuery("SELECT c FROM Categoria c", Categoria.class);
        return query.getResultList();
    }
}
