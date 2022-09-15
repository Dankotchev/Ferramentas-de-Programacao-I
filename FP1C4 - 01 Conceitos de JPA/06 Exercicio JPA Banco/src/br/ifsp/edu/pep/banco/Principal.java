package br.ifsp.edu.pep.banco;

import br.ifsp.edu.pep.banco.dao.CorrenteDAO;
import br.ifsp.edu.pep.banco.modelo.Corrente;
import br.ifsp.edu.pep.banco.modelo.Poupanca;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Principal {
//    Nome da PU :: BancoPU

    private static final CorrenteDAO correnteDAO = new CorrenteDAO();

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            if (i % 2 == 0) {
                System.out.println("Informe uma Conta Corrente");
                inserirCorrente();
                System.out.println();
            } else {
                System.out.println("Informe uma Conta Poupança");
                inserirPoupanca();
                System.out.println();
            }
        }

        apresentarContas();
    }

    private static void inserirCorrente() {
        Scanner teclado = new Scanner(System.in);
        Corrente corrente = new Corrente();

        System.out.print("Informe a Agência         : ");
        corrente.setAgencia(teclado.nextInt());
        teclado.nextLine();
        System.out.print("Informe o Número da Conta : ");
        corrente.setNumeroConta(teclado.nextInt());
        System.out.print("Informe o Saldo Inicial   : ");
        corrente.setSaldo(new BigDecimal(teclado.nextFloat()));
        correnteDAO.inserir(corrente);
    }

    private static void inserirPoupanca() {
        Scanner teclado = new Scanner(System.in);
        Poupanca poupanca = new Poupanca();

        System.out.print("Informe a Agência           : ");
        poupanca.setAgencia(teclado.nextInt());
        teclado.nextLine();
        System.out.print("Informe o Número da Conta   : ");
        poupanca.setNumeroConta(teclado.nextInt());
        System.out.print("Informe o Saldo Inicial     : ");
        poupanca.setSaldo(new BigDecimal(teclado.nextFloat()));
        poupanca.setAniversario(new Date());
        correnteDAO.inserir(poupanca);
    }

    private static void apresentarContas() {
        List<Corrente> listaCorrentes = correnteDAO.retonarTodos();
        for (Corrente corrente : listaCorrentes) {
            if (corrente instanceof Poupanca) {
                System.out.println((Poupanca) corrente);
            } else {
                System.out.println(corrente);
            }
        }
    }
}
