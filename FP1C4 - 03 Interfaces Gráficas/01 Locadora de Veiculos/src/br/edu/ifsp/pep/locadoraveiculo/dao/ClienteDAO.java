package br.edu.ifsp.pep.locadoraveiculo.dao;

import br.edu.ifsp.pep.locadoraveiculo.modelo.Cliente;

public class ClienteDAO extends AbstractDAO<Cliente>{
    
    public Cliente procurarPorID(long id) {
        return getEntityManager().find(Cliente.class, id);
    }
}
