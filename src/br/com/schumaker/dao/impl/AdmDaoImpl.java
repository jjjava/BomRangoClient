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
 * @author hudson schumaker Rede Encarte 27/01/16
 */
public class AdmDaoImpl implements AdmDao {

    @Override
    public Adm obter(Integer id) {
        String sql = "select * from redeencarte.tb_login where redeencarte.tb_login.id = " + id;
        Connection conn = HsConnection.getConnection();
        Adm adm = new Adm();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
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
        String sql = "select * from redeencarte.tb_login where redeencarte.tb_login.login = '" + email + "'";
        Connection conn = HsConnection.getConnection();
        Adm adm = new Adm();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
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
        String sql = "select * from redeencarte.tb_login where redeencarte.tb_login.login = '" + cryptEmail + "' and redeencarte.tb_login.senha = '" + cryptPassword + "'";
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
}
