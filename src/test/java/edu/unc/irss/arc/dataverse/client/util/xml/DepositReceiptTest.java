/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unc.irss.arc.dataverse.client.util.xml;

import static org.hamcrest.Matchers.*;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Akio Sone, Univ, of North Carolina at Chapel Hill, H.W. Odum Inst.
 */
public class DepositReceiptTest {
    
    String id ="https://dvn41-akiotest.irss.unc.edu/dvn/api/data-deposit/v1.1/swordv2/edit/study/doi:10.5072/FK2/E8IB8Q";
    String persistentId="doi:10.5072/FK2/E8IB8Q";
    
    public DepositReceiptTest() {
    }
    
    
    
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }



    /**
     * Test of getPersistentId method, of class DepositReceipt.
     */
    @Test
    public void testGetPersistentId() {
        System.out.println("\n\n testing getPersistentId");
        DepositReceipt instance = new DepositReceipt();
        instance.setId(id);
        String expResult = persistentId;
        String result = instance.getPersistentId();
        System.out.println("persistentId="+persistentId);
        assertThat(expResult, is(equalTo(result)));
    }


    
}
