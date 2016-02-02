package br.com.schumaker.dao.impl;

import br.com.schumaker.bs.impl.LogBsImpl;
import br.com.schumaker.connection.HsConnection;
import br.com.schumaker.dao.UnidadeDao;
import br.com.schumaker.model.Unidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 07/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class UnidadeDaoImpl implements UnidadeDao {

    @Override
    public Unidade obter(Integer id) {
        String sql = "select * from redeencarte.tb_unidade where redeencarte.tb_unidade.id = " + id;
        Connection conn = HsConnection.getConnection();
        Unidade unidade = new Unidade();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                unidade.setId(rs.getInt("id"));
                unidade.setNome(rs.getString("nome"));
                unidade.setInfo(rs.getString("info"));
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
        return unidade;
    }

    @Override
    public Unidade obter(String nome) {
        String sql = "select * from redeencarte.tb_unidade where redeencarte.tb_unidade.nome = '" + nome + "'";
        Connection conn = HsConnection.getConnection();
        Unidade unidade = new Unidade();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                unidade.setId(rs.getInt("id"));
                unidade.setNome(rs.getString("nome"));
                unidade.setInfo(rs.getString("info"));
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
        return unidade;
    }

    @Override
    public List<Unidade> listar() {
        List<Unidade> unidades = new ArrayList<>();
        String sql = "select * from redeencarte.tb_unidade order by redeencarte.tb_unidade.nome";
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Unidade unidade = new Unidade();
                unidade.setId(rs.getInt("id"));
                unidade.setNome(rs.getString("nome"));
                unidade.setInfo(rs.getString("info"));
                //---add na lista
                unidades.add(unidade);
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
        return unidades;
    }

    @Override
    public List<Unidade> like(String s) {
        List<Unidade> unidades = new ArrayList<>();
        String sql = "select * from redeencarte.tb_unidade where redeencarte.tb_unidade.nome like '%" + s + "%' order by redeencarte.tb_unidade.nome";
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Unidade unidade = new Unidade();
                unidade.setId(rs.getInt("id"));
                unidade.setNome(rs.getString("nome"));
                unidade.setInfo(rs.getString("info"));
                //---add na lista
                unidades.add(unidade);
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
        return unidades;
    }

    @Override
    public boolean verificarNome(String nome) {
        boolean validado = false;
        String sql = "select * from redeencarte.tb_unidade where redeencarte.tb_unidade.nome = '" + nome + "' order by redeencarte.tb_unidade.nome";
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                validado = true;
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return validado;
    }

    @Override
    public boolean cadastrar(Unidade unidade) {
        boolean cadastrado = false;
        String sql = "insert into redeencarte.tb_unidade ( nome, info ) values (?,?)";
        Connection conn = HsConnection.getConnection();
        PreparedStatement pst = null;
        try {
            conn.setAutoCommit(false);
            pst = conn.prepareStatement(sql);
            pst.setString(1, unidade.getNome());
            pst.setString(2, unidade.getInfo());
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
        } finally {
            try {
                pst.close();
                conn.close();
            } catch (SQLException ex) {
                System.err.println(ex);
                LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
            }
        }
        return cadastrado;
    }

    @Override
    public boolean atualizar(Unidade unidade) {
        boolean atualizado = false;
        String sql = "update redeencarte.tb_unidade set redeencarte.tb_unidade.nome=?, redeencarte.tb_unidade.info=? "
                + "where redeencarte.tb_unidade.id=?";
        Connection conn = HsConnection.getConnection();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, unidade.getNome());
            pst.setString(2, unidade.getInfo());
            //where
            pst.setInt(3, unidade.getId());
            pst.executeUpdate();
            atualizado = true;
        } catch (SQLException ex) {
            atualizado = false;
            System.err.println(ex);
            LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
        } finally {
            try {
                pst.close();
                conn.close();
            } catch (SQLException ex) {
                System.err.println(ex);
                LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
            }
        }
        return atualizado;
    }

    @Override
    public boolean deletar(Unidade unidade) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
