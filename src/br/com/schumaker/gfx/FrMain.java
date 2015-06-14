package br.com.schumaker.gfx;

import br.com.schumaker.bs.impl.FrMainBsImpl;
import br.com.schumaker.model.HsSession;
import javax.swing.JFrame;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 06/06/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class FrMain extends javax.swing.JFrame {

    public FrMain() {
        super("Bom Rango");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.createTree();
        this.initComponents();
        this.setLocationRelativeTo(null);
    }

    private void createTree() {
        root = new DefaultMutableTreeNode(HsSession.getInstance().getMercado().getNome());

        cadastro = new DefaultMutableTreeNode("Cadastro");//menu
        root.add(cadastro);

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
        jMenu1 = new javax.swing.JMenu();
        jmLogoff = new javax.swing.JMenuItem();
        jmFechar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();

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
            .addComponent(jSplitPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        jMenu1.setText("Arquivo");

        jmLogoff.setText("Logoff");
        jmLogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmLogoffActionPerformed(evt);
            }
        });
        jMenu1.add(jmLogoff);

        jmFechar.setText("Fechar");
        jmFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmFecharActionPerformed(evt);
            }
        });
        jMenu1.add(jmFechar);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");

        jMenuItem4.setText("Alterar Senha");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Exibir");

        jMenuItem1.setText("Perfil Usuário");
        jMenu3.add(jMenuItem1);

        jMenuItem5.setText("Perfil Mercado");
        jMenu3.add(jMenuItem5);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Ajuda");

        jMenuItem6.setText("Tópicos de Ajuda");
        jMenu4.add(jMenuItem6);

        jMenuItem8.setText("Enviar Mensagem");
        jMenu4.add(jMenuItem8);

        jMenuItem7.setText("Sobre");
        jMenu4.add(jMenuItem7);

        jMenuBar1.add(jMenu4);

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
                if (nodeInfo.equals("Produtos")) {
                    IfCadProduto ifCadProd = new IfCadProduto();
                    ifCadProd.setSize(jDesktop.getWidth(), jDesktop.getHeight() - 40);
                    jDesktop.add(ifCadProd);
                    ifCadProd.toFront();
                    return;
                }
                if (nodeInfo.equals("Setores")) {

                    return;
                }
                if (nodeInfo.equals("Unidades")) {

                    return;
                }
                if (nodeInfo.equals("Usuários")) {

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

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed

        FrMainBsImpl.getInstance().alterarSenha();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private DefaultMutableTreeNode root;
    private DefaultMutableTreeNode cadastro;
    private DefaultMutableTreeNode manutencao;

    private DefaultMutableTreeNode produtos;
    private DefaultMutableTreeNode fabricantes;
    private DefaultMutableTreeNode usuarios;
    private DefaultMutableTreeNode setores;
    private DefaultMutableTreeNode unidades;

    private DefaultMutableTreeNode precos;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktop;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JMenuItem jmFechar;
    private javax.swing.JMenuItem jmLogoff;
    private javax.swing.JTree jtMenuTree;
    // End of variables declaration//GEN-END:variables
}
