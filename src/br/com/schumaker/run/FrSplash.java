package br.com.schumaker.run;

import br.com.schumaker.gfx.FrLogin;
import br.com.schumaker.util.HsCommons;
import br.com.schumaker.util.HsDriverChecker;
import br.com.schumaker.util.HsMessage;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 14/06/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class FrSplash extends JFrame implements Runnable {

    public FrSplash() {
        super("Carregando...");
        setUndecorated(true);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/br/com/schumaker/res/icons/cart_32.png")));
//        AWTUtilities.setWindowOpacity(this, 0.77777777F);
        this.initComponents();
        this.jProgressBar.setString("Inicializando...");
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void start() {
        Thread s = new Thread(this);
        s.start();
    }

    @Override
    public void run() {
        HsDriverChecker hsDriverChecker = new HsDriverChecker();
        jProgressBar.setValue(20);
        try {
            Thread.sleep(HsCommons.LOADING);//1500
        } catch (InterruptedException e) {
        }
        this.jProgressBar.setString("Verificando MySQL Drivers...");
        if (hsDriverChecker.testMySqlDriver()) {
            jProgressBar.setValue(40);
            try {
                Thread.sleep(HsCommons.LOADING);
            } catch (InterruptedException e) {
            }
            this.jProgressBar.setString("Verificando Email Drivers...");
            hsDriverChecker.testMailDriver();
            jProgressBar.setValue(60);
            try {
                Thread.sleep(HsCommons.LOADING);
            } catch (InterruptedException e) {
            }
            this.jProgressBar.setString("Verificando Core...");
            try {
                Thread.sleep(HsCommons.LOADING);
            } catch (InterruptedException e) {
            }
            this.jProgressBar.setString("Verificando Conectividade...");
            jProgressBar.setValue(80);
            try {
                Thread.sleep(HsCommons.LOADING);
            } catch (InterruptedException e) {
            }
            this.jProgressBar.setString("Carregando Interface Gráfica...");
            try {
                Thread.sleep(HsCommons.LOADING);
            } catch (InterruptedException e) {
            }
            FrLogin frLogin = new FrLogin();
            jProgressBar.setValue(100);
            this.jProgressBar.setString("Pronto...");
            frLogin.setVisible(true);
            this.dispose();
        } else {
            HsMessage.mostrarMensagem(JOptionPane.ERROR_MESSAGE, "Rede Encarte", "Impossível acessar servidor");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jProgressBar = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("HanziPen SC", 3, 36)); // NOI18N
        jLabel1.setText("Rede Encarte");

        jProgressBar.setStringPainted(true);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/schumaker/res/icon_32x32@2x.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(9, 9, 9)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar jProgressBar;
    // End of variables declaration//GEN-END:variables

}
