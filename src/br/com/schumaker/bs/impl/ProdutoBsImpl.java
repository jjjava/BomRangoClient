package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.ProdutoBs;
import br.com.schumaker.dao.impl.FabricanteDaoImpl;
import br.com.schumaker.dao.impl.ProdutoDaoImpl;
import br.com.schumaker.model.Fabricante;
import br.com.schumaker.model.Produto;
import br.com.schumaker.model.Setor;
import br.com.schumaker.model.Unidade;
import br.com.schumaker.util.FileFilterReadPool;
import br.com.schumaker.util.HsMessage;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 06/06/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class ProdutoBsImpl implements ProdutoBs {

    private static final ProdutoBsImpl instance = new ProdutoBsImpl();
    private Produto produto;

    private ProdutoBsImpl() {
        produto = new Produto();
    }

    public static ProdutoBsImpl getInstance() {
        return instance;
    }

    @Override
    public Produto obter(Integer id) {
        return new ProdutoDaoImpl().obter(id);
    }

    @Override
    public List<Produto> listar() {
        return new ProdutoDaoImpl().listar();
    }

    @Override
    public List<Produto> listar(int limite) {
        return new ProdutoDaoImpl().listar(limite);
    }

    @Override
    public List<Produto> listar(String nome) {
        return new ProdutoDaoImpl().listar(nome);
    }

    @Override
    public List<Produto> listar(String nome, int limite) {
        return new ProdutoDaoImpl().listar(nome, limite);
    }

    @Override
    public List<Produto> listarELike(String nome) {
        List<Produto> listaNome = new ProdutoDaoImpl().listar(nome);
        List<Produto> listaLike = new ProdutoDaoImpl().like(nome);
        for (Produto p : listaLike) {
            listaNome.add(p);
        }
        return listaNome;
    }

    @Override
    public List<Produto> listarELike(String nome, int limite) {
        List<Produto> listaNome = new ProdutoDaoImpl().listar(nome, limite);
        List<Produto> listaLike = new ProdutoDaoImpl().like(nome, limite);
        for (Produto p : listaLike) {
            listaNome.add(p);
        }
        return listaNome;
    }

    @Override
    public List<Produto> like(String s) {
        return new ProdutoDaoImpl().like(s);
    }

    @Override
    public List<Produto> like(String s, int limite) {
        return new ProdutoDaoImpl().like(s, limite);
    }

    @Override
    public boolean verificarNome(String nome) {
        return new ProdutoDaoImpl().verificarNome(nome);
    }

    @Override
    public boolean verificarFabricante(String nome) {
        return new ProdutoDaoImpl().verificarFabricante(nome);
    }

    @Override
    public void cadastrar(Produto produto) {
        Fabricante fabricante = new FabricanteDaoImpl().obter(produto.getIdFabricante());
        if (verificarNome(produto.getNome()) && verificarFabricante(fabricante.getNome())) {
            HsMessage.mostrarMensagem(JOptionPane.WARNING_MESSAGE, "Cadastro - Produto", "Produto já existente.");
        } else {
            if (new ProdutoDaoImpl().cadastrar(produto)) {
                HsMessage.mostrarMensagem(JOptionPane.INFORMATION_MESSAGE, "Cadastro - Produto", "Produto cadastrado com sucesso.");
            } else {
                HsMessage.mostrarMensagem(JOptionPane.ERROR_MESSAGE, "Cadastro - Produto", "Erro ao cadastrar produto.");
            }
        }
    }

    @Override
    public void atualizar(Produto produto) {
        HsMessage.mostrarMensagem(JOptionPane.WARNING_MESSAGE, "Produto", "Não suportado ainda");
    }

    @Override
    public void deletar(Produto produto) {
        HsMessage.mostrarMensagem(JOptionPane.WARNING_MESSAGE, "Produto", "Não suportado ainda");
    }

    public void primeiraEtapaCadastro(Produto p, Setor s, Fabricante f, Unidade u) {
        p.setIdcategoria(new SetorBsImpl().obter(s.getNome()));
        p.setIdfabricante(new FabricanteBsImpl().obter(f.getNome()));
        p.setUnidade(new UnidadeBsImpl().obter(u.getNome()));
        p.setIdmercado(new MercadoBsImpl().getMercadoSessao());
        p.setAtivo(1);//validacao com inteiro

        setCadProdutoSessao(p);
    }

    public void segundaEtapaCadastro() {
        Produto p = getCadProdutoSessao();
    }

    private void setCadProdutoSessao(Produto produto) {

    }

    public Produto getCadProdutoSessao() {
        return null; //voltar aqui

    }

    public void carregarImagem() {
        JFileChooser chooser = new JFileChooser(System.getProperty("user.home"));
        for (int k = 0; k < FileFilterReadPool.getInstance().getInitialSize(); k++) {
            chooser.addChoosableFileFilter(FileFilterReadPool.getInstance().aquire());
        }
        chooser.setAcceptAllFileFilterUsed(false);//support all files
        chooser.setDialogTitle("Abrir arquivo");
        chooser.setApproveButtonText("Abrir");
        int sf = chooser.showOpenDialog(null);
        if (sf == JFileChooser.APPROVE_OPTION) {
            produto.setImagem(chooser.getSelectedFile().getAbsolutePath());
            System.out.println(produto.getImagem());
        }
    }
}
