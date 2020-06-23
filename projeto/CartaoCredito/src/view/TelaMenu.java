package view;

import javax.swing.JFrame;


public class TelaMenu extends javax.swing.JFrame {
    public int idCargo;
    
    /**
     * Creates new form TelaMenu
     */
    public TelaMenu() {
        initComponents();
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
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
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCliente = new javax.swing.JMenu();
        jMenuItemClientes = new javax.swing.JMenuItem();
        jMenuCartao = new javax.swing.JMenu();
        jMenuItemCartao = new javax.swing.JMenuItem();
        jMenuCargo = new javax.swing.JMenu();
        jMenuItemCargo = new javax.swing.JMenuItem();
        jMenuFuncionario = new javax.swing.JMenu();
        jMenuItemFuncionario = new javax.swing.JMenuItem();
        jMenuUsuario = new javax.swing.JMenu();
        jMenuItemUsuario = new javax.swing.JMenuItem();
        jMenuSolicitacao = new javax.swing.JMenu();
        jMenuItemSolicitacao = new javax.swing.JMenuItem();
        jMenuSPC = new javax.swing.JMenu();
        jMenuItemSPC = new javax.swing.JMenuItem();
        jMenuDependentes = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuSair = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/thumb-cartao-credito.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 0, -1, -1));

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));

        jMenuCliente.setBackground(new java.awt.Color(255, 255, 255));
        jMenuCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/BotãoCliente02.png"))); // NOI18N

        jMenuItemClientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-grupos-de-usuários-filled-50.png"))); // NOI18N
        jMenuItemClientes.setText("Clientes");
        jMenuItemClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemClientesActionPerformed(evt);
            }
        });
        jMenuCliente.add(jMenuItemClientes);

        jMenuBar1.add(jMenuCliente);

        jMenuCartao.setBackground(new java.awt.Color(255, 255, 255));
        jMenuCartao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botaoCartao.png"))); // NOI18N

        jMenuItemCartao.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemCartao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-caro-2-filled-50.png"))); // NOI18N
        jMenuItemCartao.setText("Cartões");
        jMenuItemCartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCartaoActionPerformed(evt);
            }
        });
        jMenuCartao.add(jMenuItemCartao);

        jMenuBar1.add(jMenuCartao);

        jMenuCargo.setBackground(new java.awt.Color(255, 255, 255));
        jMenuCargo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botaoCargos.png"))); // NOI18N

        jMenuItemCargo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItemCargo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-empregado-filled-50(1).png"))); // NOI18N
        jMenuItemCargo.setText("Cargos");
        jMenuItemCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCargoActionPerformed(evt);
            }
        });
        jMenuCargo.add(jMenuItemCargo);

        jMenuBar1.add(jMenuCargo);

        jMenuFuncionario.setBackground(new java.awt.Color(255, 255, 255));
        jMenuFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/BotãoFuncionários.png"))); // NOI18N

        jMenuItemFuncionario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-empregado-filled-50(1).png"))); // NOI18N
        jMenuItemFuncionario.setText("Funcionários");
        jMenuItemFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFuncionarioActionPerformed(evt);
            }
        });
        jMenuFuncionario.add(jMenuItemFuncionario);

        jMenuBar1.add(jMenuFuncionario);

        jMenuUsuario.setBackground(new java.awt.Color(255, 255, 255));
        jMenuUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botUsuario.png"))); // NOI18N

        jMenuItemUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-usuário-homem-com-círculo-filled-50.png"))); // NOI18N
        jMenuItemUsuario.setText("Usuários");
        jMenuItemUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUsuarioActionPerformed(evt);
            }
        });
        jMenuUsuario.add(jMenuItemUsuario);

        jMenuBar1.add(jMenuUsuario);

        jMenuSolicitacao.setBackground(new java.awt.Color(255, 255, 255));
        jMenuSolicitacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botaoSolitacao.png"))); // NOI18N

        jMenuItemSolicitacao.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemSolicitacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-informações-filled-50.png"))); // NOI18N
        jMenuItemSolicitacao.setText("Solicitações de cartão");
        jMenuItemSolicitacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSolicitacaoActionPerformed(evt);
            }
        });
        jMenuSolicitacao.add(jMenuItemSolicitacao);

        jMenuBar1.add(jMenuSolicitacao);

        jMenuSPC.setBackground(new java.awt.Color(255, 255, 255));
        jMenuSPC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botaoListaSPC.png"))); // NOI18N

        jMenuItemSPC.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemSPC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-lista-50.png"))); // NOI18N
        jMenuItemSPC.setText("Lista Do SPC");
        jMenuItemSPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSPCActionPerformed(evt);
            }
        });
        jMenuSPC.add(jMenuItemSPC);

        jMenuBar1.add(jMenuSPC);

        jMenuDependentes.setBackground(new java.awt.Color(255, 255, 255));
        jMenuDependentes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/btnDependentes.png"))); // NOI18N

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-grupos-de-usuários-filled-50.png"))); // NOI18N
        jMenuItem1.setText("Dependentes");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuDependentes.add(jMenuItem1);

        jMenuBar1.add(jMenuDependentes);

        jMenuSair.setBackground(new java.awt.Color(255, 255, 255));
        jMenuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/BotãoSair.png"))); // NOI18N

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-sair-filled-50.png"))); // NOI18N
        jMenuItem7.setText("Sair");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenuSair.add(jMenuItem7);

        jMenuBar1.add(jMenuSair);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItemClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemClientesActionPerformed
        TelaCliente telaCliente = new TelaCliente();
       if(idCargo==5){
           telaCliente.desabilitarExcluir();
           telaCliente.setVisible(true);
       }else{
           telaCliente.setVisible(true);
       }
    }//GEN-LAST:event_jMenuItemClientesActionPerformed

    private void jMenuItemCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCartaoActionPerformed

       TelaCartao telaCartao = new TelaCartao();
       if(idCargo==5){
           telaCartao.desabilitarExcluir();
           telaCartao.setVisible(true);
       }else{
           telaCartao.setVisible(true);
       }
    }//GEN-LAST:event_jMenuItemCartaoActionPerformed

    private void jMenuItemCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCargoActionPerformed
        new TelaCargos().setVisible(true);
    }//GEN-LAST:event_jMenuItemCargoActionPerformed

    private void jMenuItemFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFuncionarioActionPerformed
        new TelaFuncionario().setVisible(true);
    }//GEN-LAST:event_jMenuItemFuncionarioActionPerformed

    private void jMenuItemUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUsuarioActionPerformed
        new TelaUsuario().setVisible(true);
    }//GEN-LAST:event_jMenuItemUsuarioActionPerformed

    private void jMenuItemSolicitacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSolicitacaoActionPerformed
        new TelaSolicitacao().setVisible(true);
    }//GEN-LAST:event_jMenuItemSolicitacaoActionPerformed

    private void jMenuItemSPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSPCActionPerformed
        new TelaSPC().setVisible(true);
    }//GEN-LAST:event_jMenuItemSPCActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new TelaDependente().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCargo;
    private javax.swing.JMenu jMenuCartao;
    private javax.swing.JMenu jMenuCliente;
    private javax.swing.JMenu jMenuDependentes;
    private javax.swing.JMenu jMenuFuncionario;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItemCargo;
    private javax.swing.JMenuItem jMenuItemCartao;
    private javax.swing.JMenuItem jMenuItemClientes;
    private javax.swing.JMenuItem jMenuItemFuncionario;
    private javax.swing.JMenuItem jMenuItemSPC;
    private javax.swing.JMenuItem jMenuItemSolicitacao;
    private javax.swing.JMenuItem jMenuItemUsuario;
    private javax.swing.JMenu jMenuSPC;
    private javax.swing.JMenu jMenuSair;
    private javax.swing.JMenu jMenuSolicitacao;
    private javax.swing.JMenu jMenuUsuario;
    // End of variables declaration//GEN-END:variables
}
