package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.BairroBs;
import br.com.schumaker.dao.impl.BairroDaoImpl;
import br.com.schumaker.model.Bairro;
import java.util.List;

/**
 *
 * @author Hudson Schumaker HStudio - @BomRangoClient 06/06/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class BairroBsImpl implements BairroBs {
    
    public BairroBsImpl(){
    }

    @Override
    public Bairro obter(Integer id) {
        return new BairroDaoImpl().obter(id);
    }

    @Override
    public List<Bairro> listar() {
        return new BairroDaoImpl().listar();
    }

    public List<Bairro> listar(int id) {
        return new BairroDaoImpl().listar(id);
    }

    @Override
    public List<Bairro> like(String s) {
        return new BairroDaoImpl().like(s);
    }

    @Override
    public boolean verificarNome(String nome) {
        return new BairroDaoImpl().verificarNome(nome);
    }

    @Override
    public void cadastrar(Bairro cidade) {
    }

    @Override
    public void atualizar(Bairro cidade) {
        new BairroDaoImpl().atualizar(cidade);
    }

    @Override
    public void deletar(Bairro cidade) {
        new BairroDaoImpl().deletar(cidade);
    }
}
