package br.edu.ifsp.pep.livraria.dao;

import br.edu.ifsp.pep.bibliotecas.dao.AbstractDAO;
import br.edu.ifsp.pep.livraria.modelo.Livro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class LivroDAO extends AbstractDAO {

    public Livro buscarPorCodigo(Integer codigo) {
        EntityManager em = getEntityManager();
        TypedQuery<Livro> query = em.createNamedQuery("buscarPorCodigo", Livro.class);
        query.setParameter("codigo", codigo);

        return query.getSingleResult();
    }

    public Livro buscarPorISBN(Integer isbn) {
        EntityManager em = getEntityManager();
        TypedQuery<Livro> query = em.createNamedQuery("buscarPorISBN", Livro.class);
        query.setParameter("isbn", isbn);

        return query.getSingleResult();
    }

    public List<Livro> buscarPorAutor(String autor) {
        EntityManager em = getEntityManager();
        TypedQuery<Livro> query = em.createNamedQuery("buscarPorAutor", Livro.class);
        query.setParameter("autor", autor);

        return query.getResultList();
    }

    public List<Livro> buscarPorTitulo(String titulo) {
        EntityManager em = getEntityManager();
        TypedQuery<Livro> query = em.createNamedQuery("buscarPorTitulo", Livro.class);
        query.setParameter("titulo", "%" + titulo + "%");

        return query.getResultList();
    }
    
    public List<Livro> retornarTodos(){
        EntityManager em = getEntityManager();
        TypedQuery<Livro> query = em.createQuery("SELECT l FROM Livro L", Livro.class);
        
        return query.getResultList();
                
    }
}
