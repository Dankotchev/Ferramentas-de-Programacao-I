package br.edu.ifsp.pep.resolucaolocadora.dao;

import br.edu.ifsp.pep.resolucaolocadora.modelo.Cliente;

public class ClienteDAO extends AbstractDAO<Cliente> {

    public Cliente procurarPorId(Integer id) {
        return (Cliente) getEntityManager()
                .createQuery("SELECT * FROM cliente WHERE id = " + id)
                .getSingleResult();
    }
}
