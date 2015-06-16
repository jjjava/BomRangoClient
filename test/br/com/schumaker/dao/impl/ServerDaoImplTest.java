/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.schumaker.dao.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hudson
 */
public class ServerDaoImplTest {
    
    public ServerDaoImplTest() {
    }

    /**
     * Test of getStatus method, of class ServerDaoImpl.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        ServerDaoImpl instance = new ServerDaoImpl();
        int expResult = 1;
        int result = instance.getStatus();
        assertEquals(expResult, result);
    }

}
