/**
 * 
 */
package com.unblu.assessments;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.unblu.assessments.json.Conversation;



/**
 * @author Jens
 *
 */
public class Starter {

	private static final Logger LOGGER = LogManager.getLogger(Starter.class);
	private String configFile = "starter.cfg";
	private HashMap<String,String> config = new HashMap<String, String>();

	
	/**
	 * 
	 * @param filename for configuration File
	 */
	private void configure(String filename) {
		LOGGER.info("Entry - function configure(" + filename + ")");
		Properties properties = null;
		try (InputStream input = new FileInputStream(filename)) {
			if (input!=null) {
				properties = new Properties();
				properties.load(input);
				
				if (properties.getProperty("restServiceURL")!=null) {
					if ( !this.config.containsKey("restServiceURL") ) {
						this.config.put("restServiceURL", properties.getProperty("restServiceURL"));
					}
				}

				if (properties.getProperty("restServiceExport")!=null) {
					if ( !this.config.containsKey("restServiceExport") ) {
						this.config.put("restServiceExport", properties.getProperty("restServiceExport"));
					}
				}

				if (properties.getProperty("username")!=null) {
					if ( !this.config.containsKey("username") ) {
						this.config.put("username", properties.getProperty("username"));
					}
				}

				if (properties.getProperty("password")!=null) {
					if ( !this.config.containsKey("password") ) {
						this.config.put("password", properties.getProperty("password"));
					}
				}

				if (properties.getProperty("filter")!=null) {
					if ( !this.config.containsKey("filter") ) {
						this.config.put("filter", properties.getProperty("filter"));
					}
				}
				
			}
        } catch (IOException exception) {
    		LOGGER.error(exception.getLocalizedMessage());
			System.exit(-1);
        }
		LOGGER.info("Exit - function configure()");
	}
	
	/**
	 * @param restServiceURL the URL of used REST Webservice
	 * @return fetched JSON content as String   
	 */
	private String fetchJson(String restServiceURL) {
		LOGGER.trace("Entry - function fetchJson()");
		
		String username = this.config.get("username");
		String password = this.config.get("password");
		String plainCredentials = username + ":" + password;
		String base64Credentials = new String(Base64.getEncoder().encode(plainCredentials.getBytes()));
		String authorizationHeader = "Basic " + base64Credentials;
		
		HttpClient client = HttpClient.newHttpClient();
		
		// Create HTTP request object
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(restServiceURL))
                .GET()
                .header("Authorization", authorizationHeader)
                .header("Content-Type", "application/json")
                .build();
        
