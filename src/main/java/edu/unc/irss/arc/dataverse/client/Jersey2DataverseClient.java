package edu.unc.irss.arc.dataverse.client;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.TypeRef;
import com.jayway.jsonpath.spi.json.JacksonJsonProvider;
import com.jayway.jsonpath.spi.json.JsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import com.jayway.jsonpath.spi.mapper.MappingProvider;
import edu.unc.irss.arc.dataverse.client.util.GenericBuilder;
import edu.unc.irss.arc.dataverse.client.util.MinimumFieldsForDataset;
import edu.unc.irss.arc.dataverse.client.util.MinimumFieldsForDataverse;
import edu.unc.irss.arc.dataverse.client.util.dto.DvItem;
import edu.unc.irss.arc.dataverse.client.util.dto.FileItem;
import edu.unc.irss.arc.dataverse.client.util.json.Data;
import edu.unc.irss.arc.dataverse.client.util.zip.FileZipper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.apache.commons.lang3.StringUtils;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

/**
 * Client is the main entry point to submit client requests to a target
 * Dataverse 4.X or later via its Native APIs or SWORD 2.0 API.
 *
 * @author Akio Sone, Univ, of North Carolina at Chapel Hill, H.W. Odum Inst.
 */
public class Jersey2DataverseClient {

    private static final Logger logger
            = Logger.getLogger(Jersey2DataverseClient.class.getName());

    // the following block is required for using jsonpath
    static {
        Configuration.setDefaults(new Configuration.Defaults() {
            private final JsonProvider jsonProvider = new JacksonJsonProvider();
            private final MappingProvider mappingProvider = new JacksonMappingProvider();
            private final Set<Option> options = EnumSet.noneOf(Option.class);

            @Override
            public JsonProvider jsonProvider() {
                return jsonProvider;
            }

            @Override
            public MappingProvider mappingProvider() {
                return mappingProvider;
            }

            @Override
            public Set<Option> options() {
                return options;
            }
        });
    }

    private DataverseClientConfig clientConfig;

    private WebTarget webTarget;

    /**
     *
     */
    public static String NATIVE_API_URI_PREFIX = "/api";

    String getNativeApiUri(String endPath) {
        return NATIVE_API_URI_PREFIX + "/" + clientConfig.getNativeApiVersion()
                + endPath;
    }

    /**
     *
     */
    public static String SWORD_API_URI_PREFIX
            = "/dvn/api/data-deposit";

    /**
     *
     */
    public static String SWORD_API_URI_SUFFIX
            = "/swordv2/edit-media";

    String getSwordApiUri(String endPath) {
        return SWORD_API_URI_PREFIX + "/" + clientConfig.getSwordApiVersion()
                + SWORD_API_URI_SUFFIX + endPath;
    }

    private Client client;

    /**
     * Get the value of clientConfig
     *
     * @return the value of clientConfig
     */
    public DataverseClientConfig getClientConfig() {
        return clientConfig;
    }

    /**
     * Set the value of clientConfig
     *
     * @param clientConfig new value of clientConfig
     */
    public void setClientConfig(DataverseClientConfig clientConfig) {
        this.clientConfig = clientConfig;
    }

    /**
     *
     * @param clientConfig
     */
    public Jersey2DataverseClient(DataverseClientConfig clientConfig) {
        this.clientConfig = clientConfig;
        client = ClientBuilder.newClient();

        HttpAuthenticationFeature feature
                = HttpAuthenticationFeature.basic(clientConfig.getApiKey(), "");
        client.register(feature);

    }

    private final static String BUNDLE_NAME = "Bundle";
    private final static ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

    public static void main(String[] args) throws IOException {

        if (args.length != 5) {
            logger.log(Level.SEVERE, "Three arguments: dataverse_URL, Api_key, dataverse_Alias are expected dataset_Id file_location");
            throw new IllegalArgumentException("The number of arguments must be 5.");
        }

        for (int i = 0; i < args.length; i++) {
            System.out.println("arg[" + i + "]:=" + args[i]);
        }

        System.out.println("DV_API_KEY=" + System.getProperty("DV_API_KEY"));

        for (String arg : args) {
            logger.log(Level.INFO, "arg={0}", arg);
        }

        if (StringUtils.isBlank(args[0])) {
            logger.log(Level.SEVERE, "dataverse URL should not be blank");
            throw new IllegalArgumentException("dataverse URL should not be blank");
        }

        if (StringUtils.isBlank(args[1])) {
            logger.log(Level.SEVERE, "API key should not be blank");
            throw new IllegalArgumentException("API Key should not be blank");
        }

        if (StringUtils.isBlank(args[2])) {
            logger.log(Level.SEVERE, "dataverse alias should not be blank");
            throw new IllegalArgumentException("dataverse alias should not be blank");
        }

        if (StringUtils.isBlank(args[3])) {
            logger.log(Level.SEVERE, "dataset Id should not be blank");
            throw new IllegalArgumentException("dataset Id should not be blank");
        }

        if (StringUtils.isBlank(args[4])) {
            logger.log(Level.SEVERE, "file location should not be blank");
            throw new IllegalArgumentException("file location should not be blank");
        }

        // likely usage cases
        // Person value =
        // GenericBuilder.of(Person::new).with(Person::setName, "Otto").with(Person::setAge, 5).build();
        // file-uploading example case
        DataverseClientConfig clientConfig = GenericBuilder
                .of(DataverseClientConfig::new)
                .with(DataverseClientConfig::setServer, args[0])
                .with(DataverseClientConfig::setApiKey, args[1])
                .with(DataverseClientConfig::setDataverseAlias, args[2])
                .with(DataverseClientConfig::setPersistentId, args[3])
                .with(DataverseClientConfig::setZipFileLocation, args[4])
                .build();

        System.out.println("server=" + args[0]);
        System.out.println("apikey=" + args[1]);

        System.out.println("DataverseAlias=" + args[2]);
        System.out.println("setPersistentId=" + args[3]);
        System.out.println("setPersistentId=" + args[4]);

        // persistentId and zip-file location are stored in the config instance
        Jersey2DataverseClient dataverseClient = new Jersey2DataverseClient(clientConfig);
        //dataverseClient.addFilesToDataset();

    }

    // ------------------------------------------------------------------------
    // main method
    // ------------------------------------------------------------------------
    public String publishDatafile(String persistentId, File file) throws
            IllegalArgumentException, IOException {
        if (StringUtils.isBlank(persistentId)) {
            throw new IllegalArgumentException("persistentId should not be blank");
        } else if (persistentId.startsWith("doi:")) {
            persistentId = persistentId.replace("doi:", "");
        }

        if (!file.exists() || file.length() == 0L) {
            throw new IllegalArgumentException("A target file must exit and be non-empty");
        }

        return addFilesToDataset(file, persistentId);
    }

    public String publishDatafile(String persistentId, String filename) throws IllegalArgumentException, IOException {
        File file = new File(filename);
        return publishDatafile(persistentId, file);
    }
    // Native API Request Methods
    // SWORD2 API Reqiest Methods
    // ------------------------------------------------------------------------
    // dataverse-wise methods
    // ------------------------------------------------------------------------

