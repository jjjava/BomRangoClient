package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.ClienteBs;
import br.com.schumaker.dao.impl.ClienteDaoImpl;
import br.com.schumaker.gfx.FrAlterarSenha;
import br.com.schumaker.gfx.FrLogin;
import br.com.schumaker.gfx.FrMainCliente;
import br.com.schumaker.mail.SendBrief;
import br.com.schumaker.model.Cliente;
import br.com.schumaker.model.HsSessionCliente;
import br.com.schumaker.util.HsMessage;
import java.awt.Cursor;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 06/06/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class ClienteBsImpl implements ClienteBs {

    @Override
    public Cliente obter(Integer id) {
        return new ClienteDaoImpl().obter(id);
    }

    @Override
    public Cliente obter(String email) {
        return new ClienteDaoImpl().obter(email);
    }

    @Override
    public List<Cliente> listar() {
        return new ClienteDaoImpl().listar();
    }

    @Override
    public List<Cliente> like(String s) {
        return new ClienteDaoImpl().like(s);
    }

    @Override
    public boolean verificarEmail(String email) {
        return new ClienteDaoImpl().verificarEmail(email);
    }

    @Override
    public void validar(Cliente cliente, FrLogin frLogin) {
        frLogin.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        ClienteDaoImpl clienteDaoImpl = new ClienteDaoImpl();
        //
        //criptografar aqui
        //
        if (clienteDaoImpl.validar(cliente.getEmail(), cliente.getSenha())) {//usar senha criptografada
            HsSessionCliente.getInstance().setCliente(obter(cliente.getEmail()));
            HsSessionCliente.getInstance().setMercado(new LojaBsImpl().obter(HsSessionCliente.getInstance().getCliente().getIdMercado()));

            frLogin.dispose();
            new FrMainCliente().setVisible(true);
        } else {
            frLogin.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            HsMessage.mostrarMensagem(JOptionPane.WARNING_MESSAGE, "Login", "Email ou Senha incorretos.");
        }
    }

    @Override
    public boolean verificarNome(String nome) {
        return new ClienteDaoImpl().verificarNome(nome);
    }

    @Override
    public void alterarSenha(FrAlterarSenha fr, String senhaAtual, String senhaNova) {
        Cliente cliente = HsSessionCliente.getInstance().getCliente();
        if (cliente.getSenha().equals(senhaAtual)) {
            cliente.setSenha(senhaNova);
            if (new ClienteDaoImpl().atualizar(cliente)) {
                HsMessage.mostrarMensagem(JOptionPane.INFORMATION_MESSAGE, "Atualizar - Cliente", "Senha alterada com sucesso.");
                fr.dispose();//fecha JFrame alterar senha
            } else {
                HsMessage.mostrarMensagem(JOptionPane.ERROR_MESSAGE, "Atualizar - Cliente", "Erro ao atualizar senha.");
            }
        } else {
            HsMessage.mostrarMensagem(JOptionPane.ERROR_MESSAGE, "Atualizar - Cliente", "Senha atual errada.");
        }
    }

    @Override
    public void cadastrar(Cliente cliente) {
        if (verificarEmail(cliente.getEmail())) {
            HsMessage.mostrarMensagem(JOptionPane.ERROR_MESSAGE, "Cadastrar - Usuário", "Email já cadastrado.");
        } else {
            if (cliente.getSenha().length() >= 6) {
                if (cliente.getSenha().equals(cliente.getSenha2())) {
                    cliente.setIdMercado(HsSessionCliente.getInstance().getMercado().getId());
                    if (new ClienteDaoImpl().cadastrar(cliente)) {
                        HsMessage.mostrarMensagem(JOptionPane.INFORMATION_MESSAGE, "Cadastrar - Usuário", "Usuário cadastrado com sucesso.");
                    } else {
                        HsMessage.mostrarMensagem(JOptionPane.ERROR_MESSAGE, "Cadastrar - Usuário", "Erro ao cadastrar usuário.");
                    }
                } else {
                    HsMessage.mostrarMensagem(JOptionPane.ERROR_MESSAGE, "Cadastrar - Usuário", "Senhas não são iguais.");
                }
            } else {
                HsMessage.mostrarMensagem(JOptionPane.ERROR_MESSAGE, "Cadastrar - Usuário", "Senhas muito curta.");
            }
        }
    }

    @Override
    public void atualizar(Cliente cliente) {
        if (new ClienteDaoImpl().atualizar(cliente)) {
            HsMessage.mostrarMensagem(JOptionPane.INFORMATION_MESSAGE, "Atualizar - Cliente", "Cliente Atualizado com sucesso.");
        } else {
            HsMessage.mostrarMensagem(JOptionPane.ERROR_MESSAGE, "Atualizar - Cliente", "Erro ao atualizar cliente.");
        }
    }

    @Override
    public void deletar(Cliente cliente) {
        if (new ClienteDaoImpl().deletar(cliente)) {
            HsMessage.mostrarMensagem(JOptionPane.INFORMATION_MESSAGE, "Deletar - Cliente", "Cliente deletado com sucesso.");
        } else {
            HsMessage.mostrarMensagem(JOptionPane.ERROR_MESSAGE, "Deletar - Cliente", "Erro ao deletar cliente.");
        }
    }

    @Override
    public void invalidarSessao() {
        HsSessionCliente.getInstance().cleanSession();
    }

    @Override
    public void esqueceuSenha(String email) {
        if (verificarEmail(email)) {
            Cliente cliente = obter(email);
            SendBrief send = new SendBrief();
            send.setTo(email);
            send.setSubject("Esqueci minha senha Rede Encarte");
            send.setMessage("Olá, " + cliente.getNome() + "\n"
                    + "Sua senha de acesso é:\n" + cliente.getSenha() + "\n\n\n"
                    + "Equipe Rede Encarte");

            if (send.sendMessage()) {
                HsMessage.mostrarMensagem(JOptionPane.INFORMATION_MESSAGE, "Enviar Mensagem", "Mensagem enviada com sucesso.");
            } else {
                HsMessage.mostrarMensagem(JOptionPane.ERROR_MESSAGE, "Enviar Mensagem", "Erro ao enviar mensagem.");
            }
        } else {
            HsMessage.mostrarMensagem(JOptionPane.WARNING_MESSAGE, "Enviar Mensagem", "Email não cadastrado.");
        }
    }
}
