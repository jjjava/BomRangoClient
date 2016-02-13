package br.com.schumaker.run;

/**
 *
 * @author Hudson Schumaker HStudio - @BomRango 05/06/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class Run {

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
              new FrSplash().start();
            }
        });
    }
}
