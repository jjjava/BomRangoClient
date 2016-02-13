package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.SeguimentoBs;
import br.com.schumaker.dao.impl.SeguimentoDaoImpl;
import br.com.schumaker.model.Seguimento;
import java.util.List;

/**
 *
 * @author Hudson Schumaker HStudio - @BomRango 04/02/2015
 */
public class SeguimentoBsImpl implements SeguimentoBs {

    @Override
    public Seguimento obter(Integer id) {
        return new SeguimentoDaoImpl().obter(id);
    }

    @Override
    public Seguimento obter(String nome) {
        return new SeguimentoDaoImpl().obter(nome);
    }

    @Override
    public List<Seguimento> listar() {
        return new SeguimentoDaoImpl().listar();
    }

    public List<Seguimento> listar(int id) {
        return new SeguimentoDaoImpl().listar(id);
    }

    @Override
    public List<Seguimento> like(String s) {
        return new SeguimentoDaoImpl().like(s);
    }

    @Override
    public boolean verificarNome(String nome) {
        return new SeguimentoDaoImpl().verificarNome(nome);
    }

    @Override
    public void cadastrar(Seguimento seg) {
        new SeguimentoDaoImpl().cadastrar(seg);
    }

    @Override
    public void atualizar(Seguimento seg) {
        new SeguimentoDaoImpl().atualizar(seg);
    }

    @Override
    public void deletar(Seguimento seg) {
        new SeguimentoDaoImpl().deletar(seg);
    }

    public String[] getNomesToArray() {
        List<Seguimento> lista = listar();
        String nomes[] = new String[lista.size()];
        for (int k = 0; k < lista.size(); k++) {
            nomes[k] = lista.get(k).getNome();
        }
        return nomes;
    }

    public String[] getNomesToArray(int id) {
        List<Seguimento> lista = listar(id);
        String nomes[] = new String[lista.size()];
        for (int k = 0; k < lista.size(); k++) {
            nomes[k] = lista.get(k).getNome();
        }
        return nomes;
    }
}
