package br.ifsp.edu.pep.banco;

import br.ifsp.edu.pep.banco.dao.CorrenteDAO;
import br.ifsp.edu.pep.banco.dao.PoupancaDAO;
import br.ifsp.edu.pep.banco.modelo.Corrente;
import java.math.BigDecimal;
import java.util.Scanner;

public class Principal {

    private static final CorrenteDAO correnteDAO = new CorrenteDAO();
    private static final PoupancaDAO poupancaDAO = new PoupancaDAO();

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            inserirCorrente();
        }
        // Não passa para o segundo inserir, dando erro no scanner

    }

    private static void inserirCorrente() {
        Scanner teclado = new Scanner(System.in);
        Corrente corrente = new Corrente();

        System.out.println("Informe a Agência : ");
        corrente.setAgencia(teclado.nextInt());
        teclado.nextLine();
        System.out.println("Informe o Número da Conta : ");
        corrente.setNumeroConta(teclado.nextInt());
        teclado.nextLine();
        corrente.setSaldo(BigDecimal.ZERO);
        teclado.close();

        correnteDAO.inserir(corrente);
    }
}
