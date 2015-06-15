package br.com.schumaker.connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 06/06/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class HsConnection {

    public static synchronized Connection getConnection() {
        Connection conn = null;
        try {
            Driver drv = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();

        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.err.println(ex);
        }
        return conn;
    }
}
