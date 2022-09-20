package br.edu.ifsp.pep.locadora.dao;

import br.edu.ifsp.pep.locadora.modelo.Locado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class LocadoDAO extends AbstractDAO<Locado> {

    public List<Locado> retornarTodos() {
        EntityManager em = getEntityManager();
        TypedQuery<Locado> query = em.createQuery("SELECT l FROM Locado l", Locado.class);

        return query.getResultList();
    }
}
