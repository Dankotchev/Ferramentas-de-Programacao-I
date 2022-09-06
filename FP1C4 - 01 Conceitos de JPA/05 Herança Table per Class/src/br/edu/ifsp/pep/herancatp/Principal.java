package br.edu.ifsp.pep.herancatp;

import br.edu.ifsp.pep.herancatp.dao.FuncionarioDAO;
import br.edu.ifsp.pep.herancatp.dao.PessoaDAO;
import br.edu.ifsp.pep.herancatp.modelo.Funcionario;
import br.edu.ifsp.pep.herancatp.modelo.Pessoa;
import java.math.BigDecimal;

public class Principal {

    private static final PessoaDAO pessoaDAO = new PessoaDAO();
    private static final FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    public static void main(String[] args) {
        Pessoa p1 = new Pessoa();
        p1.setNome("Daniele Quirino");

        pessoaDAO.inserir(p1);

        Funcionario f1 = new Funcionario();
        f1.setNome("Danilo Quirino");
        f1.setSalario(new BigDecimal(40000));

        funcionarioDAO.inserir(f1);
        adicionarPessoas();
    }

    private static void adicionarPessoas() {
        Pessoa pessoa = new Pessoa();
        Funcionario funcionario = new Funcionario();

        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                pessoa.setNome("Pessoa # " + (i + 1));
                pessoaDAO.inserir(pessoa);
            } else {
                funcionario.setNome("Pessoa # " + (i + 1));
                funcionario.setSalario(new BigDecimal(2386 * (i + 2)));
                funcionarioDAO.inserir(funcionario);
            }
        }
    }
}
