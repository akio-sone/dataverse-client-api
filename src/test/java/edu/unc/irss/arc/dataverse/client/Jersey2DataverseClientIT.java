/*
 */
package edu.unc.irss.arc.dataverse.client;

import edu.unc.irss.arc.dataverse.client.util.MinimumFieldsForDataset;
import edu.unc.irss.arc.dataverse.client.util.MinimumFieldsForDataverse;
import edu.unc.irss.arc.dataverse.client.util.dto.DvItem;
import edu.unc.irss.arc.dataverse.client.util.dto.FileItem;
import java.io.File;
import java.util.List;
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

    /**
     * Test of getNativeApiUri method, of class Jersey2DataverseClient.
     */
    @Test
    public void testGetNativeApiUri() {
        System.out.println("getNativeApiUri");
        String endPath = "";
        Jersey2DataverseClient instance = null;
        String expResult = "";
        String result = instance.getNativeApiUri(endPath);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSwordApiUri method, of class Jersey2DataverseClient.
     */
    @Test
    public void testGetSwordApiUri() {
        System.out.println("getSwordApiUri");
        String endPath = "";
        Jersey2DataverseClient instance = null;
        String expResult = "";
        String result = instance.getSwordApiUri(endPath);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClientConfig method, of class Jersey2DataverseClient.
     */
    @Test
    public void testGetClientConfig() {
        System.out.println("getClientConfig");
        Jersey2DataverseClient instance = null;
        DataverseClientConfig expResult = null;
        DataverseClientConfig result = instance.getClientConfig();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setClientConfig method, of class Jersey2DataverseClient.
     */
    @Test
    public void testSetClientConfig() {
        System.out.println("setClientConfig");
        DataverseClientConfig clientConfig = null;
        Jersey2DataverseClient instance = null;
        instance.setClientConfig(clientConfig);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Jersey2DataverseClient.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Jersey2DataverseClient.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of publishDatafile method, of class Jersey2DataverseClient.
     */
    @Test
    public void testPublishDatafile_String_File() {
        System.out.println("publishDatafile");
        String persistentId = "";
        File file = null;
        Jersey2DataverseClient instance = null;
        String expResult = "";
        String result = instance.publishDatafile(persistentId, file);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of publishDatafile method, of class Jersey2DataverseClient.
     */
    @Test
    public void testPublishDatafile_String_String() {
        System.out.println("publishDatafile");
        String persistentId = "";
        String filename = "";
        Jersey2DataverseClient instance = null;
        String expResult = "";
        String result = instance.publishDatafile(persistentId, filename);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createNonRootDataverseByAlias method, of class Jersey2DataverseClient.
     */
    @Test
    public void testCreateNonRootDataverseByAlias() {
        System.out.println("createNonRootDataverseByAlias");
        MinimumFieldsForDataverse minset = null;
        Jersey2DataverseClient instance = null;
        String expResult = "";
        String result = instance.createNonRootDataverseByAlias(minset);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retrieveDataverseContentsByDataverseAlias method, of class Jersey2DataverseClient.
     */
    @Test
    public void testRetrieveDataverseContentsByDataverseAlias() {
        System.out.println("retrieveDataverseContentsByDataverseAlias");
        String dataverseAlias = "";
        Jersey2DataverseClient instance = null;
        String expResult = "";
        String result = instance.retrieveDataverseContentsByDataverseAlias(dataverseAlias);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retrieveDataverseContentsByDataverseId method, of class Jersey2DataverseClient.
     */
    @Test
    public void testRetrieveDataverseContentsByDataverseId() {
        System.out.println("retrieveDataverseContentsByDataverseId");
        Long dataverseId = null;
        Jersey2DataverseClient instance = null;
        String expResult = "";
        String result = instance.retrieveDataverseContentsByDataverseId(dataverseId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parseDataverseContentsFromString method, of class Jersey2DataverseClient.
     */
    @Test
    public void testParseDataverseContentsFromString() {
        System.out.println("parseDataverseContentsFromString");
        String result_2 = "";
        Jersey2DataverseClient instance = null;
        List<DvItem> expResult = null;
        List<DvItem> result = instance.parseDataverseContentsFromString(result_2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parseDataverseContentsFromFile method, of class Jersey2DataverseClient.
     */
    @Test
    public void testParseDataverseContentsFromFile() {
        System.out.println("parseDataverseContentsFromFile");
        String jsonFileName = "";
        Jersey2DataverseClient instance = null;
        List<DvItem> expResult = null;
        List<DvItem> result = instance.parseDataverseContentsFromFile(jsonFileName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteNonRootDataverseByDataverseAlias method, of class Jersey2DataverseClient.
     */
    @Test
    public void testDeleteNonRootDataverseByDataverseAlias() {
        System.out.println("deleteNonRootDataverseByDataverseAlias");
        String dataverseAlias = "";
        Jersey2DataverseClient instance = null;
        String expResult = "";
        String result = instance.deleteNonRootDataverseByDataverseAlias(dataverseAlias);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteNonRootDataverseByDataverseId method, of class Jersey2DataverseClient.
     */
    @Test
    public void testDeleteNonRootDataverseByDataverseId() {
        System.out.println("deleteNonRootDataverseByDataverseId");
        Long dataverseId = null;
        Jersey2DataverseClient instance = null;
        String expResult = "";
        String result = instance.deleteNonRootDataverseByDataverseId(dataverseId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createDatasetByDataverseId method, of class Jersey2DataverseClient.
     */
    @Test
    public void testCreateDatasetByDataverseId() {
        System.out.println("createDatasetByDataverseId");
        String dataverseId = "";
        MinimumFieldsForDataset minset = null;
        Jersey2DataverseClient instance = null;
        String expResult = "";
        String result = instance.createDatasetByDataverseId(dataverseId, minset);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createDatasetByDataverseAlias method, of class Jersey2DataverseClient.
     */
    @Test
    public void testCreateDatasetByDataverseAlias() {
        System.out.println("createDatasetByDataverseAlias");
        String dataverseAlias = "";
        MinimumFieldsForDataset minset = null;
        Jersey2DataverseClient instance = null;
        String expResult = "";
        String result = instance.createDatasetByDataverseAlias(dataverseAlias, minset);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parseDatasetCreateRequestFromString method, of class Jersey2DataverseClient.
     */
    @Test
    public void testParseDatasetCreateRequestFromString() {
        System.out.println("parseDatasetCreateRequestFromString");
        String result_2 = "";
        Jersey2DataverseClient instance = null;
        Long expResult = null;
        Long result = instance.parseDatasetCreateRequestFromString(result_2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retrieveDatasetContentsByDatasetId method, of class Jersey2DataverseClient.
     */
    @Test
    public void testRetrieveDatasetContentsByDatasetId() {
        System.out.println("retrieveDatasetContentsByDatasetId");
        String datasetId = "";
        Jersey2DataverseClient instance = null;
        String expResult = "";
        String result = instance.retrieveDatasetContentsByDatasetId(datasetId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retrieveDatasetContentsByPersistentId method, of class Jersey2DataverseClient.
     */
    @Test
    public void testRetrieveDatasetContentsByPersistentId() {
        System.out.println("retrieveDatasetContentsByPersistentId");
        String persistentId = "";
        Jersey2DataverseClient instance = null;
        instance.retrieveDatasetContentsByPersistentId(persistentId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parseReturnedDatasetContentsFromString method, of class Jersey2DataverseClient.
     */
    @Test
    public void testParseReturnedDatasetContentsFromString() {
        System.out.println("parseReturnedDatasetContentsFromString");
        String result_2 = "";
        Jersey2DataverseClient instance = null;
        List<FileItem> expResult = null;
        List<FileItem> result = instance.parseReturnedDatasetContentsFromString(result_2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parseReturnedDatasetContentsFromFile method, of class Jersey2DataverseClient.
     */
    @Test
    public void testParseReturnedDatasetContentsFromFile() {
        System.out.println("parseReturnedDatasetContentsFromFile");
        String jsonFileName = "";
        Jersey2DataverseClient instance = null;
        List<FileItem> expResult = null;
        List<FileItem> result = instance.parseReturnedDatasetContentsFromFile(jsonFileName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addFilesToDataset method, of class Jersey2DataverseClient.
     */
    @Test
    public void testAddFilesToDataset_0args() {
        System.out.println("addFilesToDataset");
        Jersey2DataverseClient instance = null;
        String expResult = "";
        String result = instance.addFilesToDataset();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addFilesToDataset method, of class Jersey2DataverseClient.
     */
    @Test
    public void testAddFilesToDataset_String() {
        System.out.println("addFilesToDataset");
        String persistentId = "";
        Jersey2DataverseClient instance = null;
        String expResult = "";
        String result = instance.addFilesToDataset(persistentId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addFilesToDataset method, of class Jersey2DataverseClient.
     */
    @Test
    public void testAddFilesToDataset_File_String() {
        System.out.println("addFilesToDataset");
        File zipFile = null;
        String persistentId = "";
        Jersey2DataverseClient instance = null;
        String expResult = "";
        String result = instance.addFilesToDataset(zipFile, persistentId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteDatasetByDatasetId method, of class Jersey2DataverseClient.
     */
    @Test
    public void testDeleteDatasetByDatasetId() {
        System.out.println("deleteDatasetByDatasetId");
        Long datasetId = null;
        Jersey2DataverseClient instance = null;
        String expResult = "";
        String result = instance.deleteDatasetByDatasetId(datasetId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteDatasetByPersistentId method, of class Jersey2DataverseClient.
     */
    @Test
    public void testDeleteDatasetByPersistentId() {
        System.out.println("deleteDatasetByPersistentId");
        String persistentId = "";
        Jersey2DataverseClient instance = null;
        String expResult = "";
        String result = instance.deleteDatasetByPersistentId(persistentId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parseDatasetDeleteRequestFromString method, of class Jersey2DataverseClient.
     */
    @Test
    public void testParseDatasetDeleteRequestFromString() {
        System.out.println("parseDatasetDeleteRequestFromString");
        String result_2 = "";
        Jersey2DataverseClient instance = null;
        String expResult = "";
        String result = instance.parseDatasetDeleteRequestFromString(result_2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteDatafile method, of class Jersey2DataverseClient.
     */
    @Test
    public void testDeleteDatafile() {
        System.out.println("deleteDatafile");
        String fileId = "";
        Jersey2DataverseClient instance = null;
        instance.deleteDatafile(fileId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
