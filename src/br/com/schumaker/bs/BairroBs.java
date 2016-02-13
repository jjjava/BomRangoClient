package br.com.schumaker.bs;

import br.com.schumaker.model.Bairro;
import java.util.List;

/**
 *
 * @author Hudson Schumaker HStudio - @BomRango 16/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public interface BairroBs {
    Bairro obter(Integer id);
    List<Bairro> listar();
    List<Bairro> like(String s);
    boolean verificarNome(String nome); 
    void cadastrar(Bairro cidade);
    void atualizar(Bairro cidade);
    void deletar(Bairro cidade);
}
