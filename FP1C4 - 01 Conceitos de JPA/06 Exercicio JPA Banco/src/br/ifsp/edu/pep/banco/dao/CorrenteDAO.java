package br.ifsp.edu.pep.banco.dao;

import br.edu.ifsp.pep.bibliotecas.dao.AbstractDAO;
import br.ifsp.edu.pep.banco.modelo.Corrente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class CorrenteDAO extends AbstractDAO<Corrente> {
        public List<Corrente> retonarTodos() {
        EntityManager em = getEntityManager();
        TypedQuery<Corrente> query = em.createQuery(
                "SELECT c FROM Corrente c", Corrente.class);

        return query.getResultList();
    }
}
