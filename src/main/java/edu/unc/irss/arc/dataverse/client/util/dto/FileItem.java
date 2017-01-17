package edu.unc.irss.arc.dataverse.client.util.dto;

import java.util.logging.Logger;

/**
 *
 * @author Akio Sone, Univ, of North Carolina at Chapel Hill, H.W. Odum Inst.
 */
public class FileItem {

    private static final Logger logger = Logger.getLogger(FileItem.class.getName());

    /**
     *
     * @param id
     * @param filename
     * @param storageIdentifier
     * @param contentType
     */
    public FileItem(Long id, String filename, String storageIdentifier, String contentType) {
        this.id = id;
        this.filename = filename;
        this.storageIdentifier = storageIdentifier;
        this.contentType = contentType;
    }

    
    
    
    
    
    
    private Long id;

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(Long id) {
        this.id = id;
    }

        private String filename;

    /**
     * Get the value of filename
     *
     * @return the value of filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Set the value of filename
     *
     * @param filename new value of filename
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

        private String storageIdentifier;

    /**
     * Get the value of storageIdentifier
     *
     * @return the value of storageIdentifier
     */
    public String getStorageIdentifier() {
        return storageIdentifier;
    }

    /**
     * Set the value of storageIdentifier
     *
     * @param storageIdentifier new value of storageIdentifier
     */
    public void setStorageIdentifier(String storageIdentifier) {
        this.storageIdentifier = storageIdentifier;
    }

        private String contentType;

    /**
     * Get the value of contentType
     *
     * @return the value of contentType
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * Set the value of contentType
     *
     * @param contentType new value of contentType
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public String toString() {
        return "Datafile={" + "id=" + id + ", filename=" + filename + ", storageIdentifier=" + storageIdentifier + ", contentType=" + contentType + '}';
    }

    
    
    
}
