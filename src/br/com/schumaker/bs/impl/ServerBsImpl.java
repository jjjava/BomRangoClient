package br.com.schumaker.bs.impl;

import br.com.schumaker.bs.ServerBs;
import br.com.schumaker.dao.impl.ServerDaoImpl;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 13/06/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class ServerBsImpl implements ServerBs {

    @Override
    public boolean getStatus() {
        return new ServerDaoImpl().getStatus() == 1;
    }

    @Override
    public boolean setStatus(int status) {
        return new ServerDaoImpl().setStatus(status);
    }

    @Override
    public boolean verifyConnection() {
        return new ServerDaoImpl().verifyConnection();
    }
}
