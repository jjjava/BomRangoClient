package br.com.schumaker.dao;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 13/06/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ServerDao {
    public int getStatus();
    public boolean setStatus(int status);
    public boolean verifyConnection();
}
