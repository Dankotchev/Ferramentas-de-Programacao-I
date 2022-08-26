package br.edu.ifsp.pep.relacionamento;

import br.edu.ifsp.pep.relacionamento.dao.CategoriaDAO;
import br.edu.ifsp.pep.relacionamento.dao.ProdutoDAO;
import br.edu.ifsp.pep.relacionamento.modelo.Categoria;
import br.edu.ifsp.pep.relacionamento.modelo.Produto;
import java.math.BigDecimal;
import java.util.List;

public class Principal {

    private static final ProdutoDAO produtoDAO = new ProdutoDAO();
    private static final CategoriaDAO categoriaDAO = new CategoriaDAO();

    public static void main(String[] args) {
        adicionarProdutos();
        exibirProdutos();
        reajustarPrecoProduto(10);
        exibirProdutos();
    }

    public static void teste() {

        Categoria categoria = new Categoria();
        Produto produto = new Produto();

        categoria.setDescricao("Informática");
        categoriaDAO.inserir(categoria);

        produto.setDescricao("Monitor Bom");
        produto.setPreco(new BigDecimal(600.0));
        produto.setQuantidade(125);
        produto.setCategoria(categoria);

        produtoDAO.inserir(produto);

        // Retornando o resultado da consulta em uma lista de Produtos
        List<Produto> listaProduto = produtoDAO.buscar();
        for (Produto p : listaProduto) {
            System.out.println("Descrição: " + p.getDescricao());
            System.out.println("Categoria: " + p.getCategoria().getDescricao());
        }

    }

    private static void adicionarProdutos() {

        for (int i = 0; i < 10; i++) {
            Categoria categoria = new Categoria();
            categoria.setDescricao("Categoria " + i + " ");
            categoriaDAO.inserir(categoria);

            Produto produto = new Produto();
            produto.setDescricao("Produto #" + i + " ");
            produto.setPreco(new BigDecimal(15.68 * (1 + i)));
            produto.setQuantidade(130 * ((i + 1) / 3));
            produto.setCategoria(categoria);
            produtoDAO.inserir(produto);

        }
    }

    public static void reajustarPrecoProduto(double porcentagem) {
        // Buscar Produtos
        List<Produto> buscar = produtoDAO.buscar();
        for (Produto p : buscar) {
            // Reajustar o preço
            p.setPreco(p.getPreco().multiply(BigDecimal.valueOf(1 + (porcentagem / 100))));

            // Atualiza o Banco de Dados
            produtoDAO.alterar(p);
        }
    }

    public static void exibirProdutos() {
        List<Produto> buscar = produtoDAO.buscar();
        for (Produto p : buscar) {
            System.out.println("Descrição: " + p.getDescricao()
                    + "Preço: R$ " + p.getPreco());
            System.out.println("Categoria: " + p.getCategoria().getDescricao());
        }
    }
}
