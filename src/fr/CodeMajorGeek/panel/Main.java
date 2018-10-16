package fr.CodeMajorGeek.panel;

import java.awt.Dimension;

import fr.CodeMajorGeek.binaryBeast.BinaryBeast;
import fr.CodeMajorGeek.propertiesConfiguration.References;
import fr.CodeMajorGeek.sql.SQLConnection;

public class Main {
	
	private static Frame frame;
	private static SQLConnection sql;
	private static BinaryBeast binaryBeast;
	
	public static void main(String[] args) {
		
		preInit();
		init();
	}
	
	private static void preInit() {
		
		new References();
		
		frame = new Frame();
		frame.createFrame("Mythical Beast Tournament", new Dimension(500, 500));
		sql = new SQLConnection(References.SQL_HOST, References.SQL_DBNAME, References.SQL_USER, References.SQL_PASSWD);
		binaryBeast = new BinaryBeast(References.BINARYBEAST_APIKEY);
	}
	
	private static void init() {
		
		//binaryBeast.addTournament("test");
	}
	
	public static SQLConnection getSQLConnection() {
		
		return sql;
	}
	
	public static BinaryBeast getBinaryBeast() {
		
		return binaryBeast;
	}
}
