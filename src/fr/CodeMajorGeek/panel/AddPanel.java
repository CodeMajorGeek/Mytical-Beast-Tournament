package fr.CodeMajorGeek.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.CodeMajorGeek.binaryBeast.BinaryBeast;

public class AddPanel extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = -4939775746224826676L;
	
	private BinaryBeast binaryBeast = Main.getBinaryBeast();
	
	public static AddPanel getMainAdd;
	
	private JTextField title = new JTextField(7);
	private JButton send = new JButton("Créer");
	
	public AddPanel() {
		
		setFocusable(true);
		requestFocus();
		
		title.addActionListener(this);
		send.addActionListener(this);
		
		add(new JLabel("Titre: "));
		add(title);
		add(send);
		
		getMainAdd = this;
	}
	
	
	public void refresh() {
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(title)) {
			
			binaryBeast.addTournament(title.getText());
			title.setText("");
		} else if(e.getSource().equals(send)) {
			
			binaryBeast.addTournament(title.getText());
			title.setText("");
		}
	}
}
