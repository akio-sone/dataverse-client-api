// package edu.harvard.iq.safe.saasystem.auditdiff;

import java.util.*;
import java.io.*;
import java.util.logging.*;

class ReportData {
    
    static final String cl = ReportData.class.getName();
    static final Logger logger = Logger.getLogger(cl);
    private static Map<String, String> box;
    private String[][] au_summary_table;
    private String[][] host_summary_table;
    private Map<String, String> h_aus_in_schema_not_in_network;
    private Map<String, String> h_aus_in_network_not_in_schema;
    private Map<String, String> h_hosts_in_schema_not_in_network;
    private Map<String, String> h_hosts_in_network_not_in_schema;
    public java.sql.Timestamp date_time = null;

    public ReportData() {

        Calendar calendar = Calendar.getInstance();
        this.date_time = new java.sql.Timestamp(calendar.getTime().getTime());


        // this.box = new HashMap <String, String> () ;

        if (ReportData.box == null) {

            box = new TreeMap<String, String>();
            ReportData.box = new TreeMap<String, String>();

            ReportData.box.put("REPORT_FILE_NAME", null);
            ReportData.box.put("REPORT_DATE", this.date_time.toString());
            ReportData.box.put("REPORT_SCHEMA_FILE_NAME", null);
            ReportData.box.put("REPORT_SCHEMA_FILE_XSD_FILE_NAME", null);
            ReportData.box.put("REPORT_XML_DIFF_FILE_NAME", null);
            ReportData.box.put("REPORT_XML_DIFF_FILE_XSD_FILE_NAME", null);

            ReportData.box.put("REPORT_NETWORK_NAME", null);
            ReportData.box.put("REPORT_NETWORK_ADMIN_EMAIL", null);
            ReportData.box.put("REPORT_SCHEMA_VERSION", null);
            ReportData.box.put("REPORT_AUDIT_REPORT_EMAIL", null);
            ReportData.box.put("REPORT_AUDIT_INTERVAL", null);

            ReportData.box.put("REPORT_N_HOSTS_ACTIVE", null);
            // ReportData.box.put( "REPORT_N_HOSTS_IN_REPORT", null ) ;

            ReportData.box.put("REPORT_HOSTS_MEAN_UPTIME", null);

            ReportData.box.put("REPORT_HOSTS_TOTAL_DISKSPACE", null);
            ReportData.box.put("REPORT_HOSTS_TOTAL_DISKSPACE_USED", null);
            ReportData.box.put("REPORT_HOSTS_TOTAL_DISKSPACE_FREE", null);

            ReportData.box.put("REPORT_N_HOSTS_IN_SCHEMA", null);
            ReportData.box.put("REPORT_N_HOSTS_IN_SCHEMA_NOT_IN_NETWORK", null);
            ReportData.box.put("REPORT_N_HOSTS_IN_NETWORK_NOT_IN_SCHEMA", null);

            ReportData.box.put("REPORT_N_AUS_IN_SCHEMA", null);
            ReportData.box.put("REPORT_N_AUS_IN_SCHEMA_NOT_IN_NETWORK", null);
            ReportData.box.put("REPORT_N_AUS_IN_NETWORK_NOT_IN_SCHEMA", null);

            ReportData.box.put("REPORT_N_HOSTS_NOT_MEETING_STORAGE", null);
            ReportData.box.put("REPORT_N_AUS_NOT_VERIFIED", null);

            ReportData.box.put("REPORT_N_HOST_AUS_IN_NETWORK", null);

            // ReportData.box.remove( "NETWORK_NAME" );

        }

        this.au_summary_table = null;
        this.host_summary_table = null;

        this.h_aus_in_schema_not_in_network = null;
        this.h_aus_in_network_not_in_schema = null;

        this.h_hosts_in_schema_not_in_network = null;
        this.h_hosts_in_network_not_in_schema = null;


    }

