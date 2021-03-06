
package view;

import controller.CargoController;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.ModelCargo;
import model.ModelFuncionario;
import controller.FuncionarioController;


public class TelaFuncionario extends javax.swing.JFrame {
    String salvarAlterar;
    ModelCargo modelCargo = new ModelCargo();
    CargoController cargoController = new CargoController();
    ArrayList<ModelCargo> listaModelCargo = new ArrayList<>();
    ModelFuncionario modelFuncionario = new ModelFuncionario();
    FuncionarioController funcionarioController = new FuncionarioController();
    ArrayList<ModelFuncionario> listaModelFuncionario = new ArrayList<>();

    /**
     * Creates new form TelaFuncionario
     */
    public TelaFuncionario() {
        initComponents();
        salvarAlterar = "salvar";
        this.carregarFuncionario();
        setLocationRelativeTo(null);
        this.listarCargos();
        this.preencherCodigoCargoPeloComboBox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jFormattedTextFieldCPF = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldSalario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        uJComboBoxCargo = new componentes.UJComboBox();
        jTextFieldPesquisa = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFuncionarios = new javax.swing.JTable();
        jButtonSalvar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldIdCargo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Funcionários");
        setResizable(false);

        jLabel1.setText("Código:");

        jTextFieldCodigo.setEditable(false);
        jTextFieldCodigo.setBackground(new java.awt.Color(255, 51, 51));

        jLabel2.setText("Nome:");

        jLabel3.setText("CPF:");

        try {
            jFormattedTextFieldCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setText("Salário:");

        jLabel5.setText("Cargo:");

        uJComboBoxCargo.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                uJComboBoxCargoPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jButtonPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-filled-50.png"))); // NOI18N
        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jTableFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód.", "Nome", "CPF", "ID.Cargo", "Salário"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableFuncionarios);
        if (jTableFuncionarios.getColumnModel().getColumnCount() > 0) {
            jTableFuncionarios.getColumnModel().getColumn(1).setPreferredWidth(400);
        }

        jButtonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-salvar-filled-50.png"))); // NOI18N
        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-editar-filled-50.png"))); // NOI18N
        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-fechar-janela-filled-50.png"))); // NOI18N
        jButtonLimpar.setText("Limpar");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });

        jButtonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-excluir-filled-50.png"))); // NOI18N
        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jLabel6.setText("ID do Cargo:");

