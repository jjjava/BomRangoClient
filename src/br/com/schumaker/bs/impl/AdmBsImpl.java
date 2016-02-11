package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.AdmBs;
import br.com.schumaker.dao.impl.AdmDaoImpl;
import br.com.schumaker.gfx.FrAlterarSenha;
import br.com.schumaker.gfx.FrLogin;
import br.com.schumaker.gfx.adm.FrMain;
import br.com.schumaker.model.Adm;
import br.com.schumaker.model.HsSessionAdm;
import br.com.schumaker.util.HsMessage;
import java.awt.Cursor;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author hudson schumaker Rede Encarte 27/01/16
 */
public class AdmBsImpl implements AdmBs {

    @Override
    public Adm obter(Integer id) {
        return new AdmDaoImpl().obter(id);
    }

    @Override
    public Adm obter(String email) {
        return new AdmDaoImpl().obter(email);
    }

    @Override
    public List<Adm> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Adm> like(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verificarEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void validar(Adm adm, FrLogin login) {
        login.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        if (new AdmDaoImpl().validar(adm.getLogin(), adm.getSenha())) {
            HsSessionAdm.getInstance().setAdm(obter(adm.getLogin()));
            login.dispose();
            new FrMain().setVisible(true);
        } else {
            login.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            HsMessage.mostrarMensagem(JOptionPane.WARNING_MESSAGE, "Login", "Email ou Senha incorretos.");
        }
    }

    @Override
    public void invalidarSessao() {
        HsSessionAdm.getInstance().cleanSession();
    }

    @Override
    public boolean verificarNome(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterarSenha(FrAlterarSenha fr, String senhaAtual, String senhaNova) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void esqueceuSenha(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