    /**
     *
     * @param minset
     * @return
     * @throws WebApplicationException
     */
    public String createNonRootDataverseByAlias(MinimumFieldsForDataverse minset)
            throws WebApplicationException {

        // valid character [a-Z, 0-9, _-] for alias
        logger.log(Level.INFO, "createNonRootDataverseByAlias is called");

        Response response = null;
        String returnedResult = null;
        try {

            logger.log(Level.INFO, "uri={0}", clientConfig.getServerURI());
            logger.log(Level.INFO, "dataverseAlias={0}", minset.getAlias());
            logger.log(Level.INFO, "api_key={0}", clientConfig.getApiKey());

//        MinimumFieldsForDataverse minset = new MinimumFieldsForDataverse.Builder()
//                .withAlias(dataverseAlias)
//                .withName("dataverse name is here")
//                .withAffiliation("UNC Odum Inst")
//                .withDescription("created by jersey client")
//                .withContactEmail("asone@email.unc.edu").create();
            String template = RESOURCE_BUNDLE.getString("templateForDataverseCreation");
            String jsonString = MessageFormat.format(template, new Object[]{
                minset.getAlias(), minset.getName(), minset.getAffiliation(),
                minset.getDescription(), minset.getContactEmail()});

            logger.log(Level.INFO, "jsonString={0}", jsonString);

            webTarget = client.target(clientConfig.getServerURI()
                    + "/dataverses/:root")
                    .queryParam("key", clientConfig.getApiKey());

            response = webTarget.request(MediaType.APPLICATION_JSON)
                    .post(Entity.json(jsonString));

            int statusCode = response.getStatus();
            returnedResult = response.readEntity(String.class);

            logger.log(Level.INFO, "response.status={0}", statusCode);
            logger.log(Level.INFO, "response.readEntity={0}", returnedResult);

            if (statusCode == 201) {
                logger.log(Level.INFO, "creation of a new dataverse was successful");
            } else {
                // parse the returned code; Normal case 
                logger.log(Level.SEVERE, "creation of a new dataverse failed: status code={0}",
                        statusCode);
                throw new WebApplicationException(returnedResult, Status.fromStatusCode(statusCode));
            }

        } finally {
            if (response != null) {
                response.close();
            }
            //client.close();
        }
        return returnedResult;
    }

    /**
     *
     * @param dataverseAlias
     * @return
     * @throws IllegalArgumentException
     * @throws WebApplicationException
     */
    public String retrieveDataverseContentsByDataverseAlias(String dataverseAlias) throws IllegalArgumentException, WebApplicationException {

        logger.log(Level.INFO, "===== retrieveDataverseContentsByDataverseAlias is called =====");
        Response response = null;
        String returnedResult = null;

        try {
            if (StringUtils.isBlank(dataverseAlias)) {
                throw new IllegalArgumentException("dataverseAlias should not be blank");
            }

            logger.log(Level.INFO, "dataverseAlias={0}", dataverseAlias);

            webTarget = client.target(clientConfig.getServerURI()
                    + getNativeApiUri("/dataverses"))
                    .path(java.text.MessageFormat.format("{0}/contents", new Object[]{dataverseAlias}))
                    .queryParam("key", clientConfig.getApiKey());

            response = webTarget.request(MediaType.APPLICATION_JSON).get();

            int statusCode = response.getStatus();
            returnedResult = response.readEntity(String.class);

            logger.log(Level.INFO, "response.status={0}", statusCode);
            logger.log(Level.INFO, "response.readEntity={0}", returnedResult);

            if (statusCode == 200) {
                logger.log(Level.INFO, "retrieval of this dataverse was successful");
            } else {
                logger.log(Level.SEVERE, "retrieval of this dataverse failed: status code={0}",
                        statusCode);
                throw new WebApplicationException(returnedResult, Status.fromStatusCode(statusCode));
            }
        } finally {
            if (response != null) {
                response.close();
            }
            //client.close();
        }
        return returnedResult;
    }

    /**
     *
     * @param dataverseId
     * @return
     * @throws IllegalArgumentException
     * @throws WebApplicationException
     */
    public String retrieveDataverseContentsByDataverseId(Long dataverseId)
            throws IllegalArgumentException, WebApplicationException {
        logger.log(Level.INFO, "===== retrieveDataverseContentsByDataverseId is called =====");
        Response response = null;
        String returnedResult = "";
        try {
            if (dataverseId < 1L || StringUtils.isBlank(dataverseId.toString())) {
                throw new IllegalArgumentException("dataverseId must be a positive integer");
            }

            logger.log(Level.INFO, "dataverseId={0}", dataverseId);

            webTarget = client.target(clientConfig.getServerURI()
                    + getNativeApiUri("/dataverses"))
                    .path(java.text.MessageFormat.format("{0}/contents", new Object[]{dataverseId.toString()}))
                    .queryParam("key", clientConfig.getApiKey());

            response = webTarget.request(MediaType.APPLICATION_JSON).get();

            int statusCode = response.getStatus();
            returnedResult = response.readEntity(String.class);

            logger.log(Level.INFO, "response.status={0}", statusCode);
            logger.log(Level.INFO, "response.readEntity={0}", returnedResult);

            if (statusCode == 200) {
                logger.log(Level.INFO, "retrieval of this dataverse was successful");

            } else {

                logger.log(Level.SEVERE, "retrieval of this dataverse failed: status code={0}",
                        statusCode);
                throw new WebApplicationException(returnedResult, Status.fromStatusCode(statusCode));
            }

        } finally {
            if (response != null) {
                response.close();
            }
            //client.close();
        }
        return returnedResult;
    }

    /**
     *
     * @param result
     * @return
     */
    public List<DvItem> parseDataverseContentsFromString(String result) {
        logger.log(Level.INFO,
                "================= parseDataverseContentsFromString =================");
        logger.log(Level.INFO, "result={0}", result);

        List<DvItem> lstDv = new ArrayList<>();
        try {

            if (StringUtils.isBlank(result)) {
                throw new IllegalArgumentException("result should not be blank");
            }

            Configuration configuration = Configuration.defaultConfiguration();
            MappingProvider mappingProvider = new JacksonMappingProvider();
            configuration.mappingProvider(mappingProvider);

            DocumentContext dtx = JsonPath.using(configuration).parse(result);

            TypeRef<List<Data>> type = new TypeRef<List<Data>>() {
            };

            List<Data> lf = dtx.read("$.data", type);
//            System.out.println("data-size=" + lf.size() +"\n\n");
//            System.out.println("data[0]=" + lf.get(0) +"\n\n");
//            System.out.println("data=" + lf +"\n\n");
//            lf.forEach((k) -> System.out.println("data="
//                    + k.getId()+"\t"
//                    + k.getType()+"\t"
//                    + k.getTitle()+"\t"
//                    + k.getProtocol()+":"+k.getAuthority()+"/"+k.getIdentifier()
//                    +"\n"));

            lf.stream().forEach((dt) -> {
                lstDv.add(new DvItem(dt.getId(), dt.getType(), dt.getTitle(),
                        dt.getPersistentId()));
            });

            logger.log(Level.INFO, "lstDv={0}", lstDv);
        } catch (IllegalArgumentException ex) {
            logger.log(Level.INFO, "IllegalArgumentException was thrown: result string is blank", ex);
        }

        return lstDv;
    }