    public void set_h_aus_in_schema_not_in_network(Map<String, String> h) {

        // ===========================================================
        //
        // Function: Copy array to this class
        //
        // Parms:
        //  1. Input array - String[][]
        //
        // Returns: nothing
        //
        // ===========================================================

        String sub_name = "Start "+cl + ".set_h_aus_in_schema_not_in_network()";
        logger.fine(sub_name);

        if (h == null) {
            logger.warning("Input hash is null.");
        } else if (h.isEmpty()) {
            logger.warning("Input hash is empty.");
        }


        this.h_aus_in_schema_not_in_network = h;


        if (!(this.h_aus_in_schema_not_in_network == null)) {
            logger.info(this.h_aus_in_schema_not_in_network.size() + " keys in input hash.");
        }


    } // set_h_aus_in_schema_not_in_network() END

    public void set_h_aus_in_network_not_in_schema(Map<String, String> h) {

        // ===========================================================
        //
        // Function: Copy array to this class
        //
        // Parms:
        //  1. Input array - String[][]
        //
        // Returns: nothing
        //
        // ===========================================================

        String sub_name = "Start " + cl + ".set_h_aus_in_network_not_in_schema()";
        logger.fine(sub_name);

        if (h == null) {
            logger.warning("Input hash is null.");
        } else if (h.isEmpty()) {
            logger.warning("Input hash is empty.");
        }


        this.h_aus_in_network_not_in_schema = h;


        if (!(this.h_aus_in_network_not_in_schema == null)) {
            logger.info(this.h_aus_in_network_not_in_schema.size() + " keys in input hash.");
        }


    } // set_h_aus_in_network_not_in_schema() END

    public void set_h_hosts_in_schema_not_in_network(Map<String, String> h) {

        // ===========================================================
        //
        // Function: Copy array to this class
        //
        // Parms:
        //  1. Input array - String[][]
        //
        // Returns: nothing
        //
        // ===========================================================

        String sub_name = "Start "+cl + ".set_h_hosts_in_schema_not_in_network()";
        logger.fine(sub_name);

        if (h == null) {
            logger.warning("Input hash is null.");
        } else if (h.isEmpty()) {
            logger.warning("Input hash is empty.");
        }


        this.h_hosts_in_schema_not_in_network = h;


        if (!(this.h_hosts_in_schema_not_in_network == null)) {
            logger.info(this.h_hosts_in_schema_not_in_network.size() + " keys in input hash.");
        }


    } // set_h_hosts_in_schema_not_in_network() END

    public void set_h_hosts_in_network_not_in_schema(Map<String, String> h) {

        // ===========================================================
        //
        // Function: Copy array to this class
        //
        // Parms:
        //  1. Input array - String[][]
        //
        // Returns: nothing
        //
        // ===========================================================

        String sub_name = "Start"+cl + ".set_h_hosts_in_network_not_in_schema()";
        logger.fine(sub_name);

        if (h == null) {
            logger.warning("Input hash is null.");
        } else if (h.isEmpty()) {
            logger.warning("Input hash is empty.");
        }


        this.h_hosts_in_network_not_in_schema = h;


        if (!(this.h_hosts_in_network_not_in_schema == null)) {
            logger.info(this.h_hosts_in_network_not_in_schema.size() + " keys in input hash.");
        }


    } // set_h_hosts_in_network_not_in_schema() END

    public void set_au_summary(String[][] s) {

        // ===========================================================
        //
        // Function: Copy array to this class
        //
        // Parms:
        //  1. Input array - String[][]
        //
        // Returns: nothing
        //
        // ===========================================================

        String sub_name = "Start "+ cl + ".set_au_summary()";
        logger.fine(sub_name);


        if (s == null) {
            logger.warning("Input array is null.");
            return;
        }

        this.au_summary_table = s;

        logger.info("Array is " + this.au_summary_table.length + " x " + this.au_summary_table[0].length);

    } // set_au_summary() END

    public void set_host_summary(String[][] s) {

        // ===========================================================
        //
        // Function: Copy array to this class
        //
        // Parms:
        //  1. Input array - String[][]
        //
        // Returns: nothing
        //
        // ===========================================================

        String sub_name = "Start "+cl + ".set_host_summary()";
        logger.fine(sub_name);

        if (s == null) {
            logger.warning("Input array is null.");
            return;
        }

        this.host_summary_table = s;

        logger.info("Array is " + this.host_summary_table.length + " x " + this.host_summary_table[0].length);

    } // set_host_summary END

