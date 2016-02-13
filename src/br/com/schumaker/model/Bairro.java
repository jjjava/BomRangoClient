package br.com.schumaker.model;

/**
 *
 * @author Hudson Schumaker - HStudio 21/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class Bairro {
    private Integer id;
    private Integer idCidade;
    private String nome;

    public Bairro() {
    }

    public Bairro(Integer id) {
        this.id = id;
    }

    public Bairro(Integer id, Integer idCidade) {
        this.id = id;
        this.idCidade = idCidade;
    }

    public Bairro(Integer id, Integer idCidade, String nome) {
        this.id = id;
        this.idCidade = idCidade;
        this.nome = nome;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Bairro{" + "id=" + id + ", idCidade=" + idCidade + ", nome=" + nome + '}';
    }
}
