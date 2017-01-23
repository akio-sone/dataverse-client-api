/*
 */
package edu.unc.irss.arc.dataverse.client.util.xml;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class AtomfeedParserTest {
    
    private static final Logger logger = Logger.getLogger(AtomfeedParserTest.class.getName());
    
    private String depositReceiptString;
    public AtomfeedParserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("\n\nexcuting the unit tests of AtomfeedParserTest\n\n");
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        depositReceiptString="<entry xmlns=\"http://www.w3.org/2005/Atom\">\n" +
"    <bibliographicCitation xmlns=\"http://purl.org/dc/terms/\">testuser, api, 2016, \"another dataset in an unpublished dataverse within an unpublished dataverse\", doi:10.5072/FK2/E8IB8Q, Root Dataverse, DRAFT VERSION [UNF:6:ZWIYlMKfx+MHLqGRd3MLuA==]</bibliographicCitation>\n" +
"    <generator uri=\"http://www.swordapp.org/\" version=\"2.0\"/>\n" +
"    <id>https://dvn41-akiotest.irss.unc.edu/dvn/api/data-deposit/v1.1/swordv2/edit/study/doi:10.5072/FK2/E8IB8Q</id>\n" +
"    <link href=\"https://dvn41-akiotest.irss.unc.edu/dvn/api/data-deposit/v1.1/swordv2/edit/study/doi:10.5072/FK2/E8IB8Q\" rel=\"edit\"/>\n" +
"    <link href=\"https://dvn41-akiotest.irss.unc.edu/dvn/api/data-deposit/v1.1/swordv2/edit/study/doi:10.5072/FK2/E8IB8Q\" rel=\"http://purl.org/net/sword/terms/add\"/>\n" +
"    <link href=\"https://dvn41-akiotest.irss.unc.edu/dvn/api/data-deposit/v1.1/swordv2/edit-media/study/doi:10.5072/FK2/E8IB8Q\" rel=\"edit-media\"/>\n" +
"    <link href=\"https://dvn41-akiotest.irss.unc.edu/dvn/api/data-deposit/v1.1/swordv2/statement/study/doi:10.5072/FK2/E8IB8Q\" rel=\"http://purl.org/net/sword/terms/statement\" type=\"application/atom+xml; type=feed\"/>\n" +
"    <treatment xmlns=\"http://purl.org/net/sword/terms/\">no treatment information available</treatment>\n" +
"    <link href=\"http://dx.doi.org/10.5072/FK2/E8IB8Q\" rel=\"alternate\"/>\n" +
"</entry>";
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of parseDepositReceipt method with the encoding, 
     * of class AtomfeedParser.
     */
    @Test
    public void testParseDepositReceipt() {
        System.out.println("parseDepositReceipt with the encoding param");
        InputStream in = AtomfeedParser.class.getResourceAsStream("/xml/depositReceipt.xml");
        String encoding = "utf8";
        AtomfeedParser instance = new AtomfeedParser();
        DepositReceipt dr = instance.parseDepositReceipt(in, encoding);
        logger.log(Level.INFO, "deposit receipt={0}", dr);
        assertEquals("testuser, api, 2016, \"another dataset in an unpublished dataverse within an unpublished dataverse\", doi:10.5072/FK2/E8IB8Q, Root Dataverse, DRAFT VERSION [UNF:6:ZWIYlMKfx+MHLqGRd3MLuA==]", dr.getBibliographicCitation());
        assertEquals("https://dvn41-akiotest.irss.unc.edu/dvn/api/data-deposit/v1.1/swordv2/edit/study/doi:10.5072/FK2/E8IB8Q", dr.getId());
        assertEquals("no treatment information available", dr.getTreatment());

        
    }
    
    
    /**
     * Test of parseDepositReceipt method with default encoding, 
     * of class AtomfeedParser.
     */
    @Test
    public void testParseDepositReceiptWOencoding() {
        System.out.println("parseDepositReceipt with no encoding param");
        InputStream in = AtomfeedParser.class.getResourceAsStream("/xml/depositReceipt.xml");
        AtomfeedParser instance = new AtomfeedParser();
        DepositReceipt dr = instance.parseDepositReceipt(in);
        logger.log(Level.INFO, "deposit receipt={0}", dr);
        assertEquals("testuser, api, 2016, \"another dataset in an unpublished dataverse within an unpublished dataverse\", doi:10.5072/FK2/E8IB8Q, Root Dataverse, DRAFT VERSION [UNF:6:ZWIYlMKfx+MHLqGRd3MLuA==]", dr.getBibliographicCitation());
        assertEquals("https://dvn41-akiotest.irss.unc.edu/dvn/api/data-deposit/v1.1/swordv2/edit/study/doi:10.5072/FK2/E8IB8Q", dr.getId());
        assertEquals("no treatment information available", dr.getTreatment());

        
    }
    
    /**
     * Test of parseDepositReceipt method with default encoding and
     * String of class AtomfeedParser.
     */
    
    
    @Test 
    public void testParseDepositReceiptWOencodingFromString(){
        System.out.println("parseDepositReceipt from a String with no encoding param");
        
        AtomfeedParser instance = new AtomfeedParser();
        DepositReceipt dr = instance.parseDepositReceipt(depositReceiptString);
        logger.log(Level.INFO, "deposit receipt={0}", dr);
        assertEquals("testuser, api, 2016, \"another dataset in an unpublished dataverse within an unpublished dataverse\", doi:10.5072/FK2/E8IB8Q, Root Dataverse, DRAFT VERSION [UNF:6:ZWIYlMKfx+MHLqGRd3MLuA==]", dr.getBibliographicCitation());
        assertEquals("https://dvn41-akiotest.irss.unc.edu/dvn/api/data-deposit/v1.1/swordv2/edit/study/doi:10.5072/FK2/E8IB8Q", dr.getId());
        assertEquals("no treatment information available", dr.getTreatment());

        
    }
}
