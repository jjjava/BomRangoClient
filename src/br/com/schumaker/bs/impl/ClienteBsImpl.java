package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.ClienteBs;
import br.com.schumaker.dao.impl.ClienteDaoImpl;
import br.com.schumaker.model.Cliente;
import br.com.schumaker.util.HsMessage;
import java.io.IOException;
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
    public void validar(Cliente cliente) {
        ClienteDaoImpl clienteDaoImpl = new ClienteDaoImpl();
        //
        //criptografar aqui
        //
        if (clienteDaoImpl.validar(cliente.getEmail(), cliente.getSenha())) {//usar senha criptografada
            try {
                cliente = clienteDaoImpl.obter(cliente.getEmail());
                FacesContext fc = FacesContext.getCurrentInstance();
                HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
                session.setAttribute("Cliente", cliente);
                FacesContext.getCurrentInstance().getExternalContext().redirect("gerenciador/gerenciarmercado.xhtml");
            } catch (IOException ex) {
                System.out.println(ex);
                LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
            }
        } else {
            HsMessage.mostrarMensagem(JOptionPane.WARNING_MESSAGE, "Login", "Email ou Senha incorretos.");
        }
    }

    @Override
    public boolean verificarNome(String nome) {
        return new ClienteDaoImpl().verificarNome(nome);
    }

    @Override
    public void cadastrar(Cliente cliente) {
        if (new ClienteDaoImpl().cadastrar(cliente)) {
            HsMessage.mostrarMensagem(JOptionPane.INFORMATION_MESSAGE, "Cadastrar - Cliente", "Cliente cadastrado com sucesso.");
        } else {
            HsMessage.mostrarMensagem(JOptionPane.ERROR_MESSAGE, "Cadastrar - Cliente", "Erro ao cadastrar cliente.");
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
       
    }
}
