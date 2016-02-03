package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.LojaBs;
import br.com.schumaker.dao.impl.LojaDaoImpl;
import br.com.schumaker.hsfiles.HsFiles;
import br.com.schumaker.model.Cliente;
import br.com.schumaker.model.HsSessionCliente;
import br.com.schumaker.model.Loja;
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
public class LojaBsImpl implements LojaBs {

    @Override
    public Loja obter(Integer id) {
        return new LojaDaoImpl().obter(id);
    }

    @Override
    public List<Loja> listar() {
        return new LojaDaoImpl().listar();
    }

    @Override
    public List<Loja> like(String s) {
        return new LojaDaoImpl().like(s);
    }

    @Override
    public boolean verificarNome(String nome) {
        return new LojaDaoImpl().verificarNome(nome);
    }

    @Override
    public void cadastrar(Loja mercado) {
        if (new LojaDaoImpl().verificarNome(mercado.getNome())) {
            HsMessage.mostrarMensagem(JOptionPane.WARNING_MESSAGE, "Cadastro - Mercado", "Já existe um mercado com esse nome.");
        } else {
            if (new LojaDaoImpl().cadastrar(mercado)) {
                if (new HsFiles().criarDirMercado(mercado.getNome())) {//cria pasta para arquivos do mercado
                    HsMessage.mostrarMensagem(JOptionPane.WARNING_MESSAGE, "Cadastro - Mercado", "Mercado cadastrado do sucesso.");
                } else {
                    HsMessage.mostrarMensagem(JOptionPane.WARNING_MESSAGE, "Cadastro - Mercado", "Erro ao cadastrar mercado.");
                }
            } else {
                HsMessage.mostrarMensagem(JOptionPane.WARNING_MESSAGE, "Cadastro - Mercado", "Erro ao cadastrar mercado.");
            }
        }
    }

    @Override
    public void atualizar(Loja mercado) {
        HsMessage.mostrarMensagem(JOptionPane.WARNING_MESSAGE, "Mercado", "Sem suporte ainda.");
    }

    @Override
    public void deletar(Loja mercado) {
        HsMessage.mostrarMensagem(JOptionPane.WARNING_MESSAGE, "Mercado", "Sem suporte ainda.");
    }

    @Override
    public void mostrarPerfil(String action) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void gerenciarSessao() {
//        FacesContext fc = FacesContext.getCurrentInstance();
//        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
//        Cliente cliente = (Cliente) session.getAttribute("Cliente");
//        if (cliente == null) {
//            try {
//                System.out.println("sessão vazia redirecionando...");
//                FacesContext.getCurrentInstance().getExternalContext().redirect("../gerenciar.xhtml");
//            } catch (IOException ex) {
//                System.err.println(ex);
//                LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
//            }
//        }
    }

    @Override
    public Cliente getClienteSessao() {
        return HsSessionCliente.getInstance().getCliente();
    }

    @Override
    public Loja getMercadoSessao() {
        return HsSessionCliente.getInstance().getMercado();
    }
}
