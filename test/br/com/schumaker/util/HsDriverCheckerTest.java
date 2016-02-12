package br.com.schumaker.util;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hudson
 */
public class HsDriverCheckerTest {
    
    public HsDriverCheckerTest() {
    }
    
    /**
     * Test of testMySqlDriver method, of class HsDriverChecker.
     */
    @Test
    public void testTestMySqlDriver() {
        System.out.println("testMySqlDriver");
        HsDriverChecker instance = new HsDriverChecker();
        boolean expResult = true;
        boolean result = instance.testMySqlDriver();
        assertEquals(expResult, result);
    }

    /**
     * Test of testMailDriver method, of class HsDriverChecker.
     */
    @Test
    public void testTestMailDriver() {
        System.out.println("testMailDriver");
        HsDriverChecker instance = new HsDriverChecker();
        boolean expResult = true;
        boolean result = instance.testMailDriver();
        assertEquals(expResult, result);
    }
    
}
