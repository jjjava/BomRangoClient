package br.com.schumaker.bs;

/**
 *
 * @author Hudson Schumaker HStudio - @BomRango 13/06/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ServerBs {
    public boolean getStatus();
    public boolean setStatus(int status);
    public boolean verifyConnection();
}
