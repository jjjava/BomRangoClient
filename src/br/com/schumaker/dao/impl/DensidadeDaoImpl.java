package br.com.schumaker.dao.impl;

import br.com.schumaker.bs.impl.LogBsImpl;
import br.com.schumaker.connection.HsConnection;
import br.com.schumaker.dao.DensidadeDao;
import br.com.schumaker.model.Densidade;
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
public class DensidadeDaoImpl implements DensidadeDao {

    public DensidadeDaoImpl() {
    }

    @Override
    public Densidade obter(Integer id) {
        Densidade densidade = new Densidade();
        Connection conn = HsConnection.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement("select * from compras.densidade where densidade.id = " + id);
            rs = pst.executeQuery();
            while (rs.next()) {
                densidade.setId(rs.getInt("id"));
                densidade.setNome(rs.getString("nome"));
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
                System.err.println(ex);//throw new RuntimeException(e);
                LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
            }
        }
        return densidade;
    }

    @Override
    public List<Densidade> listar() {
        List<Densidade> densidades = new ArrayList<>();
        Connection conn = HsConnection.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement("select * from redeencarte.tb_densidade order by redeencarte.tb_densidade.id");
            rs = pst.executeQuery();
            while (rs.next()) {
                Densidade densidade = new Densidade();
                densidade.setId(rs.getInt("id"));
                densidade.setNome(rs.getString("nome"));
                //---add na lista
                densidades.add(densidade);
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
        return densidades;
    }

    public List<Densidade> listar(int id) {
        List<Densidade> densidades = new ArrayList<>();
        Connection conn = HsConnection.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement("select * from redeencarte.tb_densidade where id = " + id);
            rs = pst.executeQuery();
            while (rs.next()) {
                Densidade densidade = new Densidade();
                densidade.setId(rs.getInt("id"));
                densidade.setNome(rs.getString("nome"));
                //---add na lista
                densidades.add(densidade);
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
        return densidades;
    }

    @Override
    public List<Densidade> like(String s) {
        List<Densidade> densidades = new ArrayList<>();
        Connection conn = HsConnection.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement("select * from compras.densidade where densidade.nome like '%" + s + "%'");
            rs = pst.executeQuery();
            while (rs.next()) {
                Densidade densidade = new Densidade();
                densidade.setId(rs.getInt("id"));
                densidade.setNome(rs.getString("nome"));
                //---add na lista
                densidades.add(densidade);
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
            }
        }
        return densidades;
    }

    @Override
    public boolean verificarNome(String nome) {
        boolean validado = false;
        Connection conn = HsConnection.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement("select * from compras.densidade where densidade.nome = '" + nome + "'");
            rs = pst.executeQuery();
            while (rs.next()) {
                validado = true;
            }
            pst.close();
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
                conn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return validado;
    }

    @Override
    public boolean cadastrar(Densidade densidade) {
        boolean cadastrado = false;
        String sql = "insert into compras.densidade (nome) values (?)";
        Connection conn = HsConnection.getConnection();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, densidade.getNome());
            pst.execute();
            cadastrado = true;
        } catch (SQLException e) {
            cadastrado = false;
            System.err.println(e);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                conn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return cadastrado;
    }

    @Override
    public boolean atualizar(Densidade densiadade) {
        boolean atualizado = false;
        String sql = "update compras.densidade set densidade.nome=? where densidade.id=?";
        Connection conn = HsConnection.getConnection();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, densiadade.getNome());
            //where
            pst.setInt(2, densiadade.getId());
            pst.executeUpdate();
            atualizado = true;
        } catch (SQLException ex) {
            atualizado = false;
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
    public boolean deletar(Densidade densidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
