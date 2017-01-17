package edu.unc.irss.arc.dataverse.client.util.json;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import javax.validation.Valid;

/**
 *
 * @author akios
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "label",
    "version",
    "datasetVersionId",
    "dataFile"
})
public class File {

    @JsonProperty("label")
    private String label;
    @JsonProperty("version")
    private Long version;
    @JsonProperty("datasetVersionId")
    private Long datasetVersionId;
    @JsonProperty("dataFile")
    @Valid
    private Datafile datafile;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public File() {
    }

    /**
     *
     * @param datafile
     * @param label
     * @param datasetVersionId
     * @param version
     */
    public File(String label, Long version, Long datasetVersionId, Datafile datafile) {
        this.label = label;
        this.version = version;
        this.datasetVersionId = datasetVersionId;
        this.datafile = datafile;
    }

    public File(String filename) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return The label
     */
    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    /**
     *
     * @param label The label
     */
    @JsonProperty("label")
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     *
     * @param label
     * @return
     */
    public File withLabel(String label) {
        this.label = label;
        return this;
    }

    /**
     *
     * @return The version
     */
    @JsonProperty("version")
    public Long getVersion() {
        return version;
    }

    /**
     *
     * @param version The version
     */
    @JsonProperty("version")
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     *
     * @param version
     * @return
     */
    public File withVersion(Long version) {
        this.version = version;
        return this;
    }

    /**
     *
     * @return The datasetVersionId
     */
    @JsonProperty("datasetVersionId")
    public Long getDatasetVersionId() {
        return datasetVersionId;
    }

    /**
     *
     * @param datasetVersionId The datasetVersionId
     */
    @JsonProperty("datasetVersionId")
    public void setDatasetVersionId(Long datasetVersionId) {
        this.datasetVersionId = datasetVersionId;
    }

    /**
     *
     * @param datasetVersionId
     * @return
     */
    public File withDatasetVersionId(Long datasetVersionId) {
        this.datasetVersionId = datasetVersionId;
        return this;
    }

    /**
     *
     * @return The datafile
     */
    @JsonProperty("dataFile")
    public Datafile getDatafile() {
        return datafile;
    }

    /**
     *
     * @param datafile The datafile
     */
    @JsonProperty("dataFile")
    public void setDatafile(Datafile datafile) {
        this.datafile = datafile;
    }

    /**
     *
     * @param datafile
     * @return
     */
    public File withDatafile(Datafile datafile) {
        this.datafile = datafile;
        return this;
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
    public File withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return "File={" + "label=" + label + ", version=" + version + ", datasetVersionId=" + datasetVersionId + ", datafile=" + datafile + ", additionalProperties=" + additionalProperties + '}';
    }

}
