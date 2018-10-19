package fr.CodeMajorGeek.panel;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class ListTourneyPanel extends JPanel{
	
	private static final long serialVersionUID = -2921328574460398589L;
	
	public static ListTourneyPanel getMainList;
	
	public static ArrayList<TourneyList> tourneyList = new ArrayList<TourneyList>();
	
	public ListTourneyPanel() {
		
		setFocusable(true);
		requestFocus();
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		getMainList = this;
		refresh();
	}
	
	
	public void refresh() {
		
		removeAll();
		revalidate();
		
		for(TourneyList list : tourneyList) 
			add(list.getList());
	}
}
