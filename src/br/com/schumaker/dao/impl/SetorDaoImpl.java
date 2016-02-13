package br.com.schumaker.dao.impl;

import br.com.schumaker.bs.impl.LogBsImpl;
import br.com.schumaker.connection.HsConnection;
import br.com.schumaker.dao.SetorDao;
import br.com.schumaker.model.Setor;
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
public class SetorDaoImpl implements SetorDao {

    public SetorDaoImpl() {
    }

    @Override
    public Setor obter(Integer id) {
        String sql = "select * from redeencarte.tb_setor where redeencarte.tb_setor.id = " + id;
        Connection conn = HsConnection.getConnection();
        Setor categoria = new Setor();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                categoria.setId(rs.getInt("id"));
                categoria.setIdSeguimento(rs.getInt("idseguimento"));
                categoria.setNome(rs.getString("nome"));
                categoria.setDescricao(rs.getString("descricao"));
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
        return categoria;
    }

    @Override
    public Setor obter(String nome) {
        String sql = "select * from redeencarte.tb_setor where redeencarte.tb_setor.nome = '" + nome + "'";
        Connection conn = HsConnection.getConnection();
        Setor categoria = new Setor();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                categoria.setId(rs.getInt("id"));
                categoria.setIdSeguimento(rs.getInt("idseguimento"));
                categoria.setNome(rs.getString("nome"));
                categoria.setDescricao(rs.getString("descricao"));
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
        return categoria;
    }

    @Override
    public List<Setor> listar() {
        List<Setor> categorias = new ArrayList<>();
        String sql = "select * from redeencarte.tb_setor order by redeencarte.tb_setor.nome";
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Setor categoria = new Setor();
                categoria.setId(rs.getInt("id"));
                categoria.setIdSeguimento(rs.getInt("idseguimento"));
                categoria.setNome(rs.getString("nome"));
                categoria.setDescricao(rs.getString("descricao"));
                //---add na lista
                categorias.add(categoria);
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
        return categorias;
    }

    @Override
    public List<Setor> like(String s) {
        List<Setor> categorias = new ArrayList<>();
        String sql = "select * from redeencarte.tb_setor where redeencarte.tb_setor.nome like '%" + s + "%' order by redeencarte.tb_setor.nome";
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Setor categoria = new Setor();
                categoria.setId(rs.getInt("id"));
                categoria.setIdSeguimento(rs.getInt("idseguimento"));
                categoria.setNome(rs.getString("nome"));
                categoria.setDescricao(rs.getString("descricao"));
                //adiciona a lista
                categorias.add(categoria);
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
        return categorias;
    }

    @Override
    public boolean verificarNome(String nome) {
        boolean validado = false;
        Connection conn = HsConnection.getConnection();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement("select * from redeencarte.tb_setor where redeencarte.tb_setor.nome = '" + nome + "'");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                validado = true;
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
        } finally {
            try {
                if(pst != null){
                    pst.close();
                }
                conn.close();
            } catch (SQLException ex) {
                System.err.println(ex);
                LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
            }
        }
        return validado;
    }

    @Override
    public boolean cadastrar(Setor setor) {
        boolean cadastrado = false;
        Connection conn = HsConnection.getConnection();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement("insert into redeencarte.tb_setor ( idseguimento, nome, descricao ) values (?,?,?)");
            pst.setInt(1, setor.getIdSeguimento());
            pst.setString(2, setor.getNome());
            pst.setString(3, setor.getDescricao());
            pst.execute();
            cadastrado = true;
        } catch (SQLException ex) {
            cadastrado = false;
            System.err.println(ex);
            LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
        } finally {
            try {
                if(pst != null){
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
    public boolean atualizar(Setor setor) {
        boolean atualizado = false;
        Connection conn = HsConnection.getConnection();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement("update redeencarte.tb_setor set redeencarte.tb_setor.nome=?, redeencarte.tb_setor.descricao=? where redeencarte.tb_setor.id=?");
            pst.setString(1, setor.getNome());
            pst.setString(2, setor.getDescricao());
            //where
            pst.setInt(3, setor.getId());
            pst.executeUpdate();
            atualizado = true;
        } catch (SQLException ex) {
            atualizado = false;
            System.err.println(ex);
            LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
        } finally {
            try {
                if(pst != null){
                    pst.close();
                }
                conn.close();
            } catch (SQLException ex) {
                System.err.println(ex);
                LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
            }
        }
        return atualizado;
    }

    @Override
    public boolean deletar(Setor setor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