    /**
     *
     * @param jsonFileName
     * @return
     */
    public List<DvItem> parseDataverseContentsFromFile(String jsonFileName) {
        logger.log(Level.INFO,
                "=================parseDataverseContentsFromFile=================");
        logger.log(Level.INFO, "jsonFileName={0}", jsonFileName);

        List<DvItem> lstDv = new ArrayList<>();
        try (InputStream inputStream = getClass().getResourceAsStream(jsonFileName)) {

            Configuration configuration = Configuration.defaultConfiguration();
            MappingProvider mappingProvider = new JacksonMappingProvider();
            configuration.mappingProvider(mappingProvider);

            DocumentContext dtx = JsonPath.using(configuration).parse(inputStream);

            TypeRef<List<Data>> type = new TypeRef<List<Data>>() {
            };

            List<Data> lf = dtx.read("$.data", type);
//            System.out.println("data-size=" + lf.size() + "\n\n");
//            System.out.println("data[0]=" + lf.get(0) + "\n\n");
//            System.out.println("data=" + lf + "\n\n");
//            lf.forEach((k) -> System.out.println("data="
//                    + k.getId() + "\t"
//                    + k.getType() + "\t"
//                    + k.getTitle() + "\t"
//                    + k.getProtocol() + ":" + k.getAuthority() + "/" + k.getIdentifier()
//                    + "\n"));

            lf.stream().forEach((dt) -> {
                lstDv.add(new DvItem(dt.getId(), dt.getType(), dt.getTitle(),
                        dt.getPersistentId()));
            });

            logger.log(Level.INFO, "lstDv={0}", lstDv);
        } catch (IllegalArgumentException ex) {
            logger.log(Level.INFO, "IllegalArgumentException was thrown: the input file missing?", ex);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "IOExceoption was thrown", ex);
        }

        return lstDv;
    }

    /**
     *
     * @param dataverseAlias
     * @return
     * @throws IllegalArgumentException
     * @throws WebApplicationException
     */
    public String deleteNonRootDataverseByDataverseAlias(String dataverseAlias)
            throws IllegalArgumentException, WebApplicationException {

        logger.log(Level.INFO, "deleteNonRootDataverseByDataverseAlias is called");

        Response response = null;
        String returnedResult = null;
        try {

            logger.log(Level.INFO, "uri={0}", clientConfig.getServerURI());
            logger.log(Level.INFO, "dataverseAlias={0}", dataverseAlias);
            logger.log(Level.INFO, "api_key={0}", clientConfig.getApiKey());

            if (StringUtils.isBlank(dataverseAlias)) {
                throw new IllegalArgumentException("dataverseAlias must be a non-blank string");
            }

            webTarget = client.target(clientConfig.getServerURI()
                    + getNativeApiUri("/dataverses"))
                    .path(dataverseAlias)
                    .queryParam("key", clientConfig.getApiKey());

            response = webTarget.request().delete();

            int statusCode = response.getStatus();
            returnedResult = response.readEntity(String.class);

            logger.log(Level.INFO, "response.status={0}", statusCode);
            logger.log(Level.INFO, "response.readEntity={0}", returnedResult);

            if (statusCode == 200) {
                logger.log(Level.INFO, "deletion of a dataverse was successful");
            } else {
                logger.log(Level.SEVERE, "deletion of a dataverse failed: status code={0}",
                        statusCode);
                throw new WebApplicationException(returnedResult, Status.fromStatusCode(statusCode));
            }

        } finally {
            if (response != null) {
                response.close();
            }
            //client.close();
        }
        return returnedResult;
    }

    /**
     *
     * @param dataverseId
     * @return
     * @throws IllegalArgumentException
     */
    public String deleteNonRootDataverseByDataverseId(Long dataverseId)
            throws IllegalArgumentException {

        logger.log(Level.INFO, "deleteNonRootDataverseByDataverseId is called");

        Response response = null;
        String returnedResult = null;

        try {
            logger.log(Level.INFO, "uri={0}", clientConfig.getServerURI());
            logger.log(Level.INFO, "dataverseId={0}", dataverseId.toString());
            logger.log(Level.INFO, "api_key={0}", clientConfig.getApiKey());

            if (dataverseId < 1L || StringUtils.isBlank(dataverseId.toString())) {
                throw new IllegalArgumentException("dataverseAlias must be a positive integer");
            }

            webTarget = client.target(clientConfig.getServerURI()
                    + getNativeApiUri("/dataverses"))
                    .path(dataverseId.toString())
                    .queryParam("key", clientConfig.getApiKey());

            response = webTarget.request().delete();

            int statusCode = response.getStatus();
            returnedResult = response.readEntity(String.class);

            logger.log(Level.INFO, "response.status={0}", statusCode);
            logger.log(Level.INFO, "response.readEntity={0}", returnedResult);

            if (statusCode == 200) {
                logger.log(Level.INFO, "deletion of a dataverse was successful");
            } else {
                logger.log(Level.SEVERE, "deletion of a dataverse failed: status code={0}",
                        statusCode);
                throw new WebApplicationException(returnedResult, Status.fromStatusCode(statusCode));
            }
        } finally {
            if (response != null) {
                response.close();
            }
            //client.close();
        }

        return returnedResult;
    }

    // ------------------------------------------------------------------------
    // dataset-wise methods
    // ------------------------------------------------------------------------
