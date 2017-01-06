/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Akio Sone, Univ, of North Carolina at Chapel Hill, H.W. Odum Inst.
 */
public class Jersey2DataverseClientTest {
    
    public Jersey2DataverseClientTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        System.out.println("jvm-injected test:server=" + System.getProperty("server"));
        System.out.println("jvm-injected test:apikey=" + System.getProperty("apiKey"));
        
        
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
    @Ignore
    @Test
    public void testGetNativeApiUri() {
        System.out.println("getNativeApiUri");
        String endPath = "";
        Jersey2DataverseClient instance = null;
        String expResult = "";
        String result = instance.getNativeApiUri(endPath);

    }

    /**
     * Test of getSwordApiUri method, of class Jersey2DataverseClient.
     */
    @Ignore
    @Test
    public void testGetSwordApiUri() {
        System.out.println("getSwordApiUri");
        String endPath = "";
        Jersey2DataverseClient instance = null;
        String expResult = "";
        String result = instance.getSwordApiUri(endPath);

    }

    /**
     * Test of getClientConfig method, of class Jersey2DataverseClient.
     */
    @Ignore
    @Test
    public void testGetClientConfig() {
        System.out.println("getClientConfig");
        Jersey2DataverseClient instance = null;
        DataverseClientConfig expResult = null;
        DataverseClientConfig result = instance.getClientConfig();

    }

    /**
     * Test of setClientConfig method, of class Jersey2DataverseClient.
     */
    @Ignore
    @Test
    public void testSetClientConfig() {
        System.out.println("setClientConfig");
        DataverseClientConfig clientConfig = null;
        Jersey2DataverseClient instance = null;
        instance.setClientConfig(clientConfig);

    }

    /**
     * Test of main method, of class Jersey2DataverseClient.
     */
    
    @Test
    public void testMain() throws Exception {
        System.out.println("testing the main method");
                System.out.println("testMain:server=" + System.getProperty("server"));
        System.out.println("testMain:apikey=" + System.getProperty("apiKey"));
        
                String server=System.getProperty("server");
                String apiKey=System.getProperty("apiKey");
                String dataverseAlias=System.getProperty("dataverseAlias");
                String persistentId=System.getProperty("persistentId");
                String zipFileLocation=System.getProperty("zipFileLocation");
                
                

        String[] args = new String[]{server, apiKey, dataverseAlias, 
            persistentId, zipFileLocation};
        Jersey2DataverseClient.main(args);

    }

    /**
     * Test of publishDatafile method, of class Jersey2DataverseClient.
     */
    @Ignore
    @Test
    public void testPublishDatafile_String_File() throws Exception {
        System.out.println("publishDatafile");
        String persistentId = "";
        File file = null;
        Jersey2DataverseClient instance = null;
        String expResult = "";
        String result = instance.publishDatafile(persistentId, file);
    }

    /**
     * Test of publishDatafile method, of class Jersey2DataverseClient.
     */
    @Ignore
    @Test
    public void testPublishDatafile_String_String() throws Exception {
        System.out.println("publishDatafile");
        String persistentId = "";
        String filename = "";
        Jersey2DataverseClient instance = null;
        String expResult = "";
        String result = instance.publishDatafile(persistentId, filename);
    }

    /**
     * Test of createNonRootDataverseByAlias method, of class Jersey2DataverseClient.
     */
    @Ignore
    @Test
    public void testCreateNonRootDataverseByAlias() {
        System.out.println("createNonRootDataverseByAlias");
        MinimumFieldsForDataverse minset = null;
        Jersey2DataverseClient instance = null;
        String expResult = "";
        String result = instance.createNonRootDataverseByAlias(minset);
    }

    /**
     * Test of retrieveDataverseContentsByDataverseAlias method, of class Jersey2DataverseClient.
     */
    @Ignore
    @Test
    public void testRetrieveDataverseContentsByDataverseAlias() {
        System.out.println("retrieveDataverseContentsByDataverseAlias");
        String dataverseAlias = "";
        Jersey2DataverseClient instance = null;
        String expResult = "";
        String result = instance.retrieveDataverseContentsByDataverseAlias(dataverseAlias);
    }

