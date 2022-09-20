package br.edu.ifsp.pep.resolucaolocadora.dao;

import br.edu.ifsp.pep.resolucaolocadora.modelo.Veiculo;
import java.util.List;

public class VeiculoDAO extends AbstractDAO<Veiculo>{
    
    public List<Veiculo> buscarTodos(){
        return getEntityManager()
                .createNamedQuery("Veiculo.buscarTodos", Veiculo.class)
                .getResultList();
    }
    
    public Veiculo buscarPorPlacaECidade(String placa, String cidade){
        return getEntityManager()
                .createNamedQuery("Veiculo.buscarPorPlacaECidade", Veiculo.class)
                .setParameter("placa", placa).setParameter("cidade", cidade)
                .getSingleResult();
    }
}
