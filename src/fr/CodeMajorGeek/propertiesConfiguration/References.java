package fr.CodeMajorGeek.propertiesConfiguration;

public class References {
	
	private Config config = new Config("properties.properties");
	
	public static String SQL_HOST;
	public static String SQL_DBNAME;
	public static String SQL_USER;
	public static String SQL_PASSWD;
	
	public static String BINARYBEAST_APIKEY;
	
	public References() {
		
		SQL_HOST = config.getSQLHost();
		SQL_DBNAME = config.getSQLDBName();
		SQL_USER = config.getSQLUser();
		SQL_PASSWD = config.getSQLPasswd();
		
		BINARYBEAST_APIKEY = config.getBinaryBeastApiKey();
	}
}
