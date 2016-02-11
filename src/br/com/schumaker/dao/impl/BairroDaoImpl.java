package br.com.schumaker.dao.impl;

import br.com.schumaker.bs.impl.LogBsImpl;
import br.com.schumaker.connection.HsConnection;
import br.com.schumaker.dao.BairroDao;
import br.com.schumaker.model.Bairro;
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
public class BairroDaoImpl implements BairroDao {

    public BairroDaoImpl() {
    }

    @Override
    public Bairro obter(Integer id) {

        Connection conn = HsConnection.getConnection();
        PreparedStatement pst = null;
        Bairro bairro = new Bairro();
        try {
            pst = conn.prepareStatement("select * from redeencarte.tb_bairro where tb_bairro.id = " + id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                bairro.setId(rs.getInt("id"));
                bairro.setIdCidade(rs.getInt("idcidade"));
                bairro.setNome(rs.getString("nome"));
            }
        } catch (SQLException ex) {
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
        return bairro;
    }

    @Override
    public List<Bairro> listar() {
        List<Bairro> bairros = new ArrayList<>();
        PreparedStatement pst = null;
        Connection conn = HsConnection.getConnection();
        try {
            pst = conn.prepareStatement("select * from redeencarte.tb_bairro order by bairro.nome");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Bairro bairro = new Bairro();
                bairro.setId(rs.getInt("id"));
                bairro.setIdCidade(rs.getInt("idcidade"));
                bairro.setNome(rs.getString("nome"));
                //---add na lista
                bairros.add(bairro);
            }
        } catch (SQLException ex) {
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
        return bairros;
    }

    public List<Bairro> listar(int id) {
        List<Bairro> bairros = new ArrayList<>();
        PreparedStatement pst = null;
        Connection conn = HsConnection.getConnection();
        try {
            pst = conn.prepareStatement("select * from redeencarte.tb_bairro where idcidade = " + id + " ");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Bairro bairro = new Bairro();
                bairro.setId(rs.getInt("id"));
                bairro.setIdCidade(rs.getInt("idcidade"));
                bairro.setNome(rs.getString("nome"));
                //---add na lista
                bairros.add(bairro);
            }
        } catch (SQLException ex) {
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
        return bairros;
    }

    @Override
    public List<Bairro> like(String s) {
        List<Bairro> bairros = new ArrayList<>();
        PreparedStatement pst = null;
        Connection conn = HsConnection.getConnection();
        try {
            pst = conn.prepareStatement("select * from compras.bairro where bairro.nome like '%" + s + "%' order by bairro.name");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Bairro bairro = new Bairro();
                bairro.setId(rs.getInt("id"));
                bairro.setIdCidade(rs.getInt("idcidade"));
                bairro.setNome(rs.getString("nome"));
                //---add na lista
                bairros.add(bairro);
            }
        } catch (SQLException ex) {
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
        return bairros;
    }

    @Override
    public boolean verificarNome(String nome) {
        boolean validado = false;
        PreparedStatement pst = null;
        Connection conn = HsConnection.getConnection();
        try {
            pst = conn.prepareStatement("select * from compras.bairro where bairro.nome = '" + nome + "'");
            ResultSet rs = pst.executeQuery();
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
                conn.close();
            } catch (SQLException ex) {
                System.err.println(ex);
                LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), ex.getMessage());
            }
        }
        return validado;
    }

    @Override
    public boolean cadastrar(Bairro bairro) {
        boolean cadastrado = false;
        Connection conn = HsConnection.getConnection();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement("insert into compras.cliente ( idcidade, nome ) values (?,?)");
            pst.setInt(1, bairro.getIdCidade());
            pst.setString(2, bairro.getNome());
            pst.execute();
            cadastrado = true;
        } catch (SQLException ex) {
            cadastrado = false;
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
        return cadastrado;
    }

    @Override
    public boolean atualizar(Bairro bairro) {
        boolean atualizado = false;
        Connection conn = HsConnection.getConnection();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement("update compras.tb_bairro set tb_bairro.idcidade=?, bairro.nome=? where tb_bairro.id=?");
            pst.setInt(1, bairro.getIdCidade());
            pst.setString(2, bairro.getNome());
            //where
            pst.setInt(3, bairro.getId());
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
    public boolean deletar(Bairro bairro) {
        throw new UnsupportedOperationException("Not supported.");
    }
}
