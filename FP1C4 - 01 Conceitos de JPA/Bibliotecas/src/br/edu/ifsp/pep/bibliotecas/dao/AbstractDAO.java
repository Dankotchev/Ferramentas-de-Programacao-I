package br.edu.ifsp.pep.bibliotecas.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class AbstractDAO<T> {

    private EntityManagerFactory emf;

    // Cria a "fabríca" ao iniciar a classe
    public AbstractDAO() {
        emf = Persistence.createEntityManagerFactory("LivrariaPU");
    }

    // Cria o "gerente" sempre que for necessário
    protected EntityManager getEntityManager() {
        return this.emf.createEntityManager();
    }

    public void inserir(T entidade) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(entidade);
        em.getTransaction().commit();
        em.close();
    }

    public void alterar(T entidade) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(entidade);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(T entidade) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(entidade));
        em.getTransaction().commit();
        em.close();
    }
}
