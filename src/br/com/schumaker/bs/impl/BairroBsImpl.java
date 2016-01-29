package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.BairroBs;
import br.com.schumaker.dao.impl.BairroDaoImpl;
import br.com.schumaker.dao.impl.EstadoDaoImpl;
import br.com.schumaker.model.Bairro;
import br.com.schumaker.util.HsMessage;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author hudson schumaker HStudio - @BomRangoClient 06/06/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class BairroBsImpl implements BairroBs {

    @Override
    public Bairro obter(Integer id) {
        return new BairroDaoImpl().obter(id);
    }

    @Override
    public List<Bairro> listar() {
        return new BairroDaoImpl().listar();
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