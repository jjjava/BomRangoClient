package br.com.schumaker.dao.impl;

import br.com.schumaker.bs.impl.LogBsImpl;
import br.com.schumaker.connection.HsConnection;
import br.com.schumaker.dao.SeguimentoDao;
import br.com.schumaker.model.Seguimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hudson Schumaker HStudio - @BomRango 12/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class SeguimentoDaoImpl implements SeguimentoDao {

    public SeguimentoDaoImpl() {
    }

    @Override
    public Seguimento obter(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Seguimento obter(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Seguimento> listar() {
        List<Seguimento> seguimentos = new ArrayList<>();
        Connection conn = HsConnection.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement("select * from redeencarte.tb_seguimento");
            rs = pst.executeQuery();
            while (rs.next()) {
                Seguimento seguimento = new Seguimento();
                seguimento.setId(rs.getInt("id"));
                seguimento.setNome(rs.getString("nome"));
                seguimento.setInfo(rs.getString("info"));
                //---add na lista
                seguimentos.add(seguimento);
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
        return seguimentos;
    }

    public List<Seguimento> listar(int id) {
        List<Seguimento> seguimentos = new ArrayList<>();
        Connection conn = HsConnection.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement("select * from redeencarte.tb_seguimento where id = " + id);
            rs = pst.executeQuery();
            while (rs.next()) {
                Seguimento seguimento = new Seguimento();
                seguimento.setId(rs.getInt("id"));
                seguimento.setNome(rs.getString("nome"));
                seguimento.setInfo(rs.getString("info"));
                //---add na lista
                seguimentos.add(seguimento);
            }
            pst.close();
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
        return seguimentos;
    }

    @Override
    public List<Seguimento> like(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verificarNome(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cadastrar(Seguimento seg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Seguimento seg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Seguimento seg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
