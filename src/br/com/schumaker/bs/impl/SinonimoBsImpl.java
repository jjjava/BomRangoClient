package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.SinonimoBs;
import br.com.schumaker.dao.impl.SinonimoDaoImpl;
import br.com.schumaker.model.Sinonimo;
import br.com.schumaker.util.HsMessage;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author hudson schumaker HStudio - @BomRango 06/06/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class SinonimoBsImpl implements SinonimoBs {

    @Override
    public Sinonimo obter(Integer id) {
        return new SinonimoDaoImpl().obter(id);
    }
    
    @Override
    public Sinonimo obter(String nome) {
        return new SinonimoDaoImpl().obter(nome);
    }

    @Override
    public List<Sinonimo> listar() {
       return new SinonimoDaoImpl().listar();
    }

    @Override
    public List<Sinonimo> like(String s) {
        return new SinonimoDaoImpl().like(s);
    }

    @Override
    public boolean verificarNome(String nome) {
         return new SinonimoDaoImpl().verificarNome(nome);
    }

    @Override
    public void cadastrar(Sinonimo sin) {
        HsMessage.mostrarMensagem(JOptionPane.WARNING_MESSAGE, "Sinonimo", "Não suportado ainda");
    }

    @Override
    public void atualizar(Sinonimo sin) {
        HsMessage.mostrarMensagem(JOptionPane.WARNING_MESSAGE, "Sinonimo", "Não suportado ainda");
    }

    @Override
    public void deletar(Sinonimo sin) {
       HsMessage.mostrarMensagem(JOptionPane.WARNING_MESSAGE, "Sinonimo", "Não suportado ainda");
    }
    
}
