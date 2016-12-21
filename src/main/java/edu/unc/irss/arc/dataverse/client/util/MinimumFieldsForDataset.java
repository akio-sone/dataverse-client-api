/*
 */
package edu.unc.irss.arc.dataverse.client.util;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Akio Sone, Univ, of North Carolina at Chapel Hill, H.W. Odum Inst.
 */
public class MinimumFieldsForDataset {

    /**
     *
     */
    public enum Subject {

        /**
         *
         */
        AGRICULTURAL_SCIENCES("Agricultural Sciences"),

        /**
         *
         */
        ARTS_AND_HUMANITIES("Arts and Humanities"),

        /**
         *
         */
        ASTRONOMY_AND_ASTROPHYSICS("Astronomy and Astrophysics"),

        /**
         *
         */
        BUSINESS_AND_MANAGEMENT("Business and Management"),

        /**
         *
         */
        CHEMISTRY("Chemistry"),

        /**
         *
         */
        COMPUTER_AND_INFORMATION_SCIENCE("Computer and Information Science"),

        /**
         *
         */
        EARTH_AND_ENVIRONMENTAL_SCIENCES("Earth and Environmental Sciences"),

        /**
         *
         */
        ENGINEERING("Engineering"),

        /**
         *
         */
        LAW("Law"),

        /**
         *
         */
        MATHEMATICAL_SCIENCES("Mathematical Sciences"),

        /**
         *
         */
        MEDICINE_HEALTH_AND_LIFE_SCIENCES("Medicine, Health and Life Sciences"),

        /**
         *
         */
        PHYSICS("Physics"),

        /**
         *
         */
        SOCIAL_SCIENCES("Social Sciences"),

        /**
         *
         */
        OTHER("Other");

        private String value;

        private Subject(String value) {
            this.value = value;

        }

        /**
         *
         * @return
         */
        public String getValue() {
            return value;
        }
    }

    @NotNull(message = "title is compulsory")
    @NotBlank(message = "Please enter a title.")
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

    private String authorAffiliation;

    /**
     * Get the value of authorAffiliation
     *
     * @return the value of authorAffiliation
     */
    public String getAuthorAffiliation() {
        return authorAffiliation;
    }

    /**
     * Set the value of authorAffiliation
     *
     * @param authorAffiliation new value of authorAffiliation
     */
    public void setAuthorAffiliation(String authorAffiliation) {
        this.authorAffiliation = authorAffiliation;
    }

    @NotNull(message = "authorName is compulsory")
    @NotBlank(message = "Please enter an author name.")
    private String authorName;

    /**
     * Get the value of authorName
     *
     * @return the value of authorName
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     * Set the value of authorName
     *
     * @param authorName new value of authorName
     */
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    @NotNull(message = "Email Address is compulsory")
    @NotBlank(message = "Email Address is compulsory")
    @Email(message = "Email Address is not a valid format")
    private String emailAddress;

    /**
     * Get the value of emailAddress
     *
     * @return the value of emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Set the value of emailAddress
     *
     * @param emailAddress new value of emailAddress
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @NotNull(message = "description is compulsory")
    @NotBlank(message = "Please enter a description.")
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

    private Subject subject;

    /**
     * Get the value of subject
     *
     * @return the value of subject
     */
    public Subject getSubject() {
        return subject;
    }

    /**
     * Set the value of subject
     *
     * @param subject new value of subject
     */
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    /**
     *
     * @return
     */
    public String getSubjectValue() {
        return subject.value;
    }

    /**
     *
     * @param title
     * @param autherAffiliation
     * @param authorName
     * @param emailAddress
     * @param description
     * @param subject
     */
    public MinimumFieldsForDataset(String title, String autherAffiliation, String authorName, String emailAddress, String description, Subject subject) {
        this.title = title;
        this.authorAffiliation = autherAffiliation;
        this.authorName = authorName;
        this.emailAddress = emailAddress;
        this.description = description;
        this.subject = subject;
    }

    /**
     *
     */
    protected MinimumFieldsForDataset() {
    }

    @Override
    public String toString() {
        return "MinimumFieldsForDataset{" + "title=" + title + ", authorAffiliation=" + authorAffiliation + ", authorName=" + authorName + ", emailAddress=" + emailAddress + ", description=" + description + ", subject=" + subject + '}';
    }

    /**
     *
     */
    public static class Builder {

        // instance to be furnished with attributes
        private MinimumFieldsForDataset minimumFieldsForDataset
                = new MinimumFieldsForDataset();

        // attributes

        /**
         *
         * @param title
         * @return
         */
        public Builder withTitle(String title) {
            minimumFieldsForDataset.title = title;
            return this;
        }

        /**
         *
         * @param autherAffiliation
         * @return
         */
        public Builder withAutherAffiliation(String autherAffiliation) {
            minimumFieldsForDataset.authorAffiliation = autherAffiliation;
            return this;
        }

        /**
         *
         * @param authorName
         * @return
         */
        public Builder withAuthorName(String authorName) {
            minimumFieldsForDataset.authorName = authorName;
            return this;
        }

        /**
         *
         * @param emailAddress
         * @return
         */
        public Builder withEmailAddress(String emailAddress) {
            minimumFieldsForDataset.emailAddress = emailAddress;
            return this;
        }

        /**
         *
         * @param description
         * @return
         */
        public Builder withDescription(String description) {
            minimumFieldsForDataset.setDescription(description);
            return this;
        }

        /**
         *
         * @param subject
         * @return
         */
        public Builder withSubject(Subject subject) {
            minimumFieldsForDataset.setSubject(subject);
            return this;
        }

        // creation method

        /**
         *
         * @return
         */
        public MinimumFieldsForDataset create() {
            return minimumFieldsForDataset;
        }
    }

}
