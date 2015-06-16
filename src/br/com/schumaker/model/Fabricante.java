package br.com.schumaker.model;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 07/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class Fabricante {

    private Integer id;
    private String nome;
    private String site;

    public Fabricante() {
    }

    public Fabricante(Integer id) {
        this.id = id;
    }

    public Fabricante(String nome) {
        this.nome = nome;
    }

    public Fabricante(String nome, String site) {
        this.nome = nome;
        this.site = site;
    }

    public Fabricante(Integer id, String nome, String site) {
        this.id = id;
        this.nome = nome;
        this.site = site;
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

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    @Override
    public String toString() {//para aparecer no combobox
        return getNome();
    }
}
