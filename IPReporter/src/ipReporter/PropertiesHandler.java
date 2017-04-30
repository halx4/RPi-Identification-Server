package ipReporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHandler {
	private final static String DEFAULT_ID="00";
	private final static String DEFAULT_SERVER_URL="http://83.212.122.89:8080/RPIIdentificationServer/RPIServer";
	final static String DEFAULT_IP_PREFIX="150.140.";
	
    private Properties properties = new Properties();

    private String propertiesFilename = new String("IPReporter.properties");
    
    
    PropertiesHandler() {

        loadProperties();

    }

    // ----------------------------------
    private void loadProperties() {

        File propFile = new File(propertiesFilename);
        FileOutputStream oFile = null;
        FileInputStream iFile = null;

        try {

            if (propFile.exists()) {// file exists
                System.out.println("properties file exists. try to load...");
                iFile = new FileInputStream(propFile);
                properties.load(iFile);
            } else {
                System.out.println("properties file not exist. creating...");
                propFile.createNewFile();
                oFile = new FileOutputStream(propFile, true);

                // default properties
                properties.setProperty("id",		DEFAULT_ID);
                properties.setProperty("server_URL",DEFAULT_SERVER_URL);
                properties.setProperty("IPPrefix",DEFAULT_IP_PREFIX);
                

                properties.store(oFile, null);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (oFile != null)
                    oFile.close();
                if (iFile != null)
                    iFile.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        // properties.list(System.out);

    }
    //-------------------------------------------------------
    String getID(){
    	return properties.getProperty("id");
    }
    //--------------------------------------------------------
    String getServerUrl(){
    	return properties.getProperty("server_URL");
    }
    //--------------------------------------------------------
    String getIpPrefix(){
    	return properties.getProperty("IPPrefix");
    }

}
