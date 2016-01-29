package br.com.schumaker.bs;

import br.com.schumaker.model.Seguimento;
import java.util.List;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 19/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public interface SeguimentoBs {
    Seguimento obter(Integer id);
    Seguimento obter(String nome);
    List<Seguimento> listar();
    List<Seguimento> like(String s);
    boolean verificarNome(String nome);
    void cadastrar(Seguimento seg);
    void atualizar(Seguimento seg);
    void deletar(Seguimento seg);
}