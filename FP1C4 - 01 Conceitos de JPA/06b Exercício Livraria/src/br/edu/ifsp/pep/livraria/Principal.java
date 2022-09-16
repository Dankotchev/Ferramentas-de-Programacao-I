package br.edu.ifsp.pep.livraria;

import br.edu.ifsp.pep.livraria.dao.LivroDAO;
import br.edu.ifsp.pep.livraria.dao.VendaDAO;
import br.edu.ifsp.pep.livraria.modelo.ItemVenda;
import br.edu.ifsp.pep.livraria.modelo.Livro;
import br.edu.ifsp.pep.livraria.modelo.Venda;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Principal {

    private static final LivroDAO livroDAO = new LivroDAO();
    private static final VendaDAO vendaDAO = new VendaDAO();

    public static void main(String[] args) {
        inserirLivros();
        inserirVenda();
    }

    private static void inserirLivros() {
        String autor = null;
        String titulo = null;
        String isbn = "12";
        for (int i = 0; i < 10; i++) {
            Livro livro;
            isbn = isbn + i; // Não é a melhor construção, mas para testar está valendo
            if (i % 2 == 0) {
                autor = "Senhor Macadâmia # " + i;
                titulo = "Uma Aventura # " + i;
                livro = new Livro(isbn, autor, titulo, (i + 1) * 58, new BigDecimal((1 + i) * 5.69));
            } else {
                autor = "Senhorita Nozes # " + 2 * i;
                titulo = "Sonhos da " + i + "ª noite de primavera";
                livro = new Livro(isbn, autor, titulo, i * 118, new BigDecimal((1 + i) * 6.12));
            }

            livroDAO.inserir(livro);
        }
    }

    private static void inserirVenda() {
        List<Livro> livros = livroDAO.retornarTodos();
        Random random = new Random();
        int k;

        for (int i = 0; i < 10; i++) {
            Venda venda = new Venda();
            List<ItemVenda> listaItemVenda = new ArrayList<>();
            k = random.nextInt(5) + 1;

            for (int j = 0; j < 4; j++) {

                ItemVenda itemVenda = new ItemVenda();
                itemVenda.setVenda(venda);
                itemVenda.setQuantidade((1 + i));
                itemVenda.setLivro(livros.get(k));
                itemVenda.setValorUnitario(livros.get(k).getPreco());

                listaItemVenda.add(itemVenda);
                k++;
            }
            venda.setData(new Date());
            venda.setItemVendas(listaItemVenda);

            vendaDAO.inserir(venda);
        }
    }
}
