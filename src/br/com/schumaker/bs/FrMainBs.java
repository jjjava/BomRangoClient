package br.com.schumaker.bs;

import br.com.schumaker.gfx.FrMain;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 14/06/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public interface FrMainBs {
    
    void showPerfilUsuario();
    void showPerfilMercado();
    void showTopicosAjuda();
    void showEnviarMensagem();
    void showSobre();
    void doLogoff(FrMain main);
    void fechar();
    void alterarSenha();   
}
