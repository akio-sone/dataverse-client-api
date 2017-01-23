/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unc.irss.arc.dataverse.client;

import edu.unc.irss.arc.dataverse.client.util.GenericBuilder;
import edu.unc.irss.arc.dataverse.client.util.MinimumFieldsForDataset;
import edu.unc.irss.arc.dataverse.client.util.MinimumFieldsForDataverse;
import edu.unc.irss.arc.dataverse.client.util.dto.DvItem;
import edu.unc.irss.arc.dataverse.client.util.dto.FileItem;
import edu.unc.irss.arc.dataverse.client.util.xml.AtomfeedParser;
import java.io.File;
import java.net.URL;
import java.util.List;
import static org.hamcrest.Matchers.*;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;


/**
 *
 * @author Akio Sone, Univ, of North Carolina at Chapel Hill, H.W. Odum Inst.
 */
public class Jersey2DataverseClientTest {
    
    
    DataverseClientConfig clientConfig;
    
    Jersey2DataverseClient dataverseClient;
    
    String dataverseId;
    String dataverseAlias;
    String datasetId;
    String datafileId;
    String persistentId;

    
    public Jersey2DataverseClientTest() {
    }
    
    
    
    
    
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("\n\nexcuting the unit tests of Jersey2DataverseClientTest\n\n");
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        
        System.out.println("setUp:server==" + System.getProperty("server"));
        System.out.println("setUp:apikey=" + System.getProperty("apiKey"));
        
        String server=System.getProperty("server");
        String apiKey=System.getProperty("apiKey");
        dataverseAlias=System.getProperty("dataverseAlias");
        persistentId=System.getProperty("persistentId");
        String zipFileLocation=System.getProperty("zipFileLocation");
        
        
        clientConfig = GenericBuilder
                .of(DataverseClientConfig::new)
                .with(DataverseClientConfig::setServer, server)
                .with(DataverseClientConfig::setApiKey, apiKey)
                .with(DataverseClientConfig::setDataverseAlias, dataverseAlias)
                .with(DataverseClientConfig::setPersistentId, persistentId)
                .with(DataverseClientConfig::setZipFileLocation, zipFileLocation)
                .build();

        
        dataverseClient = new Jersey2DataverseClient(clientConfig);
        System.out.println("setUp:dataverseAlias=" + dataverseAlias);
        
        System.out.println("setUp:dataverseId=" + System.getProperty("dataverseId"));
        dataverseId = System.getProperty("dataverseId");
        
        System.out.println("setUp:datasetId=" + System.getProperty("datasetId"));
        
        datasetId=System.getProperty("datasetId");
        
        System.out.println("setUp:persistentId=" + persistentId);
        
