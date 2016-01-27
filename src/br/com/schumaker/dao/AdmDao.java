package br.com.schumaker.dao;

import br.com.schumaker.model.Adm;
import java.util.List;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 13/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public interface AdmDao {
    Adm obter(Integer id);
    Adm obter(String email);
    List<Adm> listar();
    List<Adm> like(String s);
    boolean verificarEmail(String email);
    boolean validar(String email, String password);
}
