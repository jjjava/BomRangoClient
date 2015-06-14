package br.com.schumaker.bs;

import br.com.schumaker.gfx.FrAlterarSenha;
import br.com.schumaker.gfx.FrLogin;
import br.com.schumaker.model.Cliente;
import java.util.List;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 06/06/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ClienteBs {
    Cliente obter(Integer id);
    Cliente obter(String email);
    List<Cliente> listar();
    List<Cliente> like(String s);
    boolean verificarEmail(String email);
    void validar(Cliente cliente, FrLogin login);
    void invalidarSessao();
    boolean verificarNome(String nome);
    void alterarSenha(FrAlterarSenha fr, String senhaAtual, String senhaNova);
    void esqueceuSenha(String email);
    void cadastrar(Cliente cliente);
    void atualizar(Cliente cliente);
    void deletar(Cliente cliente);
}
