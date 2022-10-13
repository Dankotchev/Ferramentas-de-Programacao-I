package br.edu.ifsp.pep.locadoraveiculo.dao;

import br.edu.ifsp.pep.locadoraveiculo.modelo.Cliente;
import java.util.List;

public class ClienteDAO extends AbstractDAO<Cliente>{
    
    public List<Cliente> retornarTodos (){
        return getEntityManager()
                .createNamedQuery("Cliente.retornarTodos", Cliente.class)
                .getResultList();
    }
    
    public List<Cliente> buscarPorNome(String nome){
        return getEntityManager()
                .createNamedQuery("Cliente.buscarPorNome", Cliente.class)
                .setParameter("nome", "%" + nome + "%")
                .getResultList();
    }
    
    public Cliente procurarPorID(long id) {
        return getEntityManager().find(Cliente.class, id);
    }
}
