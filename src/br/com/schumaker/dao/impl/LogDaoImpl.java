package br.com.schumaker.dao.impl;

import br.com.schumaker.connection.HsConnection;
import br.com.schumaker.dao.LogDao;
import br.com.schumaker.model.Log;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Hudson Schumaker HStudio - @BomRango 04/02/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class LogDaoImpl implements LogDao {
    
    public LogDaoImpl(){    
    }

    @Override
    public void cadastarLog(Log log) {
        String sql = "insert into redeencarte.tb_log ( class, erro, data ) values (?,?,?)";
        Connection conn = HsConnection.getConnection();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, log.getClazz());
            pst.setString(2, log.getError());
            pst.setString(3, log.getDate());
            pst.execute();
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                if(pst != null){
                    pst.close();
                }
                conn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
