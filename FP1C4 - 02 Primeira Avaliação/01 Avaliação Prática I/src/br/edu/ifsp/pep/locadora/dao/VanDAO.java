package br.edu.ifsp.pep.locadora.dao;

import br.edu.ifsp.pep.locadora.modelo.Van;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class VanDAO extends AbstractDAO<Van>{
    public List<Van> retornarTodos() {
        EntityManager em = getEntityManager();
        TypedQuery<Van> query = em.createQuery("SELECT v FROM Van v", Van.class);
        
        return query.getResultList();
    }
    
}
