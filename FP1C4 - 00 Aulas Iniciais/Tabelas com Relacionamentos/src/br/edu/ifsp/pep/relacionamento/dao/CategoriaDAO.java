package br.edu.ifsp.pep.relacionamento.dao;

import br.edu.ifsp.pep.relacionamento.modelo.Categoria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class CategoriaDAO {

    private EntityManagerFactory emf;

    // Cria a "fabríca" ao iniciar a classe
    public CategoriaDAO() {
        emf = Persistence.createEntityManagerFactory("TR_PU");
    }

    // Cria o "gerente" sempre que for necessário
    private EntityManager getEntityManager() {
        return this.emf.createEntityManager();
    }

    public void inserir(Categoria categoria) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(categoria);
        em.getTransaction().commit();
    }

    public void alterar(Categoria categoria) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(categoria);
        em.getTransaction().commit();
    }

    // Retornando o resultado da consulta em uma lista de Produtos
    public List<Categoria> buscar() {
        // Retornando a consulta: Pensar em classes
        TypedQuery<Categoria> query = getEntityManager().createQuery("SELECT c FROM Categoria c", Categoria.class);
        return query.getResultList();
    }
}