    /**
     * Test of retrieveDataverseContentsByDataverseId method, of class Jersey2DataverseClient.
     */
    @Ignore
    @Test
    public void testRetrieveDataverseContentsByDataverseId() {
        System.out.println("retrieveDataverseContentsByDataverseId");
        Long dataverseId = null;
        Jersey2DataverseClient instance = null;
        String expResult = "";
        String result = instance.retrieveDataverseContentsByDataverseId(dataverseId);
    }

    /**
     * Test of parseDataverseContentsFromString method, of class Jersey2DataverseClient.
     */
    @Ignore
    @Test
    public void testParseDataverseContentsFromString() {
        System.out.println("parseDataverseContentsFromString");
        String result_2 = "";
        Jersey2DataverseClient instance = null;
        List<DvItem> expResult = null;
        List<DvItem> result = instance.parseDataverseContentsFromString(result_2);

    }

    /**
     * Test of parseDataverseContentsFromFile method, of class Jersey2DataverseClient.
     */
    @Ignore
    @Test
    public void testParseDataverseContentsFromFile() {
        System.out.println("parseDataverseContentsFromFile");
        String jsonFileName = "";
        Jersey2DataverseClient instance = null;
        List<DvItem> expResult = null;
        List<DvItem> result = instance.parseDataverseContentsFromFile(jsonFileName);

    }

    /**
     * Test of deleteNonRootDataverseByDataverseAlias method, of class Jersey2DataverseClient.
     */
    @Ignore
    @Test
    public void testDeleteNonRootDataverseByDataverseAlias() {
        System.out.println("deleteNonRootDataverseByDataverseAlias");
        String dataverseAlias = "";
        Jersey2DataverseClient instance = null;
        String expResult = "";
        String result = instance.deleteNonRootDataverseByDataverseAlias(dataverseAlias);

    }

    /**
     * Test of deleteNonRootDataverseByDataverseId method, of class Jersey2DataverseClient.
     */
    @Ignore
    @Test
    public void testDeleteNonRootDataverseByDataverseId() {
        System.out.println("deleteNonRootDataverseByDataverseId");
        Long dataverseId = null;
        Jersey2DataverseClient instance = null;
        String expResult = "";
        String result = instance.deleteNonRootDataverseByDataverseId(dataverseId);

    }

    /**
     * Test of createDatasetByDataverseId method, of class Jersey2DataverseClient.
     */
    @Ignore
    @Test
    public void testCreateDatasetByDataverseId() {
        System.out.println("createDatasetByDataverseId");
        String dataverseId = "";
        MinimumFieldsForDataset minset = null;
        Jersey2DataverseClient instance = null;
        String expResult = "";
        String result = instance.createDatasetByDataverseId(dataverseId, minset);

    }

    /**
     * Test of createDatasetByDataverseAlias method, of class Jersey2DataverseClient.
     */
    @Ignore
    @Test
    public void testCreateDatasetByDataverseAlias() {
        System.out.println("createDatasetByDataverseAlias");
        String dataverseAlias = "";
        MinimumFieldsForDataset minset = null;
        Jersey2DataverseClient instance = null;
        String expResult = "";
        String result = instance.createDatasetByDataverseAlias(dataverseAlias, minset);

    }

    /**
     * Test of parseDatasetCreateRequestFromString method, of class Jersey2DataverseClient.
     */
    @Ignore
    @Test
    public void testParseDatasetCreateRequestFromString() {
        System.out.println("parseDatasetCreateRequestFromString");
        String result_2 = "";
        Jersey2DataverseClient instance = null;
        Long expResult = null;
        Long result = instance.parseDatasetCreateRequestFromString(result_2);
    }

    /**
     * Test of retrieveDatasetContentsByDatasetId method, of class Jersey2DataverseClient.
     */
    @Ignore
    @Test
    public void testRetrieveDatasetContentsByDatasetId() {
        System.out.println("retrieveDatasetContentsByDatasetId");
        String datasetId = "";
        Jersey2DataverseClient instance = null;
        String expResult = "";
        String result = instance.retrieveDatasetContentsByDatasetId(datasetId);
    }

    /**
     * Test of retrieveDatasetContentsByPersistentId method, of class Jersey2DataverseClient.
     */
    @Ignore
    @Test
    public void testRetrieveDatasetContentsByPersistentId() {
        System.out.println("retrieveDatasetContentsByPersistentId");
        String persistentId = "";
        Jersey2DataverseClient instance = null;
        instance.retrieveDatasetContentsByPersistentId(persistentId);
    }

