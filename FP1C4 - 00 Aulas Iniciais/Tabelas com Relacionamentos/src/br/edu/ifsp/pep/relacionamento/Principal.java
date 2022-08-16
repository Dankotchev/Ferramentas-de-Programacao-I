package br.edu.ifsp.pep.relacionamento;

import br.edu.ifsp.pep.relacionamento.modelo.Categoria;
import br.edu.ifsp.pep.relacionamento.modelo.Produto;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Principal {

    public static void main(String[] args) {

        Categoria categoria = new Categoria();
        categoria.setDescricao("Informática");

        Produto produto = new Produto();
        produto.setDescricao("Monitor Bom");
        produto.setPreco(new BigDecimal(600.0));
        produto.setQuantidade(125);

        produto.setCategoria(categoria);

        // Comando unico para criar Tanto a "Fábrica" quanto o "Gerente"
        EntityManager em = Persistence
                .createEntityManagerFactory("TR_PU")
                .createEntityManager();

        // Transaçõs para o Banco de Dados
        em.getTransaction().begin();

        em.persist(categoria);
        em.persist(produto);

        // Retornando a consulta: Pensar em classes
        TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto p", Produto.class);
        
        // Retornando o resultado da cionsulta em uma lista de Produtos
        List<Produto> listaProduto = query.getResultList();

        for (Produto p : listaProduto) {
            System.out.println("Descrição: " + p.getDescricao());
            System.out.println("Categoria: " + p.getCategoria().getDescricao());
        }

        em.getTransaction().commit();
        em.close();
    }
}
