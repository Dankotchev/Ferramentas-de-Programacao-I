package br.edu.ifsp.pep.consulta;

import br.edu.ifsp.pep.consulta.dao.PessoaDAO;
import br.edu.ifsp.pep.consulta.modelo.Pessoa;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Principal {

    private static final PessoaDAO pessoaDAO = new PessoaDAO();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Pessoa pessoa = new Pessoa("Pessoa " + (i + 1), new Date(), new BigDecimal((i + 1) * 1000));
            pessoaDAO.inserir(pessoa);
        }

        System.out.println("Pessoa de ID = 5:");
        Pessoa pessoaRetornada = pessoaDAO.buscarPorID(5);
        System.out.println(pessoaRetornada);

        System.out.println("Pessoas com 1 no nome:");
        List<Pessoa> buscarPorNome = pessoaDAO.buscarPorNome("1");
        for (Pessoa pessoa : buscarPorNome) {
            System.out.println(pessoa);
        }

        System.out.println("Pessoas com salario maior que 5000");
        List<Pessoa> buscarPorSalario = pessoaDAO.buscarPorSalario(5000);
        for (Pessoa pessoa : buscarPorSalario) {
            System.out.println(pessoa);
        }
    }

}
