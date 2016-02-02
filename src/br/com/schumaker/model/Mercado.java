package br.com.schumaker.model;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 07/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class Mercado {

    private Integer id;
    private Integer idSeguimento;
    private Integer idDensidade;
    private String nome;
    private String endereco;
    private Cidade cidade;
    private String bairro;
    private Estado estado;
    private String telefone;
    private String site;
    private String email;
    private String cartoes;
    private String razaoSocial;
    private String cnpj;
    private String ie;
    private String horarioFunc;
    private int estacionamento;
    private String sobre;
    private String image;
    private int ativo;

    public Mercado() {
    }

    public Mercado(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdDensidade() {
        return idDensidade;
    }

    public void setIdDensidade(Integer idDensidade) {
        this.idDensidade = idDensidade;
    }

    public Integer getIdSeguimento() {
        return idSeguimento;
    }

    public void setIdSeguimento(Integer idSeguimento) {
        this.idSeguimento = idSeguimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getCartoes() {
        return cartoes;
    }

    public void setCartoes(String cartoes) {
        this.cartoes = cartoes;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getHorarioFunc() {
        return horarioFunc;
    }

    public void setHorarioFunc(String horarioFunc) {
        this.horarioFunc = horarioFunc;
    }

    public String getCidadeStr() {
        return cidade.getNome();
    }

    public int getCidade() {
        return cidade.getId();
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstadoStr() {
        return estado.getNome();
    }

    public int getEstado() {
        return estado.getId();
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    public int getEstacionamento() {
        return estacionamento;
    }

    public void setEstacionamento(int estacionamento) {
        this.estacionamento = estacionamento;
    }

    @Override
    public String toString() {//para aparecer no combobox
        return getNome();
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getSobre() {
        return sobre;
    }

    public void setSobre(String sobre) {
        this.sobre = sobre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
