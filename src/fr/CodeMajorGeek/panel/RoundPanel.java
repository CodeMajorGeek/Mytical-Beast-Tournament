package fr.CodeMajorGeek.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.CodeMajorGeek.binaryBeast.BinaryBeast;

public class RoundPanel extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1354815928558695357L;
	
	private BinaryBeast binaryBeast = Main.getBinaryBeast();
	
	public static RoundPanel getMainRound;
	
	private JComboBox<?> tourney;
	private ArrayList<String> tournament = new ArrayList<String>();
	private ArrayList<String> tourneyID = new ArrayList<String>();
	private JButton update = new JButton("Actualiser");
	
	public RoundPanel() {
		
		setFocusable(true);
		requestFocus();
		
		getMainRound = this;
		
		for(int i = 0; i <= ListTourneyPanel.tourneyList.size() - 1; i++) {
			
			if(ListTourneyPanel.tourneyList.get(i).Start) {
				
				tournament.add(ListTourneyPanel.tourneyList.get(i).Title);
				tourneyID.add(ListTourneyPanel.tourneyList.get(i).TourneyID);
			}
		}
		
		tourney = new JComboBox<Object>(tournament.toArray());
		
		update.addActionListener(this);
		
		add(new JLabel("Actualiser le round du tournoi: "));
		add(tourney);
		add(update);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		binaryBeast.updateRoundTournament(tourneyID.get(tourney.getSelectedIndex()), 2, 2, 0, "Random", "20/10/2018");
	}
}