        jTextFieldIdCargo.setEditable(false);
        jTextFieldIdCargo.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonSalvar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jTextFieldNome))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldPesquisa)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(37, 37, 37)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(205, 205, 205)
                                .addComponent(jLabel4)
                                .addGap(190, 190, 190)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(453, 453, 453)
                                .addComponent(uJComboBoxCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jFormattedTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jTextFieldSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonPesquisar)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldIdCargo, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uJComboBoxCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldIdCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonPesquisar)
                        .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonEditar)
                    .addComponent(jButtonLimpar)
                    .addComponent(jButtonExcluir))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void uJComboBoxCargoPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_uJComboBoxCargoPopupMenuWillBecomeInvisible
        if(uJComboBoxCargo.isPopupVisible()){
            this.preencherCodigoCargoPeloComboBox();
        }
    }//GEN-LAST:event_uJComboBoxCargoPopupMenuWillBecomeInvisible

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        this.limparCampos();
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
       modelFuncionario = new ModelFuncionario();
       modelFuncionario.setNome(jTextFieldNome.getText());
       modelFuncionario.setCargo(Integer.parseInt(jTextFieldIdCargo.getText()));
       modelFuncionario.setSalario(Double.parseDouble(jTextFieldSalario.getText()));
       modelFuncionario.setCpf(jFormattedTextFieldCPF.getText());

       if(salvarAlterar.equals("salvar")){
           try {
               if(FuncionarioController.inserirFuncionario(modelFuncionario)==true){
                   JOptionPane.showMessageDialog(this,"Funcionario cadastrado com sucesso!","Sucesso",JOptionPane.INFORMATION_MESSAGE);
                   this.limparCampos();
                   this.carregarFuncionario();
                   salvarAlterar="salvar";
               }else{
                   JOptionPane.showMessageDialog(this,"Erro ao cadastar funcionário!","ERRO",JOptionPane.ERROR_MESSAGE);
               }  } catch (SQLException ex) {
               Logger.getLogger(TelaCargos.class.getName()).log(Level.SEVERE, null, ex);
           }
      }else{
           modelFuncionario.setIdFuncionario(Integer.parseInt(jTextFieldCodigo.getText()));
           try {
               if(FuncionarioController.alterarFuncionario(modelFuncionario)==true){
                   JOptionPane.showMessageDialog(this,"Funcionário alterado com sucesso!","Sucesso",JOptionPane.INFORMATION_MESSAGE);
                   this.limparCampos();
                   this.carregarFuncionario();
                   salvarAlterar="salvar";
               }else{
                   JOptionPane.showMessageDialog(this,"Erro ao alterar funcionário!","ERRO",JOptionPane.ERROR_MESSAGE);
               }
           } catch (SQLException ex) {
               Logger.getLogger(TelaCargos.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        DefaultTableModel model = (DefaultTableModel) this.jTableFuncionarios.getModel();
        final TableRowSorter<TableModel> classificador = new TableRowSorter<>(model);
        this.jTableFuncionarios.setRowSorter(classificador);
        String texto = jTextFieldPesquisa.getText();
        classificador.setRowFilter(RowFilter.regexFilter(texto,1));
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
       salvarAlterar="alterar";
       modelFuncionario = new ModelFuncionario();
       int linha = jTableFuncionarios.getSelectedRow();
       int codigo=0;
        if(linha<0){
            JOptionPane.showMessageDialog(this,"Selecione um funcionário na tabela, antes de clicar em alterar!","Atenção",JOptionPane.WARNING_MESSAGE);
        }else{
            codigo =(int) jTableFuncionarios.getValueAt(linha,0);
           try {
               modelFuncionario = FuncionarioController.consultarFuncionario(codigo);
           } catch (SQLException ex) {
               Logger.getLogger(TelaCargos.class.getName()).log(Level.SEVERE, null, ex);
           }
            jTextFieldCodigo.setText(String.valueOf(modelFuncionario.getIdFuncionario()));
            jTextFieldNome.setText(modelFuncionario.getNome());
            jFormattedTextFieldCPF.setText(modelFuncionario.getCpf());
            jTextFieldSalario.setText(modelFuncionario.getSalario()+"");
            jTextFieldIdCargo.setText(modelFuncionario.getCargo()+"");
            
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
     int linha = jTableFuncionarios.getSelectedRow();
     int codigo = 0;
        if(linha<0){
            JOptionPane.showMessageDialog(this,"Selecione um funcionário na tabela, antes de clicar em excluir!","Atenção",JOptionPane.WARNING_MESSAGE);
        }else{
            String nome = (String)jTableFuncionarios.getValueAt(linha,1);
            int opcao= JOptionPane.showConfirmDialog(this,"Tem certeza que deseja excluir o funcionário: "+nome,"Atenção",JOptionPane.YES_NO_OPTION);
            if(opcao==JOptionPane.OK_OPTION){
                codigo = (Integer) jTableFuncionarios.getValueAt(linha,0);
                try {
                    FuncionarioController.excluirFuncionario(codigo);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaCargos.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
       }
        carregarFuncionario();
    }//GEN-LAST:event_jButtonExcluirActionPerformed
    
    private void preencherCodigoCargoPeloComboBox() {
        try {
            modelCargo = CargoController.consultarPeloNome(uJComboBoxCargo.getSelectedItem().toString());
        } catch (SQLException ex) {
            Logger.getLogger(TelaCartao.class.getName()).log(Level.SEVERE, null, ex);          
        }
        jTextFieldIdCargo.setText(String.valueOf(modelCargo.getIdCargo()));
    }
    
      private void listarCargos() {
        try {
            listaModelCargo = CargoController.listarCargo();
        } catch (SQLException ex) {
            Logger.getLogger(TelaCartao.class.getName()).log(Level.SEVERE, null, ex);
        }
        uJComboBoxCargo.removeAllItems();
        for (int i = 0; i < listaModelCargo.size(); i++) {
            uJComboBoxCargo.addItem(listaModelCargo.get(i).getNome());
        }
    }
    
    private void limparCampos(){
         jTextFieldCodigo.setText("");
         jTextFieldNome.setText("");
         jFormattedTextFieldCPF.setText("");
         jTextFieldSalario.setText("");
     }
    
    private void carregarFuncionario(){
        try {
            listaModelFuncionario =FuncionarioController.listarFuncionario();
        } catch (SQLException ex) {
            Logger.getLogger(TelaCargos.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel model = (DefaultTableModel) jTableFuncionarios.getModel();
        //número de linhas que a tabela começa
        model.setNumRows(0);
        
        //a variável cont recebe o tamanho da lista
        int cont = listaModelFuncionario.size();
        //inserir clientes na tabela
        for(int c =0; c<cont;c++){
            model.addRow(new Object[]{
                listaModelFuncionario.get(c).getIdFuncionario(),
                listaModelFuncionario.get(c).getNome(),
                listaModelFuncionario.get(c).getCpf(),
                listaModelFuncionario.get(c).getCargo(),
                listaModelFuncionario.get(c).getSalario(),
        
            });
        }
    }
    
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JFormattedTextField jFormattedTextFieldCPF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFuncionarios;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldIdCargo;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPesquisa;
    private javax.swing.JTextField jTextFieldSalario;
    private componentes.UJComboBox uJComboBoxCargo;
    // End of variables declaration//GEN-END:variables
}
