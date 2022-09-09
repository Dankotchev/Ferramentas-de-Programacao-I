package br.ifsp.edu.pep.banco;

import br.ifsp.edu.pep.banco.dao.CorrenteDAO;
import br.ifsp.edu.pep.banco.dao.PoupancaDAO;
import br.ifsp.edu.pep.banco.modelo.Corrente;
import br.ifsp.edu.pep.banco.modelo.Poupanca;
import java.math.BigDecimal;
import java.util.Scanner;

public class Principal {

    private static final CorrenteDAO correnteDAO = new CorrenteDAO();
    private static final PoupancaDAO poupancaDAO = new PoupancaDAO();

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            inserirCorrente();
        }
        for (int i = 0; i < 3; i++) {
            inserirPoupanca();
        }

    }

    private static void inserirCorrente() {
        Scanner teclado = new Scanner(System.in);
        Corrente corrente = new Corrente();

        System.out.print("Informe a Agência         : ");
        corrente.setAgencia(teclado.nextInt());
        teclado.nextLine();
        System.out.print("Informe o Número da Conta : ");
        corrente.setNumeroConta(teclado.nextInt());
//        teclado.nextLine();
        System.out.print("Informe o Saldo Inicial   : ");
        corrente.setSaldo(new BigDecimal(teclado.nextInt()));
//        teclado.close();

        correnteDAO.inserir(corrente);
    }

    private static void inserirPoupanca() {
        Scanner teclado = new Scanner(System.in);
        Poupanca poupanca = new Poupanca();

        System.out.print("Informe a Agência         : ");
        poupanca.setAgencia(teclado.nextInt());
        teclado.nextLine();
        System.out.print("Informe o Número da Conta : ");
        poupanca.setNumeroConta(teclado.nextInt());
//        teclado.nextLine();
        System.out.print("Informe o Saldo Inicial   : ");
        poupanca.setSaldo(new BigDecimal(teclado.nextInt()));
//        teclado.close();

        correnteDAO.inserir(poupanca);
    }
}
