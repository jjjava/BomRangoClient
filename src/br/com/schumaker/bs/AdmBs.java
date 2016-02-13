package br.com.schumaker.bs;

import br.com.schumaker.gfx.FrAlterarSenha;
import br.com.schumaker.gfx.FrLogin;
import br.com.schumaker.model.Adm;
import java.util.List;

/**
 *
 * @author Hudson Schumaker HStudio - @BomRango 06/06/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public interface AdmBs {
    Adm obter(Integer id);
    Adm obter(String email);
    List<Adm> listar();
    List<Adm> like(String s);
    boolean verificarEmail(String email);
    void validar(Adm asm, FrLogin login);
    void invalidarSessao();
    boolean verificarNome(String nome);
    void alterarSenha(FrAlterarSenha fr, String senhaAtual, String senhaNova);
    void esqueceuSenha(String email);
}
