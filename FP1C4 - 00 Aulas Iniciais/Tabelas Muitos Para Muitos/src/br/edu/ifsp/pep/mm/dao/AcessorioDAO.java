package br.edu.ifsp.pep.mm.dao;

import br.edu.ifsp.pep.mm.modelo.Acessorio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AcessorioDAO {

    private EntityManagerFactory emf;

    // Cria a "fabríca" ao iniciar a classe
    public AcessorioDAO() {
        emf = Persistence.createEntityManagerFactory("Muitos_Para_MuitosPU");
    }

    // Cria o "gerente" sempre que for necessário
    private EntityManager getEntityManager() {
        return this.emf.createEntityManager();
    }

    public void inserir(Acessorio acessorio) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(acessorio);
        em.getTransaction().commit();
    }

    public void alterar(Acessorio acessesorio) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(acessesorio);
        em.getTransaction().commit();
    }

    // Retornando o resultado da consulta em uma lista de Produtos
    public List<Acessorio> buscar() {
        // Retornando a consulta: Pensar em classes
        TypedQuery<Acessorio> query = getEntityManager().createQuery("SELECT a FROM Acessorio a", Acessorio.class);
        return query.getResultList();
    }
}
