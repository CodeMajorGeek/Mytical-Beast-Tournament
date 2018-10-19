package fr.CodeMajorGeek.panel;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class TeamList {
	
	int TourneyTeamID;
	int APIRequestID;
	String APIFrameworkTime;
	String APITotalTime;
	String APIServiceTime;
	String[] TourneyPlayerID;
	int Result;
	
	public TeamList(int id, String Title, int TourneyTeamID, int APIRequestID, String APIFrameworkTime, String APITotalTime, String APIServiceTime, int Result) {
		
		this.TourneyTeamID = TourneyTeamID;
		this.APIRequestID = APIRequestID;
		this.APIFrameworkTime = APIFrameworkTime;
		this.APITotalTime = APITotalTime;
		this.APIServiceTime = APIServiceTime;
		this.Result = Result;
	}
	
	public JPanel getList() {
		JPanel panel = new JPanel();
		
		panel.add(new JLabel(""));
		
		panel.setBorder(new CompoundBorder(new LineBorder(Color.LIGHT_GRAY), new EmptyBorder(4, 4, 4, 4)));
		
		return panel;
	}
}
