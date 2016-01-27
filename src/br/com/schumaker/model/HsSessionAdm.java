package br.com.schumaker.model;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 06/06/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class HsSessionAdm {

    private static final HsSessionAdm instance = new HsSessionAdm();
    private Adm adm;

    private HsSessionAdm() {
    }

    public static HsSessionAdm getInstance() {
        return instance;
    }

    public boolean cleanSession() {
        setAdm(null);
        return (getAdm() == null);
    }

    public Adm getAdm() {
        return adm;
    }

    public void setAdm(Adm adm) {
        this.adm = adm;
    }
}
