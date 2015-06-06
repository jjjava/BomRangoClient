package br.com.schumaker.run;

import br.com.schumaker.gfx.FrLogin;
import br.com.schumaker.gfx.FrMain;

/**
 *
 * @author hudsonschumaker
 */
public class Run {

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
              //  new FrMain().setVisible(true);
              new FrLogin().setVisible(true);
            }
        });
    }
}
