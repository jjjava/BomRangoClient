package br.com.schumaker.model;

/**
 *
 * @author Hudson Schumaker HStudio - @BomRango 08/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class Palavrao {
    private Integer id;
    private String nome;

    public Palavrao() {
    }

    public Palavrao(Integer id) {
        this.id = id;
    }

    public Palavrao(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
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
        return "Palavrao{" + "id=" + id + ", nome=" + nome + '}';
    }
    
}
