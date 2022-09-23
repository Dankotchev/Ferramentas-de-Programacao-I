package br.edu.ifsp.pep.resolucaolocadora.dao;

import br.edu.ifsp.pep.resolucaolocadora.modelo.Veiculo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class VeiculoDAO extends AbstractDAO<Veiculo> {

    public List<Veiculo> buscarTodos() {
        return getEntityManager()
                .createNamedQuery("Veiculo.buscarTodos", Veiculo.class)
                .getResultList();
    }

    public Veiculo buscarPorPlacaECidade(String placa, String cidade) {
        return getEntityManager()
                .createNamedQuery("Veiculo.buscarPorPlacaECidade", Veiculo.class)
                .setParameter("placa", placa).setParameter("cidade", cidade)
                .getSingleResult();
    }

    @Override
    public void inserir(Veiculo veiculo) throws Exception {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        List<Veiculo> resultado = em.createNamedQuery(
                "Veiculo.buscarPorPlacaECidade", Veiculo.class)
                .setParameter("placa", veiculo.getPlaca())
                .setParameter("cidade", veiculo.getCidade())
                .getResultList();

        if (resultado == null || resultado.isEmpty()) {
            em.persist(veiculo);
        } else {
            throw new Exception("Já existe Veículo com a placa "
                    + veiculo.getPlaca() + " na cidade "
                    + veiculo.getCidade());
        }

        em.getTransaction().commit();
        em.close();
    }

//    @Override
//    public void inserir(Veiculo veiculo) {
//        EntityManager em = getEntityManager();
//        em.getTransaction().begin();
//
//        try {
//            em.createNamedQuery("Veiculo.buscarPorPlacaECidade", Veiculo.class)
//                    .setParameter("placa", veiculo.getPlaca())
//                    .setParameter("cidade", veiculo.getCidade())
//                    .getSingleResult();
//        } catch (NoResultException nre) {
//            // Caso não retorne nenhum objeto da consulta, ocorre a nre e neste caso inserimos o veiculo no banco
//            em.persist(veiculo);
//            
//        }
//
//        em.getTransaction().commit();
//        em.close();
//    }
}
