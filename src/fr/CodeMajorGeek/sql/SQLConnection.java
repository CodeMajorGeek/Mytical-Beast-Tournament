package fr.CodeMajorGeek.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnection {
	
	private Connection connection = null;
	
	public SQLConnection(String host, String dbname, String user, String passwd) {
		
		try {
			
			connection = DriverManager.getConnection(host, user, passwd);
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	public void addTournament(String Title, int APIRequestID, String TourneyID, String APIFrameworkTime, String APITotalTime, String APIServiceTime, String URL, int Result) {
		
		try {
			
			Statement stat = connection.createStatement();
			stat.execute("INSERT INTO tournament(Title, APIRequestID, TourneyID, APIFrameworkTime, APITotalTime, APIServiceTime, URL, Result) VALUES('" + Title + "', '" + APIRequestID + "', '" + TourneyID + "', '" + APIFrameworkTime +"', '" + APITotalTime +"', '" + APIServiceTime +"', '" + URL +"', '" + Result + "')");
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.exit(-1);
		}
	}
}
