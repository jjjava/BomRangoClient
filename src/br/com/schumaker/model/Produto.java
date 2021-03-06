package br.com.schumaker.model;

/**
 *
 * @author Hudson Schumaker HStudio - @BomRango 07/01/2016
 * @version 2.0.0
 * @since 1.0.0
 */
public class Produto {

    private Integer id;
    private String nome;
    private String tipo;
    private String embalagem;
    private String descricao;
    private Double preco;
    private Double quantidade;
    private Loja idmercado;
    private Fabricante idfabricante;
    private Setor idcategoria;
    private Unidade unidade;
    private String imagem;
    private int ativo;

    public Produto() {
        preco = 0.0;
    }

    public Produto(Integer id) {
        this.id = id;
        preco = 0.0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public String getPrecoStr() {
        return "R$" + preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setPrecoSrtToDouble(String preco) {
        this.preco = Double.parseDouble(preco);
    }

    public String getPrecoSrtToDouble() {
        return preco.toString();
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public String getIdmercadoStr() {
        return idmercado.getNome();
    }

    public Loja getMercadoStr() {
        return idmercado;
    }

    public void setIdmercado(Loja idmercado) {
        this.idmercado = idmercado;
    }

    public Fabricante getFabricante() {
        return idfabricante;
    }

    public String getIdfabricanteStr() {
        return idfabricante.getNome();
    }

    public void setIdfabricante(Fabricante idfabricante) {
        this.idfabricante = idfabricante;
    }

    public String getIdcategoriaStr() {
        return idcategoria.getNome();
    }

    public void setIdcategoria(Setor idcategoria) {
        this.idcategoria = idcategoria;
    }

    public int getUnidade() {
        return unidade.getId();
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    public int getIdMercado() {
        return idmercado.getId();
    }

    public int getIdFabricante() {
        return idfabricante.getId();
    }

    public int getIdSetor() {
        return idcategoria.getId();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(String embalagem) {
        this.embalagem = embalagem;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + ", quantidade=" + quantidade + ", idmercado=" + idmercado + ", idfabricante=" + idfabricante + ", idcategoria=" + idcategoria + ", unidade=" + unidade + ", imagem=" + imagem + ", ativo=" + ativo + '}';
    }
}
