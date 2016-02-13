package br.com.schumaker.dao.impl;

import br.com.schumaker.bs.impl.LogBsImpl;
import br.com.schumaker.connection.HsConnection;
import br.com.schumaker.dao.CidadeDao;
import br.com.schumaker.model.Cidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hudson Schumaker HStudio - @BomRango 07/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class CidadeDaoImpl implements CidadeDao {

    public CidadeDaoImpl() {
    }

    @Override
    public Cidade obter(Integer id) {
        Connection conn = HsConnection.getConnection();
        Cidade cidade = new Cidade();
        try {
            PreparedStatement pst = conn.prepareStatement("select * from redeencarte.tb_cidade where redeencarte.tb_cidade.id = " + id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                cidade.setId(rs.getInt("id"));
                cidade.setIdEstado(rs.getInt("idestado"));
                cidade.setNome(rs.getString("nome"));
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
        return cidade;
    }

    @Override
    public List<Cidade> listar() {
        List<Cidade> cidades = new ArrayList<>();
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement("select * from redeencarte.tb_cidade order by cidade.nome");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Cidade cidade = new Cidade();
                cidade.setId(rs.getInt("id"));
                cidade.setIdEstado(rs.getInt("idestado"));
                cidade.setNome(rs.getString("nome"));
                //---add na lista
                cidades.add(cidade);
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
        return cidades;
    }

    public List<Cidade> listar(int id) {
        List<Cidade> cidades = new ArrayList<>();
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement("select * from redeencarte.tb_cidade where idestado = " + id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Cidade cidade = new Cidade();
                cidade.setId(rs.getInt("id"));
                cidade.setIdEstado(rs.getInt("idestado"));
                cidade.setNome(rs.getString("nome"));
                //---add na lista
                cidades.add(cidade);
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
        return cidades;
    }

    @Override
    public List<Cidade> like(String s) {
        List<Cidade> cidades = new ArrayList<>();
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement("select * from redeencarte.tb_cidade where cidade.nome like '%" + s + "%' order by cidade.name");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Cidade cidade = new Cidade();
                cidade.setId(rs.getInt("id"));
                cidade.setIdEstado(rs.getInt("idestado"));
                cidade.setNome(rs.getString("nome"));
                //---add na lista
                cidades.add(cidade);
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
        return cidades;
    }

    @Override
    public boolean verificarNome(String nome) {
        boolean validado = false;
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement("select * from redeencarte.tb_cidade where cidade.nome = '" + nome + "'");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                validado = true;
            }
            pst.close();
        } catch (SQLException e) {
            System.err.println(e);
            LogBsImpl.getInstance().inserirLog(this.getClass().getSimpleName(), e.getMessage());
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
    public boolean cadastrar(Cidade cidade) {
        boolean cadastrado = false;
        Connection conn = HsConnection.getConnection();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement("insert into redeencarte.tb_cidade ( idestado, nome ) values (?,?)");
            pst.setInt(1, cidade.getIdEstado());
            pst.setString(2, cidade.getNome());
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
    public boolean atualizar(Cidade cidade) {
        boolean atualizado = false;
        Connection conn = HsConnection.getConnection();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement("update redeencarte.tb_cidade set cidade.idestado=?, cidade.nome=? where cidade.id=?");
            pst.setInt(1, cidade.getIdEstado());
            pst.setString(2, cidade.getNome());
            //where
            pst.setInt(3, cidade.getId());
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
    public boolean deletar(Cidade cidade) {
        throw new UnsupportedOperationException("Not supported.");
    }
}
