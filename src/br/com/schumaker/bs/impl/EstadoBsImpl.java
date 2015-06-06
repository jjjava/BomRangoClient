package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.EstadoBs;
import br.com.schumaker.dao.impl.EstadoDaoImpl;
import br.com.schumaker.model.Cidade;
import br.com.schumaker.model.Estado;
import br.com.schumaker.util.HsMessage;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 16/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class EstadoBsImpl implements EstadoBs {

    @Override
    public Estado obter(Integer id) {
        return new EstadoDaoImpl().obter(id);
    }

    @Override
    public List<Estado> listar() {
        return new EstadoDaoImpl().listar();
    }

    @Override
    public List<Estado> like(String s) {
        return new EstadoDaoImpl().like(s);
    }

    @Override
    public boolean verificarNome(String nome) {
        return new EstadoDaoImpl().verificarNome(nome);
    }

    @Override
    public boolean verificarCidadeNoEstado(Cidade cidade) {
        return new EstadoDaoImpl().verificarCidadeNoEstado(cidade);
    }

    @Override
    public void cadastrar(Estado estado) {
        if (verificarNome(estado.getNome())) {
            HsMessage.mostrarMensagem(JOptionPane.WARNING_MESSAGE, "Cadastro - Estado", "Já existe um estado com esse nome.");
        } else {
            if (new EstadoDaoImpl().cadastrar(estado)) {
                HsMessage.mostrarMensagem(JOptionPane.INFORMATION_MESSAGE, "Cadastro - Estado", "Estado cadastrado com sucesso.");
            } else {
                HsMessage.mostrarMensagem(JOptionPane.ERROR_MESSAGE, "Cadastro - Estado", "Erro ao cadastrar o estado.");
            }
        }
    }

    @Override
    public void atualizar(Estado estado) {
        if (new EstadoDaoImpl().verificarNome(estado.getNome())) {
            HsMessage.mostrarMensagem(JOptionPane.WARNING_MESSAGE, "Cadastro - Estado", "Já existe um estado com esse nome.");
        } else if (new EstadoDaoImpl().verificarUf(estado.getUf())) {
            HsMessage.mostrarMensagem(JOptionPane.WARNING_MESSAGE, "Cadastro - Estado", "Já existe um estado com essa UF.");
        } else {
            if (new EstadoDaoImpl().atualizar(estado)) {
                HsMessage.mostrarMensagem(JOptionPane.WARNING_MESSAGE, "Cadastro - Estado", "Estado atualizado com sucesso.");
            } else {
                HsMessage.mostrarMensagem(JOptionPane.WARNING_MESSAGE, "Cadastro - Estado", "Erro ao atualizar estado.");
            }
        }
    }

    @Override
    public void deletar(Estado estado) {
        HsMessage.mostrarMensagem(JOptionPane.WARNING_MESSAGE, "Cadastro - Estado", "Ação não suportada.");
    }

}
