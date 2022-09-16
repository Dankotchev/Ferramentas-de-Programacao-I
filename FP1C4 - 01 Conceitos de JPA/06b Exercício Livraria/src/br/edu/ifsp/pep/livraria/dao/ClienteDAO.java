package br.edu.ifsp.pep.livraria.dao;

import br.edu.ifsp.pep.bibliotecas.dao.AbstractDAO;
import br.edu.ifsp.pep.livraria.modelo.Cliente;
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
