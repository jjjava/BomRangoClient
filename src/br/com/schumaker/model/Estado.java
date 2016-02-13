package br.com.schumaker.model;

/**
 *
 * @author Hudson Schumaker HStudio - @BomRango 13/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class Estado {

    private Integer id;
    private String nome;
    private String uf;

    public Estado() {
    }

    public Estado(int id) {
        this.id = id;
    }

    public Estado(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Estado(Integer id, String nome, String uf) {
        this.id = id;
        this.nome = nome;
        this.uf = uf;
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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "Estado{" + "id=" + id + ", nome=" + nome + ", uf=" + uf + '}';
    }
}
