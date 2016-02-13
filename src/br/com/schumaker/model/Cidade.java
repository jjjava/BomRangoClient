package br.com.schumaker.model;

/**
 *
 * @author Hudson Schumaker HStudio - @BomRango 13/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class Cidade {
    private Integer id;
    private Integer idEstado;
    private String nome;

    public Cidade() {
    }

    public Cidade(Integer id) {
        this.id = id;
    }

    public Cidade(Integer id, Integer idEstado) {
        this.id = id;
        this.idEstado = idEstado;
    }

    public Cidade(Integer id, Integer idEstado, String nome) {
        this.id = id;
        this.idEstado = idEstado;
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

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    @Override
    public String toString() {
        return "Cidade{" + "id=" + id + ", idEstado=" + idEstado + ", nome=" + nome + '}';
    }
}
