package br.com.schumaker.model;

/**
 *
 * @author Hudson Schumaker HStudio - @BomRango 06/06/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class HsSessionCliente {

    private static final HsSessionCliente instance = new HsSessionCliente();
    private Cliente cliente;
    private Loja mercado;

    private HsSessionCliente() {
    }

    public static HsSessionCliente getInstance() {
        return instance;
    }

    public boolean cleanSession() {
        cliente = null;
        mercado = null;
        return (true);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Loja getMercado() {
        return mercado;
    }

    public void setMercado(Loja mercado) {
        this.mercado = mercado;
    }
}
