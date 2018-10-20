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
		
		new ListTourneyPanel();
		new ListTeamPanel();
		
		frame = new Frame();
		frame.createFrame("Mythical Beast Tournament", new Dimension(800, 300));
		sql = new SQLConnection(References.SQL_HOST, References.SQL_DBNAME, References.SQL_USER, References.SQL_PASSWD);
		binaryBeast = new BinaryBeast(References.BINARYBEAST_APIKEY);
	}
	
	private static void init() {
		
		refresh();
	}
	
	public static void refresh() {
		
		ListTourneyPanel.tourneyList = sql.getallTournament();
		ListTourneyPanel.getMainList.refresh();
		
		ListTeamPanel.teamList = sql.getallTeam();
		ListTeamPanel.getMainList.refresh();
	}
	
	public static SQLConnection getSQLConnection() {
		
		return sql;
	}
	
	public static BinaryBeast getBinaryBeast() {
		
		return binaryBeast;
	}
}
