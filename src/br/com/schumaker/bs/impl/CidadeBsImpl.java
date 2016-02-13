package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.CidadeBs;
import br.com.schumaker.dao.impl.CidadeDaoImpl;
import br.com.schumaker.dao.impl.EstadoDaoImpl;
import br.com.schumaker.model.Cidade;
import br.com.schumaker.util.HsMessage;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Hudson Schumaker HStudio - @BomRangoClient 06/06/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class CidadeBsImpl implements CidadeBs {
    
    public CidadeBsImpl(){
    }

    @Override
    public Cidade obter(Integer id) {
        return new CidadeDaoImpl().obter(id);
    }

    @Override
    public List<Cidade> listar() {
        return new CidadeDaoImpl().listar();
    }

    public List<Cidade> listar(int id) {
        return new CidadeDaoImpl().listar(id);
    }

    @Override
    public List<Cidade> like(String s) {
        return new CidadeDaoImpl().like(s);
    }

    @Override
    public boolean verificarNome(String nome) {
        return new CidadeDaoImpl().verificarNome(nome);
    }

    @Override
    public void cadastrar(Cidade cidade) {
        if (new EstadoDaoImpl().verificarCidadeNoEstado(cidade)) {
            HsMessage.mostrarMensagem(JOptionPane.WARNING_MESSAGE, "Cadastro - Cidade", "Já existe uma cidade com esse nome no estado selecionado. ");
        } else {
            if (new CidadeDaoImpl().cadastrar(cidade)) {
                HsMessage.mostrarMensagem(JOptionPane.INFORMATION_MESSAGE, "Cadastro - Cidade", "Cidade cadastrada.");
            } else {
                HsMessage.mostrarMensagem(JOptionPane.ERROR_MESSAGE, "Cadastro - Cidade", "Erro ao cadastrar a cidade.");
            }
        }
    }

    @Override
    public void atualizar(Cidade cidade) {
        new CidadeDaoImpl().atualizar(cidade);
    }

    @Override
    public void deletar(Cidade cidade) {
        new CidadeDaoImpl().deletar(cidade);
    }

    public String[] getNomesToArray() {
        List<Cidade> lista = listar();
        String nomes[] = new String[lista.size()];
        for (int k = 0; k < lista.size(); k++) {
            nomes[k] = lista.get(k).getNome();
        }
        return nomes;
    }

    public String[] getNomesToArray(int id) {
        List<Cidade> lista = listar(id);
        String nomes[] = new String[lista.size()];
        for (int k = 0; k < lista.size(); k++) {
            nomes[k] = lista.get(k).getNome();
        }
        return nomes;
    }
}
