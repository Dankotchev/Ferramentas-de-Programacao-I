package br.edu.ifsp.pep.consulta.dao;

import br.edu.ifsp.pep.bibliotecas.dao.AbstractDAO;
import br.edu.ifsp.pep.consulta.modelo.Pessoa;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class PessoaDAO extends AbstractDAO<Pessoa> {

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
    
    public void verificarEstadoCicloDeVida(){
        Pessoa p = new Pessoa("Danilo", new Date(), new BigDecimal(5000));
        
    }
}
