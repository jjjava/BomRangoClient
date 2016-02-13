package br.com.schumaker.model;

/**
 * @author hudson schumaker HStudio - @BomRango 10/01/2015
 * @version 1.0.0
 * @since 1.0.0
 * 
 */
public class MensagemContato {

    private String nome;
    private String email;
    private String assunto;
    private String message;

    public MensagemContato() {
    }

    public MensagemContato(String nome, String email, String assunto, String message) {
        this.nome = nome;
        this.email = email;
        this.assunto = assunto;
        this.message = message;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MensagemContato{" + "nome=" + nome + ", email=" + email + ", assunto=" + assunto + ", message=" + message + '}';
    }
    
}