//    public String createDatasetJsonString (MinimumFieldsForDataset minset){
//                    
//            
//            String title ="dataset created by native api with minimal meta data";
//            String autherAffiliation = "UNC Odum Inst";
//            String authorName ="Sone, Akio";
//            String emailAddress ="asone@email.unc.edu";
//            String controlVocabulary="Other";
//            
//        String template = RESOURCE_BUNDLE.getString("templateForDatasetCreation");
//        String datasetMetadata = MessageFormat.format(template, new Object[]{minset.getTitle(), minset.getAuthorAffiliation(), minset.getAuthorName(), minset.getEmailAddress(), minset.getSubjectValue()});
//        logger.log(Level.INFO, "jsonstring={0}", datasetMetadata);
//        
//            return datasetMetadata;
//    }
    /**
     *
     * @param dataverseId
     * @param minset
     * @return
     * @throws IllegalArgumentException
     * @throws WebApplicationException
     */
    public String createDatasetByDataverseId(String dataverseId,
            MinimumFieldsForDataset minset) throws IllegalArgumentException,
            WebApplicationException {

        logger.log(Level.INFO, "createDatasetByDataverseId is called");

        Response response = null;
        String returnedResult = null;

        try {
            if (StringUtils.isBlank(dataverseId)) {
                throw new IllegalArgumentException("dataverseId should not be blank");
            }

            logger.log(Level.INFO, "dataverseId={0}", dataverseId);

//        MinimumFieldsForDataset minset = new MinimumFieldsForDataset.Builder().withTitle("this is a new dataset created by Jersey client trail 4").withAutherAffiliation("UNC Odum Inst").withAuthorName("sone, akio").withEmailAddress("asone@email.unc.edu").withSubject(MinimumFieldsForDataset.Subject.OTHER).create();
            String template = RESOURCE_BUNDLE.getString("templateForDatasetCreation");

            String jsonString = MessageFormat.format(template, new Object[]{minset.getTitle(), minset.getAuthorAffiliation(), minset.getAuthorName(), minset.getEmailAddress(), minset.getDescription(), minset.getSubjectValue()});

            logger.log(Level.INFO, "jsonString={0}", jsonString);

            webTarget = client.target(clientConfig.getServerURI()
                    + getNativeApiUri("/dataverses"))
                    .path(java.text.MessageFormat.format("{0}/datasets/", dataverseId))
                    .queryParam("key", clientConfig.getApiKey());

            response = webTarget.request()
                    .header("Content-Type", "application/json")
                    .post(Entity.json(jsonString));

            int statusCode = response.getStatus();
            returnedResult = response.readEntity(String.class);

            logger.log(Level.INFO, "response.status={0}", statusCode);
            logger.log(Level.INFO, "response.readEntity={0}", returnedResult);

            if (statusCode == 201) {
                logger.log(Level.INFO, "New dataset was successfully created");
            } else {
                logger.log(Level.SEVERE, "dataset was not created: status code={0}",
                        statusCode);
                throw new WebApplicationException(returnedResult, Response.Status.fromStatusCode(statusCode));

            }

        } finally {
            if (response != null) {
                response.close();
            }
            //client.close();
        }
        return returnedResult;
    }

    /**
     *
     * @param dataverseAlias
     * @param minset
     * @return
     * @throws IllegalArgumentException
     * @throws WebApplicationException
     */
    public String createDatasetByDataverseAlias(String dataverseAlias,
            MinimumFieldsForDataset minset) throws IllegalArgumentException,
            WebApplicationException {

        logger.log(Level.INFO, "createDatasetByDataverseAlias is called");

        Response response = null;
        String returnedResult = null;

        try {
            if (StringUtils.isBlank(dataverseAlias)) {
                throw new IllegalArgumentException("dataverseAlias should not be blank");
            }

            logger.log(Level.INFO, "dataverseAlias={0}", dataverseAlias);

//        MinimumFieldsForDataset minset = new MinimumFieldsForDataset.Builder().withTitle("this is a new dataset created by Jersey client trial 6").withAutherAffiliation("UNC Odum Inst").withAuthorName("sone, akio").withEmailAddress("asone@email.unc.edu").withSubject(MinimumFieldsForDataset.Subject.OTHER).create();
            String template = RESOURCE_BUNDLE.getString("templateForDatasetCreation");

            String jsonString = MessageFormat.format(template, new Object[]{minset.getTitle(), minset.getAuthorAffiliation(), minset.getAuthorName(), minset.getEmailAddress(), minset.getDescription(), minset.getSubjectValue()});

            logger.log(Level.INFO, "jsonString={0}", jsonString);

            webTarget = client.target(clientConfig.getServerURI()
                    + getNativeApiUri("/dataverses"))
                    .path(java.text.MessageFormat.format("{0}/datasets/", dataverseAlias))
                    .queryParam("key", clientConfig.getApiKey());

            response = webTarget.request()
                    .header("Content-Type", "application/json")
                    .post(Entity.json(jsonString));

            int statusCode = response.getStatus();
            returnedResult = response.readEntity(String.class);

            logger.log(Level.INFO, "response.status={0}", statusCode);
            logger.log(Level.INFO, "response.readEntity={0}", returnedResult);

            if (statusCode == 201) {
                logger.log(Level.INFO, "New dataset was successfully created");
            } else {
                logger.log(Level.SEVERE, "dataset was not created: status code={0}",
                        statusCode);
                throw new WebApplicationException(returnedResult, Response.Status.fromStatusCode(statusCode));
            }
        } finally {
            if (response != null) {
                response.close();
            }
            //client.close();
        }
        return returnedResult;
    }

    /**
     *
     * @param result
     * @return
     */
    public Long parseDatasetCreateRequestFromString(String result) {
        logger.log(Level.INFO, "parseDatasetCreateRequestFromString called");
        logger.log(Level.INFO, "result={0}", result);
        Long datasetId = null;
        try {

            if (StringUtils.isBlank(result)) {
                throw new IllegalArgumentException("result should not be blank");
            }

            Configuration configuration = Configuration.defaultConfiguration();
            MappingProvider mappingProvider = new JacksonMappingProvider();
            configuration.mappingProvider(mappingProvider);

            DocumentContext dtx = JsonPath.using(configuration).parse(result);

            datasetId = dtx.read("$.data.id", Long.class);

            logger.log(Level.INFO, "returned datasetId={0}", datasetId);

        } catch (IllegalArgumentException ex) {
            logger.log(Level.INFO, "IllegalArgumentException was thrown: result string is blank", ex);
        }

        return datasetId;
    }

    /**
     *
     * @param datasetId
     * @return
     */
    public String retrieveDatasetContentsByDatasetId(String datasetId) {
        Response response = null;
        String returnedResult = null;

        try {
            if (StringUtils.isBlank(datasetId)) {
                throw new IllegalArgumentException("datasetId should not be blank");
            }

            logger.log(Level.INFO, "datasetId={0}", datasetId);

            webTarget = client.target(clientConfig.getServerURI()
                    + getNativeApiUri("/datasets"))
                    .path(java.text.MessageFormat.format("{0}", new Object[]{datasetId}))
                    .queryParam("key", clientConfig.getApiKey());

            response = webTarget.request(MediaType.APPLICATION_JSON).get();

            int statusCode = response.getStatus();
            returnedResult = response.readEntity(String.class);

            logger.log(Level.INFO, "response.status={0}", statusCode);
            logger.log(Level.FINE, "response.readEntity={0}", returnedResult);
            if (statusCode == 200) {
                logger.log(Level.INFO, "retrieval of this dataset was successful");
            } else {
                // parse the returned code; Normal case 
                logger.log(Level.SEVERE, "retrieval of this dataset failed: status code={0}",
                        statusCode);
                throw new WebApplicationException("getting the contents of the dataset failed", Status.fromStatusCode(statusCode));

            }
//        } catch (IllegalArgumentException ex) {
//            logger.log(Level.SEVERE, "datasetId was blank and retrieval was aborted",
//                    ex);
        } finally {
            if (response != null) {
                response.close();
            }
            //client.close();
        }
        return returnedResult;
    }

    /**
     *
     * @param persistentId
     * @return
     */
    public String retrieveDatasetContentsByPersistentId(String persistentId) {

        Response response = null;
        String returnedResult = null;

        try {
            if (StringUtils.isBlank(persistentId)) {
                throw new IllegalArgumentException("persistentId should not be blank");
            }

            logger.log(Level.INFO, "persistentId={0}", persistentId);

            webTarget = client.target(clientConfig.getServerURI()
                    + getNativeApiUri("/datasets"))
                    .path(java.text.MessageFormat.format("{0}", new Object[]{":persistentId"}))
                    .queryParam("persistentId", persistentId)
                    .queryParam("key", clientConfig.getApiKey());

            response = webTarget.request(MediaType.APPLICATION_JSON).get();

            int statusCode = response.getStatus();
            returnedResult = response.readEntity(String.class);

            logger.log(Level.INFO, "response.status={0}", statusCode);
            logger.log(Level.INFO, "response.readEntity={0}", returnedResult);
            if (statusCode == 200) {
                logger.log(Level.INFO, "retrieval of this dataset was successful");
            } else {
                // parse the returned code; Normal case 
                logger.log(Level.SEVERE, "retrieval of this dataset failed: status code={0}",
                        statusCode);
            }
        } catch (IllegalArgumentException ex) {
            logger.log(Level.SEVERE, "persistentId was blank and retrieval was aborted",
                    ex);
        } finally {
            if (response != null) {
                response.close();
            }
            //client.close();
        }
        return returnedResult;
    }

    /**
     *
     * @param result
     * @return
     */
    public List<FileItem> parseReturnedDatasetContentsFromString(String result) {
        logger.log(Level.INFO,
                "=================parseReturnedDatasetContentsFromString=================");
        List<FileItem> ldf = new ArrayList<>();

        logger.log(Level.FINE, "result={0}", result);

        try {

            if (StringUtils.isBlank(result)) {
                throw new IllegalArgumentException("result should not be blank");
            }

            Configuration configuration = Configuration.defaultConfiguration();
            MappingProvider mappingProvider = new JacksonMappingProvider();
            configuration.mappingProvider(mappingProvider);

            DocumentContext dtx = JsonPath.using(configuration).parse(result);

            /*
             * after
             * http://stackoverflow.com/questions/30026642/map-a-jsonpath-output-to-a-list-of-pojos
             */
            TypeRef<List<edu.unc.irss.arc.dataverse.client.util.json.File>> type = new TypeRef<List<edu.unc.irss.arc.dataverse.client.util.json.File>>() {
            };

            List<edu.unc.irss.arc.dataverse.client.util.json.File> lf = dtx.read("$.data.latestVersion.files", type);
            System.out.println("files-size=" + lf.size() + "\n\n");
            System.out.println("files[0]=" + lf.get(0));

            lf.forEach((k) -> System.out.println("file=" + k + "\n"));

            lf.forEach((k) -> {
                // relevant items here
                // Long id, String filename, String contentType, 
                // String storageIdentifier, String originalFileFormat, 
                // String originalFormatLabel, String uNF, String md5
                ldf.add(//                        new Datafile(k.getDatafile().getId(),
                        //                        k.getDatafile().getFilename(),
                        //                        k.getDatafile().getContentType(),
                        //                        k.getDatafile().getStorageIdentifier(),
                        //                        k.getDatafile().getOriginalFileFormat(),
                        //                        k.getDatafile().getOriginalFormatLabel(),
                        //                        k.getDatafile().getUNF(),
                        //                        k.getDatafile().getMd5())
                        //                         ));

                        new FileItem(
                                k.getDatafile().getId(),
                                k.getDatafile().getFilename(),
                                k.getDatafile().getStorageIdentifier(),
                                k.getDatafile().getContentType())
                );

            });

            logger.log(Level.FINE, "ldf={0}", ldf);

        } catch (IllegalArgumentException ex) {
            logger.log(Level.INFO, "IllegalArgumentException was thrown: the input file missing?", ex);
        }

        return ldf;
    }

    public String getDatasetIdFromDatasetContentsFromString(String result) {
        logger.log(Level.FINE, "result={0}", result);

        if (StringUtils.isBlank(result)) {
            throw new IllegalArgumentException("result should not be blank");
        }

        Configuration configuration = Configuration.defaultConfiguration();
        MappingProvider mappingProvider = new JacksonMappingProvider();
        configuration.mappingProvider(mappingProvider);

        DocumentContext dtx = JsonPath.using(configuration).parse(result);
        List<String> idList = dtx.read("$.data..identifier", List.class);
        logger.log(Level.INFO, "dataset identifier[0]={0}", idList.get(0));
        //String datasetId = dtx.read("$.data[0].identifier");
        //logger.log(Level.INFO, "dataset identifier={0}", datasetId);

        return idList.get(0);
    }

    /**
     * A convenience method to directly return a list of datafile Ids from a
     * returned response in Json
     *
     * @param result returned Json string
     * @return list of datafileIds
     */
    public List<String> getDatafileIdListFromDatasetContentsFromString(String result) {
        logger.log(Level.INFO,
                "=================getDatafileIdListFromDatasetContentsFromString=================");
        List<String> datafileIdList = new ArrayList<>();
        List<Long> datafileIdLList = new ArrayList<>();
        logger.log(Level.FINE, "result={0}", result);
        List<FileItem> ldf = parseReturnedDatasetContentsFromString(result);
        logger.log(Level.FINE, "ldf={0}", ldf);
        (parseReturnedDatasetContentsFromString(result)).forEach((fi) -> {
            datafileIdList.add(fi.getId().toString());
            //datafileIdLList.add(fi.getId());
        });
        //datafileIdList.sort(Comparator.naturalOrder());
        //datafileIdLList.sort(String::compareTo);
        logger.log(Level.INFO, "datafileIdList={0}", datafileIdList);
        //logger.log(Level.INFO, "datafileIdLList={0}", datafileIdLList);
        return datafileIdList;
    }

    /**
     *
     * @param jsonFileName
     * @return
     */
    public List<FileItem> parseReturnedDatasetContentsFromFile(String jsonFileName) {
        logger.log(Level.INFO,
                "=================parseReturnedDatasetContents=================");
        List<FileItem> ldf = new ArrayList<>();

        logger.log(Level.INFO, "jsonFileName={0}", jsonFileName);

        try (InputStream inputStream = getClass().getResourceAsStream(jsonFileName)) {

            Configuration configuration = Configuration.defaultConfiguration();
            MappingProvider mappingProvider = new JacksonMappingProvider();
            configuration.mappingProvider(mappingProvider);

            DocumentContext dtx = JsonPath.using(configuration).parse(inputStream);

            /*
             * after
             * http://stackoverflow.com/questions/30026642/map-a-jsonpath-output-to-a-list-of-pojos
             */
            TypeRef<List<edu.unc.irss.arc.dataverse.client.util.json.File>> type = new TypeRef<List<edu.unc.irss.arc.dataverse.client.util.json.File>>() {
            };

            List<edu.unc.irss.arc.dataverse.client.util.json.File> lf = dtx.read("$.data.latestVersion.files", type);
            System.out.println("files-size=" + lf.size() + "\n\n");
            System.out.println("files[0]=" + lf.get(0));

            lf.forEach((k) -> System.out.println("file=" + k + "\n"));

            lf.forEach((k) -> {
                // relevant items here
                // Long id, String filename, String contentType, 
                // String storageIdentifier, String originalFileFormat, 
                // String originalFormatLabel, String uNF, String md5
                ldf.add(//                        new Datafile(k.getDatafile().getId(),
                        //                        k.getDatafile().getFilename(),
                        //                        k.getDatafile().getContentType(),
                        //                        k.getDatafile().getStorageIdentifier(),
                        //                        k.getDatafile().getOriginalFileFormat(),
                        //                        k.getDatafile().getOriginalFormatLabel(),
                        //                        k.getDatafile().getUNF(),
                        //                        k.getDatafile().getMd5())
                        //                         ));

                        new FileItem(
                                k.getDatafile().getId(),
                                k.getDatafile().getFilename(),
                                k.getDatafile().getStorageIdentifier(),
                                k.getDatafile().getContentType())
                );

            });

            logger.log(Level.INFO, "ldf={0}", ldf);

        } catch (IllegalArgumentException ex) {
            logger.log(Level.INFO, "IllegalArgumentException was thrown: the input file missing?", ex);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "IOExceoption was thrown", ex);
        }

        return ldf;
    }

    // stub code for the for the future Native API
    private String uploadFilesToDataset() throws IOException {

        if (StringUtils.isNotBlank(clientConfig.getZipFileLocation())
                && StringUtils.isNotBlank(clientConfig.getPersistentId())) {
            File zipFile = new File(clientConfig.getZipFileLocation());

            // TODO replace null with a new method
            return null;

        } else {
            logger.log(Level.SEVERE, "ZipFileLocation and zip-file location must be not blank");
            throw new IllegalArgumentException("Zip-file location and PersistentId must be not blank");

        }

    }

    /**
     * Uploads the pre-set zip file to the pre-set target Dataverse dataset. The
     * specified payload file may not be a zip file.
     *
     * @return the returned response from the Dataverse as as {@code String}
     * @throws java.io.IOException
     */
    public String addFilesToDataset() throws IOException {

        if (StringUtils.isNotBlank(clientConfig.getZipFileLocation())
                && StringUtils.isNotBlank(clientConfig.getPersistentId())) {
            File zipFile = new File(clientConfig.getZipFileLocation());

            return addFilesToDataset(zipFile, clientConfig.getPersistentId());

        } else {
            logger.log(Level.SEVERE, "ZipFileLocation and zip-file location must be not blank");
            throw new IllegalArgumentException("Zip-file location and PersistentId must be not blank");

        }
    }

    /**
     * Uploads the pre-specified file to the target Dataverse dataset.
     *
     * @param persistentId The persistent id of the target dataset
     * @return the returned response from the Dataverse as as {@code String}
     * @throws java.io.IOException
     */
    public String addFilesToDataset(String persistentId) throws IOException {

        if (StringUtils.isBlank(clientConfig.getZipFileLocation())) {
            logger.log(Level.SEVERE, "ZipFileLocation is not specified");
            throw new NullPointerException("Zip File Location is not specified");
        } else {
//            File zipFile = new File(clientConfig.getZipFileLocation());
//            return addFilesToDataset(zipFile, persistentId);
            clientConfig.setPersistentId(persistentId);
            return addFilesToDataset();

        }
    }

    /**
     * Uploads the pre-specified file to the target Dataverse dataset.
     *
     * @param zipFile the file or the directory to be uploaded
     * @param persistentId the persistent id of the target dataset
     * @return the returned response from the Dataverse as a {@code String}
     * @throws java.io.IOException
     */
    public String addFilesToDataset(java.io.File zipFile, String persistentId) throws IOException {
        logger.log(Level.INFO, "persistentId={0}", persistentId);

        Response response = null;
        String returnedResult = null;

        boolean isOriginalZip = true;

        try {

            // check arguments first
            if (!zipFile.exists()) {
                logger.log(Level.INFO, "zip file [{0}] does not exist",
                        zipFile.getAbsolutePath());
                throw new IllegalArgumentException("zip file does not exist");
            } else if (StringUtils.isBlank(persistentId)) {
                logger.log(Level.INFO, "persistentId is blank");
                throw new IllegalArgumentException("persistentId is blank");
            }

            // checks wheter the file is a zip file
            if (!FileZipper.isZipFile(zipFile)) {
                // the file is not a zip file; try to zip it as a temp file
                try {
                    FileZipper fz = new FileZipper();

                    Path sourcePath = zipFile.toPath();
                    Path zipPath = Files.createTempFile("uploadToDataverse_", ".zip");
                    fz.create(sourcePath, zipPath);
                    zipFile = zipPath.toFile();
                } catch (IOException ex) {
                    logger.log(Level.SEVERE, "IOException was thrown", ex);
                    throw ex;
                }

                isOriginalZip = false;

            } else {
                logger.log(Level.INFO, "{0} is a zip file",
                        clientConfig.getZipFileLocation());
            }

            logger.log(Level.INFO, "serverURI={0}", clientConfig.getServerURI());
            logger.log(Level.INFO, "zip file path={0}", zipFile.getAbsolutePath());
            webTarget = client.target(clientConfig.getServerURI()
                    + getSwordApiUri("/study")).path(persistentId);

            response = webTarget
                    .request()
                    .header("Content-Disposition", "filename=" + zipFile.getName())
                    .header("Content-Type", "application/zip")
                    .header("Packaging", "http://purl.org/net/sword/package/SimpleZip")
                    //                    .header("Content-MD5", "d1a80c8a550c515ef5c697d16516dbc0")
                    .post(Entity.entity(zipFile, MediaType.APPLICATION_OCTET_STREAM));

            int statusCode = response.getStatus();
            returnedResult = response.readEntity(String.class);

            logger.log(Level.INFO, "response.status={0}", statusCode);
            logger.log(Level.INFO, "response.readEntity={0}", returnedResult);

            if (statusCode == 201) {
                logger.log(Level.INFO, "adding files to a dataset was successful");
            } else {
                // parse the returned code; Normal case 
                logger.log(Level.SEVERE, "adding files to a dataset failed: status code={0}",
                        statusCode);
            }

        } catch (IllegalArgumentException ex) {
            logger.log(Level.SEVERE, "arguments are not valid", ex);
        } finally {
            if (response != null) {
                response.close();
            }
            //client.close();
        }

        if (!isOriginalZip) {
            logger.log(Level.INFO, "A temporarily crated zip file ({0}) will be delted on exit", zipFile.getAbsolutePath());
            zipFile.deleteOnExit();
        }
        return returnedResult;
    }

    /**
     * Uploads the file or the set of files to the target Dataverse dataset. The
     * specified location may not be a zip file.
     *
     * @param zipFileLocation the absolute path of the file or directory
     * @param persistentId the persistent id of the target dataset
     * @return the returned response from the Dataverse as a {@code String}
     * @throws java.io.IOException
     */
    public String addFilesToDataset(String zipFileLocation, String persistentId) throws IOException {
        logger.log(Level.INFO, "pathToFile={0}", zipFileLocation);
        logger.log(Level.INFO, "persistentId={0}", persistentId);

        File zipFile = new File(zipFileLocation);

        return addFilesToDataset(zipFile, persistentId);

    }

    /**
     *
     * @param datasetId
     * @return
     * @throws IllegalArgumentException
     * @throws WebApplicationException
     */
    public String deleteDatasetByDatasetId(Long datasetId) throws
            IllegalArgumentException, WebApplicationException {

        logger.log(Level.INFO, "deleting a dataset whose id={0}", datasetId);

        // natvie-api-based method
        // DELETE http://$SERVER/api/datasets/$id?key=$apiKey
        Response response = null;
        String returnedResult = null;

        try {

            if (datasetId < 1 || StringUtils.isBlank(datasetId.toString())) {
                throw new IllegalArgumentException("datasetId must be a postive integer");
            }

            webTarget = client.target(clientConfig.getServerURI()
                    + getNativeApiUri("/datasets")).path(datasetId.toString()).
                    queryParam("key", clientConfig.getApiKey());

            response = webTarget.request().delete();

            int statusCode = response.getStatus();
            returnedResult = response.readEntity(String.class);

            logger.log(Level.INFO, "response.status={0}", statusCode);
            logger.log(Level.INFO, "response.readEntity={0}", returnedResult);

            if (statusCode == 200) {
                logger.log(Level.INFO, "deleting a dataset was successful");
            } else {
                logger.log(Level.SEVERE, "deleting a dataset failed: status code={0}",
                        statusCode);
                throw new WebApplicationException(returnedResult, Response.Status.fromStatusCode(statusCode));
            }

        } finally {
            if (response != null) {
                response.close();
            }
            //client.close();
        }
        return returnedResult;
    }

    /**
     *
     * @param persistentId
     * @return
     * @throws IllegalArgumentException
     * @throws WebApplicationException
     */
    public String deleteDatasetByPersistentId(String persistentId)
            throws IllegalArgumentException, WebApplicationException {

        logger.log(Level.INFO, "deleting a dataset whose persistentId={0}",
                persistentId);

        // natvie-api-based method
        // DELETE http://$SERVER/api/datasets/$id?key=$apiKey
        Response response = null;
        String returnedResult = null;

        try {

            if (StringUtils.isBlank(persistentId)) {
                throw new IllegalArgumentException("datasetId should not be blank");
            }

            webTarget = client.target(clientConfig.getServerURI()
                    + getNativeApiUri("/datasets")).path(persistentId).
                    queryParam("key", clientConfig.getApiKey());

            response = webTarget.request().delete();

            int statusCode = response.getStatus();
            returnedResult = response.readEntity(String.class);
            logger.log(Level.INFO, "response.status={0}", statusCode);
            logger.log(Level.INFO, "response.readEntity={0}", returnedResult);

            if (statusCode == 200) {
                logger.log(Level.INFO, "deleting a dataset was successful");
            } else {
                logger.log(Level.SEVERE, "deleting a dataset failed: status code={0}",
                        statusCode);
                throw new WebApplicationException(returnedResult,
                        Response.Status.fromStatusCode(statusCode));
            }
        } finally {
            if (response != null) {
                response.close();
            }
            //client.close();
        }

        return returnedResult;
    }

    /**
     *
     * @param result
     * @return
     */
    public String parseDatasetDeleteRequestFromString(String result) {
        String message = null;
        try {

            if (StringUtils.isBlank(result)) {
                throw new IllegalArgumentException("result should not be blank");
            }

            Configuration configuration = Configuration.defaultConfiguration();
            MappingProvider mappingProvider = new JacksonMappingProvider();
            configuration.mappingProvider(mappingProvider);

            DocumentContext dtx = JsonPath.using(configuration).parse(result);

            message = dtx.read("$.data.message", String.class);

            logger.log(Level.INFO, "returned message={0}", message);
        } catch (IllegalArgumentException ex) {
            logger.log(Level.INFO, "IllegalArgumentException was thrown: result string is blank", ex);
        }

        return message;
    }

    public void downloadDatasetByDatasetId(String datasetId, String destDir) {

    }

    public void downloadDatasetByPersistentId(String persistentId, String destDir) {

        // step get a set of datafileIds
        // loop through the set to download files
    }

    // ------------------------------------------------------------------------
    // datafile-wise methods
    // ------------------------------------------------------------------------
    /**
     * Downloads a single datafile from Dataverse by its Id and saves it as a
     * zip file in a directory of the local file system.
     *
     * @param datafileId the Id of a datafile to be downloaded
     * @param destDir the directory in which a datafile to be downloaded is
     * saved
     */
    public void downloadDatafileByDatafileId(String datafileId, String destDir) {
        // requirement: get file id
        logger.log(Level.INFO, "downloading a datafile whose id={0}", datafileId);
        Response response = null;
        // emulates a curl-based request
        // curl -u $API_TOKEN: -X GET
        // https://$HOSTNAME/api/access/datafile/datafileId
        //String returnedResult = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        String downloadFilePath = null;

        try {
            logger.log(Level.INFO, "uri={0}", clientConfig.getServerURI());
            logger.log(Level.INFO, "datafileId={0}", datafileId);
            logger.log(Level.INFO, "api_key={0}", clientConfig.getApiKey());
            if (StringUtils.isBlank(datafileId)) {
                throw new IllegalArgumentException("fileId should not be blank");
            } else if (StringUtils.isBlank(destDir)) {
                throw new IllegalArgumentException("destination directory should not be blank");
            }

            webTarget = client.target(clientConfig.getServerURI()
                    + getNativeApiUri("/access/datafiles"))
                    .path(datafileId)
                    .queryParam("key", clientConfig.getApiKey());

            response = webTarget.request().get();

            int statusCode = response.getStatus();
            //returnedResult = response.readEntity(String.class);

            logger.log(Level.INFO, "response.status={0}", statusCode);
            //logger.log(Level.INFO, "response.readEntity={0}", returnedResult);

            if (statusCode == 200) {
                logger.log(Level.INFO, "downloading  was successful");

                // process response
                inputStream = response.readEntity(InputStream.class);
                downloadFilePath = destDir + "/requested_datafile_" + datafileId + ".zip";
                //File destFile = new File(downloadFilePath);
                outputStream = new FileOutputStream(downloadFilePath);
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                inputStream.close();

            } else {
                logger.log(Level.SEVERE, "downloading failed: status code={0}",
                        statusCode);
                throw new WebApplicationException("downloading request failed", Status.fromStatusCode(statusCode));
            }

        } catch (FileNotFoundException ex) {
            logger.log(Level.SEVERE, "zip file was not found", ex);
            throw new RuntimeException("downloading request failed: zip file was not created");
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "IOException was thrown", ex);
            throw new RuntimeException("downloading request failed: due to IOException");
        } finally {
            if (response != null) {
                response.close();
            }

            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException ex) {
                    logger.log(Level.SEVERE, "IOException was thrown", ex);
                }
            }
