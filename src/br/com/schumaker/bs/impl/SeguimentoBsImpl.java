package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.SeguimentoBs;
import br.com.schumaker.dao.impl.SeguimentoDaoImpl;
import br.com.schumaker.model.Seguimento;
import java.util.List;

/**
 *
 * @author Hudson Schumaker
 */
public class SeguimentoBsImpl implements SeguimentoBs{

    @Override
    public Seguimento obter(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Seguimento obter(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verificarNome(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cadastrar(Seguimento seg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Seguimento seg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Seguimento seg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
