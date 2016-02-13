package br.com.schumaker.bs;

import br.com.schumaker.gfx.FrLogin;

/**
 *
 * @author Hudson Schumaker Rede Encarte 27/01/16
 */
public interface LoginBs {
    
    boolean verifyTypeLogin(String nome);
    void doLogin(String email, String senha, FrLogin frLogin);
    void forgotPassword(String email, String senha);
}
