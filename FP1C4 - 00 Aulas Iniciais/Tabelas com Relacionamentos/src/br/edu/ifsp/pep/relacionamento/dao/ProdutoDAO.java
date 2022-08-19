package br.edu.ifsp.pep.relacionamento.dao;

import br.edu.ifsp.pep.relacionamento.modelo.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class ProdutoDAO {

    private EntityManagerFactory emf;

    // Cria a "fabríca" ao iniciar a classe
    public ProdutoDAO() {
        emf = Persistence.createEntityManagerFactory("TR_PU");
    }

    // Cria o "gerente" sempre que for necessário
    private EntityManager getEntityManager() {
        return this.emf.createEntityManager();
    }

    public void inserir(Produto produto) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();
    }

    public void alterar(Produto produto) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(produto);
        em.getTransaction().commit();
    }

    // Retornando o resultado da consulta em uma lista de Produtos
    public List<Produto> buscar() {
        // Retornando a consulta: Pensar em classes
        TypedQuery<Produto> query = getEntityManager().createQuery("SELECT p FROM Produto p", Produto.class);
        return query.getResultList();
    }
}