    /**
     * Test of parseReturnedDatasetContentsFromString method, of class Jersey2DataverseClient.
     */
    @Ignore
    @Test
    public void testParseReturnedDatasetContentsFromString() {
        System.out.println("parseReturnedDatasetContentsFromString");
        String result_2 = "";
        Jersey2DataverseClient instance = null;
        List<FileItem> expResult = null;
        List<FileItem> result = instance.parseReturnedDatasetContentsFromString(result_2);
    }

    /**
     * Test of parseReturnedDatasetContentsFromFile method, of class Jersey2DataverseClient.
     */
    @Ignore
    @Test
    public void testParseReturnedDatasetContentsFromFile() {
        System.out.println("parseReturnedDatasetContentsFromFile");
        String jsonFileName = "";
        Jersey2DataverseClient instance = null;
        List<FileItem> expResult = null;
        List<FileItem> result = instance.parseReturnedDatasetContentsFromFile(jsonFileName);
    }

    /**
     * Test of addFilesToDataset method, of class Jersey2DataverseClient.
     */
    @Ignore
    @Test
    public void testAddFilesToDataset_0args() throws Exception {
        System.out.println("addFilesToDataset");
        Jersey2DataverseClient instance = null;
        String expResult = "";
        String result = instance.addFilesToDataset();

    }

    /**
     * Test of addFilesToDataset method, of class Jersey2DataverseClient.
     */
    @Ignore
    @Test
    public void testAddFilesToDataset_String() throws Exception {
        System.out.println("addFilesToDataset");
        String persistentId = "";
        Jersey2DataverseClient instance = null;
        String expResult = "";
        String result = instance.addFilesToDataset(persistentId);

    }

    /**
     * Test of addFilesToDataset method, of class Jersey2DataverseClient.
     */
    @Ignore
    @Test
    public void testAddFilesToDataset_File_String() throws Exception {
        System.out.println("addFilesToDataset");
        File zipFile = null;
        String persistentId = "";
        Jersey2DataverseClient instance = null;
        String expResult = "";
        String result = instance.addFilesToDataset(zipFile, persistentId);

    }

    /**
     * Test of addFilesToDataset method, of class Jersey2DataverseClient.
     */
    @Ignore
    @Test
    public void testAddFilesToDataset_String_String() throws Exception {
        System.out.println("addFilesToDataset");
        String zipFileLocation = "";
        String persistentId = "";
        Jersey2DataverseClient instance = null;
        String expResult = "";
        String result = instance.addFilesToDataset(zipFileLocation, persistentId);

    }

    /**
     * Test of deleteDatasetByDatasetId method, of class Jersey2DataverseClient.
     */
    @Ignore
    @Test
    public void testDeleteDatasetByDatasetId() {
        System.out.println("deleteDatasetByDatasetId");
        Long datasetId = null;
        Jersey2DataverseClient instance = null;
        String expResult = "";
        String result = instance.deleteDatasetByDatasetId(datasetId);

    }

    /**
     * Test of deleteDatasetByPersistentId method, of class Jersey2DataverseClient.
     */
    @Ignore
    @Test
    public void testDeleteDatasetByPersistentId() {
        System.out.println("deleteDatasetByPersistentId");
        String persistentId = "";
        Jersey2DataverseClient instance = null;
        String expResult = "";
        String result = instance.deleteDatasetByPersistentId(persistentId);

    }

    /**
     * Test of parseDatasetDeleteRequestFromString method, of class Jersey2DataverseClient.
     */
    @Ignore
    @Test
    public void testParseDatasetDeleteRequestFromString() {
        System.out.println("parseDatasetDeleteRequestFromString");
        String result_2 = "";
        Jersey2DataverseClient instance = null;
        String expResult = "";
        String result = instance.parseDatasetDeleteRequestFromString(result_2);
    }

    /**
     * Test of deleteDatafile method, of class Jersey2DataverseClient.
     */
    @Ignore
    @Test
    public void testDeleteDatafile() {
        System.out.println("deleteDatafile");
        String fileId = "";
        Jersey2DataverseClient instance = null;
        instance.deleteDatafile(fileId);
        // TODO review the generated test code and remove the default call to fail.

    }
    
}
