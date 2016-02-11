package br.com.schumaker.dao.impl;

import br.com.schumaker.bs.impl.LogBsImpl;
import br.com.schumaker.connection.HsConnection;
import br.com.schumaker.dao.ServerDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 13/06/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class ServerDaoImpl implements ServerDao {

    @Override
    public int getStatus() {
        int status = -1;
        String sql = "select * from redeencarte.tb_server";
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                status = rs.getInt("status");
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
        return status;
    }

    @Override
    public boolean setStatus(int status) {
        boolean atualizado = false;
        String sql = "update redeencarte.tb_server set redeencarte.tb_server.status=? where redeencarte.tb_server.id=?";
        Connection conn = HsConnection.getConnection();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, status);
            //where
            pst.setInt(2, 1);//unica linha da tabela 
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
    public boolean verifyConnection() {
        int status = -1;
        String sql = "select * from redeencarte.tb_server";
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                status = rs.getInt("id");
            }
            pst.close();
        } catch (SQLException ex) {
            status = 0;
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
        return status == 1;
    }
}
