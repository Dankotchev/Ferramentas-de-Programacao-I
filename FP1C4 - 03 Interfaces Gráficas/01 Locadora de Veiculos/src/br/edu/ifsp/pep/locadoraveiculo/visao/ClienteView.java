package br.edu.ifsp.pep.locadoraveiculo.visao;

import br.edu.ifsp.pep.locadoraveiculo.dao.ClienteDAO;
import br.edu.ifsp.pep.locadoraveiculo.modelo.Cliente;
import br.edu.ifsp.pep.locadoraveiculo.modelo.Veiculo;
import br.edu.ifsp.pep.locadoraveiculo.utilitarios.Mensagem;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ClienteView extends javax.swing.JDialog {

    private List<Cliente> listaClientes;
    private Mensagem mensagem = new Mensagem();
    private Cliente cliente;
    private final ClienteDAO clienteDAO = new ClienteDAO();

    /**
     * Creates new form ClienteView
     */
    public ClienteView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setEstadoBotoes(true);
        this.setEstadoCamposTexto(false);

    }

    private void atualizarTabela() {
        if (this.listaClientes.isEmpty()) {
            this.mensagem.mAviso("Não há Clientes cadastrados");
        } else {
            DefaultTableModel modelo = (DefaultTableModel) this.tabelaClientes.getModel();
            modelo.setNumRows(0);

            for (Cliente cliente : listaClientes) {
                modelo.addRow(new Object[]{cliente.getId(), cliente.getNome(),
                    "CPF Exemplo", "Endereço Exemplo"
                });
            }
        }
    }

    private void setEstadoBotoes(boolean estado) {
        this.btnInserir.setVisible(estado);
        this.btnGravar.setVisible(!estado);
        this.btnCancelar.setVisible(!estado);
        this.btnAlterar.setVisible(estado);
        this.btnExcluir.setVisible(estado);
        this.btnPesquisa.setVisible(estado);
    }

    private void setEstadoCamposTexto(boolean estado) {
        this.txtPesquisar.setEnabled(!estado);
        this.txtNome.setEnabled(estado);
        this.txtCPF.setEnabled(estado);
        this.txtEndereco.setEnabled(estado);
    }
    
    private void limparCampos(){
        this.txtPesquisar.setText("");
        this.txtNome.setText("");
        this.txtCPF.setText("");
        this.txtEndereco.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelTitulo = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        tabPainel = new javax.swing.JTabbedPane();
        tabPesquisar = new javax.swing.JPanel();
        labelNomePesquisar = new javax.swing.JLabel();
        btnPesquisa = new javax.swing.JButton();
        txtPesquisar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaClientes = new javax.swing.JTable();
        tabCadastro = new javax.swing.JPanel();
        labelNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        labelCPF = new javax.swing.JLabel();
        txtCPF = new javax.swing.JFormattedTextField();
        labelEndereco = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        painelBotoesPesquisa = new javax.swing.JPanel();
        btnAlterar = new javax.swing.JButton();
        btnInserir = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnGravar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Clientes");
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        painelTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelTitulo.setFont(new java.awt.Font("Fira Sans", 1, 24)); // NOI18N
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("Cliente");

        javax.swing.GroupLayout painelTituloLayout = new javax.swing.GroupLayout(painelTitulo);
        painelTitulo.setLayout(painelTituloLayout);
        painelTituloLayout.setHorizontalGroup(
            painelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelTituloLayout.setVerticalGroup(
            painelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        tabPainel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tabPainel.setFont(new java.awt.Font("Fira Sans", 1, 18)); // NOI18N

        labelNomePesquisar.setFont(new java.awt.Font("Fira Sans", 1, 16)); // NOI18N
        labelNomePesquisar.setText("Nome");

        btnPesquisa.setFont(new java.awt.Font("Fira Sans", 1, 16)); // NOI18N
        btnPesquisa.setText("Pesquisar");
        btnPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaActionPerformed(evt);
            }
        });

        tabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "CPF", "Endereço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaClientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tabelaClientes);
        if (tabelaClientes.getColumnModel().getColumnCount() > 0) {
            tabelaClientes.getColumnModel().getColumn(0).setResizable(false);
            tabelaClientes.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout tabPesquisarLayout = new javax.swing.GroupLayout(tabPesquisar);
        tabPesquisar.setLayout(tabPesquisarLayout);
        tabPesquisarLayout.setHorizontalGroup(
            tabPesquisarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabPesquisarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabPesquisarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(tabPesquisarLayout.createSequentialGroup()
                        .addComponent(labelNomePesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        tabPesquisarLayout.setVerticalGroup(
            tabPesquisarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabPesquisarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabPesquisarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNomePesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabPainel.addTab("Pesquisa", tabPesquisar);

        labelNome.setFont(new java.awt.Font("Fira Sans", 1, 16)); // NOI18N
        labelNome.setText("Nome");

        txtNome.setFont(new java.awt.Font("Fira Sans", 0, 16)); // NOI18N

        labelCPF.setFont(new java.awt.Font("Fira Sans", 1, 16)); // NOI18N
        labelCPF.setText("CPF");

        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCPF.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtCPF.setFont(new java.awt.Font("Fira Sans", 1, 16)); // NOI18N

        labelEndereco.setFont(new java.awt.Font("Fira Sans", 1, 16)); // NOI18N
        labelEndereco.setText("Endereço");

        txtEndereco.setFont(new java.awt.Font("Fira Sans", 0, 16)); // NOI18N

        javax.swing.GroupLayout tabCadastroLayout = new javax.swing.GroupLayout(tabCadastro);
        tabCadastro.setLayout(tabCadastroLayout);
        tabCadastroLayout.setHorizontalGroup(
            tabCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tabCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome)
                    .addGroup(tabCadastroLayout.createSequentialGroup()
                        .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 454, Short.MAX_VALUE))
                    .addComponent(txtEndereco))
                .addContainerGap())
        );
        tabCadastroLayout.setVerticalGroup(
            tabCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(tabCadastroLayout.createSequentialGroup()
                        .addComponent(labelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabCadastroLayout.createSequentialGroup()
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(244, Short.MAX_VALUE))
        );

        tabPainel.addTab("Cadastro", tabCadastro);

        painelBotoesPesquisa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnAlterar.setFont(new java.awt.Font("Fira Sans", 1, 16)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAlterar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnInserir.setFont(new java.awt.Font("Fira Sans", 1, 16)); // NOI18N
        btnInserir.setText("Inserir");
        btnInserir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnInserir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Fira Sans", 1, 16)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnGravar.setFont(new java.awt.Font("Fira Sans", 1, 16)); // NOI18N
        btnGravar.setText("Gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Fira Sans", 1, 16)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelBotoesPesquisaLayout = new javax.swing.GroupLayout(painelBotoesPesquisa);
        painelBotoesPesquisa.setLayout(painelBotoesPesquisaLayout);
        painelBotoesPesquisaLayout.setHorizontalGroup(
            painelBotoesPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBotoesPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        painelBotoesPesquisaLayout.setVerticalGroup(
            painelBotoesPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBotoesPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelBotoesPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelBotoesPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelBotoesPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tabPainel)
                    .addComponent(painelBotoesPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabPainel, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(painelBotoesPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaActionPerformed
        this.listaClientes = clienteDAO.buscarPorNome(txtPesquisar.getText());
        this.atualizarTabela();
    }//GEN-LAST:event_btnPesquisaActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
//        if (this.tabelaClientes.getSelectedRow() >= 0) {
//            this.veiculo = this.listaVeiculos.get(
//                    this.tabelaClientes.getSelectedRow());
//
//            this.txtNome.setText(this.veiculo.getModelo());
//            this.txtEndereco.setText(String.valueOf(this.veiculo.getAno()));
//            this.txtCPF.setText(this.veiculo.getPlaca());
//            this.txtCidade.setText(this.veiculo.getCidade());
//            this.comboTipoVeiculo.setSelectedItem(this.veiculo.getTipo().getNome());
//
//            this.setEstadoBotoes(false);
//            this.tabPainel.setSelectedIndex(1);
//        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        this.limparCampos();
        this.tabPainel.setSelectedIndex(1);
        this.txtNome.requestFocus();
        this.setEstadoBotoes(false);
        this.setEstadoCamposTexto(true);
    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (this.tabelaClientes.getSelectedRow() >= 0) {
            this.cliente = this.listaClientes.get(
                    this.tabelaClientes.getSelectedRow());

            this.txtNome.setText(this.cliente.getNome());
            this.txtEndereco.setText("Endereço Exemplo");
            this.txtCPF.setText("09812345690");


            this.setEstadoBotoes(false);
            this.setEstadoCamposTexto(false);
            this.btnGravar.setText("Excluir");
            this.tabPainel.setSelectedIndex(1);
        }else{
            this.mensagem.mAtencao("Nenhum Cliente selecionado");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
//        String mensagem = "Veículo cadastrado";
//        boolean tudoOK = true;
//        int anoInformado = 0;
//
//        if (this.txtNome.getText().isEmpty()) {
//            this.mensagem.mAtencao("Modelo não informado");
//            this.txtNome.requestFocus();
//            tudoOK = false;
//        }
//
//        if (this.txtCPF.getText().isEmpty()) {
//            this.mensagem.mAtencao("Placa não informado");
//            this.txtCPF.requestFocus();
//            tudoOK = false;
//        }
//
//        try {
//            anoInformado = Integer.parseInt(this.txtEndereco.getText());
//
//        } catch (NumberFormatException nfe) {
//            this.mensagem.mErro("Formato inválido. Informe um valor numérico");
//            this.txtEndereco.requestFocus();
//            tudoOK = false;
//        }
//
//        if ((anoInformado < 1900) || (anoInformado > (new Date().getYear() + 1900))) {
//            this.mensagem.mAviso("Ano informado inválido");
//            this.txtEndereco.requestFocus();
//            tudoOK = false;
//        }
//
//        if (this.txtCidade.getText()
//                .isEmpty()) {
//            this.mensagem.mAtencao("Infome uma Cidade");
//            this.txtCidade.requestFocus();
//            tudoOK = false;
//        }
//
//        if (this.comboTipoVeiculo.getSelectedIndex() < 0) {
//            this.mensagem.mAtencao("Selecione um Tipo de Veículo");
//            tudoOK = false;
//        }
//
//        if (tudoOK) {
//            // Propagar no Banco de Dados se não houver informações faltantes ou incorretas
//
//            // Verifica se está realizando uma exclusão, comparando o texto do botão
//            if (this.btnGravar.getText().equals("Excluir")) {
//                mensagem = "Veículo excluído";
//                try {
//                    veiculoDAO.remover(veiculo);
//                    this.mensagem.mCorreto(mensagem);
//                    this.limparCampos();
//                } catch (Exception e) {
//                    this.mensagem.mErro(e.getMessage());
//                } finally {
//                    this.veiculo = null;
//                }
//
//                // Se o texto não foi alterado, é uma inserção ou alteração
//            } else {
//                // Realizando uma inserção
//                if (this.veiculo == null) {
//                    this.veiculo = new Veiculo(
//                            this.txtCPF.getText(),
//                            this.txtCidade.getText(),
//                            this.txtNome.getText(),
//                            anoInformado,
//                            this.listaTiposVeiculos.get(
//                                    this.comboTipoVeiculo.getSelectedIndex()));
//                } else {
//                    // Realizando uma alteração
//                    this.veiculo.setPlaca(this.txtCPF.getText());
//                    this.veiculo.setCidade(this.txtCidade.getText());
//                    this.veiculo.setModelo(this.txtNome.getText());
//                    this.veiculo.setAno(anoInformado);
//                    this.veiculo.setTipo(this.listaTiposVeiculos.get(
//                            this.comboTipoVeiculo.getSelectedIndex()));
//                    mensagem = "Veículo alterado";
//                }
//
//                // Propagando no banco a alteração ou inserção
//                try {
//                    veiculoDAO.alterar(this.veiculo);
//                    this.mensagem.mCorreto(mensagem);
//                    this.limparCampos();
//                    this.setEstadoBotoes(true);
//
//                } catch (Exception e) {
//                    this.mensagem.mErro(e.getMessage());
//                } finally {
//                    this.veiculo = null;
//                }
//            }
//        }
    }//GEN-LAST:event_btnGravarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setEstadoBotoes(true);
        this.setEstadoCamposTexto(false);
        this.tabPainel.setSelectedIndex(0);
        this.limparCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ClienteView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ClienteView dialog = new ClienteView(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnPesquisa;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelCPF;
    private javax.swing.JLabel labelEndereco;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelNomePesquisar;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel painelBotoesPesquisa;
    private javax.swing.JPanel painelTitulo;
    private javax.swing.JPanel tabCadastro;
    private javax.swing.JTabbedPane tabPainel;
    private javax.swing.JPanel tabPesquisar;
    private javax.swing.JTable tabelaClientes;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables
}
