/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.schumaker.dao;

import br.com.schumaker.model.Seguimento;
import java.util.List;

/**
 *
 * @author Hudson Schumaker
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
