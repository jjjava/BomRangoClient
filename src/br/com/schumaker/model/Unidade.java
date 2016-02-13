package br.com.schumaker.model;

/**
 *
 * @author Hudson Schumaker HStudio - @BomRango 07/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class Unidade {

    private Integer id;
    private String nome;
    private String info;

    public Unidade() {
    }

    public Unidade(Integer id) {
        this.id = id;
    }

    public Unidade(String nome, String info) {
        this.nome = nome;
        this.info = info;
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String descricao) {
        this.info = descricao;
    }
    
    @Override
    public String toString(){//para aparecer no combobox
        return getNome();
    }
}
