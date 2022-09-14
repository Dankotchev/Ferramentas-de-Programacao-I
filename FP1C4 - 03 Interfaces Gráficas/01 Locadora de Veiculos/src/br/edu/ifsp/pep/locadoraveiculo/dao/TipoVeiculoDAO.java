package br.edu.ifsp.pep.locadoraveiculo.dao;

import br.edu.ifsp.pep.locadoraveiculo.modelo.TipoVeiculo;
import java.util.List;

public class TipoVeiculoDAO extends AbstractDAO<TipoVeiculo> {

    public List<TipoVeiculo> procurarPorNome(String nome) {
        return getEntityManager()
                .createNamedQuery("TipoVeiculo.procurarPorNome", TipoVeiculo.class)
                .setParameter("nome", "%" + nome + "%")
                .getResultList();
    }
}
