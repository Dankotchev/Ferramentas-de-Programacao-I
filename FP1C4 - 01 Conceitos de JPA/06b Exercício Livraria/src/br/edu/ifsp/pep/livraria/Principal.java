package br.edu.ifsp.pep.livraria;

import br.edu.ifsp.pep.livraria.dao.LivroDAO;
import br.edu.ifsp.pep.livraria.modelo.Livro;
import java.math.BigDecimal;

public class Principal {

    private static final LivroDAO livroDAO = new LivroDAO();

    public static void main(String[] args) {
//        Livro livro = new Livro("23456789", "Danilo",
//                "Uma viagem pelo Atlântico", 286, new BigDecimal(65.85));
//
//        livroDAO.inserir(livro);
    inserirLivros();
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
                livro = new Livro(isbn, autor, titulo, (i+1) * 58, new BigDecimal((1 + i) * 5.69));
            } else {
                autor = "Senhorita Nozes # " + 2 * i;
                titulo = "Sonhos da " + i + "ª noite de primavera";
                livro = new Livro(isbn, autor, titulo, i * 118, new BigDecimal((1 + i) * 6.12));
            }
            
            livroDAO.inserir(livro);
        }
    }
}
