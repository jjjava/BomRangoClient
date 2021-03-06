package br.com.schumaker.dao.impl;

import br.com.schumaker.bs.impl.LogBsImpl;
import br.com.schumaker.connection.HsConnection;
import br.com.schumaker.dao.ProdutoDao;
import br.com.schumaker.model.Setor;
import br.com.schumaker.model.Fabricante;
import br.com.schumaker.model.Loja;
import br.com.schumaker.model.Produto;
import br.com.schumaker.model.Unidade;
import br.com.schumaker.util.HsCommons;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hudson Schumaker HStudio - @BomRango 07/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class ProdutoDaoImpl implements ProdutoDao {

    public ProdutoDaoImpl() {
    }

    @Override
    public Produto obter(Integer id) {
        String sql = "select * from compras.produto where produto.id = " + id;
        Connection conn = HsConnection.getConnection();
        Produto produto = new Produto();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                //---chaves estrangeiras
                produto.setIdcategoria(getMyCategoria(rs.getInt("idcategoria")));
                produto.setIdfabricante(getMyFabricante(rs.getInt("idfabricante")));
                produto.setIdmercado(getMyMercado(rs.getInt("idmercado")));
                produto.setUnidade(getMyUnidade(rs.getInt("unidade")));
                //---chaves estrangeiras
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setQuantidade(rs.getDouble("quantidade"));
                produto.setImagem(rs.getString("imagem"));
                produto.setAtivo(rs.getInt("ativo"));
            }
            pst.close();
        } catch (SQLException ex) {
            System.err.println(ex);
            LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.err.println(ex);
                LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
            }
        }
        return produto;
    }

    @Override
    public List<Produto> listar() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "select * from compras.produto order by produto.preco";
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                //---chaves estrangeiras
                produto.setIdcategoria(getMyCategoria(rs.getInt("idcategoria")));
                produto.setIdfabricante(getMyFabricante(rs.getInt("idfabricante")));
                produto.setIdmercado(getMyMercado(rs.getInt("idmercado")));
                produto.setUnidade(getMyUnidade(rs.getInt("unidade")));
                //---chaves estrangeiras
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setQuantidade(rs.getDouble("quantidade"));
                produto.setImagem(rs.getString("imagem"));
                produto.setAtivo(rs.getInt("ativo"));
                //---add na lista
                produtos.add(produto);
            }
            pst.close();
        } catch (SQLException ex) {
            System.err.println(ex);
            LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.err.println(ex);
                LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
            }
        }
        return produtos;
    }

    @Override
    public List<Produto> listar(int limite) {
        List<Produto> produtos = new ArrayList<>();
        String sql = "select * from compras.produto where produto.ativo=" + HsCommons.PRODATIV + " order by produto.preco limit " + limite;
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                //---chaves estrangeiras
                produto.setIdcategoria(getMyCategoria(rs.getInt("idcategoria")));
                produto.setIdfabricante(getMyFabricante(rs.getInt("idfabricante")));
                produto.setIdmercado(getMyMercado(rs.getInt("idmercado")));
                produto.setUnidade(getMyUnidade(rs.getInt("unidade")));
                //---chaves estrangeiras
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setQuantidade(rs.getDouble("quantidade"));
                produto.setImagem(rs.getString("imagem"));
                produto.setAtivo(rs.getInt("ativo"));
                //---add na lista
                produtos.add(produto);
            }
            pst.close();
        } catch (SQLException ex) {
            System.err.println(ex);
            LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.err.println(ex);
                LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
            }
        }
        return produtos;
    }

    @Override
    public List<Produto> listar(String nome) {
        List<Produto> produtos = new ArrayList<>();
        String sql = "select * from compras.produto where produto.nome = '" + nome + "' and produto.ativo=" + HsCommons.PRODATIV + " order by produto.preco";
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                //---chaves estrangeiras
                produto.setIdcategoria(getMyCategoria(rs.getInt("idcategoria")));
                produto.setIdfabricante(getMyFabricante(rs.getInt("idfabricante")));
                produto.setIdmercado(getMyMercado(rs.getInt("idmercado")));
                produto.setUnidade(getMyUnidade(rs.getInt("unidade")));
                //---chaves estrangeiras
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setQuantidade(rs.getDouble("quantidade"));
                produto.setImagem(rs.getString("imagem"));
                produto.setAtivo(rs.getInt("ativo"));
                //---add na lista
                produtos.add(produto);
            }
            pst.close();
        } catch (SQLException ex) {
            System.err.println(ex);
            LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.err.println(ex);
                LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
            }
        }
        return produtos;
    }

    @Override
    public List<Produto> listar(String nome, int limite) {
        List<Produto> produtos = new ArrayList<>();
        String sql = "select * from compras.produto where produto.nome ='" + nome + "' and produto.ativo=" + HsCommons.PRODATIV + " order by produto.preco limit " + limite;
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                //---chaves estrangeiras
                produto.setIdcategoria(getMyCategoria(rs.getInt("idcategoria")));
                produto.setIdfabricante(getMyFabricante(rs.getInt("idfabricante")));
                produto.setIdmercado(getMyMercado(rs.getInt("idmercado")));
                produto.setUnidade(getMyUnidade(rs.getInt("unidade")));
                //---chaves estrangeiras
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setQuantidade(rs.getDouble("quantidade"));
                produto.setImagem(rs.getString("imagem"));
                produto.setAtivo(rs.getInt("ativo"));
                //---add na lista
                produtos.add(produto);
            }
            pst.close();
        } catch (SQLException ex) {
            System.err.println(ex);
            LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.err.println(ex);
                LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
            }
        }
        return produtos;
    }

    @Override
    public List<Produto> like(String s) {
        List<Produto> produtos = new ArrayList<>();
        String sql = "select * from compras.produto where produto.nome like '%" + s + "%' and produto.ativo=" + HsCommons.PRODATIV + " order by produto.preco";
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            int k = 0;
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                //---chaves estrangeiras
                produto.setIdcategoria(getMyCategoria(rs.getInt("idcategoria")));
                produto.setIdfabricante(getMyFabricante(rs.getInt("idfabricante")));
                produto.setIdmercado(getMyMercado(rs.getInt("idmercado")));
                produto.setUnidade(getMyUnidade(rs.getInt("unidade")));
                //---chaves estrangeiras
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setQuantidade(rs.getDouble("quantidade"));
                produto.setImagem(rs.getString("imagem"));
                produto.setAtivo(rs.getInt("ativo"));
                //---add na lista
                produtos.add(produto);
                k++;
            }
            pst.close();
        } catch (SQLException ex) {
            System.err.println(ex);
            LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.err.println(ex);
                LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
            }
        }
        return produtos;
    }

    @Override
    public List<Produto> like(String s, int limite) {
        List<Produto> produtos = new ArrayList<>();
        String sql = "select * from compras.produto where produto.nome like '%" + s + "%' and produto.ativo=" + HsCommons.PRODATIV + " order by produto.preco limit " + limite;
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            int k = 0;
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                //---chaves estrangeiras
                produto.setIdcategoria(getMyCategoria(rs.getInt("idcategoria")));
                produto.setIdfabricante(getMyFabricante(rs.getInt("idfabricante")));
                produto.setIdmercado(getMyMercado(rs.getInt("idmercado")));
                produto.setUnidade(getMyUnidade(rs.getInt("unidade")));
                //---chaves estrangeiras
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setQuantidade(rs.getDouble("quantidade"));
                produto.setImagem(rs.getString("imagem"));
                produto.setAtivo(rs.getInt("ativo"));
                //---add na lista
                produtos.add(produto);
                k++;
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.err.println(ex);
                LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
            }
        }
        return produtos;
    }

    public List<Produto> listarPorCategoria(int idCategoria, int limite) {
        List<Produto> produtos = new ArrayList<>();
        String sql = "select * from compras.produto where produto.idcategoria=" + idCategoria + " and produto.ativo=" + HsCommons.PRODATIV + "  order by produto.preco limit " + limite;
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                //---chaves estrangeiras
                produto.setIdcategoria(getMyCategoria(rs.getInt("idcategoria")));
                produto.setIdfabricante(getMyFabricante(rs.getInt("idfabricante")));
                produto.setIdmercado(getMyMercado(rs.getInt("idmercado")));
                produto.setUnidade(getMyUnidade(rs.getInt("unidade")));
                //---chaves estrangeiras
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setQuantidade(rs.getDouble("quantidade"));
                produto.setImagem(rs.getString("imagem"));
                produto.setAtivo(rs.getInt("ativo"));
                //---add na lista
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.err.println(ex);
                LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
            }
        }
        return produtos;
    }

    @Override
    public boolean verificarNome(String nome) {
        boolean validado = false;
        String sql = "select * from compras.produto where produto.nome = '" + nome + "'";
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                validado = true;
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.err.println(ex);
                LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
            }
        }
        return validado;
    }

    @Override
    public boolean verificarFabricante(String nome) {
        boolean validado = false;
        String sql = "select * from compras.produto where produto.marca = '" + nome + "'";
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                validado = true;
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.err.println(ex);
                LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
            }
        }
        return validado;
    }

    @Override
    public boolean cadastrar(Produto produto) {
        boolean cadastrado = false;
        String sql = "insert into redeencarte.tb_produto (nome,tipo,idfabricante,idcategoria,embalagem,idunidade,qtd,imagem,ativo) "
                + " values (?,?,?,?,?,?,?,?,?)";
        Connection conn = HsConnection.getConnection();
        PreparedStatement pst = null;
        FileInputStream fis = null;
        try {
            conn.setAutoCommit(false);

            File file = new File(produto.getImagem());//prepara inserção da imagem
            fis = new FileInputStream(file);

            pst = conn.prepareStatement(sql);
            pst.setString(1, produto.getNome());
            pst.setString(2, produto.getTipo());
            pst.setInt(3, produto.getIdFabricante());
            pst.setInt(4, produto.getIdSetor());
            pst.setString(5, produto.getEmbalagem());
            pst.setInt(6, produto.getUnidade());
            pst.setDouble(7, produto.getQuantidade());
            pst.setBinaryStream(9, fis, file.length());
            pst.setInt(10, produto.getAtivo());

            pst.execute();
            conn.commit();
            cadastrado = true;
        } catch (SQLException ex) {
            cadastrado = false;
            try {
                conn.rollback();
            } catch (SQLException ex2) {
                System.err.println(ex);
                LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex2.getMessage());
            }
            System.err.println(ex);
            LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
            LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (fis != null) {
                    fis.close();
                }
                conn.close();
            } catch (SQLException | IOException ex) {
                System.err.println(ex);
                LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
            }
        }
        return cadastrado;
    }

    @Override
    public boolean atualizar(Produto produto) {
        boolean cadastrado = false;
        String sql = "update compras.produto set produto.nome=?, produto.descricao=?,"
                + " produto.preco=?, produto.quantidade=? ,produto.categoria=?"
                + " produto.imagem=?, produto.ativo=? "
                + " where produto.id=?";
        Connection conn = HsConnection.getConnection();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, produto.getNome());
            pst.setString(2, produto.getDescricao());
            pst.setDouble(3, produto.getPreco());
            pst.setDouble(4, produto.getQuantidade());
            pst.setInt(5, produto.getIdSetor());
            pst.setString(6, produto.getImagem());
            pst.setInt(7, produto.getAtivo());
            //where
            pst.setInt(8, produto.getId());
            pst.executeUpdate();
            cadastrado = true;
        } catch (SQLException ex) {
            cadastrado = false;
            System.err.println(ex);
            LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                conn.close();
            } catch (SQLException ex) {
                System.err.println(ex);
                LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
            }
        }
        return cadastrado;
    }

    @Override
    public boolean deletar(Produto produto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Setor getMyCategoria(Integer id) {
        SetorDaoImpl categoriaDaoImpl = new SetorDaoImpl();
        return categoriaDaoImpl.obter(id);
    }

    private Fabricante getMyFabricante(Integer id) {
        FabricanteDaoImpl fabricanteDaoImpl = new FabricanteDaoImpl();
        return fabricanteDaoImpl.obter(id);
    }

    private Loja getMyMercado(Integer id) {
        LojaDaoImpl mercadoDaoImpl = new LojaDaoImpl();
        return mercadoDaoImpl.obter(id);
    }

    private Unidade getMyUnidade(Integer id) {
        UnidadeDaoImpl unidadeDaoImpl = new UnidadeDaoImpl();
        return unidadeDaoImpl.obter(id);
    }
}
