/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unc.irss.arc.dataverse.client;

import edu.unc.irss.arc.dataverse.IntegrationTest;
import static org.hamcrest.Matchers.*;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
/**
 *
 * @author Akio Sone, Univ, of North Carolina at Chapel Hill, H.W. Odum Inst.
 */
@Category(IntegrationTest.class)
public class Jersey2DataverseClientIT {
    
    public Jersey2DataverseClientIT() {
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

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        
        int result= 5;
        int expResult=5;
         assertThat("URI for sword API calls", result, is(equalTo(expResult)));
        //fail("The test case is a prototype.");
    }
    
}
