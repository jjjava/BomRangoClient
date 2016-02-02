package br.com.schumaker.dao.impl;

import br.com.schumaker.bs.impl.LogBsImpl;
import br.com.schumaker.connection.HsConnection;
import br.com.schumaker.dao.FabricanteDao;
import br.com.schumaker.model.Fabricante;
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
public class FabricanteDaoImpl implements FabricanteDao {

    @Override
    public Fabricante obter(Integer id) {
        String sql = "select * redeencarte.tb_fabricante where redeencarte.tb_fabricante.id = " + id;
        Connection conn = HsConnection.getConnection();
        Fabricante fabricante = new Fabricante();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                fabricante.setId(rs.getInt("id"));
                fabricante.setNome(rs.getString("nome"));
                fabricante.setSite(rs.getString("site"));
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
        return fabricante;
    }

    @Override
    public Fabricante obter(String nome) {
        String sql = "select * from redeencarte.tb_fabricante where redeencarte.tb_fabricante.nome = '" + nome + "'";
        Connection conn = HsConnection.getConnection();
        Fabricante fabricante = new Fabricante();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                fabricante.setId(rs.getInt("id"));
                fabricante.setNome(rs.getString("nome"));
                fabricante.setSite(rs.getString("site"));
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
        return fabricante;
    }

    @Override
    public List<Fabricante> listar() {
        List<Fabricante> fabricantes = new ArrayList<>();
        String sql = "select * from redeencarte.tb_fabricante order by redeencarte.tb_fabricante.nome";
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Fabricante fabricante = new Fabricante();
                fabricante.setId(rs.getInt("id"));
                fabricante.setNome(rs.getString("nome"));
                fabricante.setSite(rs.getString("site"));
                //---add na lista
                fabricantes.add(fabricante);
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
        return fabricantes;
    }

    @Override
    public List<Fabricante> like(String s) {
        List<Fabricante> fabricantes = new ArrayList<>();
        String sql = "select * from redeencarte.tb_fabricante where redeencarte.tb_fabricante.nome like '%" + s + "%' order by redeencarte.tb_fabricante.nome";
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Fabricante fabricante = new Fabricante();
                fabricante.setId(rs.getInt("id"));
                fabricante.setNome(rs.getString("nome"));
                fabricante.setSite(rs.getString("site"));
                //---add na lista
                fabricantes.add(fabricante);
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
        return fabricantes;
    }

    @Override
    public boolean verificarNome(String nome) {
        boolean validado = false;
        String sql = "select * from redeencarte.tb_fabricante where redeencarte.tb_fabricante.nome = '" + nome + "'";
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
    public boolean cadastrar(Fabricante fabricante) {
        boolean cadastrado = false;
        String sql = "insert into redeencarte.tb_fabricante (nome, site) values (?,?)";
        Connection conn = HsConnection.getConnection();
        PreparedStatement pst = null;
        try {
            conn.setAutoCommit(false);
            pst = conn.prepareStatement(sql);
            pst.setString(1, fabricante.getNome());
            pst.setString(2, fabricante.getSite());
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
    public boolean atualizar(Fabricante fabricante) {
        boolean atualizado = false;
        String sql = "update redeencarte.tb_fabricante set redeencarte.tb_fabricante.nome=?, redeencarte.tb_fabricante.site=? "
                + "where redeencarte.tb_fabricante.id=?";
        Connection conn = HsConnection.getConnection();
        PreparedStatement pst = null;
        try {
            conn.setAutoCommit(false);
            pst = conn.prepareStatement(sql);
            pst.setString(1, fabricante.getNome());
            pst.setString(2, fabricante.getSite());
            //where
            pst.setInt(3, fabricante.getId());
            pst.executeUpdate();
            conn.commit();
            atualizado = true;
        } catch (SQLException ex) {
            atualizado = false;
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
        return atualizado;
    }

    @Override
    public boolean deletar(Fabricante fabricante) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
