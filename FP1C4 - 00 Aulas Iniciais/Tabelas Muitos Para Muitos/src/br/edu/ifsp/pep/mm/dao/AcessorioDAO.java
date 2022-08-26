package br.edu.ifsp.pep.mm.dao;

import br.edu.ifsp.pep.mm.modelo.Acessorio;
import java.util.List;
import javax.persistence.TypedQuery;

public class AcessorioDAO extends AbstractDAO<Acessorio> {

    // Retornando o resultado da consulta em uma lista de Produtos
    public List<Acessorio> buscar() {
        // Retornando a consulta: Pensar em classes
        TypedQuery<Acessorio> query = super.getEntityManager().
                createQuery("SELECT a FROM Acessorio a", Acessorio.class);
        return query.getResultList();
    }
}
