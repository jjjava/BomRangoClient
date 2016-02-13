package br.com.schumaker.model;

/**
 *
 * @author Hudson Schumaker HStudio - @BomRango 25/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class Seguimento {
    private int id;
    private String nome;
    private String info;
    
    public Seguimento(){
    }

    public Seguimento(int id) {
        this.id = id;
    }

    public Seguimento(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Seguimento(int id, String nome, String info) {
        this.id = id;
        this.nome = nome;
        this.info = info;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Seguimento{" + "id=" + id + ", nome=" + nome + ", info=" + info + '}';
    }
    
}
