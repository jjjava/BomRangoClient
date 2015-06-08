package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.FabricanteBs;
import br.com.schumaker.dao.impl.FabricanteDaoImpl;
import br.com.schumaker.model.Fabricante;
import br.com.schumaker.util.HsMessage;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 06/06/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class FabricanteBsImpl implements FabricanteBs {

    @Override
    public Fabricante obter(Integer id) {
        return new FabricanteDaoImpl().obter(id);
    }

    @Override
    public Fabricante obter(String nome) {
        return new FabricanteDaoImpl().obter(nome);
    }

    @Override
    public List<Fabricante> listar() {
        return new FabricanteDaoImpl().listar();
    }

    @Override
    public List<Fabricante> like(String s) {
        return new FabricanteDaoImpl().like(s);
    }

    @Override
    public boolean verificarNome(String nome) {
        return new FabricanteDaoImpl().verificarNome(nome);
    }

    public String[] getNomesToArray() {
        List<Fabricante> lista = listar();
        String nomes[] = new String[lista.size()];
        for (int k = 0; k < lista.size(); k++) {
            nomes[k] = lista.get(k).getNome();
        }
        return nomes;
    }

    @Override
    public void cadastrar(Fabricante fabricante) {
        if (verificarNome(fabricante.getNome())) {
            HsMessage.mostrarMensagem(JOptionPane.WARNING_MESSAGE, "Cadastro - Fabricante", "Fabricante já cadastrado.");
        } else {
            if (new FabricanteDaoImpl().cadastrar(fabricante)) {
                HsMessage.mostrarMensagem(JOptionPane.INFORMATION_MESSAGE, "Cadastro - Fabricante", "Fabricante cadastrado com sucesso.");
            } else {
                HsMessage.mostrarMensagem(JOptionPane.ERROR_MESSAGE, "Cadastro - Fabricante", "Erro ao cadastrar fabricante.");
            }
        }
    }

    @Override
    public void atualizar(Fabricante fabricante) {
        HsMessage.mostrarMensagem(JOptionPane.WARNING_MESSAGE, "Fabricante", "Ação não suportada.");
    }

    @Override
    public void deletar(Fabricante fabricante) {
        HsMessage.mostrarMensagem(JOptionPane.WARNING_MESSAGE, "Fabricante", "Ação não suportada.");
    }
}
