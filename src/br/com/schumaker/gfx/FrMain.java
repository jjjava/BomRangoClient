package br.com.schumaker.gfx;

import br.com.schumaker.bs.impl.FrMainBsImpl;
import br.com.schumaker.model.HsSessionAdm;
import javax.swing.JFrame;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 06/06/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class FrMain extends JFrame {

    public FrMain() {
        super("Rede Encarte");
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.createTree();
        this.initComponents();
        this.setSize(1024, 768);
        this.setLocationRelativeTo(null);
    }

    private void createTree() {
        root = new DefaultMutableTreeNode(HsSessionAdm.getInstance().getAdm().getNome());

        cadastro = new DefaultMutableTreeNode("Cadastro");//menu
        root.add(cadastro);

        mercados = new DefaultMutableTreeNode("Mercados");
        cadastro.add(mercados);
        produtos = new DefaultMutableTreeNode("Produtos");
        cadastro.add(produtos);
        fabricantes = new DefaultMutableTreeNode("Fabricantes");
        cadastro.add(fabricantes);
        setores = new DefaultMutableTreeNode("Setores");
        cadastro.add(setores);
        unidades = new DefaultMutableTreeNode("Unidades");
        cadastro.add(unidades);
        usuarios = new DefaultMutableTreeNode("Usuários");
        cadastro.add(usuarios);

        manutencao = new DefaultMutableTreeNode("Manutenção");//menu
        root.add(manutencao);
        precos = new DefaultMutableTreeNode("Preços");
        manutencao.add(precos);

        consultas = new DefaultMutableTreeNode("Consultas");//menu
        root.add(consultas);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtMenuTree = new javax.swing.JTree(root);
        jPanel3 = new javax.swing.JPanel();
        jDesktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmArquivo = new javax.swing.JMenu();
        jmLogoff = new javax.swing.JMenuItem();
        jmFechar = new javax.swing.JMenuItem();
        jmEditar = new javax.swing.JMenu();
        jmAlterarSenha = new javax.swing.JMenuItem();
        jmExibir = new javax.swing.JMenu();
        jmPerfilUsuario = new javax.swing.JMenuItem();
        jmMostrarPerfilMercado = new javax.swing.JMenuItem();
        jmAjuda = new javax.swing.JMenu();
        jmTopicosDeAjuda = new javax.swing.JMenuItem();
        jmEnviarMensagem = new javax.swing.JMenuItem();
        jmSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane1.setDividerLocation(240);

        jtMenuTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtMenuTreeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtMenuTree);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
        );

        jSplitPane1.setLeftComponent(jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktop)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktop)
        );

        jSplitPane1.setRightComponent(jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jSplitPane1)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        jmArquivo.setText("Arquivo");

        jmLogoff.setText("Logoff");
        jmLogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmLogoffActionPerformed(evt);
            }
        });
        jmArquivo.add(jmLogoff);

        jmFechar.setText("Fechar");
        jmFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmFecharActionPerformed(evt);
            }
        });
        jmArquivo.add(jmFechar);

        jMenuBar1.add(jmArquivo);

        jmEditar.setText("Editar");

        jmAlterarSenha.setText("Alterar Senha");
        jmAlterarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAlterarSenhaActionPerformed(evt);
            }
        });
        jmEditar.add(jmAlterarSenha);

        jMenuBar1.add(jmEditar);

        jmExibir.setText("Exibir");

        jmPerfilUsuario.setText("Perfil Usuário");
        jmPerfilUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmPerfilUsuarioActionPerformed(evt);
            }
        });
        jmExibir.add(jmPerfilUsuario);

        jmMostrarPerfilMercado.setText("Perfil Mercado");
        jmMostrarPerfilMercado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmMostrarPerfilMercadoActionPerformed(evt);
            }
        });
        jmExibir.add(jmMostrarPerfilMercado);

        jMenuBar1.add(jmExibir);

        jmAjuda.setText("Ajuda");

        jmTopicosDeAjuda.setText("Tópicos de Ajuda");
        jmTopicosDeAjuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmTopicosDeAjudaActionPerformed(evt);
            }
        });
        jmAjuda.add(jmTopicosDeAjuda);

        jmEnviarMensagem.setText("Enviar Mensagem");
        jmEnviarMensagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmEnviarMensagemActionPerformed(evt);
            }
        });
        jmAjuda.add(jmEnviarMensagem);

        jmSobre.setText("Sobre");
        jmSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSobreActionPerformed(evt);
            }
        });
        jmAjuda.add(jmSobre);

        jMenuBar1.add(jmAjuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtMenuTreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtMenuTreeMouseClicked

        if (evt.getClickCount() == 2) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) jtMenuTree.getLastSelectedPathComponent();
            Object nodeInfo = node.getUserObject();
            if (node.isLeaf()) {
                if (nodeInfo.equals("Mercados")) {
                    System.out.println("mercados");
                    return;
                }
                if (nodeInfo.equals("Produtos")) {
                    IfCadProduto ifCadProd = new IfCadProduto();
                    ifCadProd.setSize(jDesktop.getWidth(), jDesktop.getHeight() - 40);
                    jDesktop.add(ifCadProd);
                    ifCadProd.toFront();
                    return;
                }
                if (nodeInfo.equals("Fabricantes")) {
                    IfCadFabricante ifCadFabricante = new IfCadFabricante();
                    ifCadFabricante.setSize(jDesktop.getWidth(), jDesktop.getHeight() - 40);
                    jDesktop.add(ifCadFabricante);
                    ifCadFabricante.toFront();
                    return;
                }
                if (nodeInfo.equals("Setores")) {
                    IfCadSetor ifCadSetor = new IfCadSetor();
                    ifCadSetor.setSize(jDesktop.getWidth(), jDesktop.getHeight() - 40);
                    jDesktop.add(ifCadSetor);
                    ifCadSetor.toFront();
                    return;
                }
                if (nodeInfo.equals("Unidades")) {

                    return;
                }
                if (nodeInfo.equals("Usuários")) {
                    return;
                }
                if (nodeInfo.equals("Consultas")) {

                }
            }
        }
    }//GEN-LAST:event_jtMenuTreeMouseClicked

    private void jmLogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmLogoffActionPerformed
        FrMainBsImpl.getInstance().doLogoff(this);
    }//GEN-LAST:event_jmLogoffActionPerformed

    private void jmFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmFecharActionPerformed
        FrMainBsImpl.getInstance().fechar();
    }//GEN-LAST:event_jmFecharActionPerformed

    private void jmAlterarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAlterarSenhaActionPerformed
        FrMainBsImpl.getInstance().alterarSenha();
    }//GEN-LAST:event_jmAlterarSenhaActionPerformed

    private void jmPerfilUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmPerfilUsuarioActionPerformed
        FrMainBsImpl.getInstance().showPerfilUsuario();
    }//GEN-LAST:event_jmPerfilUsuarioActionPerformed

    private void jmMostrarPerfilMercadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmMostrarPerfilMercadoActionPerformed
        FrMainBsImpl.getInstance().showPerfilMercado();
    }//GEN-LAST:event_jmMostrarPerfilMercadoActionPerformed

    private void jmTopicosDeAjudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmTopicosDeAjudaActionPerformed
        FrMainBsImpl.getInstance().showTopicosAjuda();
    }//GEN-LAST:event_jmTopicosDeAjudaActionPerformed

    private void jmEnviarMensagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEnviarMensagemActionPerformed
        FrMainBsImpl.getInstance().showEnviarMensagem();
    }//GEN-LAST:event_jmEnviarMensagemActionPerformed

    private void jmSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSobreActionPerformed
        FrMainBsImpl.getInstance().showSobre();
    }//GEN-LAST:event_jmSobreActionPerformed

    private DefaultMutableTreeNode root;
    private DefaultMutableTreeNode cadastro;
    private DefaultMutableTreeNode manutencao;
    private DefaultMutableTreeNode consultas;

    private DefaultMutableTreeNode mercados;
    private DefaultMutableTreeNode produtos;
    private DefaultMutableTreeNode fabricantes;
    private DefaultMutableTreeNode usuarios;
    private DefaultMutableTreeNode setores;
    private DefaultMutableTreeNode unidades;

    private DefaultMutableTreeNode precos;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktop;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JMenu jmAjuda;
    private javax.swing.JMenuItem jmAlterarSenha;
    private javax.swing.JMenu jmArquivo;
    private javax.swing.JMenu jmEditar;
    private javax.swing.JMenuItem jmEnviarMensagem;
    private javax.swing.JMenu jmExibir;
    private javax.swing.JMenuItem jmFechar;
    private javax.swing.JMenuItem jmLogoff;
    private javax.swing.JMenuItem jmMostrarPerfilMercado;
    private javax.swing.JMenuItem jmPerfilUsuario;
    private javax.swing.JMenuItem jmSobre;
    private javax.swing.JMenuItem jmTopicosDeAjuda;
    private javax.swing.JTree jtMenuTree;
    // End of variables declaration//GEN-END:variables
}
