/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.schumaker.connection;

import java.sql.Connection;
import org.junit.After;
import org.junit.Before;
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
