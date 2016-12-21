package edu.unc.irss.arc.dataverse.client.util.xml;

import java.util.Map;
import java.util.logging.Logger;

/**
 * Stores the contents of a returned object from a SWORD2 request as
 * a data transfer object
 * 
 * @author Akio Sone, Univ, of North Carolina at Chapel Hill, H.W. Odum Inst.
 */
public class DepositReceipt {

    private static final Logger logger = Logger.getLogger(DepositReceipt.class.getName());

    /**
     *
     * @param bibliographicCitation
     * @param id
     * @param treatment
     * @param links
     */
    public DepositReceipt(String bibliographicCitation, String id, 
            String treatment, Map<String, String> links) {
        this.bibliographicCitation = bibliographicCitation;
        this.id = id;
        this.treatment = treatment;
        this.links = links;
    }

    
    
        private String bibliographicCitation;

    /**
     * Get the value of bibliographicCitation
     *
     * @return the value of bibliographicCitation
     */
    public String getBibliographicCitation() {
        return bibliographicCitation;
    }

    /**
     * Set the value of bibliographicCitation
     *
     * @param bibliographicCitation new value of bibliographicCitation
     */
    public void setBibliographicCitation(String bibliographicCitation) {
        this.bibliographicCitation = bibliographicCitation;
    }

    
        private String id;

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public String getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(String id) {
        this.id = id;
    }

    
    
    
        private String treatment;

    /**
     * Get the value of treatment
     *
     * @return the value of treatment
     */
    public String getTreatment() {
        return treatment;
    }

    /**
     * Set the value of treatment
     *
     * @param treatment new value of treatment
     */
    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    
    
    
        private Map<String, String> links;

    /**
     * Get the value of links
     *
     * @return the value of links
     */
    public Map getLinks() {
        return links;
    }

    /**
     * Set the value of links
     *
     * @param links new value of links
     */
    public void setLinks(Map links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "DepositReceipt{" + "bibliographicCitation=" + bibliographicCitation + ", id=" + id + ", treatment=" + treatment + ", links=" + links + '}';
    }

    
}
