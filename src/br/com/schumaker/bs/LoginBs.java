package br.com.schumaker.bs;

import br.com.schumaker.model.Adm;
import br.com.schumaker.model.Cliente;

/**
 *
 * @author hudson schumaker Rede Encarte 27/01/16
 */
public interface LoginBs {
    
    boolean verifyTypeLogin(String name);
    boolean validarCliente(Cliente cliente);
    boolean validarAdm(Adm adm);
    
}
