package br.edu.ifsp.pep.mma;

import br.edu.ifsp.pep.mma.dao.ProdutoDAO;
import br.edu.ifsp.pep.mma.modelo.Produto;
import java.math.BigDecimal;
import java.util.List;

public class Principal {
    private static final ProdutoDAO produtoDAO= new ProdutoDAO();

    public static void main(String[] args) {
        adcionarProdutos();
        exibirProdutos();
    }
    
    private static void adcionarProdutos(){
        for (int i = 0; i < 10; i++) {
            Produto produto = new Produto(new BigDecimal((i+1) * 345), i * 123,
                    "Produto #" + i);
            
            produtoDAO.inserir(produto);
        }
    }
    
    private static void exibirProdutos() {
        List<Produto> listaProduto = produtoDAO.buscarTodos();
        for (Produto p : listaProduto) {
            System.out.println(p);
        }
    }
}