//            client.close();
        }
    }

    /**
     * Downloads a set of datafiles from Dataverse by their Ids and saves them
     * as a zip file in a directory of the local file system.
     *
     * @param datafileIds the set of datafile Ids separated by commas such as
     * 1,2,3 where 1, 2, 3 are datafile Ids
     * @param destDir the directory in which a datafile to be downloaded is
     * saved
     */
    public void downloadDatafilesByDatafileIds(String datafileIds, String destDir) {
        // requirement: get file id
        logger.log(Level.INFO, "downloading datafiles whose ids={0}", datafileIds);
        Response response = null;
        // emulates a curl-based request
        // curl -u $API_TOKEN: -X GET
        // https://$HOSTNAME/api/access/datafile/datafileId
        //String returnedResult = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        String downloadFilePath = null;

        try {
            logger.log(Level.INFO, "uri={0}", clientConfig.getServerURI());
            logger.log(Level.INFO, "datafileIds={0}", datafileIds);
            logger.log(Level.INFO, "api_key={0}", clientConfig.getApiKey());
            if (StringUtils.isBlank(datafileIds)) {
                throw new IllegalArgumentException("fileId should not be blank");
            } else if (StringUtils.isBlank(destDir)) {
                throw new IllegalArgumentException("destination directory should not be blank");
            }

            webTarget = client.target(clientConfig.getServerURI()
                    + getNativeApiUri("/access/datafiles"))
                    .path(datafileIds)
                    .queryParam("key", clientConfig.getApiKey());

            response = webTarget.request().get();

            int statusCode = response.getStatus();
            //returnedResult = response.readEntity(String.class);

            logger.log(Level.INFO, "response.status={0}", statusCode);
            //logger.log(Level.INFO, "response.readEntity={0}", returnedResult);

            if (statusCode == 200) {
                logger.log(Level.INFO, "downloading  was successful");

                // process response
                inputStream = response.readEntity(InputStream.class);

                downloadFilePath = destDir + "/requested_datafile_" + datafileIds + ".zip";

                //File destFile = new File(downloadFilePath);
                outputStream = new FileOutputStream(downloadFilePath);
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                inputStream.close();

            } else {
                logger.log(Level.SEVERE, "downloading failed: status code={0}",
                        statusCode);
                throw new WebApplicationException("downloading request failed", Status.fromStatusCode(statusCode));
            }

        } catch (FileNotFoundException ex) {
            logger.log(Level.SEVERE, "zip file was not found", ex);
            throw new RuntimeException("downloading request failed: zip file was not created");
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "IOException was thrown", ex);
            throw new RuntimeException("downloading request failed: due to IOException");
        } finally {
            if (response != null) {
                response.close();
            }

            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException ex) {
                    logger.log(Level.SEVERE, "IOException was thrown", ex);
                }
            }
