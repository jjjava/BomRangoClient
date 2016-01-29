package br.com.schumaker.dao;

import br.com.schumaker.model.Bairro;
import java.util.List;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 11/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public interface BairroDao {
    Bairro obter(Integer id);
    List<Bairro> listar();
    List<Bairro> like(String s);
    boolean verificarNome(String nome);
    boolean cadastrar(Bairro cidade);
    boolean atualizar(Bairro cidade);
    boolean deletar(Bairro cidade);
}
