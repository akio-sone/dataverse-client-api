/*
 */
package edu.unc.irss.arc.dataverse.client.util.json;

/**
 *
 * @author Akio Sone, Univ, of North Carolina at Chapel Hill, H.W. Odum Inst.
 */
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 *
 * @author akios
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "id",
    "identifier",
    "persistentUrl",
    "protocol",
    "authority",
    "publisher",
    "type",
    "title"
})
public class Data {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("identifier")
    private String identifier;
    @JsonProperty("persistentUrl")
    private String persistentUrl;
    @JsonProperty("protocol")
    private String protocol;
    @JsonProperty("authority")
    private String authority;
    @JsonProperty("publisher")
    private String publisher;
    @JsonProperty("type")
    private String type;
    @JsonProperty("title")
    private String title;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Data() {
    }

    /**
     *
     * @param id
     * @param authority
     * @param title
     * @param protocol
     * @param type
     * @param persistentUrl
     * @param identifier
     * @param publisher
     */
    public Data(Long id, String identifier, String persistentUrl, String protocol, String authority, String publisher, String type, String title) {
        this.id = id;
        this.identifier = identifier;
        this.persistentUrl = persistentUrl;
        this.protocol = protocol;
        this.authority = authority;
        this.publisher = publisher;
        this.type = type;
        this.title = title;
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
    public Data withId(Long id) {
        this.id = id;
        return this;
    }

    /**
     *
     * @return The identifier
     */
    @JsonProperty("identifier")
    public String getIdentifier() {
        return identifier;
    }

    /**
     *
     * @param identifier The identifier
     */
    @JsonProperty("identifier")
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /**
     *
     * @param identifier
     * @return
     */
    public Data withIdentifier(String identifier) {
        this.identifier = identifier;
        return this;
    }

    /**
     *
     * @return The persistentUrl
     */
    @JsonProperty("persistentUrl")
    public String getPersistentUrl() {
        return persistentUrl;
    }

    /**
     *
     * @param persistentUrl The persistentUrl
     */
    @JsonProperty("persistentUrl")
    public void setPersistentUrl(String persistentUrl) {
        this.persistentUrl = persistentUrl;
    }

    /**
     *
     * @param persistentUrl
     * @return
     */
    public Data withPersistentUrl(String persistentUrl) {
        this.persistentUrl = persistentUrl;
        return this;
    }

    /**
     *
     * @return The protocol
     */
    @JsonProperty("protocol")
    public String getProtocol() {
        return protocol;
    }

    /**
     *
     * @param protocol The protocol
     */
    @JsonProperty("protocol")
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    /**
     *
     * @param protocol
     * @return
     */
    public Data withProtocol(String protocol) {
        this.protocol = protocol;
        return this;
    }

    /**
     *
     * @return The authority
     */
    @JsonProperty("authority")
    public String getAuthority() {
        return authority;
    }

    /**
     *
     * @param authority The authority
     */
    @JsonProperty("authority")
    public void setAuthority(String authority) {
        this.authority = authority;
    }

    /**
     *
     * @param authority
     * @return
     */
    public Data withAuthority(String authority) {
        this.authority = authority;
        return this;
    }

    /**
     *
     * @return The publisher
     */
    @JsonProperty("publisher")
    public String getPublisher() {
        return publisher;
    }

    /**
     *
     * @param publisher The publisher
     */
    @JsonProperty("publisher")
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     *
     * @param publisher
     * @return
     */
    public Data withPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    /**
     *
     * @return The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     *
     * @param type The type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @param type
     * @return
     */
    public Data withType(String type) {
        this.type = type;
        return this;
    }

    /**
     *
     * @return The title
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title The title
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @param title
     * @return
     */
    public Data withTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     *
     * @return
     */
    public String getPersistentId() {
        return this.getProtocol()
                + ":"
                + this.getAuthority()
                + "/"
                + this.getIdentifier();
    }

    @Override
    public String toString() {
        return "Data{" + "id=" + id + ", identifier=" + identifier + ", persistentUrl=" + persistentUrl + ", protocol=" + protocol + ", authority=" + authority + ", publisher=" + publisher + ", type=" + type + ", title=" + title + '}';
    }

//    @Override
//    public String toString() {
//        return ToStringBuilder.reflectionToString(this);
//    }

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
    public Data withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(identifier).append(persistentUrl).append(protocol).append(authority).append(publisher).append(type).append(title).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Data) == false) {
            return false;
        }
        Data rhs = ((Data) other);
        return new EqualsBuilder().append(id, rhs.id).append(identifier, rhs.identifier).append(persistentUrl, rhs.persistentUrl).append(protocol, rhs.protocol).append(authority, rhs.authority).append(publisher, rhs.publisher).append(type, rhs.type).append(title, rhs.title).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
