package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.FrMainAdmBs;
import br.com.schumaker.gfx.FrLogin;
import br.com.schumaker.gfx.FrSobre;
import br.com.schumaker.gfx.adm.FrMain;
import br.com.schumaker.gfx.adm.FrPerfilAdm;
import javax.swing.JOptionPane;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 14/06/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class FrMainAdmBsImpl implements FrMainAdmBs {

    private static final FrMainAdmBsImpl instance = new FrMainAdmBsImpl();

    private FrMainAdmBsImpl() {
    }

    public static FrMainAdmBsImpl getInstance() {
        return instance;
    }

    @Override
    public void showPerfilAdm() {
        new FrPerfilAdm().setVisible(true);
    }

    @Override
    public void showEnviarMensagem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showSobre() {
        new FrSobre().setVisible(true);
    }

    @Override
    public void doLogoff(FrMain main) {
        new AdmBsImpl().invalidarSessao();
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
        int v = JOptionPane.showConfirmDialog(null, "Rede Encarte", "Deseja fechar?", JOptionPane.YES_NO_OPTION);
        if (v == 0) {
            System.exit(1);
        }
    }

    @Override
    public void alterarSenha() {
        new AdmBsImpl().alterarSenha(null, null, null);
    }

}
