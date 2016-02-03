package br.com.schumaker.model;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 07/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class Setor {

    private Integer id;
    private Integer idSeguimento;
    private String nome;
    private String descricao;

    public Setor() {
    }

    public Setor(Integer id) {
        this.id = id;
    }

    public Setor(Integer id, Integer idSeguimento) {
        this.id = id;
        this.idSeguimento = idSeguimento;
    }

    public Setor(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Setor(Integer idSeguimento, String nome, String descricao) {
        this.idSeguimento = idSeguimento;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Setor(Integer id, Integer idSeguimento, String nome, String descricao) {
        this.id = id;
        this.idSeguimento = idSeguimento;
        this.nome = nome;
        this.descricao = descricao;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {//para aparecer no combobox
        return getNome();
    }

    public Integer getIdSeguimento() {
        return idSeguimento;
    }

    public void setIdSeguimento(Integer idSeguimento) {
        this.idSeguimento = idSeguimento;
    }
}