        // Send HTTP request
        HttpResponse<String> response = null;
		try {
			LOGGER.info("Starting fetching JSON from RestService");
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
			LOGGER.info("Fetching JSON from RestService done");
			// Application stops if response starts with content equal: {"$_type":"Error","
			if (response.body().trim().startsWith("{\"$_type\":\"Error\"")) {
				LOGGER.debug("Which RestService used :"+ restServiceURL);
				LOGGER.debug("Which Credentials used :"+ plainCredentials);
				LOGGER.error("Response of RestService => "+ response.body());
				System.exit(-2);
			}
		} catch (IOException | InterruptedException exception) {
			LOGGER.debug("Which RestService used :"+ restServiceURL);
			LOGGER.error("Error found by using fetchJson() => Problem by Server or Service found!");
			System.exit(-2);
		}
		if ( LOGGER.isTraceEnabled() ) {
			LOGGER.trace("Content of received RESTFul Request" +
				"\n======================== CID CONTENT ======================== \n" +
				response.body() +		
				"\n======================== CID CONTENT ======================== \n"
				);
		}
		LOGGER.trace("Exit - function fetchJson()");
		return response.body();
	}
	
	/**
	 * @param contentJSON fetch content as JSON formated text
	 * @return Java Objects based on contentJSON value
	 */
	private Conversation[] tranform2POJO(String contentJSON) {
		LOGGER.trace("Entry - function tranform2POJO()");
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Conversation[] conversations = null;
		try {
			conversations = mapper.readValue(contentJSON, Conversation[].class);
		} catch (JsonProcessingException exception) {
			LOGGER.error(exception.getLocalizedMessage());
			System.exit(-3);
		}
		LOGGER.trace("Exit - function tranform2POJO()");
		return conversations;
	}
	
	/**
	 * @param contentJSON Content fetch by @see fetchJson(String restServiceURL) 
	 * @param filter Text used as conversation filter 
	 * @return found Conversations by filter
	 */
	private List<Conversation> filterBy(String contentJSON, String filter) {
		LOGGER.trace("Entry - function filterBy()");
		Conversation[] conversations = tranform2POJO(contentJSON);
		List<Conversation> resultSet = null;
		if (conversations.length>0) {
			resultSet = new ArrayList<Conversation>();
			for (int pos=0;pos< conversations.length; pos++) {
				if (conversations[pos].getState().compareTo(filter)==0) {
					resultSet.add(conversations[pos]);
				}	
			}
		}
		LOGGER.trace("Exit - function filterBy()");
		return resultSet;
	}
	
	
	/**
	 * Export found Conversations by filter into a file<br>
	 * <br>
	 * @param conversationsSubset found Conversations by filter
	 * @param exportFile full-qualified filename for export
	 */
	private void export2File(List<Conversation> conversationsSubset, String exportFile) {
		LOGGER.trace("Entry - function export2File()");
		String jsonExport = null;
		try {
			ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			jsonExport = mapper.writeValueAsString(conversationsSubset);
		} catch (JsonProcessingException exception) {
			LOGGER.error(exception.getLocalizedMessage());
			System.exit(-5);
		}
		try {
			FileWriter fw = new FileWriter(exportFile);
			fw.write(jsonExport);
			fw.flush();
			fw.close();
		} catch (IOException exception) {
			LOGGER.error(exception.getLocalizedMessage());
			System.exit(-6);
		}
		LOGGER.trace("Exit - function export2File()");
	}
	

	/**
	 * @param parameter all argument passed into Application  
	 */
	private void manageArguments(String[] parameter) {
		LOGGER.trace("Entry - function manageArguments()");
		
		LOGGER.trace("Starting parsing arguments");
		for (int pos = 0; parameter.length>pos; pos++) {
			int argumentNr = (pos+1);
			LOGGER.trace("Value of " + argumentNr +". Argument: " + parameter[pos]);
			String argument = parameter[pos];

			// parameter is beginning with -D
			if (argument.startsWith("-D")) {
				int posSeparater = argument.indexOf('=');
				if (posSeparater > 0) {

					// Last character of parameter is not equal =
					if ( posSeparater+1 != argument.length() ) {

						// parameter is not beginning with -D=
						if ( !argument.startsWith("-D=")  ) {

							// removing -D and make a split parameter <Name>=<Value> 
							String name = argument.substring(2,posSeparater);
							String value = argument.substring(posSeparater+1);
							this.config.put(name, value);
						} else {
							LOGGER.error(argumentNr +". Argument has unexpected postion of character =" );
							System.exit(-1);
						}
					} else {
						LOGGER.error(argumentNr +". Argument has unexpected postion of character =" );
						System.exit(-1);
					}
				} else {
					LOGGER.error(argumentNr +". Argument has no expected character =" );
					System.exit(-1);
				}
			} else {
				LOGGER.error(argumentNr +". Argument is not starting with expected -D" );
				System.exit(-1);
			}
		}
		LOGGER.trace("Parsing arguments done ");
		LOGGER.trace("Exit - function manageArguments()");
	}
	
	/**
	 * System.exit(-1) result of parameter [restServiceURL] not configured!<br>
	 * System.exit(-2) result of parameter [username] not configured!<br>
	 * System.exit(-3) result of parameter [password] not configured!<br>
	 * System.exit(-4) result of parameter [filter] not configured!<br>
	 * System.exit(-5) result of parameter [exportFile] not configured!<br>
	 * @param parameter All arguments must follow the construct -D[name]=[value]<br>
	 * <br>
	 * restServiceURL<br>
	 * username<br>
	 * password<br>
	 * filter<br>
	 * exportFile
	 *   
	 */
	public static void main(String[] parameter)  {
		LOGGER.info("***** Programm started *****");
		Starter starter = new Starter();
		// Configuration done by different parameter. 
		if (parameter.length > 0)  starter.manageArguments(parameter);

		// Using content of configuration file to add missing configuration parameter.
		// configuration parameter done by arguments will be not change at this time!
		String configFile = starter.config.get("configFile");
		if (configFile!=null) {
			starter.configFile = configFile;
		}
		if ( (new File(starter.configFile)).exists()) {
			starter.configure(starter.configFile);
		} else {
			LOGGER.debug("configuration File " + starter.configFile + " not found!");
		}
		
		// fetch JSON by using RestAPI WebService.
		String contentJSON = null;
		String restServiceURL = starter.config.get("restServiceURL");
		if (restServiceURL!= null) {
			if (starter.config.get("username")==null) {
				LOGGER.error("parameter <username> not configured!");
				System.exit(-2);
			}
			if (starter.config.get("password")==null) {
				LOGGER.error("parameter <password> not configured!");
				System.exit(-3);
			}
			contentJSON = starter.fetchJson(restServiceURL);
		} else {
			LOGGER.error("parameter <restServiceURL> not configured!");
			System.exit(-1);
		}
		
		// filter jsonString based on configured condition.
		List<Conversation> conversationsSubset = null;
		String filter = starter.config.get("filter");
		if (filter!=null) {
			conversationsSubset  = starter.filterBy(contentJSON, filter);
		} else {
			LOGGER.error("parameter <filter> not configured!");
			System.exit(-4);
		}
		
		// Export subset into file
		String exportFile = starter.config.get("restServiceExport");
		if (exportFile!= null) {
			starter.export2File(conversationsSubset, exportFile);
		} else {
			LOGGER.error("parameter <restServiceExport> not configured!");
			System.exit(-5);
		}
		LOGGER.info("***** Programm done *****");
	}

}
