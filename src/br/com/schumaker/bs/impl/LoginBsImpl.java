package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.LoginBs;
import br.com.schumaker.model.Adm;
import br.com.schumaker.model.Cliente;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 04/02/2015
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
    public boolean validarCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validarAdm(Adm adm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
