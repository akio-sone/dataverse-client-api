package edu.unc.irss.arc.dataverse.client;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Akio Sone, Univ, of North Carolina at Chapel Hill, H.W. Odum Inst.
 */
public class DataverseClientConfigTest {

    public DataverseClientConfigTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("\n\nexcuting the unit tests of DataverseClientConfigTest\n\n");
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
     * Test of getServer method, of class DataverseClientConfig.
     */
    @Ignore
    @Test
    public void testGetServer() {
        System.out.println("getServer");
        DataverseClientConfig instance = new DataverseClientConfig();
        String expResult = "someserver.somedept.someu.org";
        String result = instance.getServer();

    }

    /**
     * Test of setServer method, of class DataverseClientConfig.
     */
    @Test
    public void testSetServer() {
        System.out.println("\n\ntesting setServer");
        String expResult = "someserver.somedept.someu.org";
        DataverseClientConfig instance = new DataverseClientConfig();
        instance.setServer(expResult);

        String result = instance.getServer();
        System.out.println("expected=" + expResult);
        System.out.println("actual=" + result);
        assertThat("set server : test case 1:", result, is(equalTo(expResult)));
        
        

    }

    /**
     * Test of getTarget method, of class DataverseClientConfig.
     */
    @Ignore
    @Test
    public void testGetTarget() {
        System.out.println("getTarget");
        DataverseClientConfig instance = new DataverseClientConfig();
        String expResult = "";
        String result = instance.getTarget();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTarget method, of class DataverseClientConfig.
     */
    @Test
    public void testSetTarget() {
        System.out.println("setTarget");
        String target = "";
        DataverseClientConfig instance = new DataverseClientConfig();
        instance.setTarget(target);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPath method, of class DataverseClientConfig.
     */
    @Ignore
    @Test
    public void testGetPath() {
        System.out.println("getPath");
        DataverseClientConfig instance = new DataverseClientConfig();
        String expResult = "";
        String result = instance.getPath();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPath method, of class DataverseClientConfig.
     */
    @Test
    public void testSetPath() {
        System.out.println("setPath");
        String path = "";
        DataverseClientConfig instance = new DataverseClientConfig();
        instance.setPath(path);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getApiKey method, of class DataverseClientConfig.
     */
    @Ignore
    @Test
    public void testGetApiKey() {
        System.out.println("getApiKey");
        DataverseClientConfig instance = new DataverseClientConfig();
        String expResult = "";
        String result = instance.getApiKey();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setApiKey method, of class DataverseClientConfig.
     */
    @Test
    public void testSetApiKey() {
        System.out.println("setApiKey");
        String apiKey = "";
        DataverseClientConfig instance = new DataverseClientConfig();
        instance.setApiKey(apiKey);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPersistentId method, of class DataverseClientConfig.
     */
    @Ignore
    @Test
    public void testGetPersistentId() {
        System.out.println("getPersistentId");
        DataverseClientConfig instance = new DataverseClientConfig();
        String expResult = "";
        String result = instance.getPersistentId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPersistentId method, of class DataverseClientConfig.
     */
    @Test
    public void testSetPersistentId() {
        System.out.println("setPersistentId");
        String persistentId = "";
        DataverseClientConfig instance = new DataverseClientConfig();
        instance.setPersistentId(persistentId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getApiVersion method, of class DataverseClientConfig.
     */
    @Ignore
    @Test
    public void testGetApiVersion() {
        System.out.println("getApiVersion");
        DataverseClientConfig instance = new DataverseClientConfig();
        String expResult = "";
        String result = instance.getApiVersion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setApiVersion method, of class DataverseClientConfig.
     */
    @Test
    public void testSetApiVersion() {
        System.out.println("setApiVersion");
        String apiVersion = "";
        DataverseClientConfig instance = new DataverseClientConfig();
        instance.setApiVersion(apiVersion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataverseAlias method, of class DataverseClientConfig.
     */
    @Test
    @Ignore
    public void testGetDataverseAlias() {
        System.out.println("getDataverseAlias");
        DataverseClientConfig instance = new DataverseClientConfig();
        String expResult = "";
        String result = instance.getDataverseAlias();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDataverseAlias method, of class DataverseClientConfig.
     */
    @Test
    public void testSetDataverseAlias() {
        System.out.println("setDataverseAlias");
        String dataverseAlias = "";
        DataverseClientConfig instance = new DataverseClientConfig();
        instance.setDataverseAlias(dataverseAlias);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataverseId method, of class DataverseClientConfig.
     */
    @Test
    @Ignore
    public void testGetDataverseId() {
        System.out.println("getDataverseId");
        DataverseClientConfig instance = new DataverseClientConfig();
        String expResult = "";
        String result = instance.getDataverseId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDataverseId method, of class DataverseClientConfig.
     */
    @Test
    public void testSetDataverseId() {
        System.out.println("setDataverseId");
        String dataverseId = "";
        DataverseClientConfig instance = new DataverseClientConfig();
        instance.setDataverseId(dataverseId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGroupAlias method, of class DataverseClientConfig.
     */
    @Ignore
    @Test
    public void testGetGroupAlias() {
        System.out.println("getGroupAlias");
        DataverseClientConfig instance = new DataverseClientConfig();
        String expResult = "";
        String result = instance.getGroupAlias();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGroupAlias method, of class DataverseClientConfig.
     */
    @Test
    public void testSetGroupAlias() {
        System.out.println("setGroupAlias");
        String groupAlias = "";
        DataverseClientConfig instance = new DataverseClientConfig();
        instance.setGroupAlias(groupAlias);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGroupId method, of class DataverseClientConfig.
     */
    @Test
    @Ignore
    public void testGetGroupId() {
        System.out.println("getGroupId");
        DataverseClientConfig instance = new DataverseClientConfig();
        String expResult = "";
        String result = instance.getGroupId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGroupId method, of class DataverseClientConfig.
     */
    @Test
    public void testSetGroupId() {
        System.out.println("setGroupId");
        String groupId = "";
        DataverseClientConfig instance = new DataverseClientConfig();
        instance.setGroupId(groupId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class DataverseClientConfig.
     */
    @Test
    @Ignore
    public void testGetName() {
        System.out.println("getName");
        DataverseClientConfig instance = new DataverseClientConfig();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class DataverseClientConfig.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        DataverseClientConfig instance = new DataverseClientConfig();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getZipFileLocation method, of class DataverseClientConfig.
     */
    @Test
    @Ignore
    public void testGetZipFileLocation() {
        System.out.println("getZipFileLocation");
        DataverseClientConfig instance = new DataverseClientConfig();
        String expResult = "";
        String result = instance.getZipFileLocation();
    }

    /**
     * Test of setZipFileLocation method, of class DataverseClientConfig.
     */
    @Test
    public void testSetZipFileLocation() {
        System.out.println("setZipFileLocation");
        String expResult = "/testDataFiles/images/menu_bar_support_2012-10-08.png";
        DataverseClientConfig instance = new DataverseClientConfig();
        instance.setZipFileLocation(expResult);
        String result = instance.getZipFileLocation();
        System.out.println("expected=" + expResult);
        System.out.println("actual=" + result);
        assertThat("set request URI : test case 1:", result, is(equalTo(expResult)));
    }

    /**
     * Test of getRequestURI method, of class DataverseClientConfig.
     */
    @Test
    @Ignore
    public void testGetRequestURI() {
        System.out.println("getRequestURI");
        DataverseClientConfig instance = new DataverseClientConfig();
        String expResult = "";
        String result = instance.getRequestURI();
    }

    /**
     * Test of setRequestURI method, of class DataverseClientConfig.
     */
    @Test
    @Ignore
    public void testSetRequestURI() {
        System.out.println("testing setRequestURI");
        String expResult = "";
        DataverseClientConfig instance = new DataverseClientConfig();
        instance.setRequestURI(expResult);
        String result = instance.getRequestURI();
        System.out.println("expected=" + expResult);
        System.out.println("actual=" + result);
        assertThat("set request URI : test case 1:", result, is(equalTo(expResult)));
    }

    /**
     * Test of getNativeApiVersion method, of class DataverseClientConfig.
     */
    @Test
    public void testGetNativeApiVersion() {
        System.out.println("\n\ntesting getNativeApiVersion");
        DataverseClientConfig instance = new DataverseClientConfig();
        String expResult = "v1";
        System.out.println("expected=" + expResult);
        String result = instance.getNativeApiVersion();
        System.out.println("actual=" + result);
        assertThat("get the native api version: test case 1: no setting", result, is(equalTo(expResult)));

        instance.setNativeApiVersion("1");
        System.out.println("expected=" + expResult);
        result = instance.getNativeApiVersion();
        System.out.println("actual=" + result);
        assertThat("get the native api version: test case 2: incorrect value", result, is(equalTo(expResult)));

        instance.setNativeApiVersion("v2");
        result = instance.getNativeApiVersion();

        expResult = "v2";
        System.out.println("expected=" + expResult);
        System.out.println("actual=" + result);
        assertThat("get the native api version: test case 3: non default", result, is(equalTo(expResult)));

    }

    /**
     * Test of setNativeApiVersion method, of class DataverseClientConfig.
     */
    @Test
    public void testSetNativeApiVersion() {
        System.out.println("\n\n testing setNativeApiVersion");
        String expResult = "v2";
        DataverseClientConfig instance = new DataverseClientConfig();
        instance.setNativeApiVersion(expResult);
        String result = instance.getNativeApiVersion();
        System.out.println("expected=" + expResult);
        System.out.println("actual=" + result);
        assertThat("set the native api version: test case: non default", result, is(equalTo(expResult)));
        expResult = "v1";
        instance.setNativeApiVersion("");
        result = instance.getNativeApiVersion();
        System.out.println("expected=" + expResult);
        System.out.println("actual=" + result);
        assertThat("set the native api version: test case: default", result, is(equalTo(expResult)));

    }

    /**
     * Test of getSwordApiVersion method, of class DataverseClientConfig.
     */
    @Test
    public void testGetSwordApiVersion() {
        System.out.println("\n\ntesting getSwordApiVersion");
        DataverseClientConfig instance = new DataverseClientConfig();
        String expResult = "v1.1";
        String result = instance.getSwordApiVersion();
        System.out.println("expected=" + expResult);
        System.out.println("actual=" + result);
        assertThat("get the sword api version: test case 1: no setting", result, is(equalTo(expResult)));
    }

    /**
     * Test of setSwordApiVersion method, of class DataverseClientConfig.
     */
    @Test
    public void testSetSwordApiVersion() {
        System.out.println("\n\n testing setSwordApiVersion");
        String expResult = "v2";
        DataverseClientConfig instance = new DataverseClientConfig();
        instance.setSwordApiVersion(expResult);
        String result = instance.getSwordApiVersion();
        System.out.println("expected=" + expResult);
        System.out.println("actual=" + result);
        assertThat("set the sword api version: test case 1: non-default", result, is(equalTo(expResult)));
        expResult="v1.1";
        instance.setSwordApiVersion("");
        result = instance.getSwordApiVersion();
        System.out.println("expected=" + expResult);
        System.out.println("actual=" + result);
        assertThat("set the sword api version: test case 2: default", result, is(equalTo(expResult)));
    }

    /**
     * Test of getServerURI method, of class DataverseClientConfig.
     */
    @Test
    public void testGetServerURI() {
        System.out.println("getServerURI");
        DataverseClientConfig instance = new DataverseClientConfig();
        String expResult = "";
        String result = instance.getServerURI();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class DataverseClientConfig.
     */
    @Ignore
    @Test
    public void testToString() {
        System.out.println("toString");
        DataverseClientConfig instance = new DataverseClientConfig();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
