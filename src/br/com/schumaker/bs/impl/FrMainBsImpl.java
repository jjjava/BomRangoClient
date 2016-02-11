package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.FrMainBs;
import br.com.schumaker.gfx.FrAlterarSenha;
import br.com.schumaker.gfx.FrLogin;
import br.com.schumaker.gfx.adm.FrMain;
import br.com.schumaker.gfx.FrMensagem;
import br.com.schumaker.gfx.FrSobre;
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
        new FrMensagem().setVisible(true);
    }

    @Override
    public void showSobre() {
        new FrSobre().setVisible(true);
    }

    @Override
    public void doLogoff(FrMain main) {
        new ClienteBsImpl().invalidarSessao();
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
        new FrAlterarSenha().setVisible(true);
    }
}
