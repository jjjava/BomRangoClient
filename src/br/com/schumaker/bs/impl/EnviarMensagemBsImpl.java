package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.EnviarMensagemBs;
import br.com.schumaker.gfx.FrMensagem;
import br.com.schumaker.mail.SendBrief;
import br.com.schumaker.model.HsSession;
import br.com.schumaker.util.HsMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author hudsonschumaker
 */
public class EnviarMensagemBsImpl implements EnviarMensagemBs{

    @Override
    public void enviarMensagem(FrMensagem frsms,String assunto, String texto) {
        SendBrief send = new SendBrief();
        send.setTo("hudson@schumaker.com.br");
        send.setSubject(assunto);
        send.setMessage(HsSession.getInstance().getCliente().getEmail()+"\n"
                +HsSession.getInstance().getMercado().getNome()+"\n"
                +HsSession.getInstance().getMercado().getTelefone()+"\n\n"
                +texto);
        
        if(send.sendMessage()){
            HsMessage.mostrarMensagem(JOptionPane.INFORMATION_MESSAGE, "Enviar Mensagem", "Mensagem enviada com sucesso.");
            frsms.dispose();
        }else{
            HsMessage.mostrarMensagem(JOptionPane.ERROR_MESSAGE, "Enviar Mensagem", "Erro ao enviar mensagem.");
        }
    }
}
