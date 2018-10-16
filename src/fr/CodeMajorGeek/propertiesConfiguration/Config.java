package fr.CodeMajorGeek.propertiesConfiguration;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class Config {
	
	private Configuration config;
	
	public Config(String fileName) {
		
		Parameters params = new Parameters();
		
		FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
		    new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
		    	.configure(params.properties()
		    			.setFileName(fileName));
		try {
			
		    config = builder.getConfiguration();
		}
		catch(ConfigurationException e) {
		    
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	public String getSQLHost() {
		
		return config.getString("sql.host");
	}
	
	public String getSQLDBName() {
		
		return config.getString("sql.dbname");
	}
	
	public String getSQLUser() {
		
		return config.getString("sql.user");
	}
	
	public String getSQLPasswd() {
		
		return config.getString("sql.passwd");
	}
	
	public String getBinaryBeastApiKey() {
		
		return config.getString("binarybeast.key");
	}
}
