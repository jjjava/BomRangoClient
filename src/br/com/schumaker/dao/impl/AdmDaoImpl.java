package br.com.schumaker.dao.impl;

import br.com.schumaker.bs.impl.LogBsImpl;
import br.com.schumaker.connection.HsConnection;
import br.com.schumaker.dao.AdmDao;
import br.com.schumaker.model.Adm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Hudson Schumaker HStudio - @BomRango 07/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class AdmDaoImpl implements AdmDao {

    public AdmDaoImpl() {
    }

    @Override
    public Adm obter(Integer id) {
        Connection conn = HsConnection.getConnection();
        Adm adm = new Adm();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement("select * from redeencarte.tb_login where redeencarte.tb_login.id = " + id);
            rs = pst.executeQuery();
            while (rs.next()) {
                adm.setId(rs.getInt("id"));
                adm.setNome(rs.getString("nome"));
                adm.setLogin(rs.getString("login"));
                adm.setEmail(rs.getString("email"));
                adm.setSenha(rs.getString("senha"));//duvida se carregar ou nao 
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
                conn.close();
            } catch (SQLException ex) {
                System.err.println(ex);
                LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
            }
        }
        return adm;
    }

    @Override
    public Adm obter(String email) {
        Connection conn = HsConnection.getConnection();
        Adm adm = new Adm();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement("select * from redeencarte.tb_login where redeencarte.tb_login.login = '" + email + "'");
            rs = pst.executeQuery();
            while (rs.next()) {
                adm.setId(rs.getInt("id"));
                adm.setNome(rs.getString("nome"));
                adm.setLogin(rs.getString("login"));
                adm.setEmail(rs.getString("email"));
                adm.setSenha(rs.getString("senha"));//duvida se carregar ou nao 
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
                conn.close();
            } catch (SQLException ex) {
                System.err.println(ex);
                LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
            }
        }
        return adm;
    }

    @Override
    public List<Adm> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Adm> like(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verificarEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validar(String cryptEmail, String cryptPassword) {
        boolean validado = false;
        Connection conn = HsConnection.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement("select * from redeencarte.tb_login where redeencarte.tb_login.login = '" + cryptEmail + "' and redeencarte.tb_login.senha = '" + cryptPassword + "'");
            rs = pst.executeQuery();
            while (rs.next()) {
                validado = true;
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
                conn.close();
            } catch (SQLException ex) {
                System.err.println(ex);
                LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
            }
        }
        return validado;
    }
}
