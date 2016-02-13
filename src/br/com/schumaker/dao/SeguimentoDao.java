package br.com.schumaker.dao;

import br.com.schumaker.model.Seguimento;
import java.util.List;

/**
 *
 * @author Hudson Schumaker HStudio - @BomRango 07/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public interface SeguimentoDao {
    Seguimento obter(Integer id);
    Seguimento obter(String nome);
    List<Seguimento> listar();
    List<Seguimento> like(String s);
    boolean verificarNome(String nome);
    void cadastrar(Seguimento seg);
    void atualizar(Seguimento seg);
    void deletar(Seguimento seg);
}
