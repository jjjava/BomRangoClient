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
 * @author Hudson Schumaker HStudio - @BomRango 13/06/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class ServerDaoImpl implements ServerDao {

    public ServerDaoImpl() {
    }

    @Override
    public int getStatus() {
        int status = -1;
        Connection conn = HsConnection.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement("select * from redeencarte.tb_server");
            rs = pst.executeQuery();
            while (rs.next()) {
                status = rs.getInt("status");
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
        return status;
    }

    @Override
    public boolean setStatus(int status) {
        boolean atualizado = false;
        Connection conn = HsConnection.getConnection();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement("update redeencarte.tb_server set redeencarte.tb_server.status=? where redeencarte.tb_server.id=?");
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
                if (pst != null) {
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
        Connection conn = HsConnection.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement("select * from redeencarte.tb_server");
            rs = pst.executeQuery();
            while (rs.next()) {
                status = rs.getInt("id");
            }
        } catch (SQLException ex) {
            status = 0;
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
        return status == 1;
    }
}
