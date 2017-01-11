package edu.unc.irss.arc.dataverse.client;

import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Akio Sone, Univ, of North Carolina at Chapel Hill, H.W. Odum Inst.
 */
public class DataverseClientConfig {
    
    private static final Logger logger = 
            Logger.getLogger(DataverseClientConfig.class.getName());
    
    /**
     *
     */
    public static String NATIVE_API_CURRENT_VERSION="v1";
    
    /**
     *
     */
    public static String SWORD_API_CURRENT_VERSION="v1.1";
    
    
    
    
        // baseline fields 


    private String server;

    /**
     * Get the value of server
     *
     * @return the value of server
     */
    public String getServer() {
        return server;
    }

    /**
     * Set the value of server
     *
     * @param server new value of server
     */
    public void setServer(String server) {
        this.server = server;
    }



    private String target;

    /**
     * Get the value of target
     *
     * @return the value of target
     */
    public String getTarget() {
        return target;
    }

    /**
     * Set the value of target
     *
     * @param target new value of target
     */
    public void setTarget(String target) {
        this.target = target;
    }

    private String path;

    /**
     * Get the value of path
     *
     * @return the value of path
     */
    public String getPath() {
        return path;
    }

    /**
     * Set the value of path
     *
     * @param path new value of path
     */
    public void setPath(String path) {
        this.path = path;
    }

    private String apiKey;

    /**
     * Get the value of apiKey
     *
     * @return the value of apiKey
     */
    public String getApiKey() {
        return apiKey;
    }

    /**
     * Set the value of apiKey
     *
     * @param apiKey new value of apiKey
     */
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    private String persistentId;

    /**
     * Get the value of persistentId
     *
     * @return the value of persistentId
     */
    public String getPersistentId() {
        return persistentId;
    }

    /**
     * Set the value of persistentId
     *
     * @param persistentId new value of persistentId
     */
    public void setPersistentId(String persistentId) {
        this.persistentId = persistentId;
    }

    private String apiVersion="1.0";

    /**
     * Get the value of apiVersion
     *
     * @return the value of apiVersion
     */
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * Set the value of apiVersion
     *
     * @param apiVersion new value of apiVersion
     */
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }    
    
    
    
    // native api specific fields
    private String dataverseAlias;

    /**
     * Get the value of dataverseAlias
     *
     * @return the value of dataverseAlias
     */
    public String getDataverseAlias() {
        return dataverseAlias;
    }

    /**
     * Set the value of dataverseAlias
     *
     * @param dataverseAlias new value of dataverseAlias
     */
    public void setDataverseAlias(String dataverseAlias) {
        this.dataverseAlias = dataverseAlias;
    }
    
    private String dataverseId;

    /**
     * Get the value of dataverseId
     *
     * @return the value of dataverseId
     */
    public String getDataverseId() {
        return dataverseId;
    }

    /**
     * Set the value of dataverseId
     *
     * @param dataverseId new value of dataverseId
     */
    public void setDataverseId(String dataverseId) {
        this.dataverseId = dataverseId;
    }
    
    private String groupAlias;

    /**
     * Get the value of groupAlias
     *
     * @return the value of groupAlias
     */
    public String getGroupAlias() {
        return groupAlias;
    }

    /**
     * Set the value of groupAlias
     *
     * @param groupAlias new value of groupAlias
     */
    public void setGroupAlias(String groupAlias) {
        this.groupAlias = groupAlias;
    }
    
    private String groupId;

    /**
     * Get the value of groupId
     *
     * @return the value of groupId
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * Set the value of groupId
     *
     * @param groupId new value of groupId
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
    
    private String name;

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    // sword api specific fields
    
    private String zipFileLocation;

    /**
     * Get the value of zipFileLocation
     *
     * @return the value of zipFileLocation
     */
    public String getZipFileLocation() {
        return zipFileLocation;
    }

    /**
     * Set the value of zipFileLocation
     *
     * @param zipFileLocation new value of zipFileLocation
     */
    public void setZipFileLocation(String zipFileLocation) {
        this.zipFileLocation = zipFileLocation;
    }
    
    
        private String requestURI;

    /**
     * Get the value of requestURI
     *
     * @return the value of requestURI
     */
    public String getRequestURI() {
        return requestURI;
    }

    /**
     * Set the value of requestURI
     *
     * @param requestURI new value of requestURI
     */
    public void setRequestURI(String requestURI) {
        this.requestURI = requestURI;
    }

    
        private String nativeApiVersion;

    /**
     * Get the value of nativeApiVersion
     *
     * @return the value of nativeApiVersion
     */
    public String getNativeApiVersion() {
        return StringUtils.isBlank(nativeApiVersion) || 
                !nativeApiVersion.startsWith("v") ? 
                NATIVE_API_CURRENT_VERSION : nativeApiVersion;
    }

    /**
     * Set the value of nativeApiVersion
     *
     * @param nativeApiVersion new value of nativeApiVersion
     */
    public void setNativeApiVersion(String nativeApiVersion) {
        this.nativeApiVersion = nativeApiVersion;
    }

    
    
    
    
    
    private String swordApiVersion;

    /**
     * Get the value of swordApiVersion
     *
     * @return the value of swordApiVersion
     */
    public String getSwordApiVersion() {
        return StringUtils.isBlank(swordApiVersion) || 
                !swordApiVersion.startsWith("v") ? 
                SWORD_API_CURRENT_VERSION : swordApiVersion;
    }

    /**
     * Set the value of swordApiVersion
     *
     * @param swordApiVersion new value of swordApiVersion
     */
    public void setSwordApiVersion(String swordApiVersion) {
        this.swordApiVersion = swordApiVersion;
    }
    
    /**
     *
     * @return
     */
    public String getServerURI(){
        
        return "https://"+ server;
    }

    @Override
    public String toString() {
        return "DataverseClientConfig{" + "server=" + server + ", target=" + target + ", path=" + path + ", apiKey=" + apiKey + ", persistentId=" + persistentId + ", apiVersion=" + apiVersion + ", dataverseAlias=" + dataverseAlias + ", dataverseId=" + dataverseId + ", groupAlias=" + groupAlias + ", groupId=" + groupId + ", name=" + name + ", zipFileLocation=" + zipFileLocation + ", requestURI=" + requestURI + ", nativeApiVersion=" + nativeApiVersion + ", swordApiVersion=" + swordApiVersion + '}';
    }
    
    

}
