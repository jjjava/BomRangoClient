package br.com.schumaker.gfx.adm;

import br.com.schumaker.model.HsSessionAdm;

/**
 *
 * @author Hudson Schumaker HStudio - @BomRango 14/06/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class FrPerfilAdm extends javax.swing.JFrame {

    public FrPerfilAdm() {
        this.initComponents();
        jlNome.setText(jlNome.getText() + " " + HsSessionAdm.getInstance().getAdm().getNome());
        jLEmail.setText(jlNome.getText() + " " + HsSessionAdm.getInstance().getAdm().getEmail());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlNome = new javax.swing.JLabel();
        jLEmail = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Perfil");
        setResizable(false);

        jlNome.setText("Usuário logado:");

        jLEmail.setText("Email cadastrado:");

        jButton1.setText("OK");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLEmail)
                    .addComponent(jlNome))
                .addContainerGap(334, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlNome)
                .addGap(18, 18, 18)
                .addComponent(jLEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLEmail;
    private javax.swing.JLabel jlNome;
    // End of variables declaration//GEN-END:variables
}
