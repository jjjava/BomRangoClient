package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.EstadoBs;
import br.com.schumaker.dao.impl.EstadoDaoImpl;
import br.com.schumaker.model.Cidade;
import br.com.schumaker.model.Estado;
import java.util.List;

/**
 *
 * @author Hudson Schumaker
 */
public class EstadoBsImpl implements EstadoBs {

    @Override
    public Estado obter(Integer id) {
        return new EstadoDaoImpl().obter(id);
    }

    @Override
    public List<Estado> listar() {
        return new EstadoDaoImpl().listar();
    }

    @Override
    public List<Estado> like(String s) {
        return new EstadoDaoImpl().like(s);
    }

    @Override
    public boolean verificarNome(String nome) {
        return new EstadoDaoImpl().verificarNome(nome);
    }

    @Override
    public boolean verificarCidadeNoEstado(Cidade cidade) {
        return new EstadoDaoImpl().verificarCidadeNoEstado(cidade);
    }

    @Override
    public void cadastrar(Estado estado) {
        new EstadoDaoImpl().cadastrar(estado);
    }

    @Override
    public void atualizar(Estado estado) {
        new EstadoDaoImpl().atualizar(estado);
    }

    @Override
    public void deletar(Estado estado) {
        new EstadoDaoImpl().deletar(estado);
    }
}
