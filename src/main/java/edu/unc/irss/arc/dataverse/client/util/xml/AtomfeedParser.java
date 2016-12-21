package edu.unc.irss.arc.dataverse.client.util.xml;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSParser;

/**
 * Parses an ATOM-formated returned object. This class may not be required once
 * the native API included the file-submission functionality.
 *
 * @author Akio Sone, Univ, of North Carolina at Chapel Hill, H.W. Odum Inst.
 */
public class AtomfeedParser {

    private static final Logger logger = Logger.getLogger(AtomfeedParser.class.getName());

    String bibliographicCitation;

    String id;

    String treatment;


    Map<String, String> links = new LinkedHashMap<>();

    DepositReceipt depositReceipt;

    /**
     *
     * @param in
     * @return
     */
    public DepositReceipt parseDepositReceipt(InputStream in) {
        return parseDepositReceipt(in, StandardCharsets.UTF_8.name());
    }

    /**
     *
     * @param in
     * @param encoding
     * @return
     */
    public DepositReceipt parseDepositReceipt(InputStream in, String encoding) {

        String parsedText = null;
        LSParser builder = null;

        LSInput depositReceiptInXML = null;

        // get DOM Implementation using DOM Registry
        DOMImplementationRegistry registry = null;
        try {

            registry = DOMImplementationRegistry.newInstance();

            DOMImplementationLS impl
                    = (DOMImplementationLS) registry.getDOMImplementation("LS");

            // create DOMBuilder
            builder = impl.createLSParser(DOMImplementationLS.MODE_SYNCHRONOUS, null);

            depositReceiptInXML = impl.createLSInput();

            depositReceiptInXML.setEncoding(encoding);

            DOMConfiguration config = builder.getDomConfig();

            // set validation feature
            config.setParameter("validate", Boolean.FALSE);

            // !important: this configuration changes the count of child nodes below
            // by removing white-space text nodes
            config.setParameter("element-content-whitespace", Boolean.FALSE);

            // parse document
//            logger.log(Level.INFO, "Parsing {0} ...", depositReceiptInXML);
            logger.log(Level.INFO, "Parsing a deposit receipt");
            //Document doc = builder.parseURI(depositReceiptInXML);
            depositReceiptInXML.setByteStream(in);
            Document doc = builder.parse(depositReceiptInXML);

            XPathFactory xpathfactory = XPathFactory.newInstance();
            XPath xPath = xpathfactory.newXPath();

            XPathExpression expr = null;

            expr = xPath.compile("/*[local-name() = 'entry']/*[local-name() = 'bibliographicCitation']");
            bibliographicCitation = (String) expr.evaluate(doc, XPathConstants.STRING);
            logger.log(Level.INFO, "bibliographicCitation={0}", bibliographicCitation);

            expr = xPath.compile("/*[local-name() = 'entry']/*[local-name() = 'id']");

            id = (String) expr.evaluate(doc, XPathConstants.STRING);
            logger.log(Level.INFO, "id={0}", id);

            expr = xPath.compile("/*[local-name() = 'entry']/*[local-name() = 'link']");
            NodeList linkList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

            for (int i = 0; i < linkList.getLength(); i++) {
                Node linkTag = linkList.item(i);

                String rel = linkTag.getAttributes().getNamedItem("rel").getNodeValue();

                logger.log(Level.INFO, "rel={0}", rel);

                String href = linkTag.getAttributes().getNamedItem("href").getNodeValue();
                logger.log(Level.INFO, "href={0}", href);

                links.put(rel, href);

            }

            expr = xPath.compile("/*[local-name() = 'entry']/*[local-name() = 'treatment']");
            treatment = (String) expr.evaluate(doc, XPathConstants.STRING);
            logger.log(Level.INFO, "treatment={0}", treatment);

            depositReceipt = new DepositReceipt(bibliographicCitation, id, treatment, links);

        } catch (ClassNotFoundException ex) {
            logger.log(Level.SEVERE, "", ex);
        } catch (InstantiationException ex) {
            logger.log(Level.SEVERE, "", ex);
        } catch (IllegalAccessException ex) {
            logger.log(Level.SEVERE, "", ex);
        } catch (ClassCastException ex) {
            logger.log(Level.SEVERE, "", ex);
        } catch (XPathExpressionException ex) {
            logger.log(Level.SEVERE, "", ex);
        }

        return depositReceipt;

    }

//    public static void main(String[] args) {
//        System.out.println("parseDepositReceipt");
//        InputStream in = AtomfeedParser.class.getResourceAsStream("/depositReceipt.xml");
//        String encoding = "utf8";
//        AtomfeedParser instance = new AtomfeedParser();
//        String actual = instance.parseDepositReceipt(in, encoding);
//        System.out.println("parseDepositReceipt="+actual);
//    }
    
    /**
     *
     * @param result
     * @param encoding
     * @return
     * @throws UnsupportedEncodingException
     */
    public DepositReceipt parseDepositReceipt(String result, String encoding)
            throws UnsupportedEncodingException {

        InputStream in = new ByteArrayInputStream(result.getBytes(encoding));
        return parseDepositReceipt(in, encoding);

    }

    /**
     *
     * @param result
     * @return
     */
    public DepositReceipt parseDepositReceipt(String result) {
        
        InputStream in = new ByteArrayInputStream(result.getBytes(StandardCharsets.UTF_8));
        return parseDepositReceipt(in);

    }
    
}
