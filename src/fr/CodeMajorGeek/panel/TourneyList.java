package fr.CodeMajorGeek.panel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import fr.CodeMajorGeek.binaryBeast.BinaryBeast;
import fr.CodeMajorGeek.sql.SQLConnection;

public class TourneyList {
	
	private BinaryBeast binaryBeast = Main.getBinaryBeast();
	private SQLConnection sql = Main.getSQLConnection();
	
	int id;
	String Title;
	int APIRequestID;
	String TourneyID;
	String APIFrameworkTime;
	String APITotalTime;
	String APIServiceTime;
	String URL;
	int Result;
	boolean Start;
	
	public TourneyList(int id, String Title, int APIRequestID, String TourneyID, String APIFrameworkTime, String APITotalTime, String APIServiceTime, String URL, int Result, boolean Start) {
		
		this.id = id;
		this.Title = Title;
		this.APIRequestID = APIRequestID;
		this.TourneyID = TourneyID;
		this.APIFrameworkTime = APIFrameworkTime;
		this.APITotalTime = APITotalTime;
		this.APIServiceTime = APIServiceTime;
		this.URL = URL;
		this.Result = Result;
		this.Start = Start;
	}
	
	public JPanel getList() {
		JPanel panel = new JPanel();
		
		JTextField title = new JTextField(Title, 8);
		JTextField ID = new JTextField(TourneyID + "", 7);
		JTextField url = new JTextField(URL);
		
		JButton start = new JButton("Démarrer");
		JButton remove = new JButton("Supprimer");
		
		title.setEditable(false);
		ID.setEditable(false);
		url.setEditable(false);
		
		if(Start) start.setEnabled(false);
		
		remove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				binaryBeast.deleteTournament(TourneyID);
				
				Main.refresh();
			}
		});
		
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(!Start) {
					
					binaryBeast.startTournament(TourneyID, "manual", "");
					sql.setStartedTournament(TourneyID);
					start.setEnabled(false);
				}
				
				Main.refresh();
			}
		});
		
		panel.add(new JLabel("Titre: "));
		panel.add(title);
		panel.add(new JLabel("ID de tournoi: "));
		panel.add(ID);
		panel.add(new JLabel("URL: "));
		panel.add(url);
		panel.add(remove);
		panel.add(start);
		
		if(!Start)
			panel.setBorder(new CompoundBorder(new LineBorder(Color.RED), new EmptyBorder(4,4,4,4)));
		else
			panel.setBorder(new CompoundBorder(new LineBorder(Color.GREEN), new EmptyBorder(4,4,4,4)));
		
		return panel;
	}
}
