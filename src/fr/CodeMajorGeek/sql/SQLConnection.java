package fr.CodeMajorGeek.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.CodeMajorGeek.panel.Main;
import fr.CodeMajorGeek.panel.TourneyList;

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
		
		Main.refresh();
	}
	
	public void deleteTournament(String TourneyID) {
		
		
		try {
			
			Statement stat = connection.createStatement();
			stat.execute("DELETE FROM tournament WHERE TourneyID = '" + TourneyID + "'");
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.exit(-1);
		}
		
		Main.refresh();
	}
	
	public void updateTournament(String TourneyID, String APIRequestID) {
		
		try {
			
			Statement stat = connection.createStatement();
			stat.execute("UPDATE tournament SET APIRequestID = '" + APIRequestID + "' WHERE TourneyID = '" + TourneyID + "'");
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	public ArrayList<TourneyList> getallTournament() {
		ArrayList<TourneyList> list = new ArrayList<TourneyList>();
		
		try {
			
			Statement stat = connection.createStatement();
			ResultSet res = stat.executeQuery("SELECT id, Title, APIRequestID, TourneyID, APIFrameworkTime, APITotalTime, APIServiceTime, URL, Result FROM tournament");
			
			while(res.next()) {
				
				list.add(new TourneyList(res.getInt("id"), res.getString("Title"), res.getInt("APIRequestID"), res.getString("TourneyID"), res.getString("APIFrameworkTime"), res.getString("APITotalTime"), res.getString("APIServiceTime"), res.getString("URL"), res.getInt("Result")));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.exit(-1);
		}
		
		return list;
	}
	
}
