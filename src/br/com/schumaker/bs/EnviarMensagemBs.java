
package br.com.schumaker.bs;

import br.com.schumaker.gfx.FrMensagem;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 14/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public interface EnviarMensagemBs {
    
    void enviarMensagem(FrMensagem sms, String assunto, String texto);
}
