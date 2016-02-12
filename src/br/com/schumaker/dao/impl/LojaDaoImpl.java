package br.com.schumaker.dao.impl;

import br.com.schumaker.bs.impl.LogBsImpl;
import br.com.schumaker.connection.HsConnection;
import br.com.schumaker.dao.LojaDao;
import br.com.schumaker.model.Bairro;
import br.com.schumaker.model.Cidade;
import br.com.schumaker.model.Estado;
import br.com.schumaker.model.Loja;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hudson Schumaker HStudio - @BomRango 06/06/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class LojaDaoImpl implements LojaDao {

    public LojaDaoImpl() {
    }

    @Override
    public Loja obter(Integer id) {
        String sql = "select * redeencarte.tb_loja where redeencarte.tb_loja.id = " + id;
        Connection conn = HsConnection.getConnection();
        Loja mercado = new Loja();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                mercado.setId(rs.getInt("id"));
                mercado.setIdDensidade(rs.getInt("iddensidade"));
                mercado.setNome(rs.getString("nome"));
                mercado.setEndereco(rs.getString("endereco"));
                mercado.setTelefone(rs.getString("tel"));
                mercado.setSite(rs.getString("site"));
                mercado.setCartoes(rs.getString("cartoes"));
                mercado.setCnpj(rs.getString("cnpj"));
                mercado.setHorarioFunc(rs.getString("horario"));
                //   mercado.setFundacao(rs.getString("fundacao"));
                mercado.setSobre(rs.getString("sobre"));
                mercado.setEstacionamento(rs.getInt("estacionamento"));
                //ojbetos
                mercado.setCidade(getMyCidade(rs.getInt("idcidade")));
                mercado.setEstado(getMyEstado(rs.getInt("idestado")));
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
        return mercado;
    }

    @Override
    public List<Loja> listar() {
        List<Loja> mercados = new ArrayList<>();
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement("select * from redeencarte.tb_loja");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Loja mercado = new Loja();
                mercado.setId(rs.getInt("id"));
                mercado.setIdDensidade(rs.getInt("iddensidade"));
                mercado.setNome(rs.getString("nome"));
                mercado.setEndereco(rs.getString("endereco"));
                mercado.setTelefone(rs.getString("tel"));
                mercado.setSite(rs.getString("site"));
                mercado.setCartoes(rs.getString("cartoes"));
                mercado.setCnpj(rs.getString("cnpj"));
                mercado.setHorarioFunc(rs.getString("horario"));
                //   mercado.setFundacao(rs.getString("fundacao"));
                mercado.setSobre(rs.getString("sobre"));
                mercado.setEstacionamento(rs.getInt("garagem"));
                //ojbetos
                mercado.setCidade(getMyCidade(rs.getInt("idcidade")));
                mercado.setEstado(getMyEstado(rs.getInt("idestado")));
                //---add na lista
                mercados.add(mercado);
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
        return mercados;
    }

    @Override
    public List<Loja> like(String s) {
        List<Loja> mercados = new ArrayList<>();
        String sql = "select * from redeencarte.tb_loja where redeencarte.tb_loja.nome like '%" + s + "%' order by redeencarte.tb_loja.nome";
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Loja mercado = new Loja();
                mercado.setId(rs.getInt("id"));
                mercado.setIdDensidade(rs.getInt("iddensidade"));
                mercado.setNome(rs.getString("nome"));
                mercado.setEndereco(rs.getString("endereco"));
                mercado.setTelefone(rs.getString("tel"));
                mercado.setSite(rs.getString("site"));
                mercado.setCartoes(rs.getString("cartoes"));
                mercado.setCnpj(rs.getString("cnpj"));
                mercado.setHorarioFunc(rs.getString("horario"));
                //    mercado.setFundacao(rs.getString("fundacao"));
                mercado.setSobre(rs.getString("sobre"));
                mercado.setEstacionamento(rs.getInt("estacionamento"));
                //ojbetos
                mercado.setCidade(getMyCidade(rs.getInt("idcidade")));
                mercado.setEstado(getMyEstado(rs.getInt("idestado")));
                //---add na lista
                mercados.add(mercado);
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
        return mercados;
    }

    @Override
    public List<Loja> listarPorDensidade(int idDensidade) {
        List<Loja> mercados = new ArrayList<>();
        String sql = "select * from redeencarte.tb_loja where redeencarte.tb_loja.iddensidade =" + idDensidade + " order by redeencarte.tb_loja.nome";
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Loja mercado = new Loja();
                mercado.setId(rs.getInt("id"));
                mercado.setIdDensidade(rs.getInt("iddensidade"));
                mercado.setNome(rs.getString("nome"));
                mercado.setEndereco(rs.getString("endereco"));
                mercado.setTelefone(rs.getString("tel"));
                mercado.setSite(rs.getString("site"));
                mercado.setCartoes(rs.getString("cartoes"));
                mercado.setCnpj(rs.getString("cnpj"));
                mercado.setHorarioFunc(rs.getString("horariofunc"));
//                mercado.setFundacao(rs.getString("fundacao"));
                mercado.setSobre(rs.getString("sobre"));
                mercado.setEstacionamento(rs.getInt("estacionamento"));
                //ojbetos
                mercado.setCidade(getMyCidade(rs.getInt("idcidade")));
                mercado.setEstado(getMyEstado(rs.getInt("idestado")));
                //---add na lista
                mercados.add(mercado);
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
        return mercados;
    }

    @Override
    public boolean verificarNome(String nome) {
        boolean validado = false;
        String sql = "select * from redeencarte.tb_loja where redeencarte.tb_loja.nome = '" + nome + "'";
        Connection conn = HsConnection.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                validado = true;
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
        return validado;
    }

    @Override
    public boolean cadastrar(Loja mercado) {
        boolean cadastrado = false;
        String sql = "insert into redeencarte.tb_loja (idseguimento,iddensidade,idestado,idcidade,idbairro,nome,endereco,tel,site,email,cartoes,razaosocial,cnpj,ie,garagem,sobre,"
                + "imagem,nomeimagem,status ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn = HsConnection.getConnection();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, mercado.getIdSeguimento());
            pst.setInt(2, mercado.getIdDensidade());
            pst.setInt(3, mercado.getEstado());
            pst.setInt(4, mercado.getCidade());
            pst.setInt(5, mercado.getBairro());
            pst.setString(6, mercado.getNome());
            pst.setString(7, mercado.getEndereco());
            pst.setString(8, mercado.getTelefone());
            pst.setString(9, mercado.getSite());
            pst.setString(10, mercado.getEmail());
            pst.setString(11, mercado.getCartoes());
            pst.setString(12, mercado.getRazaoSocial());
            pst.setString(13, mercado.getCnpj());
            pst.setString(14, mercado.getIe());
            pst.setString(15, mercado.getHorarioFunc());
            pst.setInt(15, mercado.getEstacionamento());
            pst.setString(16, mercado.getSobre());

            File image = new File(mercado.getImage());
            FileInputStream fis = new FileInputStream(image);
            pst.setBinaryStream(17, fis, (int) image.length());

            pst.setString(18, mercado.getImagemNome());

            pst.setInt(19, mercado.getAtivo());

            pst.execute();
            cadastrado = true;
        } catch (SQLException | FileNotFoundException ex) {
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
    public boolean atualizar(Loja mercado) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean deletar(Loja mercado) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private Estado getMyEstado(Integer id) {
        return new EstadoDaoImpl().obter(id);
    }

    private Cidade getMyCidade(Integer id) {
        return new CidadeDaoImpl().obter(id);
    }

    private Bairro getMyBairro(Integer id) {
        return new BairroDaoImpl().obter(id);
    }
}
