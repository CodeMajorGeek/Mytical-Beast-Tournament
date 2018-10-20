package fr.CodeMajorGeek.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.CodeMajorGeek.panel.Main;
import fr.CodeMajorGeek.panel.TeamList;
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
			stat.execute("INSERT INTO tournament(Title, APIRequestID, TourneyID, APIFrameworkTime, APITotalTime, APIServiceTime, URL, Result, Start) VALUES('" + Title + "', " + APIRequestID + ", '" + TourneyID + "', '" + APIFrameworkTime +"', '" + APITotalTime +"', '" + APIServiceTime +"', '" + URL +"', " + Result + ", FALSE)");
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.exit(-1);
		}
		
		Main.refresh();
	}
	
	public void addTeam(String Title, String TourneyTitle, int TourneyTeamID, int APIRequestID, String APIFrameworkTime, String APITotalTime, String APIServiceTime, int Result) {
		
		try {
			
			Statement stat = connection.createStatement();
			System.out.println("INSERT INTO team(Title, TourneyTitle, TourneyTeamID, APIRequestID, APIFrameworkTime, APITotalTime, APIServiceTime, Result) VALUES ('" + Title + "', '" + TourneyTitle + "', " + TourneyTeamID + ", " + APIRequestID + ", '" + APIFrameworkTime + "', '" + APITotalTime + "', '" + APIServiceTime + "', " + Result + ")");
			stat.execute("INSERT INTO team(Title, TourneyTitle, TourneyTeamID, APIRequestID, APIFrameworkTime, APITotalTime, APIServiceTime, Result) VALUES ('" + Title + "', '" + TourneyTitle + "', " + TourneyTeamID + ", " + APIRequestID + ", '" + APIFrameworkTime + "', '" + APITotalTime + "', '" + APIServiceTime + "', " + Result + ")");
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.exit(-1);
		}
		
	}
	
	public void setStartedTournament(String TourneyID) {
		
		try {
			
			Statement stat = connection.createStatement();
			stat.execute("UPDATE tournament SET Start = TRUE WHERE TourneyID = '" + TourneyID + "'");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
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
	
	public void updateTournament(String TourneyID, int APIRequestID) {
		
		try {
			
			Statement stat = connection.createStatement();
			stat.execute("UPDATE tournament SET APIRequestID = " + APIRequestID + " WHERE TourneyID = '" + TourneyID + "'");
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	public ArrayList<TourneyList> getallTournament() {
		ArrayList<TourneyList> list = new ArrayList<TourneyList>();
		
		try {
			
			Statement stat = connection.createStatement();
			ResultSet res = stat.executeQuery("SELECT* FROM tournament");
			
			while(res.next()) {
				
				list.add(new TourneyList(res.getInt("id"), res.getString("Title"), res.getInt("APIRequestID"), res.getString("TourneyID"), res.getString("APIFrameworkTime"), res.getString("APITotalTime"), res.getString("APIServiceTime"), res.getString("URL"), res.getInt("Result"), res.getBoolean("Start")));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.exit(-1);
		}
		
		return list;
	}
	
	public ArrayList<TeamList> getallTeam(){
		
		ArrayList<TeamList> list = new ArrayList<TeamList>();
		
		try {
			
			Statement stat = connection.createStatement();
			ResultSet res = stat.executeQuery("SELECT * FROM team");
			
			while(res.next()) {
				
				list.add(new TeamList(res.getInt("id"), res.getString("Title"), res.getString("TourneyTitle"), res.getInt("TourneyTeamID"), res.getInt("APIRequestID"), res.getString("APIFrameworkTime"), res.getString("APITotalTime"), res.getString("APIServiceTime"), res.getInt("Result")));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.exit(-1);
		}
		
		return list;
	}
	
}
