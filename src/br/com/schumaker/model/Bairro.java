package br.com.schumaker.model;

/**
 *
 * @author hudson
 */
public class Bairro {
    private Integer id;
    private Integer idCidade;
    private String nome;

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
    
}
