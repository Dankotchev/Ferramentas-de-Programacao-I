package br.edu.ifsp.pep.mma.dao;

import br.edu.ifsp.pep.mma.modelo.Venda;

public class VendaDAO extends AbstractDAO<Venda> {

//    Sobrescrevendo o método de inserir, para também inserir no banco os itens da venda
//    Usando a @Cascate e o metodo PERSIST não há necessidade de sobrescrever
//    @Override
//    public void inserir(Venda venda) {
//        EntityManager em = getEntityManager();
//        em.getTransaction().begin();
//        em.persist(venda);
//        
//        for (Item item : venda.getItens()) {
//            em.persist(item);
//        }
//        em.getTransaction().commit();
//    }
}
