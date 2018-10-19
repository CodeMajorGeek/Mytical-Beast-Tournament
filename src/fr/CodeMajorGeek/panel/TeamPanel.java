package fr.CodeMajorGeek.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.CodeMajorGeek.binaryBeast.BinaryBeast;

public class TeamPanel extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = -6650123716388744857L;
	
	public static TeamPanel getMainTeam;
	
	public static BinaryBeast binaryBeast = Main.getBinaryBeast();
	
	private JTextField name = new JTextField(7);
	private JComboBox<?> tourney;
	private String[] tourneyID;
	private JButton add = new JButton("Ajouter");
	
	
	public TeamPanel() {
		
		setFocusable(true);
		requestFocus();
		
		getMainTeam = this;
		
		String[] tournament = new String[ListTourneyPanel.tourneyList.size()];
		tourneyID = new String[ListTourneyPanel.tourneyList.size()];
		for(int i = 0; i <= ListTourneyPanel.tourneyList.size() - 1; i++) {
			
			tournament[i] = ListTourneyPanel.tourneyList.get(i).Title;
			tourneyID[i] = ListTourneyPanel.tourneyList.get(i).TourneyID;
		}
		
		tourney = new JComboBox<Object>(tournament);
		
		tourney.addActionListener(this);
		name.addActionListener(this);
		add.addActionListener(this);
		
		add(new JLabel("Nom de la team: "));
		add(name);
		add(new JLabel("Pour le tournoi: "));
		add(tourney);
		add(add);
	}
	
	public void refresh() {
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(add)) {
			
			binaryBeast.insertTeam(tourneyID[tourney.getSelectedIndex()], name.getText());
			name.setText("");
		}
	}
}
