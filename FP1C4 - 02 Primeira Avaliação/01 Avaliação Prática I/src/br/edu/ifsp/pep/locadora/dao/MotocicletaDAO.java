package br.edu.ifsp.pep.locadora.dao;

import br.edu.ifsp.pep.locadora.modelo.Motocicleta;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class MotocicletaDAO extends AbstractDAO<Motocicleta> {

    public List<Motocicleta> retornarTodos() {
        EntityManager em = getEntityManager();
        TypedQuery<Motocicleta> query = em.createQuery("SELECT m FROM Motocicleta m", Motocicleta.class);

        return query.getResultList();
    }
}
