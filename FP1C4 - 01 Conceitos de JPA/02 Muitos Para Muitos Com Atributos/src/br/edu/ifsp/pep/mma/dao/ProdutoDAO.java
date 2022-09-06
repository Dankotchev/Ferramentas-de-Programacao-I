package br.edu.ifsp.pep.mma.dao;

import br.edu.ifsp.pep.mma.modelo.Produto;
import java.util.List;
import javax.persistence.TypedQuery;

public class ProdutoDAO extends AbstractDAO<Produto> {

    public List<Produto> buscarTodos() {
        // Retornando a consulta: Pensar em classes
        TypedQuery<Produto> query = super.getEntityManager().
                createQuery("SELECT p FROM Produto p", Produto.class);
        return query.getResultList();
    }
}