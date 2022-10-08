package br.edu.ifsp.pep.locadoraveiculo.visao;

import br.edu.ifsp.pep.locadoraveiculo.dao.TipoVeiculoDAO;
import br.edu.ifsp.pep.locadoraveiculo.modelo.TipoVeiculo;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TipoVeiculoView extends javax.swing.JDialog {

    private static final TipoVeiculoDAO tipoVeiculoDAO = new TipoVeiculoDAO();
    private List<TipoVeiculo> listaTiposVeiculos;
    private TipoVeiculo tipoVeiculo; // Utilizar para inserir ou atualzar

    public TipoVeiculoView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setEstadoCamposTextos(false);
        this.setEstadoBotoes(true);
    }

    public void setEstadoCamposTextos(boolean estado) {
        this.txtValorDiaria.setVisible(estado);
        this.labelValorDiaria.setVisible(estado);
        this.tabelaTipoVeiculo.setEnabled(!estado);
        this.btnPesquisar.setVisible(!estado);
        this.btnPesquisar.setEnabled(!estado);
    }

    public void setEstadoBotoes(boolean estado) {
        this.btnInserir.setEnabled(estado);
        this.btnAlterar.setEnabled(estado);
        this.btnExcluir.setEnabled(estado);
        this.btnGravar.setEnabled(!estado);
        this.btnCancelar.setEnabled(!estado);
        this.btnPesquisar.setEnabled(estado);
    }

    public void atualizarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) this.tabelaTipoVeiculo.getModel();
        modelo.setNumRows(0);

        for (TipoVeiculo tipoVeiculo : listaTiposVeiculos) {
            modelo.addRow(new Object[]{tipoVeiculo.getId(),
                tipoVeiculo.getNome(), tipoVeiculo.getValorDiaria()});
        }
    }

    private void resetCampos(java.awt.event.ActionEvent evt) {
        this.txtNome.setText("");
        this.txtValorDiaria.setText("");
        this.setEstadoCamposTextos(false);
        this.setEstadoBotoes(true);
        this.btnPesquisarActionPerformed(evt);
        this.tipoVeiculo = null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelDados = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();
        labelValorDiaria = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtValorDiaria = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        painelTabela = new javax.swing.JScrollPane();
        tabelaTipoVeiculo = new javax.swing.JTable();
        painelBotoes = new javax.swing.JPanel();
        btnInserir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnGravar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        painelDados.setForeground(new java.awt.Color(255, 255, 255));

        labelTitulo.setFont(new java.awt.Font("Fira Sans", 0, 24)); // NOI18N
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("Tipo Veiculo");

        labelNome.setFont(new java.awt.Font("Fira Sans", 1, 16)); // NOI18N
        labelNome.setText("Nome:");

        labelValorDiaria.setFont(new java.awt.Font("Fira Sans", 1, 16)); // NOI18N
        labelValorDiaria.setText("Valor da diária:");

        txtNome.setFont(new java.awt.Font("Fira Sans", 1, 16)); // NOI18N

        txtValorDiaria.setFont(new java.awt.Font("Fira Sans", 1, 16)); // NOI18N

        btnPesquisar.setFont(new java.awt.Font("Fira Sans", 1, 16)); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelDadosLayout = new javax.swing.GroupLayout(painelDados);
        painelDados.setLayout(painelDadosLayout);
        painelDadosLayout.setHorizontalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelDadosLayout.createSequentialGroup()
                                .addComponent(labelValorDiaria)
                                .addGap(18, 18, 18)
                                .addComponent(txtValorDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelDadosLayout.createSequentialGroup()
                                .addComponent(labelNome)
                                .addGap(18, 18, 18)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelDadosLayout.setVerticalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo)
                .addGap(18, 18, 18)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelValorDiaria)
                    .addComponent(txtValorDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabelaTipoVeiculo.setFont(new java.awt.Font("Fira Sans", 0, 16)); // NOI18N
        tabelaTipoVeiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Valor da Diária"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaTipoVeiculo.setColumnSelectionAllowed(true);
        tabelaTipoVeiculo.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tabelaTipoVeiculo.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        painelTabela.setViewportView(tabelaTipoVeiculo);
        tabelaTipoVeiculo.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tabelaTipoVeiculo.getColumnModel().getColumnCount() > 0) {
            tabelaTipoVeiculo.getColumnModel().getColumn(0).setResizable(false);
            tabelaTipoVeiculo.getColumnModel().getColumn(1).setResizable(false);
            tabelaTipoVeiculo.getColumnModel().getColumn(2).setResizable(false);
        }

        painelBotoes.setBorder(new javax.swing.border.MatteBorder(null));

        btnInserir.setText("Inserir");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnGravar.setText("Gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelBotoesLayout = new javax.swing.GroupLayout(painelBotoes);
        painelBotoes.setLayout(painelBotoesLayout);
        painelBotoesLayout.setHorizontalGroup(
            painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnInserir)
                .addGap(18, 18, 18)
                .addComponent(btnAlterar)
                .addGap(18, 18, 18)
                .addComponent(btnExcluir)
                .addGap(18, 18, 18)
                .addComponent(btnGravar)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        painelBotoesLayout.setVerticalGroup(
            painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInserir)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir)
                    .addComponent(btnGravar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelDados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelTabela))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(painelTabela, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(painelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        this.setEstadoBotoes(false);
        this.setEstadoCamposTextos(true);
        this.txtNome.setRequestFocusEnabled(true);
    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        if (tabelaTipoVeiculo.getSelectedRow() >= 0) {
            this.setEstadoBotoes(false);
            this.setEstadoCamposTextos(true);

            tipoVeiculo = this.listaTiposVeiculos
                    .get(this.tabelaTipoVeiculo.getSelectedRow());

            this.txtNome.setText(tipoVeiculo.getNome());
            this.txtValorDiaria.setText(String.valueOf(tipoVeiculo.getValorDiaria()));

            this.txtNome.requestFocus();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um tipo de Veículo.",
                    "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        // Inserirndo
        String sNome = this.txtNome.getText();
        if (sNome.length() > 5) {
            BigDecimal valorDiaria = new BigDecimal(this.txtValorDiaria.getText());
            String mensagem = "Tipo Veículo cadastrado";

            // Adicionando um novo Tipo Veículo
            if (this.tipoVeiculo == null) {
                this.tipoVeiculo = new TipoVeiculo(sNome, valorDiaria);
            } // Atualizando um Tipo Veículo;
            else {
                this.tipoVeiculo.setNome(sNome);
                this.tipoVeiculo.setValorDiaria(valorDiaria);
                mensagem = "Tipo Veículo alterado";
            }

            try {
                tipoVeiculoDAO.alterar(tipoVeiculo);
                JOptionPane.showMessageDialog(null, mensagem);

                 this.resetCampos(evt);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(),
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Informe ao menos 5 caracteres no campo Nome",
                    "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnGravarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        listaTiposVeiculos = tipoVeiculoDAO.procurarPorNome(this.txtNome.getText());
        this.atualizarTabela();
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (this.tabelaTipoVeiculo.getSelectedRow() >= 0) {
            TipoVeiculo tipoVeiculoSelecionado = this.listaTiposVeiculos.get(this.tabelaTipoVeiculo.getSelectedRow());

            try {
                tipoVeiculoDAO.remover(tipoVeiculoSelecionado);
                JOptionPane.showMessageDialog(null, "Tipo veículo selecionado foi excluido");
                this.btnPesquisarActionPerformed(evt);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Tipo de Veículo não pode ser removido.\nTipo Veículo  possui veículos relacionados",
                        "Alerta", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um tipo de Veículo", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // Limpa o conteudo dos campos
        this.resetCampos(evt);
    }//GEN-LAST:event_btnCancelarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TipoVeiculoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TipoVeiculoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TipoVeiculoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TipoVeiculoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TipoVeiculoView dialog = new TipoVeiculoView(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelValorDiaria;
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JPanel painelDados;
    private javax.swing.JScrollPane painelTabela;
    private javax.swing.JTable tabelaTipoVeiculo;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtValorDiaria;
    // End of variables declaration//GEN-END:variables
}
