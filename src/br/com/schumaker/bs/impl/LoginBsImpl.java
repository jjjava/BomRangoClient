package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.LoginBs;
import br.com.schumaker.gfx.FrLogin;
import br.com.schumaker.model.Adm;
import br.com.schumaker.model.Cliente;
import br.com.schumaker.util.HsMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author Hudson Schumaker HStudio - @BomRango 04/02/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class LoginBsImpl implements LoginBs {

    private static final LoginBsImpl instance = new LoginBsImpl();

    private LoginBsImpl() {
    }

    public static LoginBsImpl getInstance() {
        return instance;
    }

    @Override
    public boolean verifyTypeLogin(String name) {
        return name.startsWith("$");
    }

    @Override
    public void doLogin(String email, String senha, FrLogin frLogin) {
        if (LoginBsImpl.getInstance().verifyTypeLogin(email)) {
            Adm adm = new Adm();
            adm.setLogin(email);
            adm.setSenha(senha);
            new AdmBsImpl().validar(adm, frLogin);
        } else {
            if (new ServerBsImpl().getStatus()) {
                Cliente cliente = new Cliente();
                cliente.setEmail(email);
                cliente.setSenha(senha);
                new ClienteBsImpl().validar(cliente, frLogin);
            } else {
                HsMessage.mostrarMensagem(JOptionPane.WARNING_MESSAGE, "Rede Encarte", "Servidor em manutenção.");
            }
        }
    }

    @Override
    public void forgotPassword(String email, String senha) {
        if (verifyTypeLogin(email)) {
            new AdmBsImpl().esqueceuSenha(email);
        } else {
            if (new ServerBsImpl().getStatus()) {
                new ClienteBsImpl().esqueceuSenha(email);
            } else {
                HsMessage.mostrarMensagem(JOptionPane.WARNING_MESSAGE, "Rede Encarte", "Servidor em manutenção.");
            }
        }
    }
}
