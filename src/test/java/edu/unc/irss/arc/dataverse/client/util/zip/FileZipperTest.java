/*
 */
package edu.unc.irss.arc.dataverse.client.util.zip;

import java.nio.file.Path;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Akio Sone, Univ, of North Carolina at Chapel Hill, H.W. Odum Inst.
 */
public class FileZipperTest {
    
    public FileZipperTest() {
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
     * Test of create method, of class FileZipper.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        String zipFilename = "";
        Path srcPath = null;
        Path relativizeBase = null;
        FileZipper instance = new FileZipper();
        instance.create(srcPath, relativizeBase, zipFilename);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
