package br.edu.ifsp.pep.utilitarios;

import javax.swing.JOptionPane;

public class Mensagem {

    public static void mAviso(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Aviso", JOptionPane.WARNING_MESSAGE);
    }

    public static void mAtencao(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Atenção", JOptionPane.WARNING_MESSAGE);
    }

    public static void mErro(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void mCorreto(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }

    public static void mInformacao(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Informação", JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean mSimNao(String mensagem) {
        boolean retorno = true;
        int escolha = JOptionPane.showConfirmDialog(null, mensagem,
                "Atenção", JOptionPane.YES_NO_OPTION);
        if (escolha == JOptionPane.NO_OPTION) {
            retorno = false;
        }
        return retorno;
    }

    public static boolean mConfimarCancelar(String mensagem) {
        boolean retorno = true;
        int escolha = JOptionPane.showConfirmDialog(null, mensagem,
                "Atenção", JOptionPane.OK_CANCEL_OPTION);
        if (escolha == JOptionPane.CANCEL_OPTION) {
            retorno = false;
        }
        return retorno;
    }

}
