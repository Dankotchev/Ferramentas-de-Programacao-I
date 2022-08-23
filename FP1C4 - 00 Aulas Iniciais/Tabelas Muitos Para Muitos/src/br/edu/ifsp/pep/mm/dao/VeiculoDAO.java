package br.edu.ifsp.pep.mm.dao;

import br.edu.ifsp.pep.mm.modelo.Veiculo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class VeiculoDAO {

    private EntityManagerFactory emf;

    // Cria a "fabríca" ao iniciar a classe
    public VeiculoDAO() {
        emf = Persistence.createEntityManagerFactory("Muitos_Para_MuitosPU");
    }

    // Cria o "gerente" sempre que for necessário
    private EntityManager getEntityManager() {
        return this.emf.createEntityManager();
    }

    public void inserir(Veiculo veiculo) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(veiculo);
        em.getTransaction().commit();
    }

    public void alterar(Veiculo veiculo) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(veiculo);
        em.getTransaction().commit();
    }

    // Retornando o resultado da consulta em uma lista de Produtos
    public List<Veiculo> buscar() {
        // Retornando a consulta: Pensar em classes
        TypedQuery<Veiculo> query = getEntityManager().createQuery("SELECT v FROM Veiculo v", Veiculo.class);
        return query.getResultList();
    }
}
