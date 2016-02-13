package br.com.schumaker.model;

/**
 *
 * @author Hudson Schumaker HStudio - @BomRango 13/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class Adm {

    private Integer id;
    private String nome;
    private String email;
    private String login;
    private String senha;

    public Adm() {
    }

    public Adm(Integer id) {
        this.id = id;
    }

    public Adm(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Adm(Integer id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Adm(Integer id, String nome, String email, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "Adm{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", login=" + login + ", senha=" + senha + '}';
    }
}
