package fr.CodeMajorGeek.panel;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class TeamList {
	
	int id;
	String TourneyTitle;
	String Title;
	int TourneyTeamID;
	int APIRequestID;
	String APIFrameworkTime;
	String APITotalTime;
	String APIServiceTime;
	int Result;
	
	public TeamList(int id, String Title, String TourneyTitle, int TourneyTeamID, int APIRequestID, String APIFrameworkTime, String APITotalTime, String APIServiceTime, int Result) {
		
		this.id = id;
		this.Title = Title;
		this.TourneyTitle = TourneyTitle;
		this.TourneyTeamID = TourneyTeamID;
		this.APIRequestID = APIRequestID;
		this.APIFrameworkTime = APIFrameworkTime;
		this.APITotalTime = APITotalTime;
		this.APIServiceTime = APIServiceTime;
		this.Result = Result;
	}
	
	public JPanel getList() {
		JPanel panel = new JPanel();
		
		JTextField title = new JTextField(7);
		title.setText(Title);
		title.setEditable(false);
		
		JTextField teamID = new JTextField(7);
		teamID.setText(TourneyTeamID + "");
		teamID.setEditable(false);
		
		JTextField tourneyTitle = new JTextField(7);
		teamID.setText(TourneyTitle);
		teamID.setEditable(false);
		
		panel.add(new JLabel("Team: "));
		panel.add(title);
		panel.add(new JLabel("TeamID: "));
		panel.add(teamID);
		panel.add(new JLabel("dans le tournoi: "));
		panel.add(tourneyTitle);
		
		panel.setBorder(new CompoundBorder(new LineBorder(Color.LIGHT_GRAY), new EmptyBorder(4, 4, 4, 4)));
		
		return panel;
	}
}
