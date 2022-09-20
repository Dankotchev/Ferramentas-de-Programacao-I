package br.edu.ifsp.pep.locadora.dao;

import br.edu.ifsp.pep.locadora.modelo.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ClienteDAO extends AbstractDAO<Cliente> {

    public List<Cliente> retornarTodos() {
        EntityManager em = getEntityManager();
        TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c", Cliente.class);

        return query.getResultList();
    }
}
