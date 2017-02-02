package edu.unc.irss.arc.dataverse.client;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.PojoClassFilter;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
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
public class DataverseClientConfigTest {

    public DataverseClientConfigTest() {
    }

    // private List<PojoClass> pojoClasses;
    PojoClass configPojo;
    private String packageName ="edu.unc.irss.arc.dataverse.client";
    private Validator validator;
    private PojoClassFilter filterTestClasses = new FilterTestClasses();
    @BeforeClass
    public static void setUpClass() {
        System.out.println("\n\nexcuting the unit tests of DataverseClientConfigTest\n\n");

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        configPojo = PojoClassFactory.getPojoClass(DataverseClientConfig.class);

        validator = ValidatorBuilder.create()
                .with(new GetterMustExistRule())
                .with(new SetterMustExistRule())
                .with(new SetterTester())
                .with(new GetterTester())
                .build();

    }

    @After
    public void tearDown() {
    }

    
    
  private static class FilterTestClasses implements PojoClassFilter {
    @Override
    public boolean include(PojoClass pojoClass) {
      return !pojoClass.getSourcePath().contains("/test-classes/");
    }
  }
    
    
    @Test
    public void validateSettersAndGetters() {
        System.out.println("\n\n running validateSettersAndGetters()");
        validator.validate(packageName, filterTestClasses);
    }

    /**
     * Test of getServer method, of class DataverseClientConfig.
     */
    @Test
    public void testGetServer() {
        System.out.println("getServer");
        DataverseClientConfig instance = new DataverseClientConfig();
        String expResult = "";
        String result = instance.getServer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setServer method, of class DataverseClientConfig.
     */
    @Test
    public void testSetServer() {
        System.out.println("setServer");
        String server = "";
        DataverseClientConfig instance = new DataverseClientConfig();
        instance.setServer(server);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTarget method, of class DataverseClientConfig.
     */
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
    public void testGetZipFileLocation() {
        System.out.println("getZipFileLocation");
        DataverseClientConfig instance = new DataverseClientConfig();
        String expResult = "";
        String result = instance.getZipFileLocation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setZipFileLocation method, of class DataverseClientConfig.
     */
    @Test
    public void testSetZipFileLocation() {
        System.out.println("setZipFileLocation");
        String zipFileLocation = "";
        DataverseClientConfig instance = new DataverseClientConfig();
        instance.setZipFileLocation(zipFileLocation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRequestURI method, of class DataverseClientConfig.
     */
    @Test
    public void testGetRequestURI() {
        System.out.println("getRequestURI");
        DataverseClientConfig instance = new DataverseClientConfig();
        String expResult = "";
        String result = instance.getRequestURI();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRequestURI method, of class DataverseClientConfig.
     */
    @Test
    public void testSetRequestURI() {
        System.out.println("setRequestURI");
        String requestURI = "";
        DataverseClientConfig instance = new DataverseClientConfig();
        instance.setRequestURI(requestURI);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNativeApiVersion method, of class DataverseClientConfig.
     */
    @Test
    public void testGetNativeApiVersion() {
        System.out.println("getNativeApiVersion");
        DataverseClientConfig instance = new DataverseClientConfig();
        String expResult = "";
        String result = instance.getNativeApiVersion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNativeApiVersion method, of class DataverseClientConfig.
     */
    @Test
    public void testSetNativeApiVersion() {
        System.out.println("setNativeApiVersion");
        String nativeApiVersion = "";
        DataverseClientConfig instance = new DataverseClientConfig();
        instance.setNativeApiVersion(nativeApiVersion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSwordApiVersion method, of class DataverseClientConfig.
     */
    @Test
    public void testGetSwordApiVersion() {
        System.out.println("getSwordApiVersion");
        DataverseClientConfig instance = new DataverseClientConfig();
        String expResult = "";
        String result = instance.getSwordApiVersion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSwordApiVersion method, of class DataverseClientConfig.
     */
    @Test
    public void testSetSwordApiVersion() {
        System.out.println("setSwordApiVersion");
        String swordApiVersion = "";
        DataverseClientConfig instance = new DataverseClientConfig();
        instance.setSwordApiVersion(swordApiVersion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
