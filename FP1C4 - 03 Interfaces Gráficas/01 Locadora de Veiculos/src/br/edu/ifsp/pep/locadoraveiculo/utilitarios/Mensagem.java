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

}
