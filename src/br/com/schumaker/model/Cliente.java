package br.com.schumaker.model;

/**
 *
 * @author Hudson Schumaker HStudio - @BomRango 13/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class Cliente {

    private Integer id;
    private Integer idMercado;
    private String nome;
    private String email;
    private String senha;
    private String senha2;

    public Cliente() {
    }

    public Cliente(Integer id, Integer idMercado) {
        this.id = id;
        this.idMercado = idMercado;
    }

    public Cliente(Integer id, Integer idMercado, String nome) {
        this.id = id;
        this.idMercado = idMercado;
        this.nome = nome;
    }

    public Cliente(Integer id, Integer idMercado, String nome, String email) {
        this.id = id;
        this.idMercado = idMercado;
        this.nome = nome;
        this.email = email;
    }

    public Cliente(Integer id, Integer idMercado, String nome, String email, String senha) {
        this.id = id;
        this.idMercado = idMercado;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Cliente(Integer id, Integer idMercado, String nome, String email, String senha, String senha2) {
        this.id = id;
        this.idMercado = idMercado;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.senha2 = senha2;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getIdMercado() {
        return idMercado;
    }

    public void setIdMercado(Integer idMercado) {
        this.idMercado = idMercado;
    }

    public String getSenha2() {
        return senha2;
    }

    public void setSenha2(String senha2) {
        this.senha2 = senha2;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", idMercado=" + idMercado + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", senha2=" + senha2 + '}';
    }
}
