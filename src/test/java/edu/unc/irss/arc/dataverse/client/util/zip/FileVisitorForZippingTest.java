/*
 */
package edu.unc.irss.arc.dataverse.client.util.zip;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Akio Sone, Univ, of North Carolina at Chapel Hill, H.W. Odum Inst.
 */
public class FileVisitorForZippingTest {
    
    private static final Logger logger = 
            Logger.getLogger(FileVisitorForZippingTest.class.getName());
    
    private String DV_API_KEY;
    
    public FileVisitorForZippingTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        DV_API_KEY=System.getProperty("DV_API_KEY");
        logger.log(Level.INFO, "TEST_API_KEY={0}", DV_API_KEY);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of visitFile method, of class FileVisitorForZipping.
     */
    @Test
    public void testVisitFile() throws Exception {
        System.out.println("visitFile");
        Path file = null;
        BasicFileAttributes attrs = null;
        FileVisitorForZipping instance = null;
        FileVisitResult expResult = null;
        FileVisitResult result = instance.visitFile(file, attrs);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of preVisitDirectory method, of class FileVisitorForZipping.
     */
    @Test
    public void testPreVisitDirectory() throws Exception {
        System.out.println("preVisitDirectory");
        Path dir = null;
        BasicFileAttributes attrs = null;
        FileVisitorForZipping instance = null;
        FileVisitResult expResult = null;
        FileVisitResult result = instance.preVisitDirectory(dir, attrs);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