    public String[][] get_host_summary() {

        // ===========================================================
        //
        // Function: Copy array to this class
        //
        // Parms:
        //  1. Input array - String[][]
        //
        // Returns: nothing
        //
        // ===========================================================

        String sub_name = "Start "+cl + ".get_host_summary()";

        logger.fine(sub_name);
        logger.info(this.host_summary_table.length + " x " + this.host_summary_table[0].length);


        return this.host_summary_table;

    } // get_host_summary END

    public String[][] get_au_summary() {

        // ===========================================================
        //
        // Function: Copy array to this class
        //
        // Parms:
        //  1. Input array - String[][]
        //
        // Returns: nothing
        //
        // ===========================================================

        String sub_name = "Start"+cl + ".get_au_summary()";
        logger.fine(sub_name);
        logger.info("Array is " + this.au_summary_table.length + " x " + this.au_summary_table[0].length);
        return this.au_summary_table;

    } // get_au_summary END

    public void check_au_summary() {
        // ===========================================================
        //
        // Function: Print dimensions of input array
        //
        // Parms:
        //  1. String representation of integer bytes - String
        //
        // Returns: nothing
        //
        //
        // ===========================================================

        String sub_name = "Start "+cl + ".check_au_summary()";
        logger.info(sub_name);
        String array_name = "au_summary";
        if (this.au_summary_table == null) {
            logger.warning("Input array '" + array_name + "' is null.");
            return;
        }

        logger.info("Array '" + array_name + "' is " + this.au_summary_table.length + " x " + this.au_summary_table[0].length);
    } // check_au_summary END

    public void addKV(String key, String val) {

        logger.info("Start "+cl+".addKV()");
        logger.fine("Key: " + key + "  Val: " + val);
        box.put(key, val);
        if (key.equals("REPORT_XML_DIFF_FILE_XSD_FILE_NAME")) {
            logger.info("In addKV  - " + box.get("REPORT_XML_DIFF_FILE_XSD_FILE_NAME"));
            logger.info("In addKV  - getV() call: " + getV("REPORT_XML_DIFF_FILE_XSD_FILE_NAME"));
        }

    } // addKV END

    public String getV(String key) {
        logger.info("Start"+cl+".getV()");
        logger.fine("Key: " + key);
        String val = null;
        if (box.containsKey(key)) {
            val = box.get(key);
            if (val == null) {
                logger.info("Key: '" + key + "' points to a null value in Map.");
                return null;
            } else {
                logger.info("Key: '" + key + "' ==> '" + val + "'");
                return val;
            }
        } else {
            logger.info("Key: '" + key + "' not found in Map.");
            return null;
        }

    } // getV() END

    public Map<String, String> getBox() {
        return box;

    }

    public String count_val_in_array_column(String[][] s, int col_index, String val_to_count) {

        // ===========================================================
        //
        // Function: Count the number of occurrances of a specific
        //           value in a single array column
        // Parms:
        //  1. Input array - String[][]
        //  2. column index of column to process - int
        //  3. value of column to count - String
        //
        // Returns:
        //  number of rows in column with specific value - String
        //
        // Comments:
        //
        // Usage eg:
        //
        //  String c = count_val_in_array_column( this.au_summary_table, 4, "no" ) ;
        //
        // ===========================================================

        String sub_name = "Start " + cl + ".count_val_in_array_column()";
        logger.info(sub_name);

        if (s == null) {
            logger.warning("Input array is null.");
            return null;
        }

        logger.info("Input Array is " + s.length + " x " + s[0].length + ".  Index of column to check is: " + col_index);

        if (col_index >= s[0].length) {
            logger.warning("Specified column index: '" + col_index
                    + "' is 0-based and must be less than number of columns in the input array: '" + s[0].length + "'");
            return null;
        }

        String s_n;

        // ===========================================================
        // Iterate over rows
        // ===========================================================
        int row_num = 0;
        int n = 0;

        String display = "\n";

        for (int row = 0; row < s.length; row++) {
            row_num++;
            display += (row_num + ". ");
            display += (s[row][col_index] + "\t ");
            if (s[row][col_index].equals(val_to_count)) {
                n++;
            }
        }

        s_n = Integer.toString(n);     // int to String

        display += "\n";
        logger.fine(display);

        logger.info("Value: '" + val_to_count + "' found in " + s_n + " of " + row_num + " rows.");

        return s_n;

    } // count_val_in_array_column() END
} // class RepData END

