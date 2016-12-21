/*
 */
package edu.unc.irss.arc.dataverse.client.util;

import java.util.logging.Logger;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Akio Sone, Univ, of North Carolina at Chapel Hill, H.W. Odum Inst.
 */
public class MinimumFieldsForDataverse {

    private static final Logger logger = Logger.getLogger(MinimumFieldsForDataverse.class.getName());

    @NotNull(message = "alias is compulsory")
    @NotBlank(message = "Please enter an alias.")
    @Size(max = 60, message = "Alias must be at most 60 characters.")
    @Pattern.List({
        @Pattern(regexp = "[a-zA-Z0-9\\_\\-]*", message = "Found an illegal character(s). Valid characters are a-Z, 0-9, '_', and '-'."),
        @Pattern(regexp = ".*\\D.*", message = "Alias should not be a number")})
    private String alias;

    /**
     * Get the value of alias
     *
     * @return the value of alias
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Set the value of alias
     *
     * @param alias new value of alias
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    @NotNull(message = "name is compulsory")
    @NotBlank(message = "Please enter a name.")
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

    private String affiliation;

    /**
     * Get the value of affiliation
     *
     * @return the value of affiliation
     */
    public String getAffiliation() {
        return affiliation;
    }

    /**
     * Set the value of affiliation
     *
     * @param affiliation new value of affiliation
     */
    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    private String description;

    /**
     * Get the value of description
     *
     * @return the value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the value of description
     *
     * @param description new value of description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @NotNull(message = "Email Address is compulsory")
    @NotBlank(message = "Email Address is compulsory")
    @Email(message = "Email Address is not a valid format")
    private String contactEmail;

    /**
     * Get the value of contactEmail
     *
     * @return the value of contactEmail
     */
    public String getContactEmail() {
        return contactEmail;
    }

    /**
     * Set the value of contactEmail
     *
     * @param contactEmail new value of contactEmail
     */
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    /**
     *
     * @param alias
     * @param name
     * @param affiliation
     * @param description
     * @param contactEmail
     */
    public MinimumFieldsForDataverse(String alias, String name, String affiliation, String description, String contactEmail) {
        this.alias = alias;
        this.name = name;
        this.affiliation = affiliation;
        this.description = description;
        this.contactEmail = contactEmail;
    }

    /**
     *
     */
    public MinimumFieldsForDataverse() {
    }

    @Override
    public String toString() {
        return "MinimumFieldsForDataverse{" + "alias=" + alias + ", name=" + name + ", affiliation=" + affiliation + ", description=" + description + ", contactEmail=" + contactEmail + '}';
    }

    /**
     *
     */
    public static class Builder {

        private MinimumFieldsForDataverse minimumFieldsForDataverse
                = new MinimumFieldsForDataverse();

        /**
         *
         * @param alias
         * @return
         */
        public Builder withAlias(String alias) {
            minimumFieldsForDataverse.alias = alias;
            return this;
        }

        /**
         *
         * @param name
         * @return
         */
        public Builder withName(String name) {
            minimumFieldsForDataverse.name = name;
            return this;
        }

        /**
         *
         * @param affiliation
         * @return
         */
        public Builder withAffiliation(String affiliation) {
            minimumFieldsForDataverse.affiliation = affiliation;
            return this;
        }

        /**
         *
         * @param description
         * @return
         */
        public Builder withDescription(String description) {
            minimumFieldsForDataverse.description = description;
            return this;
        }

        /**
         *
         * @param contactEmail
         * @return
         */
        public Builder withContactEmail(String contactEmail) {
            minimumFieldsForDataverse.contactEmail = contactEmail;
            return this;
        }

        /**
         *
         * @return
         */
        public MinimumFieldsForDataverse create() {
            return minimumFieldsForDataverse;
        }
    }

}
