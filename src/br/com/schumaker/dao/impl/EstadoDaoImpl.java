package br.com.schumaker.dao.impl;

import br.com.schumaker.bs.impl.LogBsImpl;
import br.com.schumaker.connection.HsConnection;
import br.com.schumaker.dao.EstadoDao;
import br.com.schumaker.model.Cidade;
import br.com.schumaker.model.Estado;
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
public class EstadoDaoImpl implements EstadoDao {

    public EstadoDaoImpl() {
    }

    @Override
    public Estado obter(Integer id) {
        Estado estado = new Estado();
        Connection conn = HsConnection.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement("select * from redeencarte.tb_estado where redeencarte.tb_estado.id = " + id);
            rs = pst.executeQuery();
            while (rs.next()) {
                estado.setId(rs.getInt("id"));
                estado.setNome(rs.getString("nome"));
                estado.setUf(rs.getString("uf"));
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
        return estado;
    }

    @Override
    public List<Estado> listar() {
        List<Estado> estados = new ArrayList<>();
        Connection conn = HsConnection.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement("select * from redeencarte.tb_estado order by redeencarte.tb_estado.nome");
            rs = pst.executeQuery();
            while (rs.next()) {
                Estado estado = new Estado();
                estado.setId(rs.getInt("id"));
                estado.setNome(rs.getString("nome"));
                estado.setUf(rs.getString("uf"));
                //---add na lista
                estados.add(estado);
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
        return estados;
    }

    @Override
    public List<Estado> like(String s) {
        List<Estado> estados = new ArrayList<>();
        Connection conn = HsConnection.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement("select * from compras.estado where estado.nome like '%" + s + "%' order by estado.nome");
            rs = pst.executeQuery();
            while (rs.next()) {
                Estado estado = new Estado();
                estado.setId(rs.getInt("id"));
                estado.setNome(rs.getString("nome"));
                estado.setUf(rs.getString("uf"));
                //---add na lista
                estados.add(estado);
            }
        } catch (SQLException e) {
            System.err.println(e);
            LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), e.getMessage());
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
                LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), e.getMessage());
            }
        }
        return estados;
    }

    @Override
    public boolean cadastrar(Estado estado) {
        boolean cadastrado = false;
        String sql = "insert into compras.estado ( nome, uf ) values (?,?)";
        Connection conn = HsConnection.getConnection();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(2, estado.getNome());
            pst.setString(3, estado.getUf());
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
    public boolean atualizar(Estado estado) {
        boolean atualizado = false;
        String sql = "update compras.estado set estado.nome=?, estado.uf=? where estado.id=?";
        Connection conn = HsConnection.getConnection();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, estado.getNome());
            pst.setString(2, estado.getUf());
            //where
            pst.setInt(3, estado.getId());
            pst.executeUpdate();
            atualizado = true;
        } catch (SQLException e) {
            atualizado = false;
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
        return atualizado;
    }

    @Override
    public boolean deletar(Estado estado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verificarNome(String nome) {
        boolean validado = false;
        Connection conn = HsConnection.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement("select * from compras.estado where estado.nome = '" + nome + "'");
            rs = pst.executeQuery();
            while (rs.next()) {
                validado = true;
            }
        } catch (SQLException e) {
            System.err.println(e);
            LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), e.getMessage());
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
                LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), e.getMessage());
            }
        }
        return validado;
    }

    @Override
    public boolean verificarUf(String uf) {
        boolean validado = false;
        Connection conn = HsConnection.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement("select * from compras.estado where estado.uf = '" + uf + "'");
            rs = pst.executeQuery();
            while (rs.next()) {
                validado = true;
            }
        } catch (SQLException e) {
            System.err.println(e);
            LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), e.getMessage());
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
                LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), e.getMessage());
            }
        }
        return validado;
    }

    @Override
    public boolean verificarCidadeNoEstado(Cidade cidade) {
        boolean verificado = false;
        String sql = "select * from compras.cidade where cidade.id = " + cidade.getId() + " and cidade.idestado = " + cidade.getIdEstado();
        Connection conn = HsConnection.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                verificado = true;
            }
        } catch (SQLException e) {
            System.err.println(e);
            LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), e.getMessage());
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
                LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), e.getMessage());
            }
        }
        return verificado;
    }
}
