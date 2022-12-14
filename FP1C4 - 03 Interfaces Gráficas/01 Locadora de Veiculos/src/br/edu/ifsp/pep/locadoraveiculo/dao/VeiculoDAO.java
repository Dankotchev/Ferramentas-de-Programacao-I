package br.edu.ifsp.pep.locadoraveiculo.dao;

import br.edu.ifsp.pep.locadoraveiculo.modelo.Veiculo;
import java.util.List;
import javax.persistence.EntityManager;

public class VeiculoDAO extends AbstractDAO<Veiculo> {

    public List<Veiculo> buscarTodos() {
        return getEntityManager()
                .createNamedQuery("Veiculo.buscarTodos", Veiculo.class)
                .getResultList();
    }

    public List<Veiculo> buscarVeiculosDisponiveisParaLocacao() {
        return getEntityManager()
                .createNamedQuery("Veiculo.buscarDisponiveisParaLocacao", Veiculo.class)
                .getResultList();
    }
    
    public List<Veiculo> buscarPorModelo (String modelo){
        return getEntityManager().createNamedQuery("Veiclo.buscarPorModelo", Veiculo.class)
                .setParameter("modelo", "%" + modelo + "%")
                .getResultList();
    }
    
    public List<Veiculo> buscarPorTipoVeiculo(long tipo) {
        return getEntityManager()
                .createNamedQuery("Veiculo.buscarPorTipoVeiculo", Veiculo.class)
                .setParameter("tipo", tipo)
                .getResultList();
    }
    
    public List<Veiculo> buscarPorModeloETipoVeiculo(String modelo, long tipo){
        return getEntityManager()
                .createNamedQuery("Veiculo.buscarPorModeloETipoVeiculo", Veiculo.class)
                .setParameter("modelo", "%" + modelo + "%")
                .setParameter("tipo", tipo)
                .getResultList();
    }

    @Override
    public void inserir(Veiculo veiculo) throws Exception {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        List<Veiculo> veiculos = em.createNamedQuery(
                "Veiculo.buscarPorPlacaECidade",
                Veiculo.class)
                .setParameter("placa", veiculo.getPlaca())
                .setParameter("cidade", veiculo.getCidade())
                .getResultList();
        if (veiculos == null || veiculos.isEmpty()) {
            em.persist(veiculo);
        } else {
            throw new Exception(
                    "J?? existe um Ve??culo com a placa "
                    + veiculo.getPlaca()
                    + " na cidade " + veiculo.getCidade());
        }

        em.getTransaction().commit();
        em.close();
    }
    
}
