package br.com.schumaker.run;

import br.com.schumaker.bs.impl.ServerBsImpl;
import br.com.schumaker.gfx.FrLogin;
import br.com.schumaker.util.HsDriverChecker;
import br.com.schumaker.util.HsMessage;
import com.sun.awt.AWTUtilities;
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
        AWTUtilities.setWindowOpacity(this, 0.77777777F);
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
            Thread.sleep(1500);
        } catch (InterruptedException e) {
        }
        this.jProgressBar.setString("Verificando MySQL Drivers...");
        if (hsDriverChecker.testMySqlDriver()) {
            jProgressBar.setValue(40);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
            }
            this.jProgressBar.setString("Verificando Email Drivers...");
            hsDriverChecker.testMailDriver();
            jProgressBar.setValue(60);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
            }
            this.jProgressBar.setString("Verificando Core...");
            new ServerBsImpl().getStatus();
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
            }
            this.jProgressBar.setString("Verificando Conectividade...");
            jProgressBar.setValue(80);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
            }
            this.jProgressBar.setString("Carregando Interface Gráfica...");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
            }
            FrLogin frLogin = new FrLogin();
            jProgressBar.setValue(100);
            this.jProgressBar.setString("Pronto...");
            frLogin.setVisible(true);
            this.dispose();
        } else {
            HsMessage.mostrarMensagem(JOptionPane.ERROR_MESSAGE, "BOMRANGO", "Impossível acessar servidor");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jProgressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("HanziPen SC", 3, 36)); // NOI18N
        jLabel1.setText("Bom Rango");

        jProgressBar.setStringPainted(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 232, Short.MAX_VALUE))
                    .addComponent(jProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                .addComponent(jProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar jProgressBar;
    // End of variables declaration//GEN-END:variables

}
