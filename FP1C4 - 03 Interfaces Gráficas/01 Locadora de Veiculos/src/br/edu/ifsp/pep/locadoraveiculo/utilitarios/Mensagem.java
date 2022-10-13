package br.edu.ifsp.pep.locadoraveiculo.utilitarios;

import javax.swing.JOptionPane;

public class Mensagem {

    public void mAviso(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Aviso", JOptionPane.WARNING_MESSAGE);
    }

    public void mAtencao(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Atenção", JOptionPane.WARNING_MESSAGE);
    }

    public void mErro(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public void mCorreto(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    public void mInformacao(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem, "Informação", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean mSimNao(String mensagem) {
        boolean retorno = true;
        int escolha = JOptionPane.showConfirmDialog(null, mensagem,
                "Atenção", JOptionPane.YES_NO_OPTION);
        if (escolha == JOptionPane.NO_OPTION) {
            retorno = false;
        }
        return retorno;
    }

    public boolean mConfimarCancelar(String mensagem) {
        boolean retorno = true;
        int escolha = JOptionPane.showConfirmDialog(null, mensagem, 
                "Atenção", JOptionPane.OK_CANCEL_OPTION);
        if (escolha == JOptionPane.CANCEL_OPTION) {
            retorno = false;
        }
        return retorno;
    }
    
}
