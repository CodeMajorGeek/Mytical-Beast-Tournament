package fr.CodeMajorGeek.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.CodeMajorGeek.binaryBeast.BinaryBeast;

public class TeamPanel extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = -6650123716388744857L;
	
	public static TeamPanel getMainTeam;
	
	private static BinaryBeast binaryBeast = Main.getBinaryBeast();
	
	
	private JTextField name = new JTextField(7);
	private JComboBox<?> tourney;
	private ArrayList<String> tournament = new ArrayList<String>();
	private ArrayList<String> tourneyID = new ArrayList<String>();
	private JButton add = new JButton("Ajouter");
	
	
	public TeamPanel() {
		
		setFocusable(true);
		requestFocus();
		
		getMainTeam = this;
		
		for(int i = 0; i <= ListTourneyPanel.tourneyList.size() - 1; i++) {
			
			if(!ListTourneyPanel.tourneyList.get(i).Start) {
				
				tournament.add(ListTourneyPanel.tourneyList.get(i).Title);
				tourneyID.add(ListTourneyPanel.tourneyList.get(i).TourneyID);
			}
				
		}
		
		tourney = new JComboBox<Object>(tournament.toArray());
		
		tourney.addActionListener(this);
		name.addActionListener(this);
		add.addActionListener(this);
		
		add(new JLabel("Nom de la team: "));
		add(name);
		add(new JLabel("pour le tournoi: "));
		add(tourney);
		add(add);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(add)) {
			
			binaryBeast.insertTeam(tourneyID.get(tourney.getSelectedIndex()), name.getText(), tournament.get(tourney.getSelectedIndex()));
			name.setText("");
		}
		
		Main.refresh();
	}
}
