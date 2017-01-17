/*
 */
package edu.unc.irss.arc.dataverse.client.util.dto;

import java.util.logging.Logger;

/**
 *
 * @author Akio Sone, Univ, of North Carolina at Chapel Hill, H.W. Odum Inst.
 */
public class DvItem {
    private static final Logger logger = Logger.getLogger(DvItem.class.getName());
    
    
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

    
    
        private String type;

    /**
     * Get the value of type
     *
     * @return the value of type
     */
    public String getType() {
        return type;
    }

    /**
     * Set the value of type
     *
     * @param type new value of type
     */
    public void setType(String type) {
        this.type = type;
    }

    
    
        private String title;

    /**
     * Get the value of title
     *
     * @return the value of title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the value of title
     *
     * @param title new value of title
     */
    public void setTitle(String title) {
        this.title = title;
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

    /**
     *
     * @param id
     * @param type
     * @param title
     * @param persistentId
     */
    public DvItem(Long id, String type, String title, String persistentId) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.persistentId = persistentId;
    }

    @Override
    public String toString() {
        return "DvItem={" + "id=" + id + ", type=" + type + ", title=" + title + ", persistentId=" + persistentId + '}';
    }

    
}
