package br.com.schumaker.util;

/**
 *
 * @author Hudson Schumaker HStudio - @BomRango 14/06/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class HsDriverChecker {

    public boolean testMySqlDriver() {
        boolean driver;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            driver = true;
        } catch (ClassNotFoundException e) {
            driver = false;
            System.err.println(e);
        }
        return driver;
    }

    public boolean testMailDriver() {
        boolean driver;
        try {
            Class.forName("javax.mail.Message");
            driver = true;
        } catch (ClassNotFoundException e) {
            driver = false;
            System.err.println(e);
        }
        return driver;
    }
}
