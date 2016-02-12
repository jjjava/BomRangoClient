
package br.com.schumaker.connection;

import java.sql.Connection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hudson
 */
public class HsConnectionTest {

    public HsConnectionTest() {
    }

    /**
     * Test of getConnection method, of class HsConnection.
     */
    @Test
    public void testGetConnection() {
        System.out.println("getConnection");
        Connection result = HsConnection.getConnection();
        assertNotNull(result);
    }
}
