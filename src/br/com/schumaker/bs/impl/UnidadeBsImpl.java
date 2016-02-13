package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.UnidadeBs;
import br.com.schumaker.dao.impl.UnidadeDaoImpl;
import br.com.schumaker.model.Unidade;
import br.com.schumaker.util.HsMessage;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Hudson Schumaker HStudio - @BomRango 06/06/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class UnidadeBsImpl implements UnidadeBs {

    public UnidadeBsImpl() {
    }

    @Override
    public Unidade obter(Integer id) {
        return new UnidadeDaoImpl().obter(id);
    }

    @Override
    public Unidade obter(String nome) {
        return new UnidadeDaoImpl().obter(nome);
    }

    @Override
    public List<Unidade> listar() {
        return new UnidadeDaoImpl().listar();
    }

    @Override
    public List<Unidade> like(String s) {
        return new UnidadeDaoImpl().like(s);
    }

    @Override
    public boolean verificarNome(String nome) {
        return new UnidadeDaoImpl().verificarNome(nome);
    }

    public String[] getNomesToArray() {
        List<Unidade> lista = listar();
        String nomes[] = new String[lista.size()];
        for (int k = 0; k < lista.size(); k++) {
            nomes[k] = lista.get(k).getNome();
        }
        return nomes;
    }

    @Override
    public void cadastrar(Unidade unidade) {
        if (verificarNome(unidade.getNome())) {
            HsMessage.mostrarMensagem(JOptionPane.WARNING_MESSAGE, "Cadastro - Unidade", "Unidade já existe.");
        } else {
            if (new UnidadeDaoImpl().cadastrar(unidade)) {
                HsMessage.mostrarMensagem(JOptionPane.INFORMATION_MESSAGE, "Cadastro - Unidade", "Unidade cadastrado com sucesso.");
            } else {
                HsMessage.mostrarMensagem(JOptionPane.ERROR_MESSAGE, "Cadastro - Unidade", "Erro ao cadastrar o unidade.");
            }
        }
    }

    @Override
    public void atualizar(Unidade unidade) {
        new UnidadeDaoImpl().atualizar(unidade);
    }

    @Override
    public void deletar(Unidade unidade) {
        new UnidadeDaoImpl().deletar(unidade);
    }
}
