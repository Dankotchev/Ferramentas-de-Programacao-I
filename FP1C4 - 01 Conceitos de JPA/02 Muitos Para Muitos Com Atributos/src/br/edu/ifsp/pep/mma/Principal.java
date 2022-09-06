package br.edu.ifsp.pep.mma;

import br.edu.ifsp.pep.mma.dao.ProdutoDAO;
import br.edu.ifsp.pep.mma.dao.VendaDAO;
import br.edu.ifsp.pep.mma.modelo.Item;
import br.edu.ifsp.pep.mma.modelo.Produto;
import br.edu.ifsp.pep.mma.modelo.Venda;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Principal {

    private static final ProdutoDAO produtoDAO = new ProdutoDAO();
    private static final VendaDAO vendaDAO = new VendaDAO();

    public static void main(String[] args) {
        adicionarProdutos();
        exibirProdutos();
        adicionarVenda();
    }

    private static void adicionarProdutos() {
        for (int i = 0; i < 10; i++) {
            Produto produto = new Produto(new BigDecimal((i + 1) * 345), i * 123,
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

    private static void adicionarVenda() {
        Item item = new Item();
        Venda venda = new Venda();
        List<Produto> listaProduto = produtoDAO.buscarTodos();

        // Atribuindo informações a um item antes de inserir na lista e por seguinte, na venda
        item.setVenda(venda);
        item.setProduto(listaProduto.get(0));
        item.setPreco(listaProduto.get(0).getValor());
        item.setQuantidae(10);

        List<Item> listaItens = new ArrayList<>();
        listaItens.add(item);

        venda.setItens(listaItens);
        venda.setData(new Date());

        vendaDAO.inserir(venda);
    }
}