        System.out.println("setUp:datafileId=" + System.getProperty("datafileId"));
        datafileId=System.getProperty("datafileId");
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
        System.out.println("\n\n testing getNativeApiUri");
        
        
        String endPath = "/dataverses";
        System.out.println("endPath="+endPath);
        String result = dataverseClient.getNativeApiUri(endPath);
        String expResult="/api/v1/dataverses";
        System.out.println("expected: uri"+expResult);
        System.out.println("actual: uri"+result);
        assertThat("URI for native API calls", result, is(equalTo(expResult)));

    }

    /**
     * Test of getSwordApiUri method, of class Jersey2DataverseClient.
     */
    @Ignore
    @Test
    public void testGetSwordApiUri() {
        System.out.println("\n\n testing getSwordApiUri");
        String endPath = "/study";
        String expResult = "/dvn/api/data-deposit/v1.1/swordv2/edit-media"+endPath;
        System.out.println("expected: uri"+expResult);
        String result = dataverseClient.getSwordApiUri(endPath);
        System.out.println("actual: uri"+result);
        assertThat("URI for sword API calls", result, is(equalTo(expResult)));
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
     * @throws java.lang.Exception
     */
    @Ignore
    @Test
    public void testMain() throws Exception {
        System.out.println("\n\ntesting the main method");
        /*
        
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
        */
        String zipFilelocation = clientConfig.getZipFileLocation();
        // 1st test: using a File instance with a relative path
        System.out.println("zipFilelocation="+zipFilelocation);
        // File.separator +
        // +"testDataFiles"+ File.separator + "images"+File.separator
        File zipFile = new File( "src" + File.separator + "test"
        + File.separator + "resources" +File.separator + zipFilelocation);
        System.out.println("zipFile abs path="+zipFile.getAbsolutePath());
        
        assertThat("zipFile exists", zipFile.exists(), is(true));
        
//        if (zipFile.exists()){
//            System.out.println("zip file exists: size="+zipFile.length());
//        } else {
//            System.out.println("zip file does not exists");
//        }
        
        
        // 2nd test: using class loader
//        zipFilelocation ="testDataFiles/images/" + zipFilelocation;
        System.out.println("zipFilelocation="+zipFilelocation);
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(zipFilelocation).getFile());
        System.out.println("abs path="+file.getAbsolutePath());
        assertThat("file exists", file.exists(), is(true));
        
        
        
        // 3rd test: using url
        URL url = this.getClass().getResource("/"+zipFilelocation);
        File testFile = new File(url.getFile());
        
        assertThat("testFile exists", testFile.exists(), is(true));
        
        
//        if (testFile.exists()){
//            System.out.println("abs path="+file.getAbsolutePath());
//            System.out.println("test file exists: size="+testFile.length());
//        } else {
//            System.out.println("test file does not exists");
//        }
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
        System.out.println("\n\ntesting retrieveDataverseContentsByDataverseAlias");
        //String dataverseAlias = "";
        //Jersey2DataverseClient instance = null;
        //String expResult = "";
        //String result = instance.retrieveDataverseContentsByDataverseAlias(dataverseAlias);
        
        System.out.println("dataverseAlias="+dataverseAlias);
        String result = dataverseClient.retrieveDataverseContentsByDataverseAlias(dataverseAlias);
        System.out.println("result="+result);
        List<DvItem> listDI = dataverseClient.parseDataverseContentsFromString(result);
        System.out.println("listDI.size="+listDI.size());
        assertThat("how many dataverse objects in this dataverse", listDI, hasSize(equalTo(10)));
        assertThat("how many dataverse objects in this dataverse", listDI.size(), equalTo(10)); 
        
        
    }

    /**
     * Test of retrieveDataverseContentsByDataverseId method, of class Jersey2DataverseClient.
     */
    @Ignore
    @Test
    public void testRetrieveDataverseContentsByDataverseId() {
        System.out.println("\n\ntesting retrieveDataverseContentsByDataverseId");
        Long dvId = Long.parseLong(dataverseId);
        System.out.println("dataverseId="+dataverseId);
        String result = dataverseClient.retrieveDataverseContentsByDataverseId(dvId);
        System.out.println("result="+result);
        List<DvItem> listDI = dataverseClient.parseDataverseContentsFromString(result);
        System.out.println("listDI.size="+listDI.size());
        assertThat("how many dataverse objects in this dataverse", listDI, hasSize(equalTo(10)));
        assertThat("how many dataverse objects in this dataverse", listDI.size(), equalTo(10));
        //assertThat();  title
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
        System.out.println("\n\nretrieveDatasetContentsByDatasetId");

        System.out.println("datasetId="+datasetId);
        String result = dataverseClient.retrieveDatasetContentsByDatasetId(datasetId);
        System.out.println("result="+result);
        List<FileItem> listFI = dataverseClient.parseReturnedDatasetContentsFromString(result);
        System.out.println("listFI="+listFI);
        System.out.println("listFI.size="+listFI.size());
        
        assertThat("how many objects in this dataset", listFI, hasSize(equalTo(8)));
        assertThat("how many objects in this dataset", listFI.size(), equalTo(8));
        
        
    }

    /**
     * Test of retrieveDatasetContentsByPersistentId method, of class Jersey2DataverseClient.
     */
    @Ignore
    @Test
    public void testRetrieveDatasetContentsByPersistentId() {
        System.out.println("\n\nretrieveDatasetContentsByPersistentId");
        System.out.println("persistentId="+persistentId);
        String result = dataverseClient.retrieveDatasetContentsByPersistentId(persistentId);
        
        System.out.println("result="+result);
        List<FileItem> listFI = dataverseClient.parseReturnedDatasetContentsFromString(result);
        System.out.println("listFI="+listFI);
        System.out.println("listFI.size="+listFI.size());
        
        assertThat("how many objects in this dataset", listFI, hasSize(equalTo(8)));
        assertThat("how many objects in this dataset", listFI.size(), equalTo(8));
        
        
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
     * @throws java.lang.Exception
     */
    @Ignore
    @Test
    public void testAddFilesToDataset_0args() throws Exception {
        System.out.println("\n\ntesting addFilesToDataset  0 arguments");
        
        // requests data are all in the config instance
        System.out.println("client config="+clientConfig);
        System.out.println("zip file info="+clientConfig.getZipFileLocation());
        System.out.println("datasetId="+clientConfig.getPersistentId());
        
        ClassLoader classLoader = getClass().getClassLoader();
        String absFilePath = (new File(classLoader.getResource(clientConfig.getZipFileLocation()).getFile())).getAbsolutePath();
        
        System.out.println("file path info: abs ="+absFilePath);
        clientConfig.setZipFileLocation(absFilePath);
        
        System.out.println("zip file info="+clientConfig.getZipFileLocation());
        assertThat("dataset info=", clientConfig.getPersistentId(), is(equalTo(System.getProperty("persistentId"))));
        
        
        String receipt = dataverseClient.addFilesToDataset();
        System.out.println("deposit receipt="+receipt);
        
        AtomfeedParser parser = new AtomfeedParser();
        String pid = parser.parseDepositReceipt(receipt).getPersistentId();
        System.out.println("pid="+pid);
        assertThat("check the returned persistentId", clientConfig.getPersistentId(), is(equalTo(pid)));
        
        
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
        System.out.println("\n\n testing deleteDatafile");
        
        // A fileId may be extracted from the metadata of its parent dataset to
        // to make its existence-confirmation  unnecessary
        String fileId = datafileId;
        System.out.println("datafileId to be deleted="+fileId);
        dataverseClient.deleteDatafile(fileId);
        // one way to check the above deletion is whether the fileid exists in
        // the list of datafiles under a dataset
        
    }
    
}
