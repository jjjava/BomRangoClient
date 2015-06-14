package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.FrMainBs;
import br.com.schumaker.gfx.FrLogin;
import br.com.schumaker.gfx.FrMain;
import br.com.schumaker.model.HsSession;
import javax.swing.JOptionPane;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 14/06/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class FrMainBsImpl implements FrMainBs {

    private static final FrMainBsImpl instance = new FrMainBsImpl();

    private FrMainBsImpl() {

    }

    public static FrMainBsImpl getInstance() {
        return instance;
    }

    @Override
    public void showPerfilUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showPerfilMercado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showTopicosAjuda() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showEnviarMensagem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showSobre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doLogoff(FrMain main) {
        HsSession.getInstance().cleanSession();
        main.dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrLogin().setVisible(true);
            }
        });
    }

    @Override
    public void fechar() {
        int v = JOptionPane.showConfirmDialog(null, "Bom Rango", "Deseja fechar?", JOptionPane.YES_NO_OPTION);
        if (v == 0) {
            System.exit(0);
        }
    }

    @Override
    public void alterarSenha() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
