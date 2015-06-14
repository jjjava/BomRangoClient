package br.com.schumaker.model;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 06/06/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class HsSession {

    private static final HsSession instance = new HsSession();
    private Cliente cliente;
    private Mercado mercado;

    private HsSession() {
    }

    public static HsSession getInstance() {
        return instance;
    }

    public boolean cleanSession() {
        cliente = null;
        mercado = null;
        return (cliente == null && mercado == null);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Mercado getMercado() {
        return mercado;
    }

    public void setMercado(Mercado mercado) {
        this.mercado = mercado;
    }
}
