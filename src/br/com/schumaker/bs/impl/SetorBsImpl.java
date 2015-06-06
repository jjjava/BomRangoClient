package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.SetorBs;
import br.com.schumaker.dao.impl.SetorDaoImpl;
import br.com.schumaker.model.Setor;
import br.com.schumaker.util.HsMessage;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 06/06/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class SetorBsImpl implements SetorBs {

    @Override
    public Setor obter(Integer id) {
        return new SetorDaoImpl().obter(id);
    }
    
    @Override
    public Setor obter(String nome) {
        return new SetorDaoImpl().obter(nome);
    }

    @Override
    public List<Setor> listar() {
        return new SetorDaoImpl().listar();
    }

    @Override
    public List<Setor> like(String s) {
        return new SetorDaoImpl().like(s);
    }

    @Override
    public boolean verificarNome(String nome) {
        return new SetorDaoImpl().verificarNome(nome);
    }

    @Override
    public void cadastrar(Setor setor) {
        if (verificarNome(setor.getNome())) {
            HsMessage.mostrarMensagem(JOptionPane.WARNING_MESSAGE, "Cadastro - Setor", "Já existe um setor com esse nome.");
        } else {
            if (new SetorDaoImpl().cadastrar(setor)) {
                HsMessage.mostrarMensagem(JOptionPane.INFORMATION_MESSAGE, "Cadastro - Setor", "Setor cadastrado com sucesso.");
            } else {
                HsMessage.mostrarMensagem(JOptionPane.ERROR_MESSAGE, "Cadastro - Setor", "Erro ao cadastrar o setor.");
            }
        }
    }

    @Override
    public void atualizar(Setor setor) {
        HsMessage.mostrarMensagem(JOptionPane.WARNING_MESSAGE, "Setor", "Não suportado ainda");
    }

    @Override
    public void deletar(Setor setor) {
        HsMessage.mostrarMensagem(JOptionPane.WARNING_MESSAGE, "Setor", "Não suportado ainda");
    }
}
