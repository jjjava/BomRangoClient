package br.com.schumaker.dao;

import br.com.schumaker.model.Loja;
import java.util.List;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 07/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public interface LojaDao {
    Loja obter(Integer id);
    List<Loja> listar();
    List<Loja> like(String s);
    List<Loja> listarPorDensidade(int idDensidade);
    boolean verificarNome(String nome);
    boolean cadastrar(Loja mercado);
    boolean atualizar(Loja mercado);
    boolean deletar(Loja mercado);
}
