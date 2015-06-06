package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.MercadoBs;
import br.com.schumaker.dao.impl.MercadoDaoImpl;
import br.com.schumaker.hsfiles.HsFiles;
import br.com.schumaker.model.Cliente;
import br.com.schumaker.model.Mercado;
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
public class MercadoBsImpl implements MercadoBs {

    @Override
    public Mercado obter(Integer id) {
        return new MercadoDaoImpl().obter(id);
    }

    @Override
    public List<Mercado> listar() {
        return new MercadoDaoImpl().listar();
    }

    @Override
    public List<Mercado> like(String s) {
        return new MercadoDaoImpl().like(s);
    }

    @Override
    public boolean verificarNome(String nome) {
        return new MercadoDaoImpl().verificarNome(nome);
    }

    @Override
    public void cadastrar(Mercado mercado) {
        if (new MercadoDaoImpl().verificarNome(mercado.getNome())) {
            HsMessage.mostrarMensagem(JOptionPane.WARNING_MESSAGE, "Cadastro - Mercado", "Já existe um mercado com esse nome.");
        } else {
            if (new MercadoDaoImpl().cadastrar(mercado)) {
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
    public void atualizar(Mercado mercado) {
        HsMessage.mostrarMensagem(JOptionPane.WARNING_MESSAGE, "Mercado", "Sem suporte ainda.");
    }

    @Override
    public void deletar(Mercado mercado) {
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
//        FacesContext fc = FacesContext.getCurrentInstance();
//        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        return null; //(Cliente) session.getAttribute("Cliente");
    }

    @Override
    public Mercado getMercadoSessao() {
//        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
//        Cliente cliente = (Cliente) session.getAttribute("Cliente");
//        MercadoDaoImpl mercadoDaoImpl = new MercadoDaoImpl();
        return null; // mercadoDaoImpl.obter(cliente.getIdMercado());
    }

}
