/*
 */
package edu.unc.irss.arc.dataverse.client.util;

import static org.hamcrest.Matchers.equalTo;
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
public class MinimumFieldsForDatasetTest {
    
    public MinimumFieldsForDatasetTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("\n\nexcuting the unit tests of MinimumFieldsForDatasetTest\n\n");
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
     * Test of Builder class of class MinimumFieldsForDataset.
     */
    @Test
    public void shouldRunApplication() {
        MinimumFieldsForDataset ms = new MinimumFieldsForDataset.Builder().withTitle("this is title").withAutherAffiliation("unc").withAuthorName("sone, akio").withEmailAddress("asone@email").withSubject(MinimumFieldsForDataset.Subject.MEDICINE_HEALTH_AND_LIFE_SCIENCES).create();
        System.out.println("ms="+ms);
        assertThat(ms.getTitle(), equalTo("this is title"));
        assertThat(ms.getAuthorAffiliation(), equalTo("unc"));
        assertThat(ms.getAuthorName(), equalTo("sone, akio"));
        assertThat(ms.getEmailAddress(), equalTo("asone@email"));
        assertThat(ms.getSubjectValue(), equalTo("Medicine, Health and Life Sciences"));
        
    }
        
    
    
    
}
