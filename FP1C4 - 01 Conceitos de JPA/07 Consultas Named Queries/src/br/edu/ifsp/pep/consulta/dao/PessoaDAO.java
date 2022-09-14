package br.edu.ifsp.pep.consulta.dao;

import br.edu.ifsp.pep.bibliotecas.dao.AbstractDAO;
import br.edu.ifsp.pep.consulta.modelo.Pessoa;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class PessoaDAO extends AbstractDAO<Pessoa> {

    public List<Pessoa> retonarTodos() {
        EntityManager em = getEntityManager();
        TypedQuery<Pessoa> query = em.createQuery(
                "SELECT p FROM Pessoa p", Pessoa.class);

        return query.getResultList();
    }

    public Pessoa buscarPorID(Integer id) {
        EntityManager em = getEntityManager();
        TypedQuery<Pessoa> query = em.createNamedQuery(
                "Pessoa.buscarPorId", Pessoa.class);
        query.setParameter("id", id);

        return query.getSingleResult();
    }

    public List<Pessoa> buscarPorNome(String nome) {
        EntityManager em = getEntityManager();
        TypedQuery<Pessoa> query = em.createNamedQuery(
                "Pessoa.buscarPorNome", Pessoa.class);
        query.setParameter("nome", "%" + nome + "%");

        return query.getResultList();
    }

    public List<Pessoa> buscarPorSalario(BigDecimal salario) {
        EntityManager em = getEntityManager();
        TypedQuery<Pessoa> query = em.createNamedQuery(
                "Pessoa.buscarPorSalario", Pessoa.class);
        query.setParameter("salario", salario);

        return query.getResultList();
    }

    public void verificarEstadoCicloDeVida() {
        Pessoa p = new Pessoa("Danilo", new Date(), new BigDecimal(5000));
        EntityManager em = getEntityManager();

        // Verificar se o objeto está sendo gerenciado (managed) ou não pelo Entity Manager
        System.out.println(em.contains(p));

        // Executando o método persist , e o objeto deve ir para estado gerenciado
        em.persist(p);
        System.out.println(em.contains(p));

        // Remove o objeto do estado gerenciavel
        em.detach(p);
        System.out.println(em.contains(p));

        em.close();
    }
}
