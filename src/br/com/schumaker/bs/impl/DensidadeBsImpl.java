package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.DensidadeBs;
import br.com.schumaker.dao.impl.DensidadeDaoImpl;
import br.com.schumaker.model.Densidade;
import br.com.schumaker.util.HsMessage;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Hudson Schumaker HStudio - @BomRango 06/06/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class DensidadeBsImpl implements DensidadeBs {
    
    public DensidadeBsImpl(){
    }

    @Override
    public Densidade obter(Integer id) {
        return new DensidadeDaoImpl().obter(id);
    }

    @Override
    public List<Densidade> listar() {
        return new DensidadeDaoImpl().listar();
    }

    public List<Densidade> listar(int id) {
        return new DensidadeDaoImpl().listar(id);
    }

    @Override
    public List<Densidade> like(String s) {
        return new DensidadeDaoImpl().like(s);
    }

    @Override
    public boolean verificarNome(String nome) {
        return new DensidadeDaoImpl().verificarNome(nome);
    }

    @Override
    public void cadastrar(Densidade densidade) {
        if (new DensidadeDaoImpl().cadastrar(densidade)) {
            HsMessage.mostrarMensagem(JOptionPane.INFORMATION_MESSAGE, "Casdastrar - Densidade", "Densidade cadastrada com sucesso.");
        } else {
            HsMessage.mostrarMensagem(JOptionPane.ERROR_MESSAGE, "Casdastrar - Densidade", "Erro ao cadastrar a densidade.");
        }
    }

    @Override
    public void atualizar(Densidade densidade) {
        if (new DensidadeDaoImpl().atualizar(densidade)) {
            HsMessage.mostrarMensagem(JOptionPane.INFORMATION_MESSAGE, "Atualizar - Densidade", "Densidade atualizada com sucesso.");
        } else {
            HsMessage.mostrarMensagem(JOptionPane.ERROR_MESSAGE, "Atualizar - Densidade", "Erro ao atualizar a densidade.");
        }
    }

    @Override
    public void deletar(Densidade densidade) {
        if (new DensidadeDaoImpl().deletar(densidade)) {
            HsMessage.mostrarMensagem(JOptionPane.INFORMATION_MESSAGE, "Deletar - Densidade", "Densidade deletada com sucesso.");
        } else {
            HsMessage.mostrarMensagem(JOptionPane.ERROR_MESSAGE, "Deletar - Densidade", "Erro ao deletar a densidade.");
        }
    }

    public String[] getNomesToArray() {
        List<Densidade> lista = listar();
        String nomes[] = new String[lista.size()];
        for (int k = 0; k < lista.size(); k++) {
            nomes[k] = lista.get(k).getNome();
        }
        return nomes;
    }

    public String[] getNomesToArray(int id) {
        List<Densidade> lista = listar(id);
        String nomes[] = new String[lista.size()];
        for (int k = 0; k < lista.size(); k++) {
            nomes[k] = lista.get(k).getNome();
        }
        return nomes;
    }
}
