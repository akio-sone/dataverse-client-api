/*
 */
package edu.unc.irss.arc.dataverse.client.util.json;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
//import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *
 * @author Akio Sone, Univ, of North Carolina at Chapel Hill, H.W. Odum Inst.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "id",
    "filename",
    "contentType",
    "storageIdentifier",
    "originalFileFormat",
    "originalFormatLabel",
    "UNF",
    "md5"
})
public class Datafile {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("filename")
    private String filename;
    @JsonProperty("contentType")
    private String contentType;
    @JsonProperty("storageIdentifier")
    private String storageIdentifier;
    @JsonProperty("originalFileFormat")
    private String originalFileFormat;
    @JsonProperty("originalFormatLabel")
    private String originalFormatLabel;
    @JsonProperty("UNF")
    private String uNF;
    @JsonProperty("md5")
    private String md5;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Datafile() {
    }

    /**
     *
     * @param id
     * @param storageIdentifier
     * @param originalFormatLabel
     * @param md5
     * @param filename
     * @param contentType
     * @param originalFileFormat
     * @param uNF
     */
    public Datafile(Long id, String filename, String contentType, String storageIdentifier, String originalFileFormat, String originalFormatLabel, String uNF, String md5) {
        this.id = id;
        this.filename = filename;
        this.contentType = contentType;
        this.storageIdentifier = storageIdentifier;
        this.originalFileFormat = originalFileFormat;
        this.originalFormatLabel = originalFormatLabel;
        this.uNF = uNF;
        this.md5 = md5;
    }
    
    
    
    
    

    /**
     *
     * @return The id
     */
    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id The id
     */
    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @param id
     * @return
     */
    public Datafile withId(Long id) {
        this.id = id;
        return this;
    }

    /**
     *
     * @return The filename
     */
    @JsonProperty("filename")
    public String getFilename() {
        return filename;
    }

    /**
     *
     * @param filename The filename
     */
    @JsonProperty("filename")
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     *
     * @param filename
     * @return
     */
    public Datafile withFilename(String filename) {
        this.filename = filename;
        return this;
    }

    /**
     *
     * @return The contentType
     */
    @JsonProperty("contentType")
    public String getContentType() {
        return contentType;
    }

    /**
     *
     * @param contentType The contentType
     */
    @JsonProperty("contentType")
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /**
     *
     * @param contentType
     * @return
     */
    public Datafile withContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    /**
     *
     * @return The storageIdentifier
     */
    @JsonProperty("storageIdentifier")
    public String getStorageIdentifier() {
        return storageIdentifier;
    }

    /**
     *
     * @param storageIdentifier The storageIdentifier
     */
    @JsonProperty("storageIdentifier")
    public void setStorageIdentifier(String storageIdentifier) {
        this.storageIdentifier = storageIdentifier;
    }

    /**
     *
     * @param storageIdentifier
     * @return
     */
    public Datafile withStorageIdentifier(String storageIdentifier) {
        this.storageIdentifier = storageIdentifier;
        return this;
    }

    /**
     *
     * @return The originalFileFormat
     */
    @JsonProperty("originalFileFormat")
    public String getOriginalFileFormat() {
        return originalFileFormat;
    }

    /**
     *
     * @param originalFileFormat The originalFileFormat
     */
    @JsonProperty("originalFileFormat")
    public void setOriginalFileFormat(String originalFileFormat) {
        this.originalFileFormat = originalFileFormat;
    }

    /**
     *
     * @param originalFileFormat
     * @return
     */
    public Datafile withOriginalFileFormat(String originalFileFormat) {
        this.originalFileFormat = originalFileFormat;
        return this;
    }

    /**
     *
     * @return The originalFormatLabel
     */
    @JsonProperty("originalFormatLabel")
    public String getOriginalFormatLabel() {
        return originalFormatLabel;
    }

    /**
     *
     * @param originalFormatLabel The originalFormatLabel
     */
    @JsonProperty("originalFormatLabel")
    public void setOriginalFormatLabel(String originalFormatLabel) {
        this.originalFormatLabel = originalFormatLabel;
    }

    /**
     *
     * @param originalFormatLabel
     * @return
     */
    public Datafile withOriginalFormatLabel(String originalFormatLabel) {
        this.originalFormatLabel = originalFormatLabel;
        return this;
    }

    /**
     *
     * @return The uNF
     */
    @JsonProperty("UNF")
    public String getUNF() {
        return uNF;
    }

    /**
     *
     * @param uNF The UNF
     */
    @JsonProperty("UNF")
    public void setUNF(String uNF) {
        this.uNF = uNF;
    }

    /**
     *
     * @param uNF
     * @return
     */
    public Datafile withUNF(String uNF) {
        this.uNF = uNF;
        return this;
    }

    /**
     *
     * @return The md5
     */
    @JsonProperty("md5")
    public String getMd5() {
        return md5;
    }

    /**
     *
     * @param md5 The md5
     */
    @JsonProperty("md5")
    public void setMd5(String md5) {
        this.md5 = md5;
    }

    /**
     *
     * @param md5
     * @return
     */
    public Datafile withMd5(String md5) {
        this.md5 = md5;
        return this;
    }

//    @Override
//    public String toString() {
//        return ToStringBuilder.reflectionToString(this);
//    }

    @Override
    public String toString() {
        return "Datafile{" + "id=" + id + ", filename=" + filename + ", contentType=" + contentType + ", storageIdentifier=" + storageIdentifier + ", originalFileFormat=" + originalFileFormat + ", originalFormatLabel=" + originalFormatLabel + ", uNF=" + uNF + ", md5=" + md5 + ", additionalProperties=" + additionalProperties + '}';
    }

    /**
     *
     * @return
     */
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    /**
     *
     * @param name
     * @param value
     */
    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    /**
     *
     * @param name
     * @param value
     * @return
     */
    public Datafile withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