//            client.close();
        }
    }

    /**
     *
     * @param datafileIds the set of datafile Ids separated by commas such as
     * 1,2,3 where 1, 2, 3 are datafile Ids
     * @param destDir the directory in which a zip file to be downloaded is
     * saved
     * @param zipfileName a file name without extension
     */
    public void downloadDatafilesByDatafileIds(String datafileIds, String destDir, String zipfileName) {
        // requirement: get file id
        // requirement: get file id
        logger.log(Level.INFO, "downloading datafiles whose ids={0}", datafileIds);

        Response response = null;
        // emulates a curl-based request
        // curl -u $API_TOKEN: -X GET
        // https://$HOSTNAME/api/access/datafile/datafileId
        //String returnedResult = null;
        //InputStream inputStream = null;
        //OutputStream outputStream = null;
        String downloadFilePath = destDir + "/" + zipfileName + ".zip";
        logger.log(Level.INFO, "downloadFilePath={0}", downloadFilePath);

        try {

            logger.log(Level.INFO, "uri={0}", clientConfig.getServerURI());
            logger.log(Level.INFO, "datafileIds={0}", datafileIds);
            logger.log(Level.INFO, "api_key={0}", clientConfig.getApiKey());

            if (StringUtils.isBlank(datafileIds)) {
                throw new IllegalArgumentException("fileId should not be blank");
            } else if (StringUtils.isBlank(destDir)) {
                throw new IllegalArgumentException("destination directory should not be blank");
            } else if (StringUtils.isBlank(zipfileName)) {
                throw new IllegalArgumentException("zip filename should not be blank");
            }

            webTarget = client.target(clientConfig.getServerURI()
                    + getNativeApiUri("/access/datafiles"))
                    .path(datafileIds)
                    .queryParam("key", clientConfig.getApiKey());

            response = webTarget.request().get();

            int statusCode = response.getStatus();
            //returnedResult = response.readEntity(String.class);

            logger.log(Level.INFO, "response.status={0}", statusCode);
            //logger.log(Level.INFO, "response.readEntity={0}", returnedResult);

            if (statusCode == 200) {
                logger.log(Level.INFO, "downloading  was successful");

                // process response
                try (InputStream inputStream = response.readEntity(InputStream.class);
                        OutputStream outputStream = new FileOutputStream(downloadFilePath)) {

                    // outputStream = new FileOutputStream(downloadFilePath);
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }

                } catch (FileNotFoundException ex) {
                    logger.log(Level.SEVERE, "zip file was not found", ex);
                    throw new RuntimeException("downloading request failed: zip file was not created");
                } catch (IOException ex) {
                    logger.log(Level.SEVERE, "IOException was thrown", ex);
                    throw new RuntimeException("downloading request failed: due to IOException");
                }

            } else {
                // downloading-failure is suspected
                logger.log(Level.SEVERE, "downloading failed: status code={0}",
                        statusCode);
                throw new WebApplicationException("downloading request failed", Status.fromStatusCode(statusCode));
            }

        } finally {
            if (response != null) {
                response.close();
            }
            //client.close();
        }
    }
    
    
    /**
     * Downloads a set of datafiles within a dataset by its Id in one pass.
     * The identifier of a dataset is used for the name of a zip file to be downloaded.
     * 
     * @param datasetId the Id of a dataset whose files are to be downloaded
     * @param destDir the directory in which a zip file to be downloaded is saved
     */
    public void downloadDatafilesByDatasetId(String datasetId, String destDir){
        downloadDatafilesByDatasetId(datasetId, destDir, null);
    }

    /**
     * Downloads a set of datafiles within a dataset by its Id in one pass.
     * 
     * @param datasetId the Id of a dataset whose files are to be downloaded
     * @param destDir the directory in which a zip file to be downloaded is saved
     * @param zipfileName the name a file name without extension for a downloaded zip file; if "" (blank) or null is specified, the identifier of a dataset is used.
     */
    public void downloadDatafilesByDatasetId(String datasetId, String destDir, String zipfileName) {
        
        logger.log(Level.INFO, "===== within downloadDatafilesByDatasetId ===== ");
        logger.log(Level.INFO, "datasetId={0}", datasetId);
        logger.log(Level.INFO, "destDir={0}", destDir);
        logger.log(Level.INFO, "zipfileName={0}", zipfileName);
        
        // get the metadata of datasetId
        String result = retrieveDatasetContentsByDatasetId(datasetId);
        logger.log(Level.INFO, "returned json object={0}", result);
        // get a list of datafileIds 
        //List<String> datafileIdList = getDatafileIdListFromDatasetContentsFromString(result);
        //logger.log(Level.INFO, "datafileIdList={0}", datafileIdList);
        // concatenate it
        //String datafileIdSet = String.join(",", datafileIdList);
        //logger.log(Level.INFO, "datafileIdSet={0}", datafileIdSet);
        String finalFileName = StringUtils.isBlank(zipfileName) ? getDatasetIdFromDatasetContentsFromString(result) : zipfileName;
        
        
        
        logger.log(Level.INFO, "finalFileName={0}", finalFileName);
        downloadDatafilesByDatafileIds(String.join(",",getDatafileIdListFromDatasetContentsFromString(result)), destDir, getDatasetIdFromDatasetContentsFromString(result));
        
        logger.log(Level.INFO, "===== leaving downloadDatafilesByDatasetId =====");
        
    }
    
    
    /**
     *  Downloads a set of datafiles within a dataset by its persistent Id in one pass.
     * 
     * The identifier of a dataset is used for the name of a zip file to be downloaded.
     * @param persistentId the persistent Id of a dataset
     * @param destDir the directory in which a zip file to be downloaded is saved
     */
    public void downloadDatafilesByPersistentId(String persistentId, String destDir) {
        downloadDatafilesByPersistentId(persistentId, destDir, null);
    }
    
    
    /**
     * Downloads a set of datafiles within a dataset by its persistent Id in one pass.
     * @param persistentId the persistent Id of a dataset
     * @param destDir the directory in which a zip file to be downloaded is saved
     * @param zipfileName the name a file name without extension for a downloaded zip file; if "" (blank) or null is specified, the identifier of a dataset is used.
     */
    public void downloadDatafilesByPersistentId(String persistentId, String destDir, String zipfileName) {
        
        logger.log(Level.INFO, "===== within downloadDatafilesByPersistentId ===== ");
        logger.log(Level.INFO, "persistentId={0}", persistentId);
        logger.log(Level.INFO, "destDir={0}", destDir);
        logger.log(Level.INFO, "zipfileName={0}", zipfileName);
        
        // get the metadata of datasetId
        String result = retrieveDatasetContentsByPersistentId(persistentId);
        logger.log(Level.INFO, "returned json object={0}", result);
        // get a list of datafileIds 
        //List<String> datafileIdList = getDatafileIdListFromDatasetContentsFromString(result);
        //logger.log(Level.INFO, "datafileIdList={0}", datafileIdList);
        // concatenate it
        //String datafileIdSet = String.join(",", datafileIdList);
        //logger.log(Level.INFO, "datafileIdSet={0}", datafileIdSet);
        String finalFileName = StringUtils.isBlank(zipfileName) ? getDatasetIdFromDatasetContentsFromString(result) : zipfileName;
        
        logger.log(Level.INFO, "finalFileName={0}", finalFileName);
        downloadDatafilesByDatafileIds(String.join(",",getDatafileIdListFromDatasetContentsFromString(result)), destDir, getDatasetIdFromDatasetContentsFromString(result));
        
        logger.log(Level.INFO, "===== leaving downloadDatafilesByPersistentId =====");
        
    }
    
    
    
    
    

    /**
     * Deletes a datafile by its Id
     * 
     * @param datafileId the Id of a datafile to be deleted
     */
    public void deleteDatafile(String datafileId) {
        // requirement: get file id
        logger.log(Level.INFO, "deleting a datafile whose id={0}", datafileId);
        Response response = null;
        // emulates a curl-based request
        // curl -u $API_TOKEN: -X DELETE
        // https://$HOSTNAME/dvn/api/data-deposit/v1.1/swordv2/edit-media/file/123

        try {

            if (StringUtils.isBlank(datafileId)) {
                throw new IllegalArgumentException("fileId should not be blank");
            }

            webTarget = client.target(clientConfig.getServerURI()
                    + getSwordApiUri("/file")).path(datafileId);

            response = webTarget
                    .request().delete();

            int statusCode = response.getStatus();

            logger.log(Level.INFO, "response.status={0}", statusCode);
            logger.log(Level.INFO, "response.readEntity={0}",
                    response.readEntity(String.class));

            if (statusCode != 204) {
                logger.log(Level.SEVERE, "deleting a file failed: status code={0}",
                        statusCode);
            }

        } catch (IllegalArgumentException ex) {
            logger.log(Level.SEVERE,
                    "fileId was blank and its deletion was aborted", ex);
        } finally {
            if (response != null) {
                response.close();
            }
//            client.close();
        }
    }

}
