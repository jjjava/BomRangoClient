package br.com.schumaker.bs.impl;

import br.com.schumaker.gfx.FrAlterarSenha;
import br.com.schumaker.gfx.FrLogin;
import br.com.schumaker.model.Adm;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hudson
 */
public class AdmBsImplTest {
    
    public AdmBsImplTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of obter method, of class AdmBsImpl.
     */
    @Test
    public void testObter_Integer() {
        System.out.println("obter");
        Integer id = 1;
        AdmBsImpl instance = new AdmBsImpl();
        Adm expResult = null;
        Adm result = instance.obter(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obter method, of class AdmBsImpl.
     */
    @Test
    public void testObter_String() {
        System.out.println("obter");
        String email = "";
        AdmBsImpl instance = new AdmBsImpl();
        Adm expResult = null;
        Adm result = instance.obter(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listar method, of class AdmBsImpl.
     */
    @Test
    public void testListar() {
        System.out.println("listar");
        AdmBsImpl instance = new AdmBsImpl();
        List<Adm> expResult = null;
        List<Adm> result = instance.listar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of like method, of class AdmBsImpl.
     */
    @Test
    public void testLike() {
        System.out.println("like");
        String s = "";
        AdmBsImpl instance = new AdmBsImpl();
        List<Adm> expResult = null;
        List<Adm> result = instance.like(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificarEmail method, of class AdmBsImpl.
     */
    @Test
    public void testVerificarEmail() {
        System.out.println("verificarEmail");
        String email = "";
        AdmBsImpl instance = new AdmBsImpl();
        boolean expResult = false;
        boolean result = instance.verificarEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validar method, of class AdmBsImpl.
     */
    @Test
    public void testValidar() {
        System.out.println("validar");
        Adm adm = null;
        FrLogin login = null;
        AdmBsImpl instance = new AdmBsImpl();
        instance.validar(adm, login);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of invalidarSessao method, of class AdmBsImpl.
     */
    @Test
    public void testInvalidarSessao() {
        System.out.println("invalidarSessao");
        AdmBsImpl instance = new AdmBsImpl();
        instance.invalidarSessao();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificarNome method, of class AdmBsImpl.
     */
    @Test
    public void testVerificarNome() {
        System.out.println("verificarNome");
        String nome = "";
        AdmBsImpl instance = new AdmBsImpl();
        boolean expResult = false;
        boolean result = instance.verificarNome(nome);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alterarSenha method, of class AdmBsImpl.
     */
    @Test
    public void testAlterarSenha() {
        System.out.println("alterarSenha");
        FrAlterarSenha fr = null;
        String senhaAtual = "";
        String senhaNova = "";
        AdmBsImpl instance = new AdmBsImpl();
        instance.alterarSenha(fr, senhaAtual, senhaNova);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of esqueceuSenha method, of class AdmBsImpl.
     */
    @Test
    public void testEsqueceuSenha() {
        System.out.println("esqueceuSenha");
        String email = "";
        AdmBsImpl instance = new AdmBsImpl();
        instance.esqueceuSenha(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
