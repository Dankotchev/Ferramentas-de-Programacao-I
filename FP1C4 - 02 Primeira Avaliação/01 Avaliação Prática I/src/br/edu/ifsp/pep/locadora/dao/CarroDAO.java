package br.edu.ifsp.pep.locadora.dao;

import br.edu.ifsp.pep.locadora.modelo.Carro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class CarroDAO extends AbstractDAO<Carro> {

    public List<Carro> retornarTodos() {
        EntityManager em = getEntityManager();
        TypedQuery<Carro> query = em.createQuery("SELECT c FROM Carro c", Carro.class);

        return query.getResultList();
    }
}
