package br.com.schumaker.model;

/**
 *
 * @author Hudson Schumaker HStudio - @BomRango 12/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class Densidade {
    private Integer id;
    private String nome;

    public Densidade() {
    }

    public Densidade(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Densidade(String nome) {
        this.nome = nome;
    }

    public Densidade(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Densidade{" + "id=" + id + ", nome=" + nome + '}';
    }
}
