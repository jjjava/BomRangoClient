package br.com.schumaker.bs;

import br.com.schumaker.model.Cliente;
import br.com.schumaker.model.Loja;
import java.util.List;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 05/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public interface LojaBs {
    Loja obter(Integer id);
    List<Loja> listar();
    List<Loja> like(String s);
    Cliente getClienteSessao();
    Loja getMercadoSessao();
    void mostrarPerfil(String action);
    void gerenciarSessao();
    boolean verificarNome(String nome);
    void cadastrar(Loja mercado);
    void atualizar(Loja mercado);
    void deletar(Loja mercado); 
}
